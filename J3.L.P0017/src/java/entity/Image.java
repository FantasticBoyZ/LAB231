/*							
 *  Copyright(C) 2005,  FPT University							
 *  Lab Java Web:							
 *      Photographer	
 *							
 *  Record of change:							
 *  DATE                       Version             AUTHOR                       DESCRIPTION							
 *  2021-02-20                   1.0               KhoiVT                      First Implement
 */
package entity;

/**
 * Create attributes and setter, getter of Image
 *
 * @author Vu Tien Khoi
 */
public class Image {

    /**
     * Create attributes
     */
    private int id;
    private int galeryId;
    private String imageUrl;

    /**
     * Create constructor with no parameters
     */
    public Image() {
    }

    /**
     * Create constructor with parameters
     *
     * @param id <code>Integer</code>
     * @param galeryId <code>Integer</code>
     * @param imageUrl <code>String</code>
     */
    public Image(int id, int galeryId, String imageUrl) {
        this.id = id;
        this.galeryId = galeryId;
        this.imageUrl = imageUrl;
    }

    /**
     * This method used to get Id
     *
     * @return id <code>Integer</code>
     */
    public int getId() {
        return id;
    }

    /**
     * This method used to set Id
     *
     * @param id <code>Integer</code>
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method used to get Gallery Id
     *
     * @return galeryId <code>Integer</code>
     */
    public int getGaleryId() {
        return galeryId;
    }

    /**
     * This method used to set Gallery Id
     *
     * @param galeryId <code>Integer</code>
     */
    public void setGaleryId(int galeryId) {
        this.galeryId = galeryId;
    }

    /**
     * This method used to get Image url
     *
     * @return imageUrl <code>String</code>
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * This method used to set Image url
     *
     * @param imageUrl <code>String</code>
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
