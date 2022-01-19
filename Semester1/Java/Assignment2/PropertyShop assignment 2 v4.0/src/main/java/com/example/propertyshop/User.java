/**
 @Author: Evan Sullivan
 @Version 4.0
 @Date: 9/12/2021
 */

package com.example.propertyshop;

public class User {

    private static int iDNumber = 2021001;

    private int userId;
    private String name;
    private String email;
    private String password;
    private boolean active;
    private int phone;

    public User(int userId, String name, String email, String password,int phone) {
        this.userId = iDNumber++;
        this.name = name;
        this.email = email;
        this.password = password;
        active = false;
        this.phone = phone;

    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public static int getiDNumber() {
        return iDNumber;
    }

    public static void setiDNumber(int iDNumber) {
        User.iDNumber = iDNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                '}';
    }
}
