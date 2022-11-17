package com.pcbuilder.checkout;

import com.pcbuilder.customer.Customer;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static com.pcbuilder.menus.DecorateEnum.RENDER_TXT_SPACE;
import static com.pcbuilder.menus.DecorateEnum.RENDER_TXT_SPACEx2;

// Store All Session Details

public class Order {
// TODO[ ] - get totals and add to order
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

//        System.out.println( " getting last name " + getCustomer().getLastName() );
        String optionalLastName = Optional.of( getCustomer().getLastName() ).orElse("no last");
        System.out.println( "optional" + optionalLastName );
        String optionalFirstName = Optional.of( getCustomer().getFirstName() ).orElse("no last");
        String optionalEmail = Optional.of( getCustomer().getEmail() ).orElse("no email");
        UUID optionalCustomerId = Optional.of( getCustomer().getCustomerUUID() ).orElse( UUID.fromString("no id"));
        Integer optionalShoppingCartSize = Optional.of( getShoppingCart().cartItems.size() ).orElse(0);
//        Double optionalTotals = Optional.of( getShoppingCart().priceTotals ).orElse(0.0);
        UUID optionalOrderId = Optional.of( getOrderId() ).orElse( UUID.fromString("no id"));
        Map<String, String> optionalSessionBuild = Optional.of( getSessionBuild() ).orElse( new HashMap<>() );

//        String lastName = getCustomer().getLastName();
//        String firstName = getCustomer().getFirstName();
//        String email = getCustomer().getEmail();
//        String customerID = getCustomer().getEmail();
//        int shoppingCartSize = getShoppingCart().cartItems.size();
//        double total = getShoppingCart().priceTotals;

        System.out.println();
        System.out.println(RENDER_TXT_SPACE.getDecoration()+"Customer Details: " + optionalLastName + "," + optionalFirstName );
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"customer id: " + optionalCustomerId );
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"customer email: " + optionalEmail );
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"order id: " + optionalOrderId) ;
        System.out.println(RENDER_TXT_SPACE.getDecoration()+"Session Build :  "  + optionalSessionBuild );
        System.out.println(RENDER_TXT_SPACE.getDecoration()+"Shopping Cart Details");
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"Shopping Cart : [" + optionalShoppingCartSize + "]" );

//        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"Total: " + optionalTotals );

    }


//  Accessor Methods
    public UUID getOrderId() { return orderId; }
    public void setOrderId() { this.orderId = UUID.randomUUID(); }
    public LocalDateTime getDateCreatedOrder() { return dateCreatedOrder; }
    public void setDateCreatedOrder() {
        this.dateCreatedOrder = LocalDateTime.now();
    }
//    public Customer getCustomer() { return customer; }
    public Customer getCustomer() { return this.customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public ShoppingCart getShoppingCart() { return shoppingCart; }
    public void setShoppingCart(ShoppingCart shoppingCart) { this.shoppingCart = shoppingCart; }
    public Map<String, String> getSessionBuild() { return sessionBuild; }
    public void setSessionBuild(Map<String, String> sessionBuild) { this.sessionBuild = sessionBuild; }


}