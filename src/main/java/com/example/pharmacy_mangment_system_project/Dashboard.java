package com.example.pharmacy_mangment_system_project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.*;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Dashboard {
    @FXML
    private TextField Add_acc_search;

    @FXML
    private TableView<accessories> Add_acc_table;

    @FXML
    private TextField Add_med_search;

    @FXML
    private TableView<Medication> Add_table_med;

    @FXML
    private Label Available_med_label;

    @FXML
    private Button Buying_acc_btn;

    @FXML
    private Button Buying_med_btn;

    @FXML
    private Button Dashboard_btn;

    @FXML
    private Button Logout_btn;

    @FXML
    private Label Purchase_Balance;

    @FXML
    private Label Purchase_Balance_acc;

    @FXML
    private ComboBox<?> Purchase_Med_ID;

    @FXML
    private ComboBox<?> Purchase_Med_Name;
    @FXML
    private Spinner<Integer> Purchase_QTY;

    @FXML
    private ComboBox<?> Purchase_Med_type;
    @FXML
    private ComboBox<?> add_med_status;

    @FXML
    private ComboBox<?> Purchase_acc_id;

    @FXML
    private TableColumn<?, ?> Purchase_acc_id_col;

    @FXML
    private ComboBox<?> Purchase_acc_name;

    @FXML
    private TableColumn<?, ?> Purchase_acc_name_col;

    @FXML
    private TableColumn<?, ?> Purchase_acc_price_col;

    @FXML
    private TableColumn<?, ?> Purchase_acc_qty_col;

    @FXML
    private TableView<?> Purchase_acc_table;

    @FXML
    private Button Purchase_add_btn;

    @FXML
    private Button Purchase_add_btn1;

    @FXML
    private Button Purchase_add_btn11;

    @FXML
    private Button Purchase_add_btn111;

    @FXML
    private Button Purchase_add_btn1111;

    @FXML
    private TextField Purchase_amount;

    @FXML
    private TextField Purchase_amount_acc;

    @FXML
    private TableColumn<customerData, String> Purchase_med_id_col;

    @FXML
    private TableColumn<customerData, String> Purchase_med_name_col;

    @FXML
    private TableColumn<customerData, String> Purchase_med_price_col;

    @FXML
    private TableColumn<customerData, String> Purchase_med_qty_col;

    @FXML
    private TableColumn<customerData, String> Purchase_med_type_col;

    @FXML
    private TableView<customerData> Purchase_table;

    @FXML
    private Label Purchase_total;

    @FXML
    private Label Purchase_total_acc;

    @FXML
    private Button acc_add_btn;

    @FXML
    private Button acc_pay_btn;

    @FXML
    private TextField add_acc_id;

    @FXML
    private TableColumn<accessories, Integer> add_acc_id_col;

    @FXML
    private TableColumn<accessories, Double> add_acc_price_col;

    @FXML
    private TextField add_acc_name;

    @FXML
    private TableColumn<accessories, String> add_acc_name_col;


    @FXML
    private TextField add_acc_price;

    @FXML
    private TextField add_med_Price;

    @FXML
    private Button add_med_btn;

    @FXML
    private TableColumn<Medication, Date> add_med_date_col;

    @FXML
    private TextField add_med_id;

    @FXML
    private TableColumn<Medication, String> add_med_id_col;

    @FXML
    private TextField add_med_name;

    @FXML
    private TableColumn<Medication, String> add_med_name_col;

    @FXML
    private TableColumn<Medication, String> add_med_price_col;

    @FXML
    private ComboBox<?> add_med_type;

    @FXML
    private TableColumn<Medication, String> add_med_type_col;
    @FXML
    private TableColumn<Medication, String> add_med_statue_col;

    @FXML
    private Button clear_med_btn;

    @FXML
    private Button inserting_acc_btn;

    @FXML
    private Button inserting_med_btn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button remove_med_btn;

    @FXML
    private Label total_income_label;

    @FXML
    private Button update_med_btn;
    @FXML
    private AnchorPane AddMedicines_form;

    @FXML
    private AnchorPane Add_acc_form;
    @FXML
    private AnchorPane dashboard_form;
    @FXML
    private AnchorPane BuyMedicines_form;

    @FXML
    private AnchorPane Buy_acc_form;
    @FXML
    private TextField add_med_Instuction;
    @FXML
    private DatePicker Add_med_date;
    @FXML
    private TableColumn<Medication, String> add_med_instr_col1;
    private PreparedStatement prepare;
    private Connection connect;
    private ResultSet result;
    private Statement statement;
    //private Pharmacy p1=new Pharmacy();


    Alert alert;

    public Dashboard() throws IOException {
    }

    public void logout() {
        try {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("CONFIRMATION MASSAGE");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you wanna logout?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                Logout_btn.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchForm(ActionEvent event) throws IOException {
        if (event.getSource() == Dashboard_btn) {
            dashboard_form.setVisible(true);
            AddMedicines_form.setVisible(false);
            BuyMedicines_form.setVisible(false);
            Add_acc_form.setVisible(false);
            Buy_acc_form.setVisible(false);
            homeAM();
            homeTC();


        } else if (event.getSource() == inserting_med_btn) {
            dashboard_form.setVisible(false);
            AddMedicines_form.setVisible(true);
            BuyMedicines_form.setVisible(false);
            Add_acc_form.setVisible(false);
            Buy_acc_form.setVisible(false);
            addMedicineShowListData();
            addmedlist();
            setAdd_med_status();
        } else if (event.getSource() == Buying_med_btn) {
            dashboard_form.setVisible(false);
            AddMedicines_form.setVisible(false);
            BuyMedicines_form.setVisible(true);
            Add_acc_form.setVisible(false);
            Buy_acc_form.setVisible(false);
            purshaeType();
            purshaemedid();
            setPurchase_Med_Name();
            purchaseshowlistdata();
            purchaseshowvalue();
            purchasedisplaytotal();
        } else if (event.getSource() == inserting_acc_btn) {
            dashboard_form.setVisible(false);
            AddMedicines_form.setVisible(false);
            BuyMedicines_form.setVisible(false);
            Add_acc_form.setVisible(true);
            Buy_acc_form.setVisible(false);
            addacclist();


        } else if (event.getSource() == Buying_acc_btn) {
            dashboard_form.setVisible(false);
            AddMedicines_form.setVisible(false);
            BuyMedicines_form.setVisible(false);
            Add_acc_form.setVisible(false);
            Buy_acc_form.setVisible(true);
        }

    }

    //Medication meddata;
    Pharmacy pharmacy = Pharmacy.getInstance();


    public ObservableList<Medication> addmedicineslistdata() {
        ObservableList<Medication> listData = FXCollections.observableArrayList();
        //pharmacy.getMedication_inventory();

        connect = database.connectDB();

        String selectQuery = "SELECT * FROM medicine";
        try {
            assert connect != null;
            try (PreparedStatement selectStmt = connect.prepareStatement(selectQuery)) {
                ResultSet resultSet = selectStmt.executeQuery();
                while (resultSet.next()) {
                    //              if(add_med_Instuction.getText().equals("null")){
                    //                  Medication med=new Medication(result.getInt("medicine_id"),result.getString("Medicine_name"),result.getDouble("Price"),result.getDate("date"),result.getString("type"));
                    //                  p1.addMedication(med);
                    //            }
                    //              else if(add_med_Instuction.getText()!="null"){
                    //                  PrescriptionMedication med=new PrescriptionMedication(result.getInt("medicine_id"),result.getString("Medicine_name"),result.getDouble("Price"),result.getDate("date"),result.getString("medicine_instr"),result.getString("type"));
                    //                  p1.addMedication(med);
                    //              }
                    PrescriptionMedication med = new PrescriptionMedication(resultSet.getInt("medicine_id"), resultSet.getString("Medicine_name"), resultSet.getDouble("Price"), resultSet.getDate("date").toLocalDate(), resultSet.getString("medicine_instr"), resultSet.getString("type"), resultSet.getString("status"));
                    listData.add(med);
                    //pharmacy.getMedication_inventory().add(med);


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<Medication> addmedcinelist;

    public void addMedicineShowListData() {
        addmedcinelist = addmedicineslistdata();

        add_med_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        add_med_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        add_med_type_col.setCellValueFactory(new PropertyValueFactory<>("type"));
        add_med_price_col.setCellValueFactory(new PropertyValueFactory<>("price"));
        add_med_instr_col1.setCellValueFactory(new PropertyValueFactory<>("dosageInstructions"));
        add_med_date_col.setCellValueFactory(new PropertyValueFactory<>("expiarydate"));
        add_med_statue_col.setCellValueFactory(new PropertyValueFactory<>("status"));
        //Add_table_med.setItems(p1.getMedication_inventory());
        Add_table_med.setItems(addmedcinelist);

    }

    public void addMedicineSelect() {
        Medication meddata = Add_table_med.getSelectionModel().getSelectedItem();

        //pharmacy.getMedication_inventory().add(Add_table_med.getSelectionModel().getSelectedItem());
        int num = Add_table_med.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            return;
        }
        add_med_name.setText(meddata.getName());
        //add_med_name.setText();
        add_med_id.setText(String.valueOf(meddata.getId()));
        add_med_Price.setText(String.valueOf(meddata.getPrice()));
        add_med_Instuction.setText(String.valueOf(meddata.getDosageInstructions()));
        //add_med_type.getSelectionModel().getSelectedItem();
        Add_med_date.setValue(meddata.getExpirationDate());


    }

    public String[] addmedicinlisttype = {"Analgesics", "Antibiotics", "Antiseptics"};

    public void addmedlist() {
        List<String> listt = new ArrayList<String>();
        listt.addAll(Arrays.asList(addmedicinlisttype));
        ObservableList Listdata = FXCollections.observableArrayList(listt);
        add_med_type.setItems(Listdata);
    }

    public String[] medsatutes = {"available", "not available"};

    public void setAdd_med_status() {
        List<String> lists = new ArrayList<String>();
        lists.addAll(Arrays.asList(medsatutes));
        ObservableList Listdatasta = FXCollections.observableArrayList(lists);
        add_med_status.setItems(Listdatasta);

    }

    public void addmedicineADD() {
        connect = database.connectDB();
            String insertQuery = "INSERT INTO medicine (medicine_id, Medicine_name, type, Price, date, medicine_instr,status) VALUES (?, ?, ?, ?, ?, ?,?)";

        try {
            Alert alert;
            if (add_med_name.getText().isEmpty() || add_med_type.getSelectionModel().getSelectedItem() == null || Add_med_date.getValue() == null || add_med_Price.getText().isEmpty() || add_med_id.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            } else {
                String checkData = "SELECT medicine_id FROM medicine WHERE medicine_id=?";
                PreparedStatement checkStmt = connect.prepareStatement(checkData);
                checkStmt.setInt(1, Integer.parseInt(add_med_id.getText()));
                ResultSet resultSet = checkStmt.executeQuery();
                if (resultSet.next()) {
                    // Medicine ID already exists, show error message
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error message");
                    alert.setHeaderText(null);
                    alert.setContentText("Medicine ID already exists");
                    alert.showAndWait();
                } else {
                    PreparedStatement insertStmt = connect.prepareStatement(insertQuery);
                    insertStmt.setInt(1, Integer.parseInt(add_med_id.getText()));
                    insertStmt.setString(2, add_med_name.getText());
                    insertStmt.setString(3, (String) add_med_type.getSelectionModel().getSelectedItem());
                    insertStmt.setString(4, add_med_Price.getText());
                    insertStmt.setDate(5, java.sql.Date.valueOf(Add_med_date.getValue()));
                    insertStmt.setString(6, add_med_Instuction.getText());
                    insertStmt.setString(7, (String) add_med_status.getSelectionModel().getSelectedItem());
                    insertStmt.executeUpdate();
                    addMedicineShowListData();
                    //insertStmt.close();
                }
                //checkStmt.close();
                //resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void addmedrest() {
        add_med_name.setText("");
        add_med_id.setText("");
        add_med_Price.setText("");
        add_med_type.getSelectionModel().clearSelection();
        add_med_Instuction.setText("");
        Add_med_date.setValue(null);

    }

    public void updateMedicine() {
        connect = database.databaseLink;
        String sql = "UPDATE medicine SET medicine_id = ?, Medicine_name = ?, type = ?, price = ?, date = ?, medicine_instr = ?,status=? WHERE medicine_id = ?";

        try {
            Alert alert;
            if (add_med_name.getText().isEmpty() || add_med_type.getSelectionModel().getSelectedItem() == null || Add_med_date.getValue() == null || add_med_Price.getText().isEmpty() || add_med_id.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to update?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    PreparedStatement preparedStatement = connect.prepareStatement(sql);
                    preparedStatement.setInt(1, Integer.parseInt(add_med_id.getText()));
                    preparedStatement.setString(2, add_med_name.getText());
                    preparedStatement.setString(3, (String) add_med_type.getSelectionModel().getSelectedItem());
                    preparedStatement.setString(4, add_med_Price.getText());
                    preparedStatement.setDate(5, java.sql.Date.valueOf(Add_med_date.getValue()));
                    preparedStatement.setString(6, add_med_Instuction.getText());
                    preparedStatement.setString(7, (String) add_med_status.getSelectionModel().getSelectedItem());
                    preparedStatement.setInt(8, Integer.parseInt(add_med_id.getText()));
                    preparedStatement.executeUpdate();

                    addMedicineShowListData();
                    addmedrest();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMedicine() {
        Medication meddata = Add_table_med.getSelectionModel().getSelectedItem();
        int num = Add_table_med.getSelectionModel().getSelectedIndex();
        if (num < 0) {
            return; // No row selected, exit the method
        }

        int medicineId = meddata.getId(); // Assuming the ID is stored in the "id" field of the Medication object
        String deleteQuery = "DELETE FROM medicine WHERE medicine_id = ?";

        try (Connection connection = database.connectDB()) {
            assert connection != null;
            try (PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery)) {
                deleteStmt.setInt(1, medicineId);
                deleteStmt.executeUpdate();
                addMedicineShowListData(); // Refresh the table data after deletion
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void purshaeType() {
        String sql = "SELECT * FROM medicine WHERE status ='available'";
        connect = database.connectDB();
        try {
            ObservableList listData = FXCollections.observableArrayList();
            //assert connect != null;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                listData.add(result.getString("type"));
            }
            Purchase_Med_type.setItems(listData);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void purshaemedid() {
        String sql = "SELECT * FROM medicine WHERE type ='" + Purchase_Med_type.getSelectionModel().getSelectedItem() + "'";
        //String selected= (String) Purchase_Med_type.getSelectionModel().getSelectedItem();
        //String sql="SELECT * FROM medicine WHERE type ='nocia'OR type='antipayotic'";;

        connect = database.connectDB();
        try {
            ObservableList listData = FXCollections.observableArrayList();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                listData.add(result.getString("medicine_id"));
            }
            Purchase_Med_ID.setItems(listData);
            setPurchase_Med_Name();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setPurchase_Med_Name() {
        String sql = "SELECT * FROM medicine WHERE medicine_id ='" + Purchase_Med_ID.getSelectionModel().getSelectedItem() + "'";
        //String selected= (String) Purchase_Med_type.getSelectionModel().getSelectedItem();
        //String sql="SELECT * FROM medicine WHERE type ='nocia'OR type='antipayotic'";;

        connect = database.connectDB();
        try {
            ObservableList listData = FXCollections.observableArrayList();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                listData.add(result.getString("Medicine_name"));
            }
            Purchase_Med_Name.setItems(listData);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public ObservableList<customerData> buylistdata() {
        buycustomerID();
        String sql = "SELECT * FROM customer WHERE customer_id='" + customerID + "'";
        ObservableList<customerData> listData = FXCollections.observableArrayList();
        connect = database.databaseLink;
        try {
            customerData customerdata;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                customerdata = new customerData(result.getInt("customer_id"), result.getString("type"), result.getInt("medicine_id"), result.getString("medicine_name"), result.getInt("qty"), result.getDouble("price"), result.getDate("date"));
                listData.add(customerdata);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;


    }

    private int customerID;

    public void buycustomerID() {
        String sql = "SELECT customer_id FROM customer";
        connect = database.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            if (result.next()) {
                customerID = result.getInt("customer_id");
            }
            int CID = 0;
            String checkData = "SELECT customerid FROM customer_info";
            statement = connect.createStatement();
            result = statement.executeQuery(checkData);
            if (result.next()) {
                CID = result.getInt("customerid");

            }
            if (customerID == 0) {
                customerID += 1;
            } else if (CID == customerID) {
                customerID += 1;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private ObservableList<customerData> purchaselist;

    public void purchaseshowlistdata() {
        purchaselist = buylistdata();
        Purchase_med_id_col.setCellValueFactory(new PropertyValueFactory<>("medicineId"));
        Purchase_med_name_col.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
        Purchase_med_type_col.setCellValueFactory(new PropertyValueFactory<>("type"));
        Purchase_med_qty_col.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        Purchase_med_price_col.setCellValueFactory(new PropertyValueFactory<>("price"));
        Purchase_table.setItems(purchaselist);


    }

    private SpinnerValueFactory<Integer> spinner;

    public void purchaseshowvalue() {
        spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 20, 0);
        Purchase_QTY.setValueFactory(spinner);
    }

    private int Qty;
    private double totalP;

    public void purchasequantity() {
        Qty = Purchase_QTY.getValue();

    }

    public void purchaseadd() {
        buycustomerID();

        String insertQuery = "INSERT INTO customer (customer_id, type, medicine_id, medicine_name, qty, price, date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        connect = database.connectDB();
        try {
            Alert alert;
            if (Purchase_Med_type.getSelectionModel().getSelectedItem() == null
                    || Purchase_Med_ID.getSelectionModel().getSelectedItem() == null
                    || Purchase_Med_Name.getSelectionModel().getSelectedItem() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setContentText("Please fill all blanks");
                alert.showAndWait();
            } else {
                PreparedStatement insertStmt = connect.prepareStatement(insertQuery);
                insertStmt.setString(1, String.valueOf(customerID));
                insertStmt.setString(2, (String) Purchase_Med_type.getSelectionModel().getSelectedItem());
                insertStmt.setString(3, String.valueOf(Purchase_Med_ID.getSelectionModel().getSelectedItem()));
                insertStmt.setString(4, (String) Purchase_Med_Name.getSelectionModel().getSelectedItem());
                insertStmt.setString(5, String.valueOf(Qty));

                String checkdata = "SELECT Price FROM medicine WHERE medicine_id = ?";
                PreparedStatement prepareCheckData = connect.prepareStatement(checkdata);
                prepareCheckData.setString(1, String.valueOf(Purchase_Med_ID.getSelectionModel().getSelectedItem()));
                ResultSet resultCheckData = prepareCheckData.executeQuery();

                double priceD = 0;
                double totalprice = 0;
                if (resultCheckData.next()) {
                    priceD = resultCheckData.getDouble("Price");
                }
                totalP = (priceD * Qty);
                insertStmt.setString(6, String.valueOf(totalP));

                java.util.Date date = new java.util.Date();
                java.sql.Date startDate = new java.sql.Date(date.getTime());
                insertStmt.setString(7, String.valueOf(startDate));

                insertStmt.executeUpdate();
                purchaseshowlistdata();
                purchasedisplaytotal();
            }
            prepare.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double balance;
    private double amount;

    public void Purchasamount() {
        if (Purchase_amount.getText().isEmpty() || totalpriceD == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error massage");
            alert.setContentText(null);
            alert.setContentText("invalid:3");
            alert.showAndWait();
        } else {
            amount = Double.parseDouble(Purchase_amount.getText());
            if (totalpriceD > amount) {
                Purchase_amount.setText("");
            } else {
                balance = (amount - totalpriceD);
                Purchase_Balance.setText(String.valueOf(balance));
            }
        }
    }

    private double totalpriceD;

    public void purchasedisplaytotal() {
        String sql = "SELECT SUM(price) FROM customer WHERE customer_id='" + customerID + "'";
        connect = database.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            if (result.next()) {
                totalpriceD = result.getDouble("SUM(price)");
            }
            Purchase_total.setText("$" + String.valueOf(totalpriceD));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void purchasePay() {
        buycustomerID();
        String sql = "INSERT INTO customer_info (customerid, total, date) VALUES (?, ?, ?)";
        connect = database.connectDB();
        try {
            Alert alert;
            if (totalpriceD == 0) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("something wrong");
                alert.showAndWait();


            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setContentText("ARE YOU SURE?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, String.valueOf(customerID));
                    prepare.setString(2, String.valueOf(totalpriceD));
                    java.util.Date date = new java.util.Date();
                    java.sql.Date startDate = new java.sql.Date(date.getTime());
                    prepare.setString(3, String.valueOf(startDate));
                    prepare.executeUpdate();
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("successfull");
                    alert.showAndWait();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void homeTC() {
        String sql = "SELECT SUM(total) FROM customer_info ";
        connect = database.connectDB();
        double totalDisplay = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                totalDisplay = result.getDouble("SUM(total)");
                total_income_label.setText("$" + String.valueOf(totalDisplay));

            }


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void homeAM() {
        String sql = "SELECT COUNT(medicine_id) FROM medicine WHERE status='available'";
        connect = database.connectDB();
        int countam = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                countam = result.getInt("COUNT(medicine_id)");

            }
            Available_med_label.setText(String.valueOf(countam));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public class TextFileManager {
        private String fileName;

        public TextFileManager(String fileName) {
            this.fileName = fileName;
        }

        public void createNewFile() throws IOException {
            File file = new File(fileName);
            if (file.exists()) {
                System.out.println("File already exists: " + fileName);
                return;
            }

            if (file.createNewFile()) {
                System.out.println("New file created: " + fileName);
            } else {
                System.out.println("Failed to create the file: " + fileName);
            }
        }

        public void storeDataToFile(accessories accessory) throws IOException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(textFileManager.getFileName(), true))) {
                writer.write(accessory.getId() + "," + accessory.getName() + "," + accessory.getPrice());
                writer.newLine();
                System.out.println("Data added to the file successfully.");
            }
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public void readDataFromFile() throws IOException {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    double price = Double.parseDouble(data[2]);
                    accessories accessory = new accessories(id, name, price);
                    pharmacy.getAccessories_inventory().add(accessory);

                }
            }
        }
    }
    TextFileManager textFileManager=new TextFileManager("C:\\Users\\ASUS\\Desktop\\accessory2.txt");
    public void ADDacc(ActionEvent e) throws IOException {
        if (add_acc_name.getText().isEmpty()||add_acc_id.getText().isEmpty()||add_acc_price.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the blank fields");
            alert.showAndWait();
        }
        else {


            textFileManager.createNewFile();
            int id = Integer.parseInt(add_acc_id.getText());
            String name = add_acc_name.getText();
            Double price = Double.valueOf(add_acc_price.getText());
            accessories accessory = new accessories(id, name, price);
            pharmacy.getAccessories_inventory().add(accessory);
            //addacclist();
            textFileManager.storeDataToFile(accessory);
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("successfull");
            alert.showAndWait();
        }

    }
    public void addacclist() throws IOException {
        Add_acc_table.getItems().clear();
        textFileManager.readDataFromFile();

        add_acc_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        add_acc_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        add_acc_price_col.setCellValueFactory(new PropertyValueFactory<>("price"));
        //Add_table_med.setItems(p1.getMedication_inventory());
        Add_acc_table.setItems(pharmacy.getAccessories_inventory());

    }
    public void addACCSelect() {

        ObservableList<accessories> accessories_inventory = pharmacy.getAccessories_inventory();


        //pharmacy.getMedication_inventory().add(Add_table_med.getSelectionModel().getSelectedItem());
        int num = Add_acc_table.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            return;
        }

        accessories selectedAccessory = Add_acc_table.getSelectionModel().getSelectedItem();
        if (selectedAccessory != null) {
            add_acc_name.setText(selectedAccessory.getName());
            add_acc_id.setText((String.valueOf(selectedAccessory.getId())));
            add_acc_price.setText(String.valueOf(selectedAccessory.getPrice()));
        } else {
            add_acc_name.setText(""); // Set an empty string if no accessory is selected
            add_acc_id.setText("");
            add_acc_price.setText("");
        }
    }
    public void deleteSelectedAccessory() throws IOException {

        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete?");
        Optional<ButtonType> option = alert.showAndWait();
        accessories selectedAccessory = Add_acc_table.getSelectionModel().getSelectedItem();
        if (selectedAccessory != null) {
            // Remove the selected accessory from the ObservableList
            pharmacy.getAccessories_inventory().remove(selectedAccessory);

            // Clear the contents of the text file
            PrintWriter writer = new PrintWriter(textFileManager.getFileName());
            writer.print("");
            writer.close();

            // Rewrite the data to the text file
            for (accessories accessory : pharmacy.getAccessories_inventory()) {
                textFileManager.storeDataToFile(accessory);
            }


            //addacclist();
        }
    }
    public void updateAccessory() throws IOException {
        if (add_acc_name.getText().isEmpty()||add_acc_id.getText().isEmpty()||add_acc_price.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the blank fields");
            alert.showAndWait();
        }
        else {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to update?");
            Optional<ButtonType> option = alert.showAndWait();
            accessories selectedAccessory = Add_acc_table.getSelectionModel().getSelectedItem();
            if (selectedAccessory != null) {
                selectedAccessory.setName(add_acc_name.getText());
                selectedAccessory.setPrice(Double.valueOf(add_acc_price.getText()));

                // Update the text file
                rewriteTextFile();

                // Refresh the TableView
                addacclist();

            }
        }
    }

    private void rewriteTextFile() throws IOException {
        // Clear the contents of the text file
        PrintWriter writer = new PrintWriter(textFileManager.getFileName());
        writer.print("");
        writer.close();

        // Rewrite the updated data to the text file
        for (accessories accessory : pharmacy.getAccessories_inventory()) {
            textFileManager.storeDataToFile(accessory);
        }
    }
    public void addAccrest() {
        add_acc_name.setText("");
        add_acc_id.setText("");
        add_acc_price.setText("");
    }

}




















