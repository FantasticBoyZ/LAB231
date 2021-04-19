/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import context.DBContext;
import dao.InforDAO;
import dao.ShareDAO;
import entity.Information;
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
@WebServlet(name = "InforControl", urlPatterns = {"/InforControl"})
public class InforControl extends HttpServlet {

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
            
            //begin of get and set information
            InforDAO inforDAO = new InforDAO();
            Information infor = inforDAO.getInformation();
            request.setAttribute("infor", infor);
            //end of get and set information
            request.setAttribute("activeInfor", "activeInfor");
            request.getRequestDispatcher("Location.jsp").forward(request, response);
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
