
package dao;

import context.DBContext;
import entity.Share;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ShareDAO {
     public List<Share> getShare() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<Share> list = new ArrayList<>();
        try {
            String query = "select * from Share";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Share share = new Share(rs.getString("icon"),
                        rs.getString("socialNetwork"),
                        rs.getString("URL"));
                list.add(share);
            }
            return list;
        } catch (Exception e) {
           throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
    }
}
