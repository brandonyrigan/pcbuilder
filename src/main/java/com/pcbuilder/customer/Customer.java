package com.pcbuilder.customer;

import java.util.UUID;

public class Customer {
    private UUID customerUUID;
    private String firstName, lastName, email;

    public Customer( String firstName, String lastName, String email ){
        setCustomerUUID();
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public void updateCustomerBasicInfo(String[] actualCustomerInfo) {
        setFirstName( actualCustomerInfo[0] );
        setLastName( actualCustomerInfo[1] );
        setEmail( actualCustomerInfo[2] );
    }

    public UUID getCustomerUUID() {
        return customerUUID;
    }
    public void setCustomerUUID() { this.customerUUID = UUID.randomUUID();}
    public String getFirstName() { return firstName;}
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}