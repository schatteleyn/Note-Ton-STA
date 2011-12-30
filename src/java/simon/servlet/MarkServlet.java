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


@WebServlet(name = "MarkServlet", urlPatterns = {"/mark"})
public class MarkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idBooster = Integer.valueOf(req.getParameter("idBooster"));
        String comments = (String) req.getParameter("comments");
        Integer mark1 = Integer.valueOf(req.getParameter("mark1"));  
        Integer mark2 = Integer.valueOf(req.getParameter("mark2"));  
        Integer mark3 = Integer.valueOf(req.getParameter("mark3"));  
        Integer mark4 = Integer.valueOf(req.getParameter("mark4"));
        Integer mark5 = Integer.valueOf(req.getParameter("mark5"));
        Integer mark6 = Integer.valueOf(req.getParameter("mark6"));
        String intervention = (String) req.getSession().getAttribute("intervention");  //Should be Intervention

            req.setAttribute("idBooster", idBooster);
            req.setAttribute("comments", comments);
            req.setAttribute("mark1", mark1);
            req.setAttribute("mark2", mark2);
            req.setAttribute("mark3", mark3);
            req.setAttribute("mark4", mark4);
            req.setAttribute("mark5", mark5);
            req.setAttribute("mark6", mark6);
            
            Mark mark = new Mark();
            mark.setIdBooster(idBooster);
            mark.setComments(comments);
            mark.setMark1(mark1);
            mark.setMark2(mark2);
            mark.setMark3(mark3);
            mark.setMark4(mark4);
            mark.setMark5(mark5);
            mark.setMark6(mark6);
            
            Mark addMark = DaoFactory.getDaoFactory().getMarkDao().addMark(mark);
    }
}