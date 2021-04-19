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
 * This class used to create attribute of Introduction
 *
 * @author Dương Thanh Tùng
 */
public class IntroductionEntity {

    /**
     * Create attributes
     */
    private String title, picture, shortDescription, detailDescription;

    /**
     * Create constructor with no parameters
     */
    public IntroductionEntity() {
    }

    /**
     * Create constructor with parameters
     *
     * @param title <code>String</code>
     * @param picture <code>String</code>
     * @param shortDescription <code>String</code>
     * @param detailDescription <code>String</code>
     */
    public IntroductionEntity(String title, String picture, String shortDescription, String detailDescription) {
        this.title = title;
        this.picture = picture;
        this.shortDescription = shortDescription;
        this.detailDescription = detailDescription;
    }

    /**
     * This method used to get Title
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method used to set Title
     *
     * @param title <code>String</code>
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method used to get Picture
     *
     * @return picture
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
     * @return shortDescription
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
     * @return detailDescription
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

}
