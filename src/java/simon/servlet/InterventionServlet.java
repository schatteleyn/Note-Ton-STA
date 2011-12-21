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


}