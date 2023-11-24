package com.automation.demoblaze.dataSchema;

public class ProductSchema {
    private String name;
    private String price;
    private String description;
    private String linkProductID;
    private String image;

    public ProductSchema(){

    }

    public ProductSchema(String name, String price, String description,String linkProductID, String image){
        this.name = name;
        this.price = price;
        this.description = description;
        this.linkProductID = linkProductID;
        this.image = image;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkProductID() {
        return linkProductID;
    }

    public void setLinkProductID(String linkProductID) {
        this.linkProductID = linkProductID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
