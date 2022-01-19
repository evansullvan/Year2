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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.HashMap;

public class RegisterController {


    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private TextField reenterpass;

    @FXML
    private Button register;
    @FXML
    private TextField username;

    @FXML
    private Label emailfeedback;

    @FXML
    private Label usernamefeedback;

    @FXML
    private Label passwordfeedback;

    @FXML
    private Label confpasswordfeedback;



    //takes in the values for a new user and adds that user to the hashmap
    public void onRegisterClick(ActionEvent event) {
        String feedback1 = "";
        if (email.getText().isBlank()) {
            feedback1 += "email is empty";
            emailfeedback.setText("Email is empty");
        } else if (!isValidEmailAddress(email.getText())) {
            feedback1 += "Email is not valid";
            emailfeedback.setText("Email is not valid");
        }
        if (username.getText().isBlank()) {
            usernamefeedback.setText("Username cant be blank");
        }
        if (password.getText().isBlank()) {
            feedback1 += "password is empty";
            passwordfeedback.setText("password is empty");
        }
        if (!password.getText().equals(reenterpass.getText())) {
            feedback1 += "password not equal to confirmation password";
            confpasswordfeedback.setText("password is not the same");
        }

        if (feedback1.isBlank()) {

            //getting the hashmap from userStorage class
            UserStorage x = new UserStorage();
            HashMap<String, UserDetails> people = x.getUsers();


            if (people.containsKey(email.getText())) {
                emailfeedback.setText("Email already in use");
            }
            if (people.containsValue(username.getText())) {
                usernamefeedback.setText("Username taken");
            } else {
                people.put(email.getText(), new UserDetails(username.getText(), email.getText(), password.getText()));
                // feedback.setText("User created, Hello: " + username.getText());

                if (email.getText().contains("Admin")) {
                    try {
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AdminView.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 800, 800);

                        stage.setTitle("Admin");
                        stage.setScene(scene);
                        stage.show();
                    } catch (Exception e) {
                        confpasswordfeedback.setText("Unable to load main scene");
                    }
                } else {

                    try {
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AgentView.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 800, 800);

                        stage.setTitle("Agent view");
                        stage.setScene(scene);
                        stage.show();
                    } catch (Exception e) {
                        confpasswordfeedback.setText("Unable to load main scene");
                    }

                }
            }
        }
    }

//sends user back to nonregistered view
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
            confpasswordfeedback.setText("Unable to load main scene");
        }


    }


    //sends user to login page
    @FXML
    public void loginClicked(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);

            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            confpasswordfeedback.setText("Unable to load main scene");
        }
    }


    //checks if email is in correct format
    public boolean isValidEmailAddress(String email) {

        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();


    }


}

