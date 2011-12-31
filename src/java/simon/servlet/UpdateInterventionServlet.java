/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import simon.dao.DaoFactory;
import simon.entity.Campus;
import simon.entity.Intervention;
import simon.entity.Speaker;


@WebServlet(name = "UpdateInterventionServlet", urlPatterns = {"/intervention/update"})
public class UpdateInterventionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        if(req.getParameter("id") == null){
            resp.sendRedirect("../myInterventions.jsp");
        }
        
        else{
        
        Long interventionId = Long.valueOf(req.getParameter("intervId"));
        Intervention intervObj = DaoFactory.getDaoFactory().getInterventionDao().findInterventionById(interventionId);
        
        String subject = intervObj.getSubject();
        Long campus = intervObj.getCampus().getId();
        Date beginning = (Date) intervObj.getBeginning();
        Date ending = (Date) intervObj.getEnding();
        String description = intervObj.getDescription(); 
        
        String fromPeriodStr;
        String toPeriodStr;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        fromPeriodStr = dateFormat.format(beginning);
        toPeriodStr = dateFormat.format(ending);

        req.setAttribute("intervId", interventionId);
        req.setAttribute("subject", subject);
        req.setAttribute("campus", campus);
        req.setAttribute("beginning", fromPeriodStr);
        req.setAttribute("ending", toPeriodStr);
        req.setAttribute("description", description);
        req.setAttribute("CampusList", DaoFactory.getDaoFactory().getCampusDao().getAllCampus());
        req.getRequestDispatcher("/updateIntervention.jsp").forward(req, resp);
                        
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        Long interventionId = Long.valueOf(req.getParameter("intervId"));
        
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
            req.setAttribute("error_description", "description is required !");
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
            
            DaoFactory.getDaoFactory().getInterventionDao().updateIntervention(intervention);
            resp.sendRedirect("/myInterventions.jsp");
        }
            
            
    }
}