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
import simon.entity.Intervention;
import simon.entity.Speaker;

@WebServlet(name = "InterventionServlet", urlPatterns = {"/intervention/new"})
public class InterventionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sujet = (String) req.getParameter("sujet");
        String campus = (String) req.getParameter("campus");
        Date from = Date.valueOf(req.getParameter("from"));
        Date to = Date.valueOf(req.getParameter("to"));
        String description = (String) req.getParameter("description");
        Speaker speaker = (Speaker) req.getSession().getAttribute("speaker");
        
        if (sujet.isEmpty() || campus.isEmpty() || description.isEmpty()) {
            req.setAttribute("erreur", "Vous devez remplir tous les champs.");
            getServletContext().getRequestDispatcher("intervention/new").forward(req, resp);
        }
        
        else {        
            Intervention intervention = new Intervention();
            intervention.setSubject(sujet);
            //intervention.setCampus(campus);
            intervention.setBeginning(from);
            intervention.setEnding(to);
            intervention.setDescription(description);
            intervention.setSpeaker(speaker);
            Intervention addIntervention = DaoFactory.getDaoFactory().getInterventionDao().addIntervention(intervention);
            //getServletContext().getRequestDispatcher("intervention/" + id).forward(req, resp);
        }
        
    }


}