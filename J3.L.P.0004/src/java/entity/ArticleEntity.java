/*							
 *  Copyright(C) 2005,  FPT University							
 *  Lab Java Web:							
 *      Digital News
 *							
 *  Record of change:							
 *  DATE                       Version             AUTHOR                       DESCRIPTION							
 *  2021-02-20                   1.0               KhoiVT                      First Implement
 */
package entity;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *This class used to create attribute of Cakes
 * 
 * @author Vu Tien Khoi
 */
public class ArticleEntity {
    /**
     * Create attributes
     */
    private int id;
    private String title;
    private String image;
    private String content;
    private String authorName;
    private Date dateCreated;

    
    /**
     * Create constructor with no parameters
     */
    
    public ArticleEntity() {
    }
    /**
     * Create constructor with parameters
     *
     * @param id <code>Integer</code>
     * @param title <code>String</code>
     * @param image <code>String</code>
     * @param content <code>String</code>
     * @param authorName <code>String</code>
     * @param dateCreated <code>String</code>
     */
    public ArticleEntity(int id, String title, String image, String content, String authorName, Date dateCreated) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
        this.authorName = authorName;
        this.dateCreated = dateCreated;
    }
    /**
     * This method used to get ID of Article
     *
     * @return id <code>Integer</code>
     */
    public int getId() {
        return id;
    }
    /**
     * This method used to set ID of Article
     *
     * @param id <code>Integer</code>
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * This method used to get Title of Article
     *
     * @return title <code>String</code>
     */
    public String getTitle() {
        return title;
    }
    /**
     * This method used to set Title of Article
     *
     * @param title <code>String</code>
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * This method used to get Image of Article
     *
     * @return image <code>String</code>
     */
    public String getImage() {
        return image;
    }
    /**
     * This method used to set Image of Article
     *
     * @param image <code>String</code>
     */
    public void setImage(String image) {
        this.image = image;
    }
    /**
     * This method used to get Content of Article
     *
     * @return content <code>String</code>
     */
    public String getContent() {
        return content;
    }
    /**
     * This method used to set Content of Article
     *
     * @param content <code>String</code>
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     * This method used to get Name of Author
     *
     * @return authorName <code>String</code>
     */
    public String getAuthorName() {
        return authorName;
    }
    /**
     * This method used to set Name of Author
     *
     * @param authorName <code>String</code>
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    /**
     * This method used to get Date created of Article
     *
     * @return dateCreated <code>Date</code>
     */
    public Date getDateCreated() {
        return dateCreated;
    }
    /**
     * This method used to set Date created of Article
     *
     * @param dateCreated <code>Date</code>
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    /**
     * This method used to get DateFormat of date
     *
     * @return date <code>String</code>
     */
    public String getDateFormat(){
        String strConvert = new SimpleDateFormat("MMM dd yyyy - hh:mma").format(dateCreated).toLowerCase();
        StringBuilder sb = new StringBuilder(strConvert);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        return sb.toString();
    }
//    ArticleEntity article = new ArticleEntity(1,"Covid 19","images/covid","new vaccine for corona virus","KhoiVT",
//                new Date(System.currentTimeMillis()));
//        assertEquals(1,article.getId());
}
