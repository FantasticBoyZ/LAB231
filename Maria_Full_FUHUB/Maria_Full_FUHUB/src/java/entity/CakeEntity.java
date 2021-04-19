/*							
 *  Copyright(C) 2005,  FPT University							
 *  Lab Java Web:							
 *      Maria Bagnarelli's Cafe
 *							
 *  Record of change:							
 *  DATE                       Version             AUTHOR                       DESCRIPTION							
 *  2021-02-20                   1.0               TungDT                      First Implement
 */
package entity;

/**
 * This class used to create attribute of Cakes
 *
 * @author Dương Thanh Tùng
 */
public class CakeEntity {

    /**
     * Create attributes
     */
    private int id;
    private String name, picture, shortDescription, detailDescription;
    private String price;

    /**
     * Create constructor with no parameters
     */
    public CakeEntity() {
    }

    /**
     * Create constructor with parameters
     *
     * @param id <code>Integer</code>
     * @param name <code>String</code>
     * @param picture <code>String</code>
     * @param shortDescription <code>String</code>
     * @param detailDescription <code>String</code>
     * @param price <code>String</code>
     */
    public CakeEntity(int id, String name, String picture, String shortDescription, String detailDescription, String price) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.shortDescription = shortDescription;
        this.detailDescription = detailDescription;
        this.price = price;
    }

    /**
     * This method used to get ID
     *
     * @return id <code>Integer</code>
     */
    public int getId() {
        return id;
    }

    /**
     * This method used to set ID
     *
     * @param id <code>Integer</code>
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method used to get Name
     *
     * @return id <code>String</code>
     */
    public String getName() {
        return name;
    }

    /**
     * This method used to set Name
     *
     * @param name <code>String</code>
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method used to get Picture
     *
     * @return id <code>String</code>
     */
    public String getPicture() {
        return picture;
    }

    /**
     * This method used to set Picture
     *
     * @param picture <code>String</code>
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * This method used to get ShortDescription
     *
     * @return id <code>String</code>
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * This method used to set ShortDescription
     *
     * @param shortDescription <code>String</code>
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * This method used to get DetailDescription
     *
     * @return id <code>String</code>
     */
    public String getDetailDescription() {
        return detailDescription;
    }

    /**
     * This method used to set DetailDescription
     *
     * @param detailDescription <code>String</code>
     */
    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    /**
     * This method used to get Price
     *
     * @return id <code>String</code>
     */
    public String getPrice() {
        return price;
    }

    /**
     * This method used to set Price
     *
     * @param price <code>String</code>
     */
    public void setPrice(String price) {
        this.price = price;
    }

}
