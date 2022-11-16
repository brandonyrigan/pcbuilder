package com.pcbuilder.checkout;

public class Checkout {

    private Order order;

    public Checkout(Order order ){
        setOrder(order);
    }

    public void processPayment(){
        System.out.println( "fetching order details..." );
        System.out.println( "processing payment..." );

        System.out.println( "payment approved, Thank you for your purchase" );
    }

    public Order getOrder() { return this.order; }
    public void setOrder(Order order) { this.order = order; }

}