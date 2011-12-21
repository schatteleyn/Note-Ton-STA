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
import simon.entity.Speaker;

@WebServlet(name = "SignupServlet", urlPatterns = {"/signup"})
public class SignupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = (String) req.getParameter("nom");
        String prenom = (String) req.getParameter("prenom");
        String email = (String) req.getParameter("email");
        String password = (String) req.getParameter("password");
        String confirmation = (String) req.getParameter("confirmation");
        
        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || password.isEmpty() || confirmation.isEmpty()) {
            req.setAttribute("erreur", "Vous devez remplir tous les champs.");
            getServletContext().getRequestDispatcher("signup.jsp").forward(req, resp);
        }
        
        else if(!confirmation.equals(password)) {
            req.setAttribute("erreur", "Le mot de passe et la confirmation doivent être identique.");
            getServletContext().getRequestDispatcher("signup.jsp").forward(req, resp);
        }
        
        else {        
            String encryptedPassword = DaoFactory.getDaoFactory().getSpeakerDao().encryptPassword(password);
            Speaker speaker = new Speaker(nom, prenom, email, encryptedPassword);
            speaker = (Speaker) DaoFactory.getDaoFactory().getSpeakerDao().addSpeaker(speaker);
        }
   
    }
}