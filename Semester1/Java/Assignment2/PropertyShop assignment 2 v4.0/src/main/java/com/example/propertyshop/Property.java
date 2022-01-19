


/**
 @Author: Evan Sullivan
 @Version 4.0
 @Date: 9/12/2021
 */

package com.example.propertyshop;

public class Property {

    private static int Propertyid = 2009706;
    private int id;
    private String description;
    private String address;
    private String category;
    private String location;
    private String ber;
    private String eircode;
    private double price;
    private String agentId;
    private String status;
    private int numberOfViews;
    private boolean isAvailable;
    private String imageName;

    public Property(String description, String address, String category, String location, String ber, String eircode, double price, String agentId, String status, String imageName) {
        super();
        this.id = Propertyid++;
        this.description = description;
        this.address = address;
        this.category = category;
        this.location = location;
        this.ber = ber;
        this.eircode = eircode;
        this.price = price;
        this.agentId = agentId;
        this.status = status;
        this.numberOfViews = numberOfViews;
        this.isAvailable = true;
        this.imageName = imageName;
    }

    public Property(String description, String address, String category, String location, String ber, String eircode, double price, String agentId, String status) {
        super();
        this.id = Propertyid++;
        this.description = description;
        this.address = address;
        this.category = category;
        this.location = location;
        this.ber = ber;
        this.eircode = eircode;
        this.price = price;
        this.agentId = agentId;
        this.status = status;
        this.numberOfViews = numberOfViews;
        this.isAvailable = true;
        imageName = null;
    }

    public int getPropertyid() {
        return Propertyid;
    }

    public void setPropertyid(int propertyid) {
        this.id = propertyid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBer() {
        return ber;
    }

    public void setBer(String ber) {
        this.ber = ber;
    }

    public String getEircode() {
        return eircode;
    }

    public void setEircode(String eircode) {
        this.eircode = eircode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumberOfViews() {
        return numberOfViews;
    }

    public void setNumberOfViews(int numberOfViews) {
        this.numberOfViews = numberOfViews;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "Property: " + Propertyid+ "\n"+ "Description: "+ description+"\n"+ "Address: "+ address+"\n"+ "Category:"+ category+"\n"+ "Location: "+ location+"\n"+ "Ber: "+ ber
                +"\n"+ "Eircode: "+ eircode+"\n"+ "Price: "+ price+"\n"+ "AgentID: "+ agentId+"\n" + "status: "+ status+"\n";
    }
}
