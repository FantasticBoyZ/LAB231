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
import dao.ImageDAO;
import entity.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contain some method used to process with Image table in database
 *
 * @author Vu Tien Khoi
 */
public class ImageDAOImpl extends DBContext implements ImageDAO {

    /**
     * This method used to count total number of image with id input
     *
     * @param id <code>Integer</code> id of Gallery input
     * @return count <code>Integer</code> number of image
     * @throws Exception
     */
    @Override
    public int countImage(int id) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT count(*) from image where galery_id = ?";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, id);
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
     * This method used to get url of image with id input
     *
     * @param id <code>Integer</code> id of Gallery input
     * @return url <code>String</code> url of image
     * @throws Exception
     */
    @Override
    public List<Image> getImageByGaleryID(int id) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Image> list = new ArrayList<>();
        try {
            String query = "select ROW_NUMBER() over (order by id ASC) as rn , * from  image where galery_id = ?";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            rs = pr.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt(1));
                image.setGaleryId(rs.getInt(3));
                image.setImageUrl(rs.getString(4));
                list.add(image);
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

    /**
     * This method used to get list of image with paging
     *
     * @param galeryID <code>Integer</code> id of gallery input
     * @param pageIndex <code>Integer</code> index of first gallery in list
     * @param pageSize <code>Integer</code> number of gallery in 1 page
     * @return list: List of Image
     * @throws Exception
     */
    @Override
    public List<Image> getListImageWithPaging(int galeryID, int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Image> list = new ArrayList<>();
        int size = countImage(galeryID);
        try {
            String query = "select * from ( select ROW_NUMBER() over (order by id ASC) as rn , * from  image where galery_id = ?) "
                    + "as b where rn between ((?*?) - ?)and (?*?)";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, galeryID);
            pr.setInt(2, pageSize);
            pr.setInt(3, pageIndex);
            pr.setInt(4, pageSize - 1);
            pr.setInt(5, pageSize);
            pr.setInt(6, pageIndex);
            rs = pr.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGaleryId(rs.getInt("galery_id"));
                image.setImageUrl(rs.getString("image_url"));
                list.add(image);
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

    /**
     * This method used to get image by Gallery Id and Image Id
     *
     * @param id <code>Integer</code> Gallery Id input
     * @param galeryId <code>Integer</code> Image Id
     * @return Image <code>Object</code>
     * @throws Exception
     */
    @Override
    public Image getImageID(int id, int galeryId) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * from image where id = ? and galery_id = ?";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            pr.setInt(2, galeryId);
            rs = pr.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGaleryId(rs.getInt("galery_id"));
                image.setImageUrl(rs.getString("image_url"));
                return image;
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
     * This method used to get Image by Gallery ID
     *
     * @param galeryID <code>Integer</code> Image Id
     * @return Image <code>Object</code>
     * @throws Exception
     */
    @Override
    public Image getTopImageGalery(int galeryID) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT top (?) * from image where galery_id = ?";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, 1);
            pr.setInt(2, galeryID);
            rs = pr.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGaleryId(rs.getInt("galery_id"));
                image.setImageUrl(rs.getString("image_url"));
                return image;
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
            ImageDAO imgDao = new ImageDAOImpl();
            List<Image> list = imgDao.getImageByGaleryID(2);
            System.out.println(list.size());
        } catch (Exception ex) {
            Logger.getLogger(ImageDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
