/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Menu;
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
public class MenuDAO {
     public int getCountMenu() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        int count = 0;
        try {
            String query = "SELECT COUNT(Id) FROM Menu";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
             throw e;
        }finally{
            db.closeConnection(rs, ps, conn);
        }
        return count;
     }
     public List<Menu> getListMenu(int pageIndex, int pageSize) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        List<Menu> list = new ArrayList<>();
        try {
            String query = "select *from("
                + "select ROW_NUMBER() over (order by ID ASC) as rn, *\n"
                + "from Menu\n"
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
                Menu menu = new Menu(rs.getInt("id"), 
                        rs.getString("name"), 
                        rs.getString("price"), 
                        rs.getString("shortDes"), 
                        rs.getString("detailDes"));
                list.add(menu);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
    }
     
}
