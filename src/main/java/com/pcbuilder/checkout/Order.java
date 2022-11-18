package com.pcbuilder.checkout;

import com.pcbuilder.customer.Customer;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static com.pcbuilder.menus.DecorateEnum.*;

// Store All Session Details

public class Order {
    Customer customer;
    LocalDateTime dateCreatedOrder;
    private UUID orderId;
    Map<String, String> sessionBuild;
    Map<String, Double> currentBuildPrice;
    ShoppingCart shoppingCart;

    public Order(){}
    public Order( Customer customer, ShoppingCart shoppingCart, Map<String, String> sessionBuild){
        setOrderId();
        setDateCreatedOrder();
        setCustomer( customer );
        setShoppingCart( shoppingCart );
        setSessionBuild( sessionBuild );
    }

//  Business Logic
    public void printSessionOrder(){

        String optionalLastName = Optional.of( getCustomer().getLastName() ).orElse("no last");
        String optionalFirstName = Optional.of( getCustomer().getFirstName() ).orElse("no last");
        String optionalEmail = Optional.of( getCustomer().getEmail() ).orElse("no email");
        String optionalCustomerId = Optional.of( getCustomer().getCustomerUUID().toString() ).orElse( "no customer uuid" );
        Integer optionalShoppingCartSize = Optional.of( getShoppingCart().getCartItems().size() ).orElse(0);
        String optionalOrderId = Optional.of( getOrderId().toString() ).orElse("no order uuid");

        Double totals = calcTotalFromSubTotals( getSessionBuild() );

        System.out.println();
        System.out.println(RENDER_TXT_SPACE.getDecoration()+"Customer Details: " + optionalLastName + "," + optionalFirstName );
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"customer id: " + optionalCustomerId );
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"customer email: " + optionalEmail );
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"order id: " + optionalOrderId) ;


        System.out.println(RENDER_TXT_SPACE.getDecoration()+"Shopping Cart Details");
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"Shopping Cart : [" + optionalShoppingCartSize + "]" );

        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"SubTotal: " );
        renderSubTotal(createShoppingCartSubTotal(getSessionBuild()));
        System.out.println( RENDER_SHORT_BAR.getDecoration());
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"Total: $" + df.format(totals));
        System.out.println( RENDER_SHORT_BAR.getDecoration());
    }

    private Double calcTotalFromSubTotals( Map<String, String> sessionBuild ){
        Double totals = 0.0;
        String[] componentInfo = new String[]{};

        for( Map.Entry<String, String> entries : sessionBuild.entrySet() ){
            componentInfo = entries.getValue().split(",");
            totals += Double.parseDouble(componentInfo[2]);
        };

        return totals;

    }
    private Map<String, Double> createShoppingCartSubTotal(Map<String, String> sessionBuild) {
        Map<String, Double> subTotals = new HashMap<>();
        String[] componentInfo = new String[]{};

        for( Map.Entry<String, String> entries : sessionBuild.entrySet() ){
            componentInfo = entries.getValue().split(",");
            subTotals.put(componentInfo[0], Double.parseDouble(componentInfo[2]));
        };
        return subTotals;
    }

    private void renderSubTotal(Map<String, Double> optionalSubTotals) {
        for (Map.Entry<String, Double> entry : optionalSubTotals.entrySet()) {
            System.out.println(RENDER_TXT_SPACEx2.getDecoration()+ "[" + entry.getKey() + "]" + ": $" + entry.getValue());
        }
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
    public Map<String, Double> getCurrentBuildPrice() { return currentBuildPrice; }
    public void setCurrentBuildPrice(Map<String, Double> currentBuildPrice) { this.currentBuildPrice = currentBuildPrice; }
}