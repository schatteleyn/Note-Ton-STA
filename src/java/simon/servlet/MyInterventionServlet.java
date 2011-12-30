/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import simon.dao.DaoFactory;
import simon.dao.InterventionDao;
import simon.entity.Intervention;
import simon.entity.Speaker;


@WebServlet(name = "GetinterventionBySpeaker", urlPatterns = {"/intervention/speaker"})
public class MyInterventionServlet extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      Speaker speaker = (Speaker) req.getSession().getAttribute("speaker");
      InterventionDao interventiondao = DaoFactory.getDaoFactory().getInterventionDao();
      List<Intervention> listIntervention = interventiondao.findInterventionBySpeaker(speaker);
      req.setAttribute("interventions", listIntervention);
      req.getRequestDispatcher("/myInterventions.jsp").forward(req, resp);
     }
}