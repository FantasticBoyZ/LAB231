/*							
 *  Copyright(C) 2005,  FPT University							
 *  Lab Java Web:							
 *      Maria Bagnarelli's Cafe
 *							
 *  Record of change:							
 *  DATE                       Version             AUTHOR                       DESCRIPTION							
 *  2021-02-20                   1.0               TungDT                      First Implement
 */
package dao.impl;

import context.DBContext;
import dao.CakeDAO;
import entity.CakeEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contain some method used to process with Cake table
 *
 * @author Dương Thanh Tùng
 */
public class CakeDAOImpl extends DBContext implements CakeDAO {

    /**
     * This method used to get product from database
     *
     * @return list: List of Cake
     * @throws Exception
     */
    @Override
    public List<CakeEntity> getTop2() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<CakeEntity> list = new ArrayList<>();
        try {
            String query = "select top 2* from Products order by DateCreated desc";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CakeEntity cake = new CakeEntity(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("picture"),
                        rs.getString("shortDescription"),
                        rs.getString("detailDescription"),
                        rs.getString("price")
                );
                list.add(cake);
            }
            return list;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    /**
     * This method used to get Cake with cake id matched with id input
     *
     * @param CakeID <code>Integer</code>
     * @return list: List of Cake
     * @throws Exception
     */
    @Override
    public CakeEntity getCakeDetail(int CakeID) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from Products where ID = ?";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, CakeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                CakeEntity cake = new CakeEntity(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("picture"),
                        rs.getString("shortDescription"),
                        rs.getString("detailDescription"),
                        rs.getString("price")
                );
                return cake;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return null;
    }

    /**
     * This method used to get total product in database
     *
     * @return count: Number of product
     * @throws Exception
     */
    @Override
    public int getTotalProducts() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            String query = "select count(*) from Products";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return count;
    }

    /**
     * This method used to get all Cake and pagination
     *
     * @param pageIndex <code>Integer</code>
     * @param pageSize <code>Integer</code>
     * @return list: List of Cake
     * @throws Exception
     */
    @Override
    public List<CakeEntity> getAllCakes(int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<CakeEntity> list = new ArrayList<>();
        try {
            String sql = "select *from("
                    + "select ROW_NUMBER() over (order by ID ASC) as rn, *\n"
                    + "from Products"
                    + ")as x\n"
                    + "where rn between ?*?-2"
                    + "and ?*?";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pageIndex);
            ps.setInt(2, pageSize);
            ps.setInt(3, pageIndex);
            ps.setInt(4, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                CakeEntity cake = new CakeEntity(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("picture"),
                        rs.getString("shortDescription"),
                        rs.getString("detailDescription"),
                        rs.getString("price")
                );
                list.add(cake);
            }
            return list;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

}
