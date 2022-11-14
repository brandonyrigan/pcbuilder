package com.pcbuilder.checkout;

import com.pcbuilder.customer.Customer;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class Order {


    private UUID orderId;
    LocalDateTime dateCreatedOrder;
//    LocalDateTime dateShipped;


    public Order( Customer customer, ShoppingCart shoppingCart, Map<String, String> sessionBuild  ){
        setOrderId();
        setDateCreatedOrder();
        viewOrder( customer, shoppingCart, sessionBuild );
    }

//  Business Logic
    public void viewOrder(Customer customer, ShoppingCart shoppingCart, Map<String, String> sessionBuild ){

//  TODO[ ] : process Shopping Cart details

        String space = "       ";
        String doubleSpace = "       ";
        System.out.println();
        System.out.println(space+"Session Order Details: " + customer.getLastName() +", " + customer.getFirstName() );
        System.out.println(doubleSpace+"order id: " + getOrderId());

        System.out.println(doubleSpace+"Shopping Cart : " + " items:  [  ] " );
        System.out.println(doubleSpace+"Session Build :  " + sessionBuild );
    }


//  Accessor Methods
    public UUID getOrderId() { return orderId; }
    public void setOrderId() { this.orderId = UUID.randomUUID(); }
    public LocalDateTime getDateCreatedOrder() { return dateCreatedOrder; }
    public void setDateCreatedOrder() {
        this.dateCreatedOrder = LocalDateTime.now();
    }


}