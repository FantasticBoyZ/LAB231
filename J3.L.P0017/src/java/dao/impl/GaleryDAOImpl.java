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
import dao.GaleryDAO;
import entity.Galery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contain some method used to process with Gallery table in database
 *
 * @author Vu Tien Khoi
 */
public class GaleryDAOImpl extends DBContext implements GaleryDAO {

    /**
     * This method used to get top number Gallery from database
     *
     * @return list: List of Gallery
     * @throws Exception
     */
    @Override
    public List<Galery> getTopGalery(int topNumber) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Galery> listGalery = new ArrayList<>();
        try {
            String query = "SELECT top (?) * from galery";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, topNumber);
            rs = pr.executeQuery();
            while (rs.next()) {
                Galery galery = new Galery();
                galery.setID(rs.getInt("ID"));
                galery.setTitle(rs.getString("title"));
                galery.setDescription(rs.getString("description"));
                galery.setName(rs.getString("name"));
                galery.setImage(rs.getString("image"));
                listGalery.add(galery);
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
        return listGalery;
    }

    /**
     * This method used to get Gallery by id input
     *
     * @param index <code>Integer</code>
     * @param id <code>Integer</code>
     * @return Gallery <code>Object</code>
     * @throws Exception
     */
    @Override
    public Galery getGaleryByID(int id) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT  * from galery where ID = ?";
            conn = getConnection();
            pr = conn.prepareStatement(query);

            pr.setInt(1, id);
            rs = pr.executeQuery();
            while (rs.next()) {
                Galery galery = new Galery();
                galery.setID(rs.getInt("ID"));
                galery.setTitle(rs.getString("title"));
                galery.setDescription(rs.getString("description"));
                galery.setName(rs.getString("name"));
                galery.setImage(rs.getString("image"));
                return galery;
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

    /**
     * This method used to count total number of Gallery
     *
     * @return count <code>Integer</code> number of gallery
     * @throws Exception
     */
    @Override
    public int count() throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT count(*) from galery";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            rs = pr.executeQuery();
            int cout = 0;
            while (rs.next()) {
                cout = rs.getInt(1);
            }
            return cout;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
    }

    /**
     * This method used to get list of Gallery with Paging
     *
     * @param pageIndex <code>Integer</code> index of first gallery in list
     * @param pageSize <code>Integer</code> number of gallery in 1 page
     * @return list: List of Gallery
     * @throws Exception
     */
    @Override
    public List<Galery> getListGaleryWithPaging(int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Galery> list = new ArrayList<>();
        int size = count();
        try {
            String query = "select * from ( select ROW_NUMBER() over (order by id ASC) as rn , * from  galery )"
                    + "as b where rn between ((?*?) - ?)and (?*?)";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, pageSize);
            pr.setInt(2, pageIndex);
            pr.setInt(3, pageSize - 1);
            pr.setInt(4, pageSize);
            pr.setInt(5, pageIndex);
            rs = pr.executeQuery();
            while (rs.next()) {
                Galery galery = new Galery();
                galery.setID(rs.getInt("ID"));
                galery.setTitle(rs.getString("title"));
                galery.setDescription(rs.getString("description"));
                galery.setName(rs.getString("name"));
                galery.setImage(rs.getString("image"));
                list.add(galery);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
        return list;
    }

    public static void main(String[] args) {
        try {
            GaleryDAO dao = new GaleryDAOImpl();
            List<Galery> list = dao.getTopGalery(3);
            System.out.println(dao.getGaleryByID(1));
        } catch (Exception ex) {
            Logger.getLogger(GaleryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
