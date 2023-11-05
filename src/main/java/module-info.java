module com.example.whatsapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.whatsapp to javafx.fxml;
    exports com.example.whatsapp;
}