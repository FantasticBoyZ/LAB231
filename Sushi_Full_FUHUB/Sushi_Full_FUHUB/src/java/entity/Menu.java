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
public class Menu {
    private int id;
    private String name;
    private String price;
    private String shortDes;
    private String detailDes;

    public Menu() {
    }

    public Menu(int id, String name, String price, String shortDes, String detailDes) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.shortDes = shortDes;
        this.detailDes = detailDes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getShortDes() {
        return shortDes;
    }

    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

    public String getDetailDes() {
        return detailDes;
    }

    public void setDetailDes(String detailDes) {
        this.detailDes = detailDes;
    }
    
}
