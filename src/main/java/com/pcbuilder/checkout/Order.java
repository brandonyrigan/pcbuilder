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
    Map<String, Double> currentBuildPrice;
    ShoppingCart shoppingCart;

    public Order(){}
    public Order( Customer customer, ShoppingCart shoppingCart, Map<String, String> sessionBuild, Map<String, Double> currentBuildPrices){
        setOrderId();
        setDateCreatedOrder();
        setCustomer( customer );
        setShoppingCart( shoppingCart );
        setSessionBuild( sessionBuild );
        setCurrentBuildPrice( currentBuildPrices );
    }

//  Business Logic
    public void printSessionOrder(){

        String optionalLastName = Optional.of( getCustomer().getLastName() ).orElse("no last");
        String optionalFirstName = Optional.of( getCustomer().getFirstName() ).orElse("no last");
        String optionalEmail = Optional.of( getCustomer().getEmail() ).orElse("no email");
        String optionalCustomerId = Optional.of( getCustomer().getCustomerUUID().toString() ).orElse( "no customer uuid" );
        Integer optionalShoppingCartSize = Optional.of( getShoppingCart().getCartItems().size() ).orElse(0);
        String optionalOrderId = Optional.of( getOrderId().toString() ).orElse("no order uuid");
        Map<String, String> optionalSessionBuild = Optional.of( getSessionBuild() ).orElse( new HashMap<>() );
        Map<String, Double> optionalSubTotals = Optional.of( getCurrentBuildPrice() ).orElse( new HashMap<>() );
        Double totals = calcTotalFromSubTotals( getCurrentBuildPrice() );

        System.out.println();
        System.out.println(RENDER_TXT_SPACE.getDecoration()+"Customer Details: " + optionalLastName + "," + optionalFirstName );
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"customer id: " + optionalCustomerId );
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"customer email: " + optionalEmail );
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"order id: " + optionalOrderId) ;

        System.out.println(RENDER_TXT_SPACE.getDecoration()+"Session Build :  ");
        renderSessionBuild(optionalSessionBuild);

        System.out.println(RENDER_TXT_SPACE.getDecoration()+"Shopping Cart Details");
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"Shopping Cart : [" + optionalShoppingCartSize + "]" );

        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"SubTotal: " + optionalSubTotals );
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"Total: " + totals);

    }

    private Double calcTotalFromSubTotals( Map<String, Double> subTotals ){
        Double totals = 0.0;

        Optional<Map<String, Double>> optionalSubTotals = Optional.ofNullable(subTotals);

        if ( optionalSubTotals.isPresent() ) {

            Map<String, Double> stringDoubleMap = optionalSubTotals.get();
            for (Map.Entry<String, Double> entry : stringDoubleMap.entrySet()) {
                totals += entry.getValue();
            }
        }
        return totals;

    }
    private void renderSessionBuild(Map<String, String> optionalSessionBuild){
        for (Map.Entry<String, String> entry : optionalSessionBuild.entrySet()){
            System.out.println(RENDER_TXT_SPACEx2.getDecoration()+ "["+ entry.getKey()+ "] "+": "+ entry.getValue()  );
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