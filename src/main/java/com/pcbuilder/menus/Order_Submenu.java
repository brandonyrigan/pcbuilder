package com.pcbuilder.menus;
import com.pcbuilder.checkout.Checkout;
import com.pcbuilder.client.Main;
import com.pcbuilder.menus.MainMenu;
import com.pcbuilder.session.Session;

import static com.pcbuilder.menus.IDecorate.*;

public class Order_Submenu extends MainMenu {

    public Order_Submenu( Session session ) { super( session ); }

    @Override
    public void renderOwnMenu() {
        renderSubmenuOrder();
        runOrderWalkThrough();
    }

    //  Order Menu
    private void renderSubmenuOrder(){
        System.out.println( RENDER_BAR.getDecoration() );
        System.out.println("View Order" );
        System.out.println("   Select from the options below");
        System.out.println("   [1] Main Menu " + "[2] Update Payment Details "+ "[3] Confirm Order ");
    }
    private void runOrderWalkThrough(){
//TODO[ ] : Refactor switch case
        Session session = getSession();
        session.createNewOrder();
        session.getOrder();

        updateUserSelection();
        do{
            switch ( getSelection() ){
                case 1:
                    System.out.println( "to Main Menu" );
                    break;
                case 2:
                    System.out.println( "Update Payment Details" );
                    updateUserSelection();
                    break;
                case 3:
                    System.out.println( "Confirm Order" );
                    processCustomerOrder();
                    break;
                default: break;
            }
        } while ( getSelection() != 1 );
    }


    //  Process the Order Menu
    private void processCustomerOrder() {
        System.out.println( "Finalizing build... " );
        System.out.println( "Congratulations your PC Build is complete! " );

        Session session = getSession();

        Checkout checkoutSession = session.processOrder();
        checkoutSession.processPayment();
        updateUserSelection();
    }


}