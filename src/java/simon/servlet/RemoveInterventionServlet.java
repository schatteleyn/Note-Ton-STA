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
import simon.entity.Intervention;


@WebServlet(name = "RemoveInterventionServlet", urlPatterns = {"/intervention/remove"})
public class RemoveInterventionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Long id = Long.valueOf(req.getParameter("id"));

		Intervention intervention = DaoFactory.getDaoFactory().getInterventionDao().findInterventionById(id);

		if(intervention.getSpeaker().getId().equals(req.getSession().getAttribute("userId"))){
			DaoFactory.getDaoFactory().getInterventionDao().removeIntervention(intervention);
		}
			req.getRequestDispatcher("/intervention").forward(req, resp);
    }

}
