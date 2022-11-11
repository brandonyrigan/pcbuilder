package com.pcbuilder.client;

import com.pcbuilder.checkout.Order;
import com.pcbuilder.checkout.ShoppingCart;
import com.pcbuilder.customer.Customer;
import com.pcbuilder.inventory.Inventory;
import com.pcbuilder.session.Session;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        run();

    }

    public static void run(){

// Welcome the User and Capture Customer Info
        String[] customerBasicInfo = welcomeTheCustomer();

//Step 0
//  Creating a new Session ( Customer, Inventory, ShoppingCart, Order )
//       - creates new customer, new shopping cart, new order, fetches inventory
        Session session = startCustomerSession( customerBasicInfo );
        session.getShoppingCart().shoppingCartMethod();

//  Display Build to the User
//  STEP 1
    }


    public static String [] welcomeTheCustomer(){
        String welcomeMessage = " Welcome to PC Builder where...";
        System.out.println( welcomeMessage );
        String[] customerInputBasicInfo = captureCustomerInformation();
        return customerInputBasicInfo;
    }
    public static String[] captureCustomerInformation(){
//      TODO: allow user to go back and edit any input
//      TODO: allow user to exit the App

        Scanner scanner = new Scanner(System.in);

        String[] customerInputValues = new String[3];
        String customerFirstName;
        String customerLastName;
        String customerEmail;

        System.out.print("\nEnter your first name: ");
        customerFirstName = scanner.next();
        System.out.print("Value entered: " + customerFirstName.toUpperCase() + ", is this correct?  Yes/No");

        System.out.print("\nEnter your last name: ");
        customerLastName = scanner.next();
        System.out.print("Value entered: " + customerLastName.toUpperCase() + ", is this correct? Yes/No");

        System.out.print("\nEnter your email: ");
        customerEmail = scanner.next();
        System.out.print("Value entered: " + customerEmail.toUpperCase() + ", is this correct? Yes/No" );

        System.out.println( "\nIs the following information correct? Yes/No" );
        System.out.println( "name : " + customerLastName + "," + customerFirstName );
        System.out.println( "email: " + customerEmail );

        customerInputValues[0] = customerFirstName;
        customerInputValues[1] = customerLastName;
        customerInputValues[2] = customerEmail;
        return customerInputValues;
    }

    public static Session generateNewSession( String... customer ){
        Session newSession = new Session( customer );
        return newSession;
    }
    public static Session startCustomerSession( String[] customerBasicInfo ){

         Session session = generateNewSession( customerBasicInfo );

        return session;
    }

}