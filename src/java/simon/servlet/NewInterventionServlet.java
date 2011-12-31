/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.servlet;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import simon.dao.DaoFactory;
import simon.entity.Campus;
import simon.entity.Intervention;
import simon.entity.Speaker;

@WebServlet(name = "NewInterventionServlet", urlPatterns = {"/intervention/new"})
public class NewInterventionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String subject = req.getParameter("sujet");
        Long campus = Long.valueOf(req.getParameter("campus"));
        Date from = Date.valueOf(req.getParameter("from"));
        Date to = Date.valueOf(req.getParameter("to"));
        String description = req.getParameter("description");
        
        Boolean validate = true;
        
        if(subject.isEmpty()){
            validate = false;
            req.setAttribute("error_subject", "Subject is required !");
	}
        
        else if(description.isEmpty()){
            validate = false;
            req.setAttribute("error_description", "Description is required !");
	}
        
        else {        
            Intervention intervention = new Intervention();
            intervention.setSubject(subject);
            Campus theCampus = DaoFactory.getDaoFactory().getCampusDao().findCampusById(campus);
            intervention.setCampus(theCampus);
            intervention.setBeginning(from);
            intervention.setEnding(to);
            intervention.setDescription(description);
            Speaker theSpeaker = DaoFactory.getDaoFactory().getSpeakerDao().findSpeakerById((Long) req.getSession().getAttribute("userId"));
	    intervention.setSpeaker(theSpeaker);
            
            DaoFactory.getDaoFactory().getInterventionDao().addIntervention(intervention);
            resp.sendRedirect("/myInterventions.jsp");
        }
        
    }


}