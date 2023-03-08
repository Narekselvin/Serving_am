package com.example.myfoodapp.models;

public class DailyMealModel {
    String image;
    String name;
    String discount;
    String description;
    String type;


    public DailyMealModel(String image, String name, String discount, String description, String type) {
        this.image = image;
        this.name = name;
        this.discount = discount;
        this.description = description;
        this.type = type;
    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
