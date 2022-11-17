package com.pcbuilder.session;

import com.pcbuilder.build.Build;
import com.pcbuilder.build.BuildFactory;
import com.pcbuilder.checkout.Checkout;
import com.pcbuilder.checkout.Order;
import com.pcbuilder.checkout.ShoppingCart;
import com.pcbuilder.customer.Customer;
import com.pcbuilder.inventory.Component;
import com.pcbuilder.inventory.Inventory;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Session {

    public Build finalBuild;
    private Customer customer;
    private Checkout checkout;
    private LocalDate sessionStart, sessionEnd;
    public Map<String,String> sessionBuild;
    private Order order;
    private ShoppingCart shoppingCart;
    private UUID uuid;


    public Session( String[] customerInfo ) {
        setCustomer( customerInfo );
        setCheckout( new Checkout() );
        setSessionBuild( new HashMap<>() );
        setShoppingCart( createNewShoppingCart() );
        setOrder( new Order() );
        setUuid();
        setSessionStartDate();
        setSessionEndDate();
    }


//  Business Logic
    public void addBuildToCart(Build finalBuild) {
//    ShoppingCart.addPCBuildToCart(finalBuild);
    System.out.println("Build added to cart");
}
    public void createNewCheckoutSession(){
        Order order = getOrder();

        System.out.println( "Gathering your order details... " );
        System.out.println( "Beginning new checkout session... " );
        System.out.println( "Processing your order details... " );

        Checkout newCheckoutSession = new Checkout( order );
        setCheckout( newCheckoutSession );
    }
    public Build composeBuild( Session sessionBuild ) {
        finalBuild = BuildFactory.createBuild( sessionBuild );
        return finalBuild;
    }
    public void createNewOrder(){
        Customer customerSession = getCustomer();
        ShoppingCart sessionShoppingCart = getShoppingCart();
        Map<String, String> sessionBuild = getSessionBuild();
        Order newOrder = new Order( customerSession, sessionShoppingCart, sessionBuild );
        setOrder(newOrder);
    }
    public ShoppingCart createNewShoppingCart(){
        ShoppingCart newShoppingCart = new ShoppingCart();
        return newShoppingCart;
    }
    public Map<String, Collection<Component>> fetchMapOfInventory(){
        Map<String, Collection<Component>> fetchedMapOfInventory = Inventory.mapOfInventory;
        return fetchedMapOfInventory;
    }
    public void updateSessionBuild( String categoryName, String componentInfo ){

        Map<String, String> currentBuild = getSessionBuild();
        currentBuild.put( categoryName, componentInfo );

    }


//  Accessor Methods
    public UUID getUuid() { return uuid; }
    public void setUuid() {
        UUID uuid = UUID.randomUUID();
        this.uuid = uuid;
    }
    public LocalDate getSessionStartDate() { return this.sessionStart; }
    public void setSessionStartDate() {
        LocalDate start = LocalDate.from( LocalDateTime.now() );
        this.sessionStart = start;
    }
    public LocalDate getSessionEndDate() { return sessionEnd; }
    public void setSessionEndDate() {
        LocalDate end = LocalDate.from(LocalDateTime.now());
        this.sessionEnd = end;
    }
    public Customer getCustomer() { return customer;}
    public void setCustomer( String... customerInfo ) {
        Customer guestCustomer = new Customer( customerInfo[0], customerInfo[1], customerInfo[2] );
        this.customer = guestCustomer;
    }
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
    public ShoppingCart getShoppingCart() { return shoppingCart; }
    public void setShoppingCart(ShoppingCart shoppingCart) { this.shoppingCart = shoppingCart; }
    public Map<String, String> getSessionBuild() { return sessionBuild;}
    public void setSessionBuild(Map<String, String> sessionBuild) { this.sessionBuild = sessionBuild; }
    public Checkout getCheckout() { return checkout; }
    public void setCheckout(Checkout checkout) { this.checkout = checkout; }
}