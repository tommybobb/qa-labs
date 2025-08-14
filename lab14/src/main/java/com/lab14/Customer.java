package com.lab14;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer
{   
    @JsonProperty("customerId")
    //@JsonAlias({"customerId", "CustomerID", "id"})  also works to handle multiple variations!
    private int id;

    private String name;
    private String city;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
}
