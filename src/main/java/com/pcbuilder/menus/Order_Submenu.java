package com.pcbuilder.menus;
import com.pcbuilder.checkout.Order;
import com.pcbuilder.checkout.ShoppingCart;
import com.pcbuilder.session.Session;

import static com.pcbuilder.menus.DecorateEnum.*;

//  TODO[ ] : process Shopping Cart details

public class Order_Submenu extends MainMenu {

    Boolean hasConfirmedOrder;

    public Order_Submenu( Session session ) {
        super( session );
        setHasConfirmedOrder( false );
    }

    @Override
    public void renderOwnMenu() {
        renderSubmenuOrder();
        runOrderWalkThrough();
    }

    //  Order Menu
    private void renderSubmenuOrder(){
        System.out.println( RENDER_SHORT_BAR.getDecoration() );
        System.out.println("View Order" );
        System.out.println("   Select from the options below");
        System.out.println("   [1] Main Menu " + " [2] Create New Order" + " [3] Confirm Order "+ " [4] Proceed to Checkout ");
        if( !getHasConfirmedOrder() ) messageUserHasNoConfirmedOrders();
    }
    private void runOrderWalkThrough(){
//TODO[ ] : Refactor switch case
        Order order = getSession().getOrder();
        if( getHasConfirmedOrder() ) order.printSessionOrder();
        updateUserSelection();
        do{
            switch ( getSelection() ){
                case 1: break;
                case 2:
                    createNewOrder();
                    break;
                case 3:
                    processCustomerOrder();
                    break;
                case 4 :
                    proceedToPurchase();
                    break;
                default: break;
            }
        } while ( getSelection() != 1 );

    }


    //  Process the Order Menu
    private void processCustomerOrder() {
        System.out.println(getHasConfirmedOrder());
        if( !getHasConfirmedOrder() ) messageUserHasNoConfirmedOrders();
        else{
            System.out.println( "Thank You, Initiating Confirmation..." );
            System.out.println( "Fetching order details..." );
            System.out.println( "Validating order details..." );
            System.out.println( "Order Confirmation  complete...Thank you." );
        }
        updateUserSelection();
    }
    private void createNewOrder(){
        int shoppingCartSize = getSession().getShoppingCart().cartItems.size();

        if( shoppingCartSize < 1 ) messageUserHasEmptyCart();
        else{
            Session session = getSession();
            session.createNewOrder();
            setHasConfirmedOrder( true );
        }
        updateUserSelection();
    };
    private void proceedToPurchase(){
        if( getHasConfirmedOrder() ) setSelection(1);
        else System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"Cannot Checkout on an Empty Cart, Nothing to Purchase " );
        updateUserSelection();
    }
    private void messageUserHasNoConfirmedOrders(){
        System.out.println();
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"Sorry, cannot create new order on an Empty Cart " );
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"Please, continue shopping to Create a New Order, Thank You. " );
    }
    private void messageUserHasEmptyCart(){
        System.out.println();
        System.out.println(RENDER_TXT_SPACEx2.getDecoration()+"Sorry, No Items Found in Your ShoppingCart." );
    }

    protected Boolean getHasConfirmedOrder() { return hasConfirmedOrder; }
    protected void setHasConfirmedOrder(Boolean hasConfirmedOrder) { this.hasConfirmedOrder = hasConfirmedOrder; }
}