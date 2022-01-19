/**
 @Author: Evan Sullivan
 @Version 4.0
 @Date: 9/12/2021
 */


package com.example.propertyshop;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    //creates a new hashmap
    public static HashMap<String, UserDetails> users = new HashMap<>();

    //returns hashmap of users
    public HashMap<String, UserDetails> getUsers() {
        return users;
    }


    //adds user to hashmap
    public int addUser(String userName, String userEmail, String userPassword) {


        users.put(userEmail, new UserDetails(userName, userEmail, userPassword));//Hashmap put() method returns true if
        return User.getiDNumber(); //userId was incremented after the product was created
    }


    //iterates through hashmap and displays each key and value pair
    public String listAllUsers() {
        String allUsers = "";
        for (Map.Entry<String, UserDetails> entry : users.entrySet()) {
            allUsers = (entry.getKey() + "/" + entry.getValue());
        }
        return allUsers;
    }


    //edits a user based on the email entered.
    public boolean editUser(int userID, String userName, String userEmail, String active) {

        for (int i = 0; i < users.size(); i++) {
            UserDetails u = users.get(i);
            if (u.getUserId() == userID) {  //Using Setter Methods to change values
                u.setUserName(userName);
                u.setUserEmail(userEmail);
                u.setUserPassword(active);


                return true;
            }
        }
        return false;  //No such id found
    }
}






