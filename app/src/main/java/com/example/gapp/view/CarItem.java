package com.example.gapp.view;

public class CarItem {

    //fields
    private String name;
    private double price;
    private String tag;

    //Constructor
    public CarItem(String name , String tag, double price){
        this.name=name;
        this.tag=tag;
        this.price=price;
    }

    //methods
    public String getName() {return name;}
    public  double getPrice() {return price;}
    public String getTag(){return  tag;}
}
