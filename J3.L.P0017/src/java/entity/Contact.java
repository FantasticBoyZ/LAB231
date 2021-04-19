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
 * Create attributes and setter, getter of contact
 *
 * @author Vu Tien Khoi
 */
public class Contact {

    /**
     * Create attributes
     */
    private String telephone;
    private String email;
    private String faceUrl;
    private String twitterUrl;
    private String googleUrl;
    private String about;
    private String address;
    private String city;
    private String country;
    private String mapUrl;
    private String imageMain;
    private String iconFace;
    private String iconTwitter;
    private String iconGoogle;

    /**
     * Create constructor with no parameters
     */
    public Contact() {
    }

    /**
     * This method used to get Icon face
     *
     * @return iconFace <code>String</code>
     */
    public String getIconFace() {
        return iconFace;
    }

    /**
     * This method used to set Icon face
     *
     * @param iconFace <code>String</code>
     */
    public void setIconFace(String iconFace) {
        this.iconFace = iconFace;
    }

    /**
     * This method used to get Icon twitter
     *
     * @return iconTwitter <code>String</code>
     */
    public String getIconTwitter() {
        return iconTwitter;
    }

    /**
     * This method used to set Icon twitter
     *
     * @param iconTwitter <code>String</code>
     */
    public void setIconTwitter(String iconTwitter) {
        this.iconTwitter = iconTwitter;
    }

    /**
     * This method used to get Icon google
     *
     * @return iconGoogle <code>String</code>
     */
    public String getIconGoogle() {
        return iconGoogle;
    }

    /**
     * This method used to set Icon google
     *
     * @param iconGoogle <code>String</code>
     */
    public void setIconGoogle(String iconGoogle) {
        this.iconGoogle = iconGoogle;
    }

    /**
     * This method used to get Image main
     *
     * @return imageMain <code>String</code>
     */
    public String getImageMain() {
        return imageMain;
    }

    /**
     * This method used to set Image main
     *
     * @param imageMain <code>String</code>
     */
    public void setImageMain(String imageMain) {
        this.imageMain = imageMain;
    }

    /**
     * This method used to get Telephone
     *
     * @return telephone <code>String</code>
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method used to set Telephone
     *
     * @param telephone <code>String</code>
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * This method used to get Email
     *
     * @return email <code>String</code>
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method used to set Email
     *
     * @param email <code>String</code>
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method used to get Face_url
     *
     * @return faceUrl <code>String</code>
     */
    public String getFaceUrl() {
        return faceUrl;
    }

    /**
     * This method used to set Face_url
     *
     * @param faceUrl <code>String</code>
     */
    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    /**
     * This method used to get Twitter_url
     *
     * @return twitterUrl <code>String</code>
     */
    public String getTwitterUrl() {
        return twitterUrl;
    }

    /**
     * This method used to set Twitter_url
     *
     * @param twitterUrl <code>String</code>
     */
    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    /**
     * This method used to get Google_url
     *
     * @return googleUrl <code>String</code>
     */
    public String getGoogleUrl() {
        return googleUrl;
    }

    /**
     * This method used to set Google_url
     *
     * @param googleUrl <code>String</code>
     */
    public void setGoogleUrl(String googleUrl) {
        this.googleUrl = googleUrl;
    }

    /**
     * This method used to get About
     *
     * @return about <code>String</code>
     */
    public String getAbout() {
        return about;
    }

    /**
     * This method used to set About
     *
     * @param about <code>String</code>
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * This method used to get Address
     *
     * @return address <code>String</code>
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method used to set Address
     *
     * @param address <code>String</code>
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method used to get City
     *
     * @return city <code>String</code>
     */
    public String getCity() {
        return city;
    }

    /**
     * This method used to set City
     *
     * @param city <code>String</code>
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method used to get Country
     *
     * @return country <code>String</code>
     */
    public String getCountry() {
        return country;
    }

    /**
     * This method used to set Country
     *
     * @param country <code>String</code>
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * This method used to get Map_url
     *
     * @return mapUrl <code>String</code>
     */
    public String getMapUrl() {
        return mapUrl;
    }

    /**
     * This method used to set Map_url
     *
     * @param mapUrl <code>String</code>
     */
    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

}
