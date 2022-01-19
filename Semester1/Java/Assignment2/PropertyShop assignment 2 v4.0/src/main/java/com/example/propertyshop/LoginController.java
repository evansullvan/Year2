/**
 @Author: Evan Sullivan
 @Version 4.0
 @Date: 9/12/2021
 */


package com.example.propertyshop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.HashMap;

public class LoginController {

    @FXML
    private TextField loginEmail;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private Label loginFeedback;
    @FXML
    private Label passwordFeedback;

//checks if all data is inputted and correct and if so, the user will be sent to
// either the admin page or agent page based on what the user inputted.
    @FXML
    void onLoginButtonClicked(ActionEvent event) {
        String feedbackErrorMessage = "";
        String feedbackErrorMessagepass = "";
        if (loginEmail.getText().isBlank()) {
            feedbackErrorMessage += "Email field not completed \n";
        } else if (!isValidEmailAddress(loginEmail.getText())) { //can use other email checking e.g. Apache
            feedbackErrorMessage += "Not a valid Email address \n";
        }
        if (loginPassword.getText().isBlank()) {
            feedbackErrorMessagepass += "Password field not completed \n";
        }
        if (feedbackErrorMessage.isEmpty()) { //no errors
            //search the hashmap for the user with that email
            //if the email comes back with a user with a status of false then login denied

            UserStorage x = new UserStorage();
            HashMap<String, UserDetails> people = x.getUsers();

            if (people.containsKey(loginEmail.getText())) {
                if (loginEmail.getText().contains("Admin")) {
                    try {
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AdminView.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 620, 440);

                        stage.setTitle("Admin Page");
                        stage.setScene(scene);
                        stage.show();
                    } catch (Exception e) {
                        loginFeedback.setText("Unable to load admin Page");
                    }
                } else {
                    try {
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("RegisteredView.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 620, 440);

                        stage.setTitle("Agent Page");
                        stage.setScene(scene);
                        stage.show();
                    } catch (Exception e) {
                        loginFeedback.setText("Unable to load Agent Page");
                    }
                }
            } else {
                loginFeedback.setText("No email found please Register");
            }


        } else {  //errors in data entered
            loginFeedback.setText(feedbackErrorMessage);
            passwordFeedback.setText(feedbackErrorMessagepass);
        }
    }


    //sends user to register page
    @FXML
    void onRegisterButtonClicked(ActionEvent event) {
        try {
            /*we can reuse this code in many projects, it changes scenes*/
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Register.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 620, 440);

            stage.setTitle("Property listing Registration Form");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            loginFeedback.setText("Unable to load Registration");
        }
    }


    //checks if email is in correct format
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();


    }

//sends user back to the Unregistered view
    @FXML
    protected void onBackClicked(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("nonRegisteredView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);

            stage.setTitle("Home");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            loginFeedback.setText("Unable to load Home");
        }
    }
}
