/*							
 *  Copyright(C) 2005,  FPT University							
 *  Lab Java Web:							
 *      Maria Bagnarelli's Cafe	
 *							
 *  Record of change:							
 *  DATE                       Version             AUTHOR                       DESCRIPTION							
 *  2021-02-20                   1.0               KhoiVT                      First Implement
 */
package dao.impl;

import context.DBContext;
import dao.ViewsDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class contain some method used to process with Views table in database
 *
 * @author Vu Tien Khoi
 */
public class ViewsDAOImpl extends DBContext implements ViewsDAO {

    /**
     * This method used to get views from Views table
     *
     * @return count: Total views
     * @throws Exception
     */
    @Override
    public int getViews() throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * from views";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            rs = pr.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
    }

    /**
     * This method used to update(add views by 1) to Views table
     *
     * @throws Exception
     */
    @Override
    public void UpdateViews() throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "UPDATE [views] SET views = views + 1";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Views: "+new ViewsDAOImpl().getViews());
    }

}
