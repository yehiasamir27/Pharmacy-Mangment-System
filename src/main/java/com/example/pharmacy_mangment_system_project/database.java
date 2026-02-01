package com.example.pharmacy_mangment_system_project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class database {
    public static Connection databaseLink;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pharmcy";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    public static Connection connectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink= DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            return databaseLink;


        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}
