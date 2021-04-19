/*							
 *  Copyright(C) 2005,  FPT University							
 *  Lab Java Web:							
 *      Photographer	
 *							
 *  Record of change:							
 *  DATE                       Version             AUTHOR                       DESCRIPTION							
 *  2021-02-20                   1.0               KhoiVT                     First Implement
 */
package controller;

import dao.ContactDAO;
import dao.GaleryDAO;
import dao.ImageDAO;
import dao.impl.ContactDAOImpl;
import dao.impl.GaleryDAOImpl;
import dao.impl.ImageDAOImpl;
import entity.Image;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class uses to handle request and send response to Gallery Page
 *
 * @author Vu Tien Khoi
 */
public class GalleryPageController extends HttpServlet {

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
            ContactDAO contactDao = new ContactDAOImpl();

            String galleryID = request.getParameter("galeryID");
            boolean invalid = true;

            int gallery = 0;
            //check galery id
            try {
                if (galleryID != null) {
                    gallery = Integer.parseInt(galleryID);
                } else {
                    // set default galery id
                    gallery = 1;
                }
            } catch (NumberFormatException e) {
                request.setAttribute("error", "This galery is invalid!!");
                request.getRequestDispatcher("Error.jsp").forward(request, response);
                invalid = false;
            }

            if (invalid == true) {
                int pageSize = 8;

                //count total result 
                int totalRecord = imgDao.countImage(gallery);
                if (totalRecord <= 0) {
                    request.setAttribute("error", "No image in galery!!");
                    request.getRequestDispatcher("Error.jsp").forward(request, response);
                }
                int maxPage = totalRecord / pageSize;
                if ((totalRecord % pageSize) != 0) {
                    maxPage++;
                }

                //get top 1 image of galery
                String pageIndex = request.getParameter("index");
                int index = 0;

                //check index page
                try {
                    if (pageIndex != null) {
                        index = Integer.parseInt(pageIndex);
                    } else {
                        // set default index
                        index = 1;
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("error", "This page is invalid!!");
                    request.getRequestDispatcher("Error.jsp").forward(request, response);

                }
                List<Image> list = imgDao.getImageByGaleryID(gallery);
                request.setAttribute("slideShow", list);
                try {
                    //get list image with paging 
                    List<Image> imagelList = imgDao.getListImageWithPaging(gallery, index, pageSize);
                    request.setAttribute("listImage", imagelList);

                } catch (Exception ex) {
                    request.setAttribute("error", "This galleryID is invalid!!");
                    request.getRequestDispatcher("Error.jsp").forward(request, response);
                }

                request.setAttribute("index", index);
                request.setAttribute("maxPage", maxPage);
                request.setAttribute("galeryID", gallery);
                request.setAttribute("totalRecord", totalRecord);
                request.setAttribute("galery", galeryDao.getGaleryByID(gallery));
            }
            //get top 3 galery
            request.setAttribute("top3", galeryDao.getTopGalery(3));
            //get contact infor
            request.setAttribute("contact", contactDao.getContact());

            request.setAttribute("active", galleryID);
            request.getRequestDispatcher("Gallery.jsp").forward(request, response);
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
