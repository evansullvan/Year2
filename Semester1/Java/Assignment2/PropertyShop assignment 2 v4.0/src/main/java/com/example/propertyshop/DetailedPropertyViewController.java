

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;



public class DetailedPropertyViewController {
    @FXML private Label id;
    @FXML private Label address;
    @FXML private Label description;
    @FXML private Label cost;
    @FXML private Label locations;
    @FXML private Label available;
    @FXML private Label type;
    @FXML private Label agentID;
    @FXML private Label ber;
    @FXML private ImageView image;
    @FXML private ImageView photo;
    @FXML private Label eircode;



    /**
     * This method accepts a person to initialize the view
     * @param property
     */

    /**
     * When this method is called, it will change the Scene to
     * a detailed view of that selected property
     */
    public void initData(Property property)
    {

        id.setText(""+property.getPropertyid());
        description.setText(""+property.getDescription());
        address.setText(""+property.getAddress());
        type.setText(""+property.getCategory());
        locations.setText(""+property.getLocation());
        ber.setText(""+property.getBer());
        cost.setText(""+property.getPrice());


        agentID.setText(""+property.getAgentId());
        if(property.isAvailable()){
            available.setText("Available");
        }else{
            available.setText("Off the market");
        }
        eircode.setText(""+property.getEircode());

    photo.setImage(new Image(property.getImageName()));
}

   //changes scene to agent view
    public void changeScreenButtonPushed(ActionEvent event) throws IOException
    {



        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AgentView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();


    }

    //changes scene to nonregistered view
    public void changeScreenButtonPushedUNREG(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("nonRegisteredView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
}
