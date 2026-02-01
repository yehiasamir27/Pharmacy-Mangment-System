package com.example.pharmacy_mangment_system_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Pharmacy {
    private PreparedStatement prepare;
    private Connection connect;

    private ResultSet result;
    private Statement statement;

    private static Pharmacy instance;

    private ObservableList<Medication> medication_inventory;
    private ObservableList<accessories> accessories_inventory;

    public ObservableList<Medication> getMedication_inventory() {
        return medication_inventory;
    }

    public void setMedication_inventory(ObservableList<Medication> medication_inventory) {
        this.medication_inventory = medication_inventory;
    }

    public static Pharmacy getInstance() {
        // Step 3: Create and return the singleton instance
        if (instance == null) {
            instance = new Pharmacy();
        }
        return instance;
    }


    private Pharmacy() {
        medication_inventory = FXCollections.observableArrayList();
        accessories_inventory = FXCollections.observableArrayList();
    }

    public ObservableList<accessories> getAccessories_inventory() {
        return accessories_inventory;
    }

    public void setAccessories_inventory(ObservableList<accessories> accessories_inventory) {
        this.accessories_inventory = accessories_inventory;
    }

    public void addMedication(Medication medication) {
        medication_inventory.add(medication);
    }

    public void addAccessories(accessories Accessories) {
        accessories_inventory.add(Accessories);
    }

    public void updateMedication(Medication medication) {
        for (Medication med : medication_inventory) {
            if (med.getName().equals(medication.getName())) {
                med.setPrice(medication.getPrice());
                break;
            }
        }
    }

    public void updateAccessories(accessories Accessories) {
        for (accessories acc : accessories_inventory) {
            if (acc.getName().equals(Accessories.getName())) {
                acc.setPrice(Accessories.getPrice());
                acc.setQuantity(Accessories.getQuantity());
                break;
            }
        }
    }

    public Medication searchMedication(String name) {
        for (Medication med : medication_inventory) {
            if (med.getName().equals(name)) {
                return med;
            }
        }
        return null;
    }

    public accessories searchAccessories(String name) {
        for (accessories acc : accessories_inventory) {
            if (acc.getName().equals(name)) {
                return acc;
            }
        }
        return null;
    }

//    public ObservableList<Medication> addmedicineslistdata() {
//        //ObservableList<Medication> listData=FXCollections.observableArrayList();
//        //pharmacy.getMedication_inventory();
//
//        connect = database.connectDB();
//
//        String selectQuery = "SELECT * FROM medicine";
//        try {
//            assert connect != null;
//            try (PreparedStatement selectStmt = connect.prepareStatement(selectQuery)) {
//                ResultSet resultSet = selectStmt.executeQuery();
//                while (resultSet.next()) {
//                    //              if(add_med_Instuction.getText().equals("null")){
//                    //                  Medication med=new Medication(result.getInt("medicine_id"),result.getString("Medicine_name"),result.getDouble("Price"),result.getDate("date"),result.getString("type"));
//                    //                  p1.addMedication(med);
//                    //            }
//                    //              else if(add_med_Instuction.getText()!="null"){
//                    //                  PrescriptionMedication med=new PrescriptionMedication(result.getInt("medicine_id"),result.getString("Medicine_name"),result.getDouble("Price"),result.getDate("date"),result.getString("medicine_instr"),result.getString("type"));
//                    //                  p1.addMedication(med);
//                    //              }
//                    PrescriptionMedication med = new PrescriptionMedication(resultSet.getInt("medicine_id"), resultSet.getString("Medicine_name"), resultSet.getDouble("Price"), resultSet.getDate("date").toLocalDate(), resultSet.getString("medicine_instr"), resultSet.getString("type"), resultSet.getString("status"));
//                    listData.add(med);
//                    //pharmacy.getMedication_inventory().add(med);
//
//
//                }
//            }
//        }
//    }

}

