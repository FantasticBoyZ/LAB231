/*							
 *  Copyright(C) 2005,  FPT University							
 *  Lab Java Web:							
 *      Photographer	
 *							
 *  Record of change:							
 *  DATE                       Version             AUTHOR                       DESCRIPTION							
 *  2021-02-20                   1.0               KhoiVT                      First Implement
 */
package dao.impl;

import context.DBContext;
import dao.ContactDAO;
import entity.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class contain some method used to process with Contact table in database
 *
 * @author Vu Tien Khoi
 */
public class ContactDAOImpl extends DBContext implements ContactDAO {

    /**
     * This method used to get all contact from database
     *
     * @return Contact <code>Object</code>
     * @throws Exception
     */
    @Override
    public Contact getContact() throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT top 1 * from contact";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            rs = pr.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setTelephone(rs.getString("telephone"));
                contact.setEmail(rs.getString("email"));
                contact.setFaceUrl(rs.getString("face_url"));
                contact.setTwitterUrl(rs.getString("twitter_url"));
                contact.setGoogleUrl(rs.getString("google_url"));
                contact.setAbout(rs.getString("about"));
                contact.setAddress(rs.getString("address"));
                contact.setCity(rs.getString("city"));
                contact.setCountry(rs.getString("country"));
                contact.setMapUrl(rs.getString("map_url"));
                contact.setImageMain(rs.getString("image_main"));
                contact.setIconFace(rs.getString("icon_face"));
                contact.setIconTwitter(rs.getString("icon_twitter"));
                contact.setIconGoogle(rs.getString("icon_google"));
                return contact;
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            ContactDAO dao = new ContactDAOImpl();
            Contact contact = dao.getContact();
            System.out.println(contact.getImageMain());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
