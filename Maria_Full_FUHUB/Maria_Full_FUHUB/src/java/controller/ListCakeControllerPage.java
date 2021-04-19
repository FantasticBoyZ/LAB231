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
import dao.impl.CakeDAOImpl;
import dao.impl.ShareDAOImpl;
import entity.CakeEntity;
import entity.ShareEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class used to get request from client and process then send response to
 * List Cake Page
 *
 * @author Dương Thanh Tùng
 */
@WebServlet(name = "ListCakeControl", urlPatterns = {"/ListCakeControl"})
public class ListCakeControllerPage extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {

            // Get all share from database to display
            ShareDAOImpl shareDAO = new ShareDAOImpl();
            List<ShareEntity> share = shareDAO.getShare();
            request.setAttribute("share", share);

            //Get all cake detail 
            CakeDAO cakeDAO = new CakeDAOImpl();
            //Get page index, default by 1
            String page_index = request.getParameter("txtPage");
            if (page_index == null) {
                page_index = "1";
            }
            int pageIndex = Integer.parseInt(page_index);

            int pageSize = 3; // 3 Cakes display in 1 Page
            int rowCount = cakeDAO.getTotalProducts();  //totalProduct = 20
            int maxPage = rowCount / pageSize; //Count number of page
            if (rowCount % pageSize != 0) {
                maxPage = maxPage + 1;
            }
            List<CakeEntity> cakes = cakeDAO.getAllCakes(pageIndex, pageSize);

            //Set attributes to send to client
            request.setAttribute("cakes", cakes);
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("pageIndex", pageIndex);

            request.setAttribute("activeList", "activeList");
            //Forward to List Page
            request.getRequestDispatcher("List.jsp").forward(request, response);

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
