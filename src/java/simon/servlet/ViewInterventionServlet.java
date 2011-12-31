/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import simon.dao.DaoFactory;
import simon.entity.Intervention;

@WebServlet(name = "ViewInterventionServlet", urlPatterns = {"/viewIntervention"})
public class ViewInterventionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Intervention intervention = DaoFactory.getDaoFactory().getInterventionDao().findInterventionById(Long.parseLong(req.getParameter("intervention")));
        req.setAttribute("intervention", intervention);
        req.setAttribute("subject", intervention.getSubject());
        req.setAttribute("beginning", intervention.getBeginning());
        req.setAttribute("ending", intervention.getEnding());
        req.setAttribute("campus", intervention.getCampus());
        req.setAttribute("description", intervention.getDescription());
        req.setAttribute("totalMarks", DaoFactory.getDaoFactory().getMarkDao().getCount(intervention));
        req.setAttribute("speakerMark", DaoFactory.getDaoFactory().getMarkDao().getSpeakerMark(intervention)); 
        req.setAttribute("slideMark", DaoFactory.getDaoFactory().getMarkDao().getSlideMark(intervention));
        req.setAttribute("globalMarks", DaoFactory.getDaoFactory().getMarkDao().getGlobalMark(intervention));
        req.setAttribute("StringChart", DaoFactory.getDaoFactory().getMarkDao().getStringChart(intervention.getId()));
        req.getRequestDispatcher("/viewIntervention.jsp").forward(req, resp);
    }

}