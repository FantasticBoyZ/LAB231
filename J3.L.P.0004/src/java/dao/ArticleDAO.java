/*							
 *  Copyright(C) 2005,  FPT University							
 *  Lab Java Web:							
 *      Digital News
 *							
 *  Record of change:							
 *  DATE                       Version             AUTHOR                       DESCRIPTION							
 *  2021-02-20                   1.0               KhoiVT                      First Implement
 */
package dao;

import entity.ArticleEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * This interface class used to create method to process in ArticleDaoImpl
 *
 * @author Vu Tien Khoi
 */
public interface ArticleDAO {
//    /**
//     * This method used to get all article from database
//     *
//     * @return list: List of Article
//     * @throws Exception
//     */
//    public ArrayList<ArticleEntity> getAllArticle() throws Exception;
    /**
     * This method used to get top n recent article from database
     *
     * @param number <code>Integer</code>
     * @return list: List of Article
     * @throws Exception
     */
    public ArrayList<ArticleEntity> getRecentArticle(int number) throws Exception;
    /**
     * This method used to get an article by id from database
     *
     * @param ArticleId <code>Integer</code>
     * @return ArticleEntity
     * @throws Exception
     */
    public ArticleEntity getArticleById(int ArticleId) throws Exception;
    /**
     * This method used to get article from database that was search by text
     *
     * @param text <code>String</code>
     * @param pageIndex <code>Integer</code>
     * @param pageSize <code>Integer</code>
     * @return list: List of Article
     * @throws Exception
     */
    public List<ArticleEntity> searchByTitle(String text, int pageIndex, int pageSize) throws Exception;
    /**
     * This method used to get number of article was search by text
     *
     * @param text <code>String</code>
     * @return Integer
     * @throws Exception
     */
    public int countArticle(String text) throws Exception;
}
