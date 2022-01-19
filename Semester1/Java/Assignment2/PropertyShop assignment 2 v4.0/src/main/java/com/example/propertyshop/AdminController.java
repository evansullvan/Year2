
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
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.HashMap;

public class AdminController {


    @FXML
    private Button clear;

    @FXML
    private TextArea userDetails;

    @FXML
    private TextField delete;

    @FXML
    private Button home;

    @FXML
    private Button Delete;
    @FXML
    private TextField active;

    @FXML
    private TextField username;

    @FXML
    private TextField userId;

    @FXML
    private TextField userEmail;

    @FXML
    private TextField UserEmail;

    @FXML
    private Label feedbackArea;

    UserStorage userStorage;

    public UserStorage x = new UserStorage();
    HashMap<String, UserDetails> people = x.getUsers();

    @FXML
    protected void displayAllUsers() {

        //going through hashmap and printing it
        userDetails.setText(String.valueOf(Arrays.asList(people.toString())));


    }

    //deletes agent based on email
    @FXML
    protected void deleteUser() {

        if (UserEmail.getText().isBlank()) {
            feedbackArea.setText("Email is blank ");
        } else {
            String email = UserEmail.getText();
            people.remove(email);
            feedbackArea.setText("User is deleted");

        }
    }


    //takes in the email and the new fields to be updated and updates that agent
    @FXML
    protected void onUpdateButtonClick() {
        String active1 = "No";
        if (userId.getText().isBlank() ||
                userEmail.getText().isBlank() ||
                username.getText().isBlank() ||
                (active.getText().isBlank())) {
            feedbackArea.setText("Required Fields not completed");
        } else {
            if (active.getText().equals("Yes")) {
                active1 = "Yes";
            } else if (active.getText().equals("No")) {
                active1 = "No";
            }
            int id1 = Integer.parseInt(userId.getText());

            userStorage.editUser(id1, username.getText(),
                    userEmail.getText(), active1);
            feedbackArea.setText("User Updated");
        }
    }


    //brings user to agent page
    @FXML
    protected void onHomeClick(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AgentView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);

            stage.setTitle("Agent");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            feedbackArea.setText("Unable to load Home");
        }
    }

    //clears results from admin page
    @FXML
    protected void onClearClick() {
        if (userDetails.getText().isBlank()) {
            feedbackArea.setText("Results are already cleared");
        } else {
            userDetails.clear();
        }
    }


}






