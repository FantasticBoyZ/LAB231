/*							
 *  Copyright(C) 2005,  FPT University							
 *  Lab Java Web:							
 *      Photographer	
 *							
 *  Record of change:							
 *  DATE                       Version             AUTHOR                       DESCRIPTION							
 *  2021-02-20                   1.0               KhoiVT                      First Implement
 */
package controller;

import dao.ContactDAO;
import dao.GaleryDAO;
import dao.ImageDAO;
import dao.impl.ContactDAOImpl;
import dao.impl.GaleryDAOImpl;
import dao.impl.ImageDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class uses to handle request and send response to Photo Page
 *
 * @author Vu Tien Khoi
 */
@WebServlet(name = "PhotoDeailPageController", urlPatterns = {"/PhotoDeailPageController"})
public class PhotoDeailPageController extends HttpServlet {

    /**
     * This method used to set all attribute to display data in Gallery page by
     * get data from database throw DAO interface
     *
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
            GaleryDAO galeryDao = new GaleryDAOImpl();
            ImageDAO imgDao = new ImageDAOImpl();
            ContactDAO conDao = new ContactDAOImpl();

            String galeryID = request.getParameter("galeryID");
            String imgID = request.getParameter("imgID");
            boolean invalid = true;
            boolean indexValid = true;
            int galery = 0;
            //check galery id
            try {
                if (galeryID != null) {
                    galery = Integer.parseInt(galeryID);
                } else {
                    // set default galery id
                    galery = 1;
                }
            } catch (NumberFormatException e) {
                request.setAttribute("error", "This gallery is invalid!!");
                request.getRequestDispatcher("Error.jsp").forward(request, response);
                invalid = false;
            }

            if (invalid == true) {
                //count total result 
                int totalRecord = imgDao.countImage(galery);
                if (totalRecord <= 0) {
                    request.setAttribute("error", "No image in gallery!!");
                    request.getRequestDispatcher("Error.jsp").forward(request, response);
                }
                //get index page
                int image = 0;
                String pageIndex = request.getParameter("index");
                int index = 0;

                //check index page
                try {
                    if (pageIndex != null) {

                        index = Integer.parseInt(pageIndex);
                    } else {
                        index = 1;
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("error", "This page is invalid!!");
                    request.getRequestDispatcher("Error.jsp").forward(request, response);
                    indexValid = false;
                }

                if (indexValid == true && index > 0) {
                    //check image id valid
                    try {
                        if (imgID != null) {
                            image = Integer.parseInt(imgID);
                        } else {
                            // set default image id
                            image = imgDao.getTopImageGalery(galery).getId();
                        }
                    } catch (Exception e) {
                        request.setAttribute("error", "This image not found!!");
                        request.getRequestDispatcher("Error.jsp").forward(request, response);
                    }
                    // check image in galery or not
                    if (imgDao.getImageID(image, galery) != null) {
                        request.setAttribute("top1Galery", imgDao.getImageID(image, galery));
                    } else {
                        request.setAttribute("error", "This image not found!!");
                        request.getRequestDispatcher("Error.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("error", "This page is invalid!!");
                    request.getRequestDispatcher("Error.jsp").forward(request, response);
                }
                request.setAttribute("galeryID", galery);
                request.setAttribute("totalRecord", totalRecord);
                request.setAttribute("galery", galeryDao.getGaleryByID(galery));
            }
            //get top 3 galery
            request.setAttribute("top3", galeryDao.getTopGalery(3));

            //get contact infor
            request.setAttribute("contact", conDao.getContact());
            request.setAttribute("active", galeryID);
            request.getRequestDispatcher("Photo.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("error", ex);
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
