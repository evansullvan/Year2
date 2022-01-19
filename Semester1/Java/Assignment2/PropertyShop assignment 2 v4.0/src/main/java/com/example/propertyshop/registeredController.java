/**
 @Author: Evan Sullivan
 @Version 4.0
 @Date: 9/12/2021
 */


/**
 note
 this system allows Everyone to access the create,read and update
 but will only allow the users who created the property listing to update and delete it.*/


package com.example.propertyshop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

public class registeredController implements Initializable {
    PropertyShop propertylist;
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
    private TableColumn<Property, String> imageColumn;

    @FXML
    private ComboBox category;
    @FXML
    private ComboBox colocation;
    ObservableList<String> combocategory = FXCollections.observableArrayList("All", "Condo", "Single Family Home", "Townhouse", "Room");
    ObservableList<String> combolocation = FXCollections.observableArrayList("All", "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe", "Palestine");


    @FXML
    private ComboBox available;
    ObservableList<String> availablity = FXCollections.observableArrayList("Availibilty", "Not available", "Available");

    private String imageURL;

    @FXML
    private Label propertyIDfeedbackArea;
    @FXML
    private Label descriptionfeedbackArea;
    @FXML
    private Label addressfeedbackArea;
    @FXML
    private Label locationfeedbackArea;
    @FXML
    private Label availablefeedbackArea;
    @FXML
    private Label costfeedbackArea;
    @FXML
    private Label eircodefeedbackArea;
    @FXML
    private Label agentidfeedbackArea;
    @FXML
    private Label typefeedbackArea;
    @FXML
    private Label berfeedbackArea;
    @FXML
    private Label imagefeedbackArea;

    @FXML
    private TextField propertyID;

    @FXML
    private TextArea description;
    @FXML
    private TextField address;

    @FXML
    private TextField ber;
    @FXML
    private TextField cost;
    @FXML
    private TextField eircode;
    @FXML
    private TextField agentid;
    @FXML
    private Button deletebutton;

    @FXML
    private Button addimage;

    @FXML
    private Button updateproperty;

    UserStorage x = new UserStorage();
    HashMap<String, UserDetails> people = x.getUsers();

    private String imageName;


    //add property
    @FXML
    protected void onCreateButtonClick() throws Exception {
        //check fields are not empty

        descriptionfeedbackArea.setText(null);
        addressfeedbackArea.setText(null);
        locationfeedbackArea.setText(null);
        costfeedbackArea.setText(null);
        agentidfeedbackArea.setText(null);
        typefeedbackArea.setText(null);
        availablefeedbackArea.setText(null);
        if (description.getText().isBlank()) {
            descriptionfeedbackArea.setText("Must have a description longer than 13 char");
        }
        if (address.getText().isBlank()) {
            addressfeedbackArea.setText("Address cannot be blank");
        } else if (propertylist.getPropertyList().contains(address.getText())) {
            addressfeedbackArea.setText("Address already used");
        }
        if (colocation.getValue().equals("All")) {
            locationfeedbackArea.setText("Choose a location");
        }
        if (cost.getText().isBlank()) {
            costfeedbackArea.setText("Price cannot be blank");
        } else if (cost.getText().matches("[a-zA-Z]+")) {
            costfeedbackArea.setText("Only numbers allowed");
        }
        if (agentid.getText().isBlank()) {
            agentidfeedbackArea.setText("AgentID not completed");

        }
        if (ber.getText().isBlank()) {
            berfeedbackArea.setText("BER not completed");

        }

        if (eircode.getText().isBlank()) {
            eircodefeedbackArea.setText("Eircode not completed");

        } else if (propertylist.getPropertyList().contains(eircode.getText())) {
            eircodefeedbackArea.setText("Eircode already used");
        } else if (description.getText().length() < 10) {
            descriptionfeedbackArea.setText("description too short, Needs more than 13 characters");
        } else if (address.getText().length() < 13) {
            addressfeedbackArea.setText("Address Length too Short must be over 10 characters");


        } else if (category.getValue().equals("All")) {
            typefeedbackArea.setText("Property Category not selected");

        } else if (available.getValue().equals("Availibilty")) {
            availablefeedbackArea.setText("Availabilty not selected");
        } else {
            if (people.containsKey(agentid.getText())) {
                double c = Double.parseDouble(cost.getText());
                //Using wrapper class method to convert from String to double
                //Should use exception handling to cater for potential non numeric values
                int propertyId = propertylist.addProperty(description.getText(),
                        address.getText(), (String) category.getValue(), (String) colocation.getValue(), ber.getText(), eircode.getText(), c, agentid.getText(), (String) available.getValue(), imageURL);
                tblView.setItems(FXCollections.observableArrayList(propertylist.getPropertyList()));

                propertylist.save();

            } else {
                agentidfeedbackArea.setText("Enter a registered agent Email");
            }
        }
    }

