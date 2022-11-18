package com.pcbuilder.menus;

import com.pcbuilder.customer.Customer;
import com.pcbuilder.session.Session;
import static com.pcbuilder.menus.DecorateEnum.RENDER_BANNER_WELCOME;
import java.util.Scanner;

public class RenderMenusUI {
    protected String confirmSelection;

    public RenderMenusUI(){ renderMenu(); }


    public void renderMenu(){ startNewCustomerSession();}
    private void startNewCustomerSession(  ){
        welcomeTheCustomer();
        generateNewMenu();
    }
    private void welcomeTheCustomer(){
        System.out.println( RENDER_BANNER_WELCOME.getDecoration() );
        System.out.println( "Browse and Build a personal PC from an existing inventory of PC Components");
    }

    public Session generateNewSessionObject(String[] customerBasicInfo ){
        System.out.println( " starting new Session " );
        Session newSession = new Session(customerBasicInfo);
        return newSession;
    }
    public void generateNewMenu( ){
        String[] guestCustomerInfo = processCustomerInformation();
        Session newSession = generateNewSessionObject( guestCustomerInfo );
        newSession.getCustomer().updateCustomerBasicInfo(guestCustomerInfo);
        MainMenu mainMenu = new MainMenu(newSession, guestCustomerInfo);
        mainMenu.renderOwnMenu();
    }
    protected void updateConfirmSelection(){
        Scanner scanner = new Scanner(System.in);
        setConfirmSelection( scanner.nextLine() );
    }

    private String[] processCustomerInformation(){

        String[] customerInputValues = new String[3];
        String customerFirstName;
        String customerLastName;
        String customerEmail;

        boolean chooseToEdit = true;

        do{
            System.out.print("Enter your first name: ");
            updateConfirmSelection();
            customerFirstName = getConfirmSelection();

            System.out.print("Enter your last name: ");
            updateConfirmSelection();
            customerLastName = getConfirmSelection();

            System.out.print("Enter your email: ");
            updateConfirmSelection();
            customerEmail = getConfirmSelection();

            System.out.println( "\nYou entered " +
                    "\n name: " + customerLastName+", "+customerFirstName +
                    "\n email: " + customerEmail +
                    "\ndid we get that right? Yes/No" );
            updateConfirmSelection();
            String editChoice = getConfirmSelection();
            if( editChoice.equalsIgnoreCase("y") || editChoice.equalsIgnoreCase("yes") ) chooseToEdit = false;
        }
        while( chooseToEdit );

        customerInputValues[0] = customerFirstName;
        customerInputValues[1] = customerLastName;
        customerInputValues[2] = customerEmail;

        return customerInputValues;
    }

    public String getConfirmSelection() { return confirmSelection; }
    public void setConfirmSelection(String confirmSelection) { this.confirmSelection = confirmSelection; }

}