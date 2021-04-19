/*							
 *  Copyright(C) 2005,  FPT University							
 *  Lab Java Web:							
 *      Digital News
 *							
 *  Record of change:							
 *  DATE                       Version             AUTHOR                       DESCRIPTION							
 *  2021-02-20                   1.0               KhoiVT                      First Implement
 */
package controller;

import dao.ArticleDAO;
import dao.impl.ArticleDAOImpl;
import entity.ArticleEntity;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class used to get id from Uniform Resource Locator and process then send
 * response to Home page
 *
 *
 * @author Vu Tien Khoi
 */
public class DetailController extends HttpServlet {

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
        try {
            ArticleDAO articleDAO = new ArticleDAOImpl();
            // Get latest Article from database
            ArticleEntity latestArticle = articleDAO.getRecentArticle(1).get(0);
            request.setAttribute("latestArticle", latestArticle);

            // Get top 5 recent Article from database and set attribute
            ArrayList<ArticleEntity> list = articleDAO.getRecentArticle(5);
            request.setAttribute("top5", list);

            // Get id parameter from url
            int id = Integer.parseInt(request.getParameter("id"));

            // check id range valid
            ArticleEntity article = articleDAO.getArticleById(id);
            if (article != null) {
                request.setAttribute("article", article);
                request.getRequestDispatcher("HomePage.jsp").forward(request, response);
            } else {
                String error = "ID is invalid";
                request.setAttribute("error", error);
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            //If had an error, forward to Error Page
            String error = ex.getMessage();
            request.setAttribute("error", error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
    }// </editor-fold>

}
