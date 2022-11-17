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
        System.out.println("   [1] Main Menu " + " [2] Confirm Order ");
    }
    private void runOrderWalkThrough(){
//TODO[ ] : Refactor switch case

        createNewOrder();

        Order order = getSession().getOrder();
        order.printSessionOrder();
        updateUserSelection();
        do{

            switch ( getSelection() ){
                case 1: break;
                case 2:
                    processCustomerOrder();
                    break;
                default: break;
            }

        } while ( getSelection() != 1 );

    }
    //  Process the Order Menu
    private void processCustomerOrder() {
        System.out.println( "Thank You, Initiating Confirmation..." );
        System.out.println( "Fetching order details..." );
        System.out.println( "Validating order details..." );
        System.out.println( "Order Confirmation  complete...Thank you." );
        setHasConfirmedOrder(true);
        updateUserSelection();
    }
    private void createNewOrder(){
        Session session = getSession();
        session.createNewOrder();

        System.out.println( " New Order Created, Thank You. " );
        setHasConfirmedOrder(true);
        updateUserSelection();
    };

    public Boolean getHasConfirmedOrder() { return hasConfirmedOrder; }

    public void setHasConfirmedOrder(Boolean hasConfirmedOrder) { this.hasConfirmedOrder = hasConfirmedOrder; }
}