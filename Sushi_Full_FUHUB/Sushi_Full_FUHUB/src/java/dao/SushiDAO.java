/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Sushi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trinh hoan
 */
public class SushiDAO {
    
    public Sushi getOne(int id) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        try {
            String query = "SELECT * FROM Sushi WHERE Id = ?";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sushi sushi = new Sushi(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getString("shortDes"),
                        rs.getString("detailDes"),
                        rs.getString("price"));
                return sushi;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return null;
    }
    
    public int getTotalSushi() throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        int count = 0;
        try {
            String query = "SELECT COUNT(Id) FROM Sushi";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
    }
    
    public List<Sushi> getListSuShiPaging(int pageIndex, int pageSize) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        List<Sushi> list = new ArrayList<>();
        try {
            String query = "select *from("
                    + "select ROW_NUMBER() over (order by ID ASC) as rn, *\n"
                    + "from Sushi \n"
                    + ")as x\n"
                    + "where rn between (?-1)*?+1"
                    + "and ?*?";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, pageIndex);
            ps.setInt(2, pageSize);
            ps.setInt(3, pageIndex);
            ps.setInt(4, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sushi sushi = new Sushi(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getString("shortDes"),
                        rs.getString("detailDes"),
                        rs.getString("price"));
                list.add(sushi);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
    }
}
