package com.pcbuilder.menus;

import com.pcbuilder.session.Session;

import static com.pcbuilder.menus.DecorateEnum.RENDER_BANNER_SUBMENU_UPDATE_PROFILE;

public class UpdateCustomerInfo_Submenu extends MainMenu {

    public UpdateCustomerInfo_Submenu( Session session ) { super( session ); }

    @Override
    public void renderOwnMenu(){
        System.out.println( RENDER_BANNER_SUBMENU_UPDATE_PROFILE.getDecoration() );
        processCustomerInformation();
    }

    private String[] processCustomerInformation(){
//DONE[x]: allow user to go back and edit their entries
//DONE[x]: allow user to exit the App
//DONE[x]: refactor to use confirmSelection data field

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
            String editChoice = getConfirmSelection().toUpperCase().substring(0);
            if( editChoice.equals("Y") ) chooseToEdit = false;
        }
        while( chooseToEdit );

        customerInputValues[0] = customerFirstName;
        customerInputValues[1] = customerLastName;
        customerInputValues[2] = customerEmail;

        return customerInputValues;
    }


}