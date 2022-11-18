package com.pcbuilder.menus;

import com.pcbuilder.checkout.Checkout;
import com.pcbuilder.checkout.Payment;
import com.pcbuilder.session.Session;

import static com.pcbuilder.menus.DecorateEnum.*;

public class Checkout_Submenu extends MainMenu {

    Checkout checkout;

    public Checkout_Submenu( Session session ) {
        super(session);
        setCheckout( new Checkout() );
    }

    @Override
    public void renderOwnMenu() {
        renderCheckoutSubmenu();
        runOrderSubmenu();
    }
    private void renderCheckoutSubmenu(){
        System.out.println( RENDER_BANNER_SUBMENU_PURCHASE.getDecoration() );
        System.out.println("CheckOut Menu" );
        System.out.println("   Select from the options below");
        renderCheckoutOptions();
    }
    private void runOrderSubmenu(){

        createNewCheckout();

        Checkout checkout = getCheckout();
        checkout.displayOrderDetails();
        renderCheckoutOptions();
        do{
            updateUserSelection();
            switch ( getSelection() ){
                case 1: break;
                case 2:
                    addPaymentMethod();
                    renderCheckoutOptions();
                    break;
                case 3:
                    updatePaymentInfo();
                    renderCheckoutOptions();
                    break;
                case 4:
                    makePayment();
                    renderCheckoutOptions();
                    break;
                default: break;
            }
        } while ( getSelection() != 1 );

    }

    private void addPaymentMethod(){
        addPaymentMethodToSessionOrder();
    }
    private void addPaymentMethodToSessionOrder(){
        Checkout checkout = getCheckout();

        String[] ccInfo = customerCreditCardInfo().split(",");
        String name = ccInfo[0];
        Long ccNumber = Long.parseLong(ccInfo[1]);
        Integer ccCCV = Integer.parseInt(ccInfo[2]);

        Payment newPayment = new Payment( ccNumber, ccCCV, name );
        checkout.addCustomerPayment( newPayment );

        System.out.println( " Your Card Info: " );
        checkout.displayPaymentInfo();
    }

    private void updatePaymentInfo(){
        Checkout checkout = getCheckout();

        String[] ccInfo = customerCreditCardInfo().split(",");
        String name = ccInfo[0];
        Long ccNumber = Long.parseLong(ccInfo[1]);
        Integer ccCCV = Integer.parseInt(ccInfo[2]);

        Payment newPayment = new Payment( ccNumber, ccCCV, name );
        checkout.addCustomerPayment( newPayment );

        System.out.println( " Your Updated Card info: " );
        checkout.displayPaymentInfo();

    }

    private void makePayment(){

        Checkout checkout = getCheckout();
        checkout.processPayment();
        System.out.println( RENDER_BANNER_THANKYOU.getDecoration() );
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
    private void createNewCheckout(){
        Checkout newCheckoutSession = new Checkout( session.getOrder(), new Payment() );
        setCheckout( newCheckoutSession );
    }

    private void renderCheckoutOptions() {
        System.out.println("   [1] Main Menu " + " [2] Add Payment" + " [3] Update Payment" + " [4] Make Payment " );
    }


    public Checkout getCheckout() { return checkout; }
    public void setCheckout(Checkout checkout) { this.checkout = checkout; }


}