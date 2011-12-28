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


@WebServlet(name = "UpdateInterventionServlet", urlPatterns = {"/intervention/update"})
public class UpdateInterventionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Long interventionId = Long.valueOf(req.getParameter("intervId"));
            String sujet = req.getParameter("subject");
            String campus = req.getParameter("campus");
            String from = req.getParameter("fromPeriod");
            String to = req.getParameter("toPeriod");
            String description = req.getParameter("description");
            
            if (sujet.isEmpty() || campus.isEmpty() || from.isEmpty() || to.isEmpty() || description.isEmpty()) {
            req.setAttribute("erreur", "Vous devez remplir tous les champs.");
            getServletContext().getRequestDispatcher("intervention/new").forward(req, resp);
        }
        
        else {        
            Intervention intervention = new Intervention(sujet, campus, from, to, description, speaker);
            DaoFactory.getDaoFactory().getInterventionDao().updateIntervention(intervention);
            resp.sendRedirect("/intervention");
        }
            
            
    }
}