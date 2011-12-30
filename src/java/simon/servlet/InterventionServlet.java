/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import simon.dao.DaoFactory;
import simon.entity.Campus;
import simon.entity.Intervention;

@WebServlet(name = "InterventionServlet", urlPatterns = {"/intervention"})
public class InterventionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long campusId = Long.parseLong(req.getParameter("campus"));
        Campus campus = DaoFactory.getDaoFactory().getCampusDao().findCampusById(campusId);
        List<Intervention> interventions = DaoFactory.getDaoFactory().getInterventionDao().findInterventionByCampus(campus);
        req.setAttribute("interventions", interventions);
        req.getRequestDispatcher("/intervention.jsp").forward(req, resp);
    }


}