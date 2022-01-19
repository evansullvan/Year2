/**
 @Author: Evan Sullivan
 @Version 4.0
 @Date: 9/12/2021
 */

package com.example.propertyshop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class nonregsiteredController implements Initializable {

    PropertyShop propertylist;

    //combo boxes for the search options
    @FXML
    private ComboBox<String> searchCategory;
    @FXML
    private ComboBox<String> searchlocation;
    ObservableList<String> categories = FXCollections.observableArrayList("All", "Condo", "Single Family Home", "Townhouse", "Room");
    ObservableList<String> locations = FXCollections.observableArrayList("All", "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe", "Palestine");


    @FXML
    private Button detailedProductViewButton;
    @FXML
    private TableView tblView;
    @FXML
    private TableColumn<Property, Integer> idColumn;
    @FXML
    private TableColumn<Property, String> LocationColumn;
    @FXML
    private TableColumn<Property, String> descriptionColumn;
    @FXML
    private TableColumn<Property, Double> costColumn;
    @FXML
    private TableColumn<Property, String> typeColumn;
    @FXML
    private Label feedbackArea;

    //sends user to login page
    @FXML
    protected void onLoginClicked(ActionEvent event) {

        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);

            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            feedbackArea.setText("Unable to load Login screen");
        }
    }


    //sends user to register page
    @FXML
    protected void onRegisterClicked(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Register.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 680, 470);

            stage.setTitle("Register Page");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            feedbackArea.setText("Unable to load Register page");
        }
    }


    //changes observable list to only show certain types of houses
    public void changedCategoryCombo(ActionEvent e) throws Exception {
        tblView.setItems(FXCollections.observableArrayList(propertylist.getPropertyList(searchCategory.getValue(), searchlocation.getValue())));
    }


    //changes observable list to only show certain locations of houses
    public void changedlocationCombo(ActionEvent e) throws Exception {
        tblView.setItems(FXCollections.observableArrayList(propertylist.getPropertyList(searchCategory.getValue(), searchlocation.getValue())));
    }

    //changes to a detailed view for that selected property
    public void changeSceneToDetailedView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DetailedViewforUnreg.fxml"));
        Parent tableViewParent = loader.load();

        Scene tableViewScene = new Scene(tableViewParent);

        //access the controller and call a method
        DetailedPropertyViewController controller = loader.getController();
        Property propertyToDisplay = (Property) tblView.getSelectionModel().getSelectedItem(); //cast as Product
        if (propertyToDisplay == null) //sometimes no Product will have been selected
            return;

        controller.initData(propertyToDisplay);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        propertylist = new PropertyShop();  // initialise shop to a new (empty) collection of Properties



        propertylist.addProperty("first property", "123 street", "Room", "Ireland", "A", "x91n7d6", 99999, "7645", "Available", "file:/C:/Users/evans/Pictures/EEEEEEEEEEEEEEEEEEEEEEEEE.jpg");
        propertylist.addProperty("second property", "125 street", "Condo", "Andorra", "A", "x91n7d6", 9876599, "7625", "Available", "file:/C:/Users/evans/Pictures/EEEEEEEEEEEEEEEEEEEEEEEEE.jpg");


        ObservableList<Property> data =
                FXCollections.observableArrayList(propertylist.getPropertyList());

        idColumn.setCellValueFactory(new PropertyValueFactory<Property, Integer>("propertyid"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("description"));
        LocationColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("location"));
        costColumn.setCellValueFactory(new PropertyValueFactory<Property, Double>("price"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("Category"));

//search combo boxes
        searchCategory.setItems(categories);
        searchlocation.setItems(locations);
        searchCategory.setValue("All");
        searchlocation.setValue("All");

    }


    //if user slects on the table, change the property button to nondisabled, and retrieves the arraylists of
    // properties and displays them in the table view
    public void userClickedOnTable() {
        tblView.setItems(FXCollections.observableArrayList(propertylist.getPropertyList()));

        detailedProductViewButton.setDisable(false);
    }
}
