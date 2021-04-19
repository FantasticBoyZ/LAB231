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
import dao.IntroductionDAO;
import entity.IntroductionEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class contain some method used to process with Introduction table
 *
 * @author Dương Thanh Tùng
 */
public class IntroductionDAOImpl extends DBContext implements IntroductionDAO{

    /**
     * This method used to get all Introduction from database
     *
     * @return list: List of Introduction
     * @throws Exception
     */
    @Override
    public IntroductionEntity getIntroduction() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from Intro";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                IntroductionEntity introduction = new IntroductionEntity(rs.getString("title"),
                        rs.getString("picture"),
                        rs.getString("shortDescription"),
                        rs.getString("detailDescription"));
                return introduction;
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
