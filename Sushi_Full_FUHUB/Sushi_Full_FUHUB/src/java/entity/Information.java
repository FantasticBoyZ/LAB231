/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author trinh hoan
 */
public class Information {
    private int id;
    private String address;
    private String tel;
    private String email;
    private String openingHours;

    public Information(){
    }

    public Information(int id, String address, String tel, String email, String openingHours) {
        this.id = id;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.openingHours = openingHours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }
   
    
}
