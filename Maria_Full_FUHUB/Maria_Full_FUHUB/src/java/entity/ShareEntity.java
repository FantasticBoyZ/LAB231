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
 * This class used to create attribute of Share
 *
 * @author Dương Thanh Tùng
 */
public class ShareEntity {

    /**
     * Create attributes
     */
    private String icon, socialNetwork, url;

    /**
     * Create constructor with no parameters
     */
    public ShareEntity() {
    }

    /**
     * Create constructor with parameters
     *
     * @param icon <code>String</code>
     * @param socialNetwork <code>String</code>
     * @param url <code>String</code>
     */
    public ShareEntity(String icon, String socialNetwork, String url) {
        this.icon = icon;
        this.socialNetwork = socialNetwork;
        this.url = url;
    }

    /**
     * This method used to get Icon
     *
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method used to set Icon
     *
     * @param icon <code>String</code>
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * This method used to get SocialNetwork
     *
     * @return socialNetwork
     */
    public String getSocialNetwork() {
        return socialNetwork;
    }

    /**
     * This method used to set SocialNetwork
     *
     * @param socialNetwork <code>String</code>
     */
    public void setSocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    /**
     * This method used to get URL
     *
     * @return url
     */
    public String getURL() {
        return url;
    }

    /**
     * This method used to set URL
     *
     * @param URL <code>String</code>
     */
    public void setURL(String URL) {
        this.url = URL;
    }

}
