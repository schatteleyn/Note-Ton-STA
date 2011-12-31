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
import simon.dao.CampusDao;
import simon.dao.DaoFactory;
import simon.entity.Campus;

@WebServlet(name = "GetCampusServlet", urlPatterns = {"/index.jsp"})
public class GetCampusServlet extends HttpServlet {
    
    private String arr_campus[] = {"Paris", "Nantes", "Rennes", "Nice", "Starsbourg", "Montréal"};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CampusDao campusdao = DaoFactory.getDaoFactory().getCampusDao();
        List<Campus> listCampus = campusdao.getAllCampus();
        
        if (listCampus.isEmpty())
        {
           for (int i=0; i<arr_campus.length; i++) {
               Campus campus = new Campus(arr_campus[i]);
               campus = campusdao.addCampus(campus);
           } 
        }
        
        req.setAttribute("list_campus", listCampus);
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }

}