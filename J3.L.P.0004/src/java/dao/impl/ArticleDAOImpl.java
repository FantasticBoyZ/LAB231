/*							
 *  Copyright(C) 2005,  FPT University							
 *  Lab Java Web:							
 *      Digital News
 *							
 *  Record of change:							
 *  DATE                       Version             AUTHOR                       DESCRIPTION							
 *  2021-02-20                   1.0               KhoiVT                      First Implement
 */
package dao.impl;

import context.DBContext;
import dao.ArticleDAO;
import entity.ArticleEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contain some method used to process with Article table
 *
 * @author Vu Tien Khoi
 */
public class ArticleDAOImpl extends DBContext implements ArticleDAO{
    
    /**
     * This method used to get top n recent article from database
     *
     * @param number <code>Integer</code>
     * @return list: List of Article
     * @throws Exception
     */
    @Override
    public ArrayList<ArticleEntity> getRecentArticle(int number) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ArticleEntity> list = new ArrayList();
        try {
            String sql = "select top (?) ar.id,title,[image],content,au.name as [Author Name],[date] "
                    + "from Article ar,Author au "
                    + "where ar.authorID = au.id";
            con =  getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, number);
            rs = ps.executeQuery();
            while (rs.next()) {
                ArticleEntity article = new ArticleEntity();
                article.setId(rs.getInt(1));
                article.setTitle(rs.getString(2));
                article.setImage(rs.getString(3));
                article.setContent(rs.getString(4));
                article.setAuthorName(rs.getString(5));
                article.setDateCreated(rs.getDate(6));
                list.add(article);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
        return list;
    }
    /**
     * This method used to get an article by id from database
     *
     * @param ArticleId <code>Integer</code>
     * @return ArticleEntity
     * @throws Exception
     */
    @Override
    public ArticleEntity getArticleById(int ArticleId) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            String sql = "select ar.id,title,[image],content,au.name as [Author Name],[date] "
                    + "from Article ar,Author au "
                    + "where ar.authorID = au.id\n" 
                    + "and ar.id = ?";
            con =  getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ArticleId);
            rs = ps.executeQuery();
            while (rs.next()) {
                ArticleEntity article = new ArticleEntity();
                article.setId(rs.getInt(1));
                article.setTitle(rs.getString(2));
                article.setImage(rs.getString(3));
                article.setContent(rs.getString(4));
                article.setAuthorName(rs.getString(5));
                article.setDateCreated(rs.getDate(6));
                return article;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
        return null;
    }
    /**
     * This method used to get article from database that was search by text
     *
     * @param text <code>String</code>
     * @param pageIndex <code>Integer</code>
     * @param pageSize <code>Integer</code>
     * @return list: List of Article
     * @throws Exception
     */
    @Override
    public List<ArticleEntity> searchByTitle(String text, int pageIndex, int pageSize) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ArticleEntity> list = new ArrayList();
        try {
            String sql = "select *from(select ROW_NUMBER() over (order by ar.ID ASC) as row_index, ar.id,title,[image],content,au.name as [Author Name],[date] \n" +
"					from Article ar,Author au \n" +
"					where ar.authorID = au.id \n" +
"					and title \n" +
"                    like ? \n" +
"                    )as x\n" +
"                    where row_index between ?*?-2\n" +
"                    and ?*?";
            con =  getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + text + "%");
            ps.setInt(2, pageIndex);
            ps.setInt(3, pageSize);
            ps.setInt(4, pageIndex);
            ps.setInt(5, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                ArticleEntity article = new ArticleEntity();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setImage(rs.getString("image"));
                article.setContent(rs.getString("content"));
                article.setAuthorName(rs.getString("Author Name"));
                article.setDateCreated(rs.getDate("date"));
                list.add(article);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
        return list;
    }
    /**
     * This method used to get number of article was search by text
     *
     * @param text <code>String</code>
     * @return Integer
     * @throws Exception
     */
    @Override
    public int countArticle(String text) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from Article \n"
                    + "where title like ?";
            con =  getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + text + "%");
            rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
    }
    public static void main(String[] args) throws Exception {
        int size = new ArticleDAOImpl().getRecentArticle(5).size();
        System.out.println(new ArticleDAOImpl().countArticle("a"));
    }
}















///**
//     * This method used to get all article from database
//     *
//     * @return list: List of Article
//     * @throws Exception
//     */
//    @Override
//    public ArrayList<ArticleEntity> getAllArticle() throws Exception {
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        ArrayList<ArticleEntity> list = new ArrayList();
//        
//        try {
//            String sql = "select ar.id,title,[image],content,au.name as [Author Name],[date] "
//                    + "from Article ar,Author au "
//                    + "where ar.authorID = au.id";
//            con =  getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                ArticleEntity article = new ArticleEntity();
//                article.setId(rs.getInt(1));
//                article.setTitle(rs.getString(2));
//                article.setImage(rs.getString(3));
//                article.setContent(rs.getString(4));
//                article.setAuthorName(rs.getString(5));
//                article.setDateCreated(rs.getDate(6));
//                list.add(article);
//            }
//        } catch (SQLException e) {
//            throw e;
//        } finally {
//            closeResultSet(rs);
//            closePreparedStatement(ps);
//            closeConnection(con);
//        }
//        return list;
//    }
