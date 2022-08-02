module com.example.airbnbproject2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.airbnbproject2 to javafx.fxml;
    exports com.example.airbnbproject2;
}