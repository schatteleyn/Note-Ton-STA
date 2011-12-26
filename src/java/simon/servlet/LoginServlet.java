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

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = (String) req.getParameter("email");
        String password = (String) req.getParameter("password");
        
        if (email.isEmpty() || password.isEmpty()) {
            req.setAttribute("erreur", "Vous devez remplir les deux champs.");
            getServletContext().getRequestDispatcher("login.jsp").forward(req, resp);
        }
 
            
        else {
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            speakerLogin = (Speaker) DaoFactory.getDaoFactory().getSpeakerDao().login(email, password);
            getServletContext().getRequestDispatcher("intervention.jsp").forward(req, resp);
        }
    }

    
}
