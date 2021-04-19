/*							
 *  Copyright(C) 2005,  FPT University							
 *  Lab Java Web:							
 *      Photographer	
 *							
 *  Record of change:							
 *  DATE                       Version             AUTHOR                       DESCRIPTION							
 *  2021-02-20                   1.0               KhoiVT                      First Implement
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class used to connect with Database
 *
 * @author Vu Tien Khoi
 */
public class DBContext {

    /**
     * Create attributes
     */
    private final String serverName = "localhost";
    private final String dbname = "Photo";
    private final String portNumber = "1433";
    private final String instance = "";
    private final String username = "sa";
    private final String password = "123456";

    /**
     * This class used to get Connection
     *
     * @return DriverManager
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbname;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.out.println("Connect Success");
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * This class used to close Connection
     *
     * @param con <code>Connection</code>
     * @throws SQLException
     */
    public void closeConnection(Connection con) throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    /**
     * This class used to close ResultSet
     *
     * @param rs <code>ResultSet</code>
     * @throws SQLException
     */
    public void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }

    /**
     * This class used to close PreparedStatement
     *
     * @param ps <code>PreparedStatement</code>
     * @throws SQLException
     */
    public void closePreparedStatement(PreparedStatement ps) throws SQLException {
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new DBContext().getConnection();
    }
}
