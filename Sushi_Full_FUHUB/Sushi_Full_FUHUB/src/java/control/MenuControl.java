/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import context.DBContext;
import dao.MenuDAO;
import dao.ShareDAO;
import entity.Menu;
import entity.Share;
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
@WebServlet(name = "MenuControl", urlPatterns = {"/MenuControl"})
public class MenuControl extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            //begin of set imagePath
            DBContext bContext = new DBContext();
            String imagePath = bContext.getImagePath();
            request.setAttribute("imagePath", imagePath);
            //end of set imagePath
            
             //begin of set share
            ShareDAO shareDAO = new ShareDAO();
            List<Share> share = shareDAO.getShare();
            request.setAttribute("share", share);
            //end of set share
           
            String pageIndex = request.getParameter("pageIndex");
            if(pageIndex == null){
                pageIndex = "1";
            }
            int index = 0;
            try {
                index = Integer.parseInt(pageIndex);
            } catch (Exception e) {
                index = 1;
            }
            
            MenuDAO menuDAO = new MenuDAO();
            int pageSize = 3;
            int total = menuDAO.getCountMenu();
            int maxPage = total / pageSize;
            if(total % pageSize != 0){
                maxPage++;
            }
            if(index <= 0 || index > maxPage){
                index = 1;
            }
            List<Menu> listMenu = menuDAO.getListMenu(index, pageSize);
            request.setAttribute("listMenu", listMenu);
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("pageIndex", index);
            request.setAttribute("activeMenu", "activeMenu");
            request.getRequestDispatcher("Menu.jsp").forward(request, response);
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
