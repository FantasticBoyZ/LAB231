/*							
 *  Copyright(C) 2005,  FPT University							
 *  Lab Java Web:							
 *      Maria Bagnarelli's Cafe
 *							
 *  Record of change:							
 *  DATE                       Version             AUTHOR                       DESCRIPTION							
 *  2021-02-20                   1.0               TungDT                      First Implement
 */
package controller;

import dao.CakeDAO;
import dao.ShareDAO;
import dao.impl.CakeDAOImpl;
import dao.impl.ShareDAOImpl;
import entity.CakeEntity;
import entity.ShareEntity;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class used to get request from client and process then send response to
 * Cake Page
 *
 * @author Dương Thanh Tùng
 */
@WebServlet(name = "CakeControl", urlPatterns = {"/CakeControl"})
public class CakeControllerPage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            // Get all share from database to display
            ShareDAO shareDAO = new ShareDAOImpl();
            List<ShareEntity> share = shareDAO.getShare();
            request.setAttribute("share", share);

            //Get cake detail by id, default id = 1 
            String id = request.getParameter("id");
            int idCake;
            try {
                idCake = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                idCake = 1;
            }
            CakeDAO cakeDAO = new CakeDAOImpl();
            CakeEntity cake = cakeDAO.getCakeDetail(idCake);
            if (cake == null) {
                request.setAttribute("cake", cakeDAO.getCakeDetail(1));
            } else {
                request.setAttribute("cake", cake);
            }

            //Forward to Cake Detail Page
            request.getRequestDispatcher("CakeDetail.jsp").forward(request, response);
        } catch (Exception ex) {
            //If had an error, forward to Error Page
            String error = ex.getMessage();
            request.setAttribute("error", error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
