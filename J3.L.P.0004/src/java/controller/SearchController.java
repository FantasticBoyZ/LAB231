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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class used to get text from search form and process then forward to
 * Search Page
 *
 * @author Vu Tien Khoi
 */
public class SearchController extends HttpServlet {

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
            // Get search text from search form
            String search = request.getParameter("Search").trim();
            String pageIndex = request.getParameter("index");
            // if page index is null then set it equal 1
            if (pageIndex == null) {
                pageIndex = "1";
            }
            int index = Integer.parseInt(pageIndex);
            ArticleDAO articleDAO = new ArticleDAOImpl();
            // count total article that searched by keyword
            int totalArticle = articleDAO.countArticle(search);
            int pageSize = 3;
            // total page can be display
            int totalPage = totalArticle / pageSize;
            if (totalPage % pageSize != 0 && totalPage > 1) {
                totalPage++;
            }
            List<ArticleEntity> listSearch = articleDAO.searchByTitle(search, index, pageSize);
            request.setAttribute("listSearch", listSearch);
            request.setAttribute("maxPage", totalPage);
            request.setAttribute("txt", search);
            request.setAttribute("index", index);
            // Get latest Article from database
            ArticleEntity latestArticle = articleDAO.getRecentArticle(1).get(0);
            request.setAttribute("latestArticle", latestArticle);

            // Get top 5 recent Article from database and set attribute
            ArrayList<ArticleEntity> list = articleDAO.getRecentArticle(5);
            request.setAttribute("top5", list);
            request.getRequestDispatcher("SearchResultPage.jsp").forward(request, response);
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
