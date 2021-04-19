/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import context.DBContext;
import dao.ShareDAO;
import dao.SushiDAO;
import entity.Share;
import entity.Sushi;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author trinh hoan
 */
@WebServlet(name = "HomeControl", urlPatterns = {"/HomeControl"})
public class HomeControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            //begin of get and set imagePath
            DBContext bContext = new DBContext();
            String imagePath = bContext.getImagePath();
            request.setAttribute("imagePath", imagePath);
            //end of get and set imagePath
            //begin of set share
            ShareDAO shareDAO = new ShareDAO();
            List<Share> share = shareDAO.getShare();
            request.setAttribute("share", share);
            //end of set share
            
            //begin of get index
            String pageIndex = request.getParameter("pageIndex");
            if (pageIndex == null) {
                pageIndex = "1";
            }
            int index = 0;
            try {
                index = Integer.parseInt(pageIndex);
            } catch (Exception e) {
                index = 1;
            }
            //end of get index

            //begin count total and maxPage sushi
            SushiDAO sushiDAO = new SushiDAO();
            int pageSize = 3;
            int total = sushiDAO.getTotalSushi();
            int maxPage = total / pageSize;
            if (total % pageSize != 0) {
                maxPage++;
            }
            if (index <= 0 || index > maxPage) {
                index = 1;
            }
            //end of count total and maxPage sushi

            //begin: if sushi is null then index = 1
            List<Sushi> listSushi = sushiDAO.getListSuShiPaging(index, pageSize);
            if (listSushi == null) {
                request.setAttribute("listSushi", sushiDAO.getListSuShiPaging(1, pageSize));
            } else {
                request.setAttribute("listSushi", listSushi);
            }
            //end: if sushi is null then index = 1

            request.setAttribute("maxPage", maxPage);
            request.setAttribute("pageIndex", index);
            request.setAttribute("activeHome", "activeHome");
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        } catch (Exception e) {
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
