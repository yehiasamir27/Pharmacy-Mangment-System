package com.example.pharmacy_mangment_system_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Login  {
    private PreparedStatement prepare;
    private Connection connect;
    private ResultSet result;
    @FXML
    private Button login_button;

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    public void loginAdmin(ActionEvent event){
        String query = "SELECT * FROM login WHERE username = ? AND password = ?";
        connect=database.connectDB();
        try {
            prepare = connect.prepareStatement(query);
            prepare.setString(1, username.getText());
            prepare.setString(2, password.getText());
            result = prepare.executeQuery();
            Alert alert;
            if(username.getText().isEmpty()|| password.getText().isEmpty()){
                alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error massage");
                alert.setHeaderText(null);
                alert.setContentText("please fill all blank filed");
                alert.showAndWait();
            }else {
                if (result.next()){
                    alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information massage");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully login");
                    alert.showAndWait();
                    login_button.getScene().getWindow().hide();
                    Parent root =  FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                    Stage stage =new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                }else {
                    alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error massage");
                    alert.setHeaderText(null);
                    alert.setContentText("wrong username or password");
                    alert.showAndWait();
                }
            }


        }
        catch (SQLException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
