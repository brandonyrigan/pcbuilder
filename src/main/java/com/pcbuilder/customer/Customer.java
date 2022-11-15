package com.pcbuilder.customer;

import java.util.UUID;

/**
 * Created by dev0 on 11/10/22.
 */
public class Customer {
    private UUID customerUUID;
    private String firstName;
    private String lastName;
    private String email;

    public Customer(UUID uuid, String firstName, String lastName, String email ){
        this.customerUUID = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UUID getCustomerUUID() {
        return customerUUID;
    }

    public void setCustomerUUID() {
        this.customerUUID = UUID.randomUUID();
    }

    public String getFirstName() {
        return firstName;
    }

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