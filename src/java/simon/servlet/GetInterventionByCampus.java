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
import simon.dao.InterventionDao;
import simon.entity.Intervention;


@WebServlet(name = "GetIntervention", urlPatterns = {"/intervention/campus"})
public class GetInterventionByCampus extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String campusIdParam = req.getParameter("CampusId");
      Long campusId = Long.valueOf(campusIdParam);
                
      InterventionDao interventiondao = DaoFactory.getDaoFactory().getInterventionDao();
      Intervention listIntervention = interventiondao.findInterventionByCampus(campusId);
      req.getRequestDispatcher("/intervention.jsp").forward(req, resp);
      
     
    }
    
}