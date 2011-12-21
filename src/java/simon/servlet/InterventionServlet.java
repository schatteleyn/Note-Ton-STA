/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import simon.dao.InterventionDao;
import simon.dao.DaoFactory;
import simon.entity.Intervention;

@WebServlet(name = "InterventionServlet", urlPatterns = {"/intervention/new"})
public class InterventionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sujet = (String) req.getParameter("sujet");
        String campus = (String) req.getParameter("campus");
        String from = (String) req.getParameter("from");
        String to = (String) req.getParameter("to");
        String description = (String) req.getParameter("description");
        String speaker = (string) req.getSession().getAttribute("email");
        
        if (sujet.isEmpty() || campus.isEmpty() || from.isEmpty() || to.isEmpty() || description.isEmpty()) {
            req.setAttribute("erreur", "Vous devez remplir tous les champs.");
            getServletContext().getRequestDispatcher("intervention/new").forward(req, resp);
        }
        
        else {        
            Intervention intervention = new Intervention(sujet, campus, from, to, description, speaker);
            intervention = (Intervention) DaoFactory.getDaoFactory().getInterventionDao().addIntervention(intervention);
            //getServletContext().getRequestDispatcher("intervention/" + id).forward(req, resp);
        }
        
    }


}