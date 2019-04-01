package com.example.gapp.model;

public class CarItem {

    //fields
    private String name;
    private double price;
    private String tag;
    private  String description;



    //Constructor
    public CarItem(String name , String tag, double price,String description){
        this.name=name;
        this.tag=tag;
        this.price=price;
        this.description=description;
    }

    //methods
    public String getName() {return name;}
    public  double getPrice() {return price;}
    public String getTag(){return  tag;}
    public String getDescription() { return description; }


}
