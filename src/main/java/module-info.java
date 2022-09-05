module com.example.airbnbproject2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.opencsv;
    requires javafx.web;


    opens com.example.airbnbproject2 to javafx.fxml;
    exports com.example.airbnbproject2;
}