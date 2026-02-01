package com.example.pharmacy_mangment_system_project;

import  java.time.LocalDate;

public class Medication implements  ExpirationDate {
    private String name;
    private double price;
    //private int quantity;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String type;
    private String status;

    public LocalDate getExpiarydate() {
        return expiarydate;
    }

    public String getType() {
        return type;
    }

    public String getDosageInstructions() {
        return dosageInstructions;
    }

    public void setDosageInstructions(String dosageInstructions) {
        this.dosageInstructions = dosageInstructions;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setExpiarydate(LocalDate expiarydate) {
        this.expiarydate = expiarydate;
    }
    private String dosageInstructions;


    private  LocalDate expiarydate;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Medication(int id, String name, double price, LocalDate expiarydate, String dosageInstructions, String type, String status) {
        this.id = id;
        this.name = name;
        this.price = price;
        //this.quantity = quantity;
        this.expiarydate=expiarydate;
        this.dosageInstructions=dosageInstructions;
        this.type = type;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

//    public int getQuantity() {
//        return quantity;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
    @Override
    public LocalDate getExpirationDate(){
        //return expiarydate.getYear()+"/"+expiarydate.getMonth()+"/"+expiarydate.getDay();
        return getExpiarydate();
    }
}
