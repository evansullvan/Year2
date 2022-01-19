package com.example.propertyshop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AgentView.fxml"));
        primaryStage.setTitle("Agent");
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception {




        UserStorage x = new UserStorage();
        HashMap<String, UserDetails> people = x.getUsers();

        people.put("Admin2@gmail.com", new UserDetails("Admin123", "Admin2@gmail.com", "123"));
        launch(args);
    }
}