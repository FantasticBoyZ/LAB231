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
import dao.ShareDAO;
import entity.ShareEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implement some method in interface class ShareDAO used to process
 * with Share table
 *
 * @author Dương Thanh Tùng
 */
public class ShareDAOImpl extends DBContext implements ShareDAO {

    /**
     * This method used to get all Share from database
     *
     * @return list: List of Share
     * @throws Exception
     */
    @Override
    public List<ShareEntity> getShare() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ShareEntity> list = new ArrayList<>();
        try {
            String query = "select * from Share";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                ShareEntity share = new ShareEntity(rs.getString("icon"),
                        rs.getString("socialNetwork"),
                        rs.getString("URL"));
                list.add(share);
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
