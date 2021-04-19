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
public class Sushi {
    private int id;
    private String name;
    private String image;
    private String shortDes;
    private String detailDes;
    private String price;
    public Sushi() {
    }

    public Sushi(int id, String name, String image, String shortDes, String detailDes, String price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.shortDes = shortDes;
        this.detailDes = detailDes;
        this.price = price;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
}
