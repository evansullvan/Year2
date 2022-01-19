module com.example.tableview {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;


    opens com.example.propertyshop to javafx.fxml,xstream;
    exports com.example.propertyshop;
}