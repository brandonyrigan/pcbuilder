package com.pcbuilder.menus;

import com.pcbuilder.session.Session;
import com.pcbuilder.menus.*;
import static com.pcbuilder.menus.DecorateEnum.*;

public class UpdateCustomerInfo_Submenu extends MainMenu {

    public UpdateCustomerInfo_Submenu( Session session ) { super( session ); }

    @Override
    public void renderOwnMenu(){
        System.out.println( RENDER_BANNER_SUBMENU_UPDATE_PROFILE.getDecoration() );
        session.getCustomer().updateCustomerBasicInfo(processCustomerInformation());
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


}