package com.example.myfoodapp.models;

public class MyCartModel {
    private String name, price;

    public MyCartModel(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

}