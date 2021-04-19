/*							
 *  Copyright(C) 2005,  FPT University							
 *  Lab Java Web:							
 *      Photographer	
 *							
 *  Record of change:							
 *  DATE                       Version             AUTHOR                       DESCRIPTION							
 *  2021-02-20                   1.0               KhoiVT                      First Implement
 */
package listener;

import dao.ViewsDAO;
import dao.impl.ViewsDAOImpl;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application life cycle listener.
 *
 * @author Vu Tien Khoi
 */
public class CountViewListener implements HttpSessionListener {

    /**
     * This method used to get Views Number from database and display in client
     * when session is created
     *
     * @param se <code>HttpSessionEvent</code>
     */
    @Override
    @SuppressWarnings("null")
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext ctx = null;
        try {
            //Get views from database
            ViewsDAO viewDao = new ViewsDAOImpl();
            int count = viewDao.getViews();

            //Formarted to format 6 digits
            NumberFormat formatter = new DecimalFormat("000000");
            String number = formatter.format(count);

            //Add to list to display in client
            List views = new ArrayList();
            for (int i = number.length() - 1; i >= 0; i--) {
                views.add(number.charAt(i));
            }

            //Update views on database and create session
            viewDao.UpdateViews();
            ctx = se.getSession().getServletContext();

            //Set attributes
            ctx.setAttribute("totalViews", views);
        } catch (Exception ex) {
            //If had an error, send it to Error Page
            ctx.setAttribute("error", ex.getMessage());
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
