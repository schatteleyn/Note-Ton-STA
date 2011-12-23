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
import simon.dao.DaoFactory;
import simon.entity.Intervention;


@WebServlet(name = "UpdateInterventionServlet", urlPatterns = {"/intervention/update"})
public class UpdateInterventionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    }

}