package com.pcbuilder.customer;

import java.util.UUID;

/**
 * Created by dev0 on 11/10/22.
 */
public class Customer {
    private UUID customerUUID;
    private java.lang.String firstName;
    private java.lang.String lastName;
    private java.lang.String email;

    public Customer(UUID uuid, java.lang.String firstName, java.lang.String lastName, java.lang.String email ){}

    public UUID getCustomerUUID() {
        return customerUUID;
    }

    public void setCustomerUUID() {
        this.customerUUID = UUID.randomUUID();
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }
}