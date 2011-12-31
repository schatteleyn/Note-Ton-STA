/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.servlet;

import java.io.IOException;
import java.util.regex.Pattern;
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
        getServletContext().getRequestDispatcher("/signup.jsp").forward(req, resp);
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
        
        Boolean validate = true;

        if(prenom.isEmpty()){
                validate = false;
                req.setAttribute("error_FirstName", "First name is required !");
        }

        if(nom.isEmpty()){
                validate = false;
                req.setAttribute("error_LastName", "Last name is required !");
        }

        if(email.isEmpty()){
                validate = false;
                req.setAttribute("error_email", "Email is required !");
        }

        else if(!Pattern.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", email)){
                validate = false;
                req.setAttribute("error_email", "Email is invalid !");
        }
        else if(DaoFactory.getDaoFactory().getSpeakerDao().findSpeakerByEmail(email) != null){
                req.setAttribute("error_email", "This email already exist in database !");
        }

        if(password.isEmpty()){
                validate = false;
                req.setAttribute("error_password", "Password is required !");
        }

        if(confirmation.isEmpty()){
                validate = false;
                req.setAttribute("error_confirmation", "Password confirmation is required !");
        }

        else if(!confirmation.equals(password)){
                validate = false;
                req.setAttribute("error_confirmation", "Confirmation is not the same !");
        }

        
        if(validate) {        
            String encryptedPassword = DaoFactory.getDaoFactory().getSpeakerDao().encryptPassword(password);
            Speaker speaker = new Speaker(nom, prenom, email, encryptedPassword);
            speaker = DaoFactory.getDaoFactory().getSpeakerDao().addSpeaker(speaker);
        }
        else{
            req.setAttribute("nom", nom);
            req.setAttribute("prenom", prenom);
            req.setAttribute("email", email);

            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
   
    }
}