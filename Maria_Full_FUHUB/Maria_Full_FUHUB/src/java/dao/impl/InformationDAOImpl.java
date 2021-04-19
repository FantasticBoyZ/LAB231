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
import dao.InformationDAO;
import entity.InformationEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class implement some method in interface class InformationDAO used to
 * process with Information table
 *
 * @author Dương Thanh Tùng
 */
public class InformationDAOImpl extends DBContext implements InformationDAO {

    /**
     * This method used to get all information from database
     *
     * @return list: list of Information
     * @throws Exception
     */
    @Override
    public InformationEntity getInfomation() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from Information";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                InformationEntity information = new InformationEntity(rs.getString("shortDescription"),
                        rs.getString("address"),
                        rs.getString("tel"),
                        rs.getString("email"),
                        rs.getString("openingHours"),
                        rs.getString("signature"));
                return information;
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
}
