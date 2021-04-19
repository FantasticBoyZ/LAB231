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
 * This class used to create attribute of Information
 *
 * @author Dương Thanh Tùng
 */
public class InformationEntity {

    /**
     * Create attributes
     */
    private String shortDescription, address, tel, email, openingHours, signature;

    /**
     * Create constructor with no parameters
     */
    public InformationEntity() {
    }

    /**
     * Create constructor with parameters
     *
     * @param shortDescription <code>String</code>
     * @param address <code>String</code>
     * @param tel <code>String</code>
     * @param email <code>String</code>
     * @param openingHours <code>String</code>
     * @param signature <code>String</code>
     */
    public InformationEntity(String shortDescription, String address, String tel, String email, String openingHours, String signature) {
        this.shortDescription = shortDescription;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.openingHours = openingHours;
        this.signature = signature;
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
     * This method used to get Address
     *
     * @return address
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
     * This method used to get Tel
     *
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method used to set Tel
     *
     * @param tel <code>String</code>
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * This method used to get Email
     *
     * @return email
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
     * This method used to get OpeningHours
     *
     * @return openingHours
     */
    public String getOpeningHours() {
        return openingHours;
    }

    /**
     * This method used to set OpeningHours
     *
     * @param openingHours <code>String</code>
     */
    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    /**
     * This method used to get Signature
     *
     * @return signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * This method used to set Signature
     *
     * @param signature <code>String</code>
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

}
