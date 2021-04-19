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
 * Create attributes and setter, getter of gallery
 *
 * @author Vu Tien Khoi
 */
public class Galery {

    /**
     * create attributes
     */
    private int ID;
    private String title;
    private String description;
    private String name;
    private String image;

    /**
     * Create constructor with no parameters
     */
    public Galery() {
    }

    /**
     * Create constructor with parameters
     *
     * @param ID <code>Integer</code>
     * @param title <code>String</code>
     * @param description <code>String</code>
     * @param name <code>String</code>
     * @param image <code>String</code>
     */
    public Galery(int ID, String title, String description, String name, String image) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.name = name;
        this.image = image;
    }

    /**
     * This method used to get url of image by Gallery Id
     *
     * @return url of image
     */
    public String getImage() {
        return image;
    }

    /**
     * This method used to set url of image
     *
     * @param image <code>String</code>
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * This method used to get Name
     *
     * @return name <code>String</code>
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
     * This method used to get Id
     *
     * @return ID <code>Integer</code>
     */
    public int getID() {
        return ID;
    }

    /**
     * This method used to set Id
     *
     * @param ID <code>Integer</code>
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * This method used to get Title
     *
     * @return title <code>String</code>
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
     * This method used to get Description
     *
     * @return description <code>String</code>
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method used to set Description
     *
     * @param description <code>String</code>
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method used to get String of Gallery
     *
     * @return
     */
    @Override
    public String toString() {
        return "Galery{" + "ID=" + ID + ", title=" + title + ", description=" + description + '}';
    }

}
