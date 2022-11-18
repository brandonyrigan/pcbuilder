package com.pcbuilder.checkout;

public class Checkout {

    private Order order;
    Payment payment;

    public Checkout(){}
    public Checkout( Order order ){ setOrder(order); }
    public Checkout( Order order, Payment payment ){
        this(order);
        setPayment( payment );
    }

//  Business Logic
    public void displayOrderDetails(){
        Order order = getOrder();
        order.printSessionOrder();
    }
    public void addCustomerPayment( Payment newPayment ){
        setPayment( newPayment );
    }
    public void processPayment(){
        System.out.println( "Fetching order details..." );
        System.out.println( "Fetching payment method..." );
        System.out.println( "Processing payment..." );
        System.out.println( "payment approved, Thank you for your purchase" );
        System.out.println( "Submitting payment..." );
        messageSuccessfulPayment();
    }

    public void displayPaymentInfo(){
        Payment payment = getPayment();
        System.out.println( " Name:  " + payment.customerNameOnCard );
        System.out.println( " ccNumber:  " + payment.creditCarNumber );
        System.out.println( " ccv:  " + payment.ccv );
    }

//  Helper Methods
    private void messageSuccessfulPayment(){
        System.out.println( "Payment Method Approved" );
        System.out.println( "Thank you for your purchase!" );
        System.out.println( "We hope you enjoyed your experience with us!" );
    }
    private void messageFailedPayment(){
        System.out.println( "Payment Method Unsuccessful" );
        System.out.println( "Please Try Again" );
//        updateUserSelection();
    }

//  Accessor Methods
    public Order getOrder() { return this.order; }
    public void setOrder(Order order) { this.order = order; }
    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }

}