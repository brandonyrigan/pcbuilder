package com.pcbuilder.menus;

import com.pcbuilder.checkout.Checkout;
import com.pcbuilder.checkout.Payment;
import com.pcbuilder.session.Session;

import static com.pcbuilder.menus.DecorateEnum.*;

public class Checkout_Submenu extends MainMenu {

    Checkout checkout;

    public Checkout_Submenu( Session session ) {
        super(session);
        setCheckout( createNewCheckout() );
    }

    @Override
    public void renderOwnMenu() {
        renderCheckoutSubmenu();
        runOrderSubmenu();
    }
    private void renderCheckoutSubmenu(){
        System.out.println( RENDER_BANNER_SUBMENU_PURCHASE.getDecoration() );
        System.out.println("CheckOut Details" );
        System.out.println("   Select from the options below");
        System.out.println("   [1] Main Menu " + " [2] Add Payment" + " [3] Make Payment " );
    }
    private void runOrderSubmenu(){

        Checkout checkout = getCheckout();
        checkout.displayOrderDetails();

        updateUserSelection();
        do{
            switch ( getSelection() ){
                case 1: break;
                case 2:
                    addPaymentMethod();
                    break;
                case 3:
                    makePayment();
                    break;
                default: break;
            }
        } while ( getSelection() != 1 );

    }

    private void addPaymentMethod(){
        addPaymentMethodToSessionOrder();
        updateUserSelection();
    }
    private void addPaymentMethodToSessionOrder(){
        Checkout checkout = getCheckout();

        String[] ccInfo = customerCreditCardInfo().split(",");
        String name = ccInfo[0];
        Integer ccNumber = Integer.parseInt(ccInfo[1]);
        Integer ccCCV = Integer.parseInt(ccInfo[2]);

        Payment newPayment = new Payment( ccNumber, ccCCV, name );

        checkout.addCustomerPayment( newPayment );

        updateUserSelection();
    }
    private void makePayment(){

        Checkout checkout = getCheckout();
        checkout.processPayment();
//        EXIT
        updateUserSelection();
    }

    private String customerCreditCardInfo(){
        System.out.println( " Enter Credit/Debit Card Number " );
        updateConfirmSelection();
        String customerCreditCardNumber = getConfirmSelection();

        System.out.println( " Enter Name on Credit/Debit Card " );
        updateConfirmSelection();
        String customerNameOnCard = getConfirmSelection();

        System.out.println( " Enter CCV Code " );
        updateConfirmSelection();
        String customerCCVCode = getConfirmSelection();

        return customerNameOnCard + "," +
                customerCreditCardNumber + "," +
                customerCCVCode;
    }
    private Checkout createNewCheckout(){
        Checkout newCheckoutSession = new Checkout( session.getOrder(), new Payment() );
        return newCheckoutSession;
    }


    public Checkout getCheckout() { return checkout; }
    public void setCheckout(Checkout checkout) { this.checkout = checkout; }


}