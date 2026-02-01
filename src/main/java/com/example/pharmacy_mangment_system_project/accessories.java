package com.example.pharmacy_mangment_system_project;

public class accessories   {
    private String name;
    private double price;
    private int quantity;
       // private Date expiarydate;

//    public accessories(String name, double price, int quantity) {
//        this.name = name;
//        this.price = price;
//        this.quantity = quantity;
//
//    }
    private int id;
    public accessories(int id,String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id=id;
        //this.expiarydate =new Date(year,month,day);
    }
    public accessories(int id,String name, double price){
        this.name = name;
        this.price = price;
        //this.quantity = quantity;
        this.id=id;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
//    @Override
//    public String getExpirationDate(){
//        return expiarydate.getYear()+"/"+expiarydate.getMonth()+"/"+expiarydate.getDay();
//    }

}

