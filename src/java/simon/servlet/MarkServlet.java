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
import simon.entity.Mark;

/**
 *
 * @author patrice
 */
@WebServlet(name = "MarkServlet", urlPatterns = {"/mark"})
public class MarkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idBooster = (String) req.getParameter("idBooster"); //Should be Integer
        String comments = (String) req.getParameter("comments");
        String mark1 = (String) req.getParameter("mark1");  //Should be Integer
        String mark2 = (String) req.getParameter("mark2");  //Should be Integer
        String mark3 = (String) req.getParameter("mark3");  //Should be Integer
        String mark4 = (String) req.getParameter("mark4");  //Should be Integer
        String mark5 = (String) req.getParameter("mark5");  //Should be Integer
        String mark6 = (String) req.getParameter("mark6");  //Should be Integer
        String intervention = (String) req.getParameter("intervention");  //Should be Intervention

            req.setAttribute("idBooster", idBooster);
            req.setAttribute("comments", comments);
            req.setAttribute("mark1", mark1);
            req.setAttribute("mark2", mark2);
            req.setAttribute("mark3", mark3);
            req.setAttribute("mark4", mark4);
            req.setAttribute("mark5", mark5);
            req.setAttribute("mark6", mark6);
            Mark mark = new Mark(idBooster, comments, mark1, mark2, mark3, mark4, mark5, mark6, intervention);
            mark = (Mark) DaoFactory.getDaoFactory().getMarkDao().addMark(mark);
    }
}