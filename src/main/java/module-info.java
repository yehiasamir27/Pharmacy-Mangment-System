module com.example.pharmacy_mangment_system_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.pharmacy_mangment_system_project to javafx.fxml;
    exports com.example.pharmacy_mangment_system_project;
}