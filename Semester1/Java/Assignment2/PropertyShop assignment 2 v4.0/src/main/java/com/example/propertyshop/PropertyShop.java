/**
 Author: Evan Sullivan
 Version 4.0
 Date: 9/12/2021
 */



package com.example.propertyshop;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PropertyShop {
    private ArrayList<Property> properties;

//constructor for a new property arraylist
    public PropertyShop() {
        properties = new ArrayList<Property>();
    }


    //returns the arraylist of properties
    public ArrayList<Property> getPropertyList() {
        return properties;
    }

    //returns the searched arraylist
    public ArrayList<Property> getPropertyList(String cat, String location) {

        if (cat.equals("All") && location.equals("All")) {
            return properties;
        }

        ArrayList<Property> searchResults = new ArrayList<>();

        for (Property item : properties) {

            if (cat.equals("All") && item.getLocation().equals(location)) {
                searchResults.add(item);
            } else if (location.equals("All") && item.getCategory().equals(cat)) {
                searchResults.add(item);
            } else if (item.getCategory().equals(cat) && item.getLocation().equals(location)) {
                searchResults.add(item);
            }

        }
        return searchResults;
    }

//addds property to arraylist given the values by the user
    public int addProperty(String description, String address, String category, String location, String ber, String eircode, double price, String agentId, String status, String imageName) {
        int id = 2019000 + properties.size();
        Property property = new Property(description, address, category, location, ber, eircode, price, agentId, status, imageName);
        properties.add(property);
        return -1;
    }

    public int addProperty(String description, String address, String category, String location, String ber, String eircode, double price, String agentId, String status) {
        Property property = new Property(description, address, category, location, ber, eircode, price, agentId, status);
        properties.add(property);
        return -1;
    }

//edits the property with new values and replaces that property in the arraylist
    public boolean editProperty(Object propertytoupdate, String description, String address, String category, String location, String ber, String eircode, double price, String agentId, String imageName) {

        for (int i = 0; i < properties.size(); i++) {
            Property p = properties.get(i);
            if (properties.contains(propertytoupdate)) {
                //Using Setter Methods to change values
                p.setDescription(description);
                p.setAddress(address);
                p.setCategory(category);
                p.setLocation(location);
                p.setBer(ber);
                p.setEircode(eircode);
                p.setPrice(price);
                p.setAgentId(agentId);
                p.getImageName();

            }
            return true;

        }
        return false;  //No such id found
    }


    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("propertylist.xml"));
        properties = (ArrayList<Property>) is.readObject();
        is.close();
    }

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("propertylist.xml"));
        out.writeObject(properties);
        out.close();
    }
}

