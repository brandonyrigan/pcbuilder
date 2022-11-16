package com.pcbuilder.session;

import com.pcbuilder.checkout.Checkout;
import com.pcbuilder.build.Build;
import com.pcbuilder.inventory.Component;
import com.pcbuilder.menus.IDecorate;
import com.pcbuilder.menus.MainMenu;

import java.util.*;

public class WalkThroughUI {


    private int selection;
    private String confirmSelection;
    private int componentCount;


    public WalkThroughUI(){ renderMenu(); }


//    Business Methods
private void renderMenu(){
//    TODO[]: stop user from re-rendering when inputs invalid menu selection not 1-5 or 0

    welcomeTheCustomer();
    String[] customerInfo = processCustomerInformation();
    Session session = startCustomerSession(customerInfo);
    MainMenu mainMenu = new MainMenu( session, customerInfo );
    mainMenu.renderOwnMenu();

    do{
        mainMenu(customerInfo);
        renderCurrentSessionBuild( session );
        if ( componentCount == 8 ) { createBuild(session); }

        updateUserSelection();

        switch ( getSelection() ){
            case 1:
                    System.out.println( "PC Builder WalkThrough" );
                renderSubmenuPCComponentsMenu( session );
                runPCComponentsSubmenu( session );
                break;
            case 2:
                System.out.println( "Shopping Cart" );
                break;
            case 3:
                    System.out.println( "View Order" );
                renderSubmenuOrder();
                runOrderWalkThrough( session );
                break;
            case 4:
                System.out.println( "Purchase" );
                break;
            case 5:
                    System.out.println( "Update Customer Information" );
                processCustomerInformation();
                break;
            default: break;
        }
    }
    while( selection != 0 );
}


//  Main Menu Helper Methods
    private void updateUserSelection(){
        Scanner scanner = new Scanner(System.in);
        setSelection( Integer.parseInt( scanner.next() ));
    }
    private void updateConfirmSelection(){
        Scanner scanner = new Scanner(System.in);
        setConfirmSelection( scanner.nextLine() );
    }
    private void displayBuildCompleteMessage() {
        System.out.println("Build is complete! All 8 components have been selected. Please go to shopping cart to complete order.");
        System.out.println(IDecorate.RENDER_BAR);
    }
    private void createBuild(Session session) {
//        displayBuildCompleteMessage();
        Build build = session.composeBuild(session);
        session.addBuildToCart(build);
        componentCount = 0;
    }


// Main Menu
    private void mainMenu(String... customerInfo){
        System.out.println( IDecorate.RENDER_BAR );
        System.out.println( " Customer:  " + customerInfo[1] + ", "+ customerInfo[0] );
        System.out.println(" MENU: " +
                "  [1] PC Builder " +
                "  [2] Shopping Cart " +
                "  [3] View Order " +
                "  [4] Purchase"+
                "  [5] Update Customer Information "+
                "  [6] Update Customer Information "
        );
    }
//    private void runPCComponentsSubmenu(Session session ){
//
////  TODO[ ]: keep customer in this menu until done selecting all components or return to main menu
//        Map<String, Collection<Component>> fetchedInventoryMap = session.fetchMapOfInventory();
//        Collection<Component> targetCollection = null;
//
//        updateUserSelection();
//        switch ( getSelection() ) {
//            case 1:
//                targetCollection = fetchedInventoryMap.get("PowerSupply");
//                renderComponentCategory(session, targetCollection, "PowerSupply");
//                break;
//            case 2:
//                targetCollection = fetchedInventoryMap.get("Storage");
//                renderComponentCategory(session, targetCollection, "Storage");
//                break;
//            case 3:
//                targetCollection = fetchedInventoryMap.get("CPUCooler");
//                renderComponentCategory(session, targetCollection, "CPUCooler");
//                break;
//            case 4:
//                targetCollection = fetchedInventoryMap.get("Motherboard");
//                renderComponentCategory(session, targetCollection, "Motherboard");
//                break;
//            case 5:
//                targetCollection = fetchedInventoryMap.get("Memory");
//                renderComponentCategory(session, targetCollection, "Memory");
//                break;
//            case 6:
//                targetCollection = fetchedInventoryMap.get("VideoCard");
//                renderComponentCategory(session, targetCollection, "VideoCard");
//                break;
//            case 7:
//                targetCollection = fetchedInventoryMap.get("CPU");
//                renderComponentCategory(session, targetCollection, "CPU");
//                break;
//            case 8:
//                targetCollection = fetchedInventoryMap.get("Case");
//                renderComponentCategory(session, targetCollection, "Case");
//                break;
//            case 9:
//                System.out.println();
//                break;
//            default:
//                break;
//        }
//    }


// Session  and Customer
    private void renderCurrentSessionBuild( Session session ){
        System.out.println( " Current Build " + session.getSessionBuild() );
        System.out.println(" Build Progress: " + componentCount + "/8");
        System.out.println( IDecorate.RENDER_BAR );

    }
    public static Session startCustomerSession( String[] customerBasicInfo ){
        return new Session( customerBasicInfo );
    }
    private void welcomeTheCustomer(){
        System.out.println( "Welcome to PC Builder where..." );
    }
    private String[] processCustomerInformation(){
//      TODO[]: allow user to go back and edit their entries
//      TODO[x]: allow user to exit the App
//      TODO[x]: refactor to use confirmSelection data field

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


//  PC Builder Menu
    private void renderSubmenuPCComponentsMenu(Session session){
    System.out.println("   Select which component you would like to view an inventory for");
    System.out.println("   [9] Return to Main Menu " );

        Map<String, Collection<Component>> fetchedInventoryMap = session.fetchMapOfInventory();
        int index = 1;
        for ( Map.Entry<String, Collection<Component>> entry : fetchedInventoryMap.entrySet() ) {
            System.out.print( "   ["+ index++ +"] "+entry.getKey() );
        }
        System.out.println();
    }
    private void runPCComponentsSubmenu( Session session ){

//  TODO[ ]: keep customer in this menu until done selecting all components or return to main menu

    Map<String, Collection<Component>> fetchedInventoryMap = session.fetchMapOfInventory();
    Collection<Component> targetCollection = null;

    updateUserSelection();
    switch ( getSelection() ) {
        case 1:
            targetCollection = fetchedInventoryMap.get("PowerSupply");
            renderComponentCategory(session, targetCollection, "PowerSupply");
            break;
        case 2:
            targetCollection = fetchedInventoryMap.get("Storage");
            renderComponentCategory(session, targetCollection, "Storage");
            break;
        case 3:
            targetCollection = fetchedInventoryMap.get("CPUCooler");
            renderComponentCategory(session, targetCollection, "CPUCooler");
            break;
        case 4:
            targetCollection = fetchedInventoryMap.get("MotherBoard");
            renderComponentCategory(session, targetCollection, "MotherBoard");
            break;
        case 5:
            targetCollection = fetchedInventoryMap.get("Memory");
            renderComponentCategory(session, targetCollection, "Memory");
            break;
        case 6:
            targetCollection = fetchedInventoryMap.get("VideoCard");
            renderComponentCategory(session, targetCollection, "VideoCard");
            break;
        case 7:
            targetCollection = fetchedInventoryMap.get("CPU");
            renderComponentCategory(session, targetCollection, "CPU");
            break;
        case 8:
            targetCollection = fetchedInventoryMap.get("Case");
            renderComponentCategory(session, targetCollection, "Case");
            break;
        case 9:
            System.out.println();
            break;
        default:
            break;
    }

}
    private void renderComponentCategory(Session session, Collection<Component> targetCollection, String collectionName ){

        int selectCounter = 1;

        String[] holdComponentIds = new String[ targetCollection.size() +1 ];

        System.out.println(IDecorate.RENDER_BAR);
        System.out.printf("%-5s | %-53s | %-10s | %-10s | %-20s ", "SELECT", collectionName , "PRICE", "RATING", "DESCRIPTION");
        System.out.println();
        System.out.println(IDecorate.RENDER_DASHES);

        for(Component component: targetCollection){
            holdComponentIds[ selectCounter ] = component.getProductId().toString();
            System.out.format("%6s | %-53s | %-10s | %-10s | %-20s",
                    selectCounter, component.getName(), component.getPrice(),
                    component.getRating(), component.getDescription());
            selectCounter++;
            System.out.println();
        }
        System.out.println(IDecorate.RENDER_BAR);

        String componentUUID = customerComponentSelection( holdComponentIds );

        if (!session.getSessionBuild().containsKey(collectionName))  componentCount++;

        session.updateSessionBuild( collectionName, componentUUID );

    }
    public String customerComponentSelection( String... componentIds ){

        boolean chooseToEdit = true;
        String targetID = "";

        do{
            System.out.print( "\nPlease, make your selection : ");
            updateUserSelection();
            targetID = componentIds[getSelection()];
            System.out.println( "You entered " + " ["+getSelection()+"]" + ", did we get that right? Yes/No" );
            updateConfirmSelection();
            String editChoice = getConfirmSelection().toUpperCase().substring(0);
            if( editChoice.equals("Y") ) chooseToEdit = false;
        }
        while( chooseToEdit );

        return targetID;
    }


//  Order Menu
    private void renderSubmenuOrder(){
        System.out.println( IDecorate.RENDER_BAR );
        System.out.println("View Order" );
        System.out.println("   Select from the options below");
        System.out.println("   [1] Main Menu " + "[2] Update Payment Details "+ "[3] Confirm Order ");
    }
    private void runOrderWalkThrough( Session session ){

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
                    processCustomerOrder( session );
                    break;
                default: break;
            }
        }while ( getSelection() != 1 );
    }


//  Process Order Menu
    private void processCustomerOrder( Session session ) {
        System.out.println( "Finalizing build... " );
        System.out.println( "Congratulations your PC Build is complete! " );

        Checkout checkoutSession = session.processOrder();
        checkoutSession.processPayment();
        updateUserSelection();
    }


//  Accessor Methods
    public int getSelection() { return selection; }
    public void setSelection(int selection) { this.selection = selection; }
    public String getConfirmSelection() { return confirmSelection; }
    public void setConfirmSelection(String confirmSelection) { this.confirmSelection = confirmSelection; }


}