    //remove property
    @FXML
    public void removeProperty() {
        if (agentid.getText().isBlank()) {
            agentid.setText("enter the correct Agent Email to delete this property");
        } else {

            Property propertyToDelete = (Property) tblView.getSelectionModel().getSelectedItem();


            if (!propertyToDelete.getAgentId().equals(agentid.getText())) {
                System.out.println("Email not the same");
                agentidfeedbackArea.setText("Email not the same, unable to delete property");
            }else {
                Alert alert =
                        new Alert(Alert.AlertType.WARNING,
                                "Delete this Property?",
                                ButtonType.OK,
                                ButtonType.CANCEL);
                alert.setTitle("Delete Property Warning");
                Optional<ButtonType> result = alert.showAndWait();
                //Notice showAndWait method
/*
=================End of Alert Code Display =======================
         Now Check to see if Delete confirmed
 */
                if (result.get() == ButtonType.OK) {
                    if (propertylist.getPropertyList().remove(propertyToDelete)) {  //
                        System.out.println("Deleted");
                        tblView.setItems(FXCollections.observableArrayList(propertylist.getPropertyList()));
                    }
                } else {
                    System.out.println("Delete Cancelled");
                }
                try {
                    propertylist.save();//End of Alert check
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//end of valid property id

    @FXML
    public void clickItem(MouseEvent event) {
        Property propertyTodisplay = (Property) tblView.getSelectionModel().getSelectedItem();
        if (event.getClickCount() == 2) //Checking double click
        {
            description.setText(propertyTodisplay.getDescription());
            address.setText(propertyTodisplay.getAddress());
            category.setValue(propertyTodisplay.getCategory());
            colocation.setValue("" + propertyTodisplay.getLocation());
            ber.setText("" + propertyTodisplay.getBer());
            eircode.setText("" + propertyTodisplay.getEircode());
            cost.setText("" + propertyTodisplay.getPrice());
            available.setValue(propertyTodisplay.isAvailable());
            agentid.setText(String.valueOf(propertyTodisplay.getAgentId()));

            detailedProductViewButton.setDisable(false);
            deletebutton.setDisable(false);
            updateproperty.setDisable(false);
        }
    }

    @FXML
    public void updateProperty() {

        if (agentid.getText().isBlank()) {
            agentid.setText("enter the correct Agent Email to Update this property");
        } else {
            Property propertyToUpdate = (Property) tblView.getSelectionModel().getSelectedItem();

            if (!propertyToUpdate.getAgentId().equals(agentid.getText())) {
                System.out.println("Email not the same");
                agentidfeedbackArea.setText("Email not the same, unable to delete property");
            }

            if (propertyToUpdate == null) {
                descriptionfeedbackArea.setText("Click a property to edit");
            }
            descriptionfeedbackArea.setText(null);
            addressfeedbackArea.setText(null);
            locationfeedbackArea.setText(null);
            costfeedbackArea.setText(null);
            agentidfeedbackArea.setText(null);
            typefeedbackArea.setText(null);
            availablefeedbackArea.setText(null);

            if (description.getText().isBlank()) {
                descriptionfeedbackArea.setText("Must have a description longer than 13 char");
            }
            if (address.getText().isBlank()) {
                addressfeedbackArea.setText("Address cannot be blank");
            } else if (propertylist.getPropertyList().contains(address.getText())) {
                addressfeedbackArea.setText("Address already used");
            }
            if (colocation.getValue().equals("All")) {
                locationfeedbackArea.setText("Location cannot be blank");
            }
            if (cost.getText().isBlank()) {
                costfeedbackArea.setText("Price cannot be blank");
            } else if (cost.getText().matches("[a-zA-Z]+")) {
                costfeedbackArea.setText("Only numbers allowed");
            }
            if (agentid.getText().isBlank()) {
                agentidfeedbackArea.setText("AgentID not completed");
            }
            if (ber.getText().isBlank()) {
                berfeedbackArea.setText("BER not completed");
            }
            if (eircode.getText().isBlank()) {
                eircodefeedbackArea.setText("Eircode not completed");
            } else if (propertylist.getPropertyList().contains(eircode.getText())) {
                eircodefeedbackArea.setText("Eircode already used");
            } else if (description.getText().length() < 10) {
                descriptionfeedbackArea.setText("description too short, Needs more than 13 characters");
            } else if (address.getText().length() < 13) {
                addressfeedbackArea.setText("Address Length too Short must be over 10 characters");

            } else if (category.getValue().equals("All")) {
                typefeedbackArea.setText("Property Category not selected");

            } else if (available.getValue().equals("Availibilty")) {
                availablefeedbackArea.setText("Availabilty not selected");
            } else {
                if (propertyToUpdate.getAgentId().equals(agentid.getText())) {
                    propertylist.editProperty(propertyToUpdate, description.getText(), address.getText(), String.valueOf(category.getValue()), String.valueOf(colocation.getValue()), ber.getText(), eircode.getText(), Double.parseDouble(cost.getText()), agentid.getText(), addimage.getText());
                    try {
                        propertylist.save();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    tblView.getItems().clear();
                    tblView.setItems(FXCollections.observableArrayList(propertylist.getPropertyList()));


                } else {
                    agentidfeedbackArea.setText("enter the correct Agent Email to Update this property");
                }
                tblView.getSelectionModel().clearSelection();
            }
        }

    }

    //using pattern matching to see if any non numeric values were entered
    public boolean matches(String regex) {
        regex = "^.*" + regex + ".*$"; // pad with regex to allow partial matching
        System.out.println("abcABC   ".matches(regex));
        return "abcABC   ".matches(regex);
    }


    //allows user to select an image and stores it in String imageURL
    public void selectImageButtonPressed(ActionEvent event) {
        FileChooser fc = new FileChooser();
        Window ownerWindow = null;
        File selectedFile = fc.showOpenDialog(ownerWindow);

        if (selectedFile != null) {
            System.out.println(selectedFile.toURI().toString());
            Image image = new Image(selectedFile.toURI().toString(), 150, 150, true, true);
            // imgImage.setImage(image);
            imageURL = selectedFile.toURI().toString();
            addimage.setText(imageURL);
        } else {
            System.out.println("Not a valid file.");

        }

    }


    private static void configureFileChooser(
            final FileChooser fileChooser) {
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        //new FileChooser.ExtensionFilter("All Images", "*.*"),

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
    }



    public void initialize(URL location, ResourceBundle resources) {
        propertylist = new PropertyShop();  // initialise shop to a new (empty) collection of Properties

        //testing

        propertylist.addProperty("first property", "123 street", "Room", "Ireland", "A", "x91n7d6", 99999, "7645", "Available", "file:/C:/Users/evans/Pictures/EEEEEEEEEEEEEEEEEEEEEEEEE.jpg");
        propertylist.addProperty("second property", "125 street", "Condo", "Andorra", "A", "x91n7d6", 9876599, "7625", "Available", "file:/C:/Users/evans/Pictures/EEEEEEEEEEEEEEEEEEEEEEEEE.jpg");


        ObservableList<Property> data =
                FXCollections.observableArrayList(propertylist.getPropertyList());

        idColumn.setCellValueFactory(new PropertyValueFactory<Property, Integer>("propertyid"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("description"));
        LocationColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("location"));
        costColumn.setCellValueFactory(new PropertyValueFactory<Property, Double>("price"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("Category"));
        imageColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("imageName"));

//search combo boxes
        searchCategory.setItems(categories);
        searchlocation.setItems(locations);
        searchCategory.setValue("All");
        searchlocation.setValue("All");

        //add details comboboxes
        category.setItems(combocategory);
        colocation.setItems(combolocation);
        category.setValue("All");
        colocation.setValue("All");

        //available combobox
        available.setItems(availablity);
        available.setValue("Availibilty");

        tblView.setItems(data);
    }


    //changes observable list to only show certain types of houses
    public void changedCategoryCombo(ActionEvent e) throws Exception {
        // this.detailedProductViewButton.setDisable(false);
        tblView.setItems(FXCollections.observableArrayList(propertylist.getPropertyList(searchCategory.getValue(), searchlocation.getValue())));
    }
    //changes observable list to only show certain location of houses
    public void changedSubCategoryCombo(ActionEvent e) throws Exception {
        this.detailedProductViewButton.setDisable(false);
        tblView.setItems(FXCollections.observableArrayList(propertylist.getPropertyList(searchCategory.getValue(), searchlocation.getValue())));
    }

    //changes to a detailed view for that selected property
    public void userClickedOnTable() {
        detailedProductViewButton.setDisable(false);
    }

    /**
     * When this method is called, it will pass the selected Property object to
     * a the detailed view
     */
    public void changeSceneToDetailedView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DetailedView.fxml"));
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

//logs user out and brings them to nonregistered view
    @FXML
    public void logoutClicked(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("nonRegisteredView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);

            stage.setTitle("Register");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {

        }
    }
}