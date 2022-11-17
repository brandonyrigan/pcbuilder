package com.pcbuilder.checkout;

import com.pcbuilder.customer.Customer;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import static com.pcbuilder.menus.DecorateEnum.RENDER_TXT_SPACE;
import static com.pcbuilder.menus.DecorateEnum.RENDER_TXT_SPACEx2;

public class Order {

    Customer customer;
    LocalDateTime dateCreatedOrder;
    private UUID orderId;
    Map<String, String> sessionBuild;
    ShoppingCart shoppingCart;

    public Order(){}
    public Order( Customer customer, ShoppingCart shoppingCart, Map<String, String> sessionBuild  ){
        setOrderId();
        setDateCreatedOrder();
        setCustomer( customer );
        setShoppingCart( shoppingCart );
        setSessionBuild( sessionBuild );
    }

//  Business Logic
    public void printSessionOrder(){

        String lastName = getCustomer().getLastName();
        String firstName = getCustomer().getFirstName();
        String email = getCustomer().getEmail();
        String customerID = getCustomer().getEmail();
        int shoppingCartSize = getShoppingCart().cartItems.size();

        System.out.println();
        System.out.println(RENDER_TXT_SPACE.getDecoration()+"Session Details: " + lastName+ "," + firstName );
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"customer id: " + customerID);
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"customer email: " + email);
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"order id: " + getOrderId());
        System.out.println(RENDER_TXT_SPACE.getDecoration()+"Session Build :  "  + getSessionBuild() );
        System.out.println(RENDER_TXT_SPACE.getDecoration()+"Shopping Cart Details");
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"Shopping Cart : [" + shoppingCartSize + "]" );

    }


//  Accessor Methods
    public UUID getOrderId() { return orderId; }
    public void setOrderId() { this.orderId = UUID.randomUUID(); }
    public LocalDateTime getDateCreatedOrder() { return dateCreatedOrder; }
    public void setDateCreatedOrder() {
        this.dateCreatedOrder = LocalDateTime.now();
    }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public ShoppingCart getShoppingCart() { return shoppingCart; }
    public void setShoppingCart(ShoppingCart shoppingCart) { this.shoppingCart = shoppingCart; }
    public Map<String, String> getSessionBuild() { return sessionBuild; }
    public void setSessionBuild(Map<String, String> sessionBuild) { this.sessionBuild = sessionBuild; }


}