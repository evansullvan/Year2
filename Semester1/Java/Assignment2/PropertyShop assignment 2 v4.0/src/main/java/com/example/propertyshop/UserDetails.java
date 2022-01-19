/**
 @Author: Evan Sullivan
 @Version 4.0
 @Date: 9/12/2021
 */
package com.example.propertyshop;

public class UserDetails {
    private static int next_user_id_number =20210001;

    private int userId;
    private String userName;
    private String userEmail;
    private String  userPassword;
    private boolean userIsActive;

    public UserDetails(String userName, String userEmail, String userPassword) {
        userId=next_user_id_number; //increment next_user_id_number before allocating it to the new user
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        userIsActive = false; //decision made that new users are initially active.
    }

    @Override
    public String toString() { //Can modify to suit requirements/preferences
        //Note: Password is not part of return String!
        return "\n"+"userId= " + userId + "\n "+  "userName= " + userName + '\n' +
                "userEmail= " + userEmail + '\n' +
                "Is User Active?: " + userIsActive +"\n"+"________________"+"\n";
    }

    public static int getNext_user_id_number() {
        return next_user_id_number;
    }

    public static void setNext_user_id_number(int next_user_id_number) {
        UserDetails.next_user_id_number = next_user_id_number;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Boolean isUserIsActive() {
        return userIsActive;
    }

    public void setUserIsActive(Boolean userIsActive) {
        this.userIsActive = userIsActive;
    }
}
