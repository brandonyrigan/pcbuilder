package com.pcbuilder.customer;

import java.util.UUID;

public class Customer {


    protected UUID customerId;
    protected String firstName;
    protected String lastName;
    protected String email;


    public Customer( String firstName, String lastName, String email ){
        setCustomerId();
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }


    public UUID getCustomerId() { return customerId; }
    public void setCustomerId( ) {
        this.customerId = UUID.randomUUID(); }
    public String getFirstName() { return firstName;}
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email; }
}