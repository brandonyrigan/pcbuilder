package com.pcbuilder.session;

import com.pcbuilder.inventory.Component;
import java.util.*;

public class WalkThroughUI {


    private int selection;
    private String confirmSelection;


    public WalkThroughUI() { renderMenu(); }
    private void mainMenu(String... customerInfo){
        System.out.println( " Customer:  " + customerInfo[1] + ", "+ customerInfo[0] );
        System.out.println(" MENU: " +
                        "  [1] PC Builder " +
                        "  [2] Shopping Cart " +
                        "  [3] View Order " +
                        "  [4] Purchase"+
                        "  [5] Update Customer Information "
        );
    }
    private void renderCurrentSessionBuild( Session session ){
        System.out.println( " Current Build " + session.getSessionBuild() );
    }


//    Business Methods
    private void renderMenu(){
//    TODO[x]: stop user from re-rendering when inputs invalid menu selection not 1-5 or 0

        welcomeTheCustomer();
        String[] customerInfo = processCustomerInformation();
        Session session = startCustomerSession(customerInfo);

        do{
            mainMenu(customerInfo);
            renderCurrentSessionBuild( session );
            updateUserSelection();
            switch ( selection ){
                case 1:
                    System.out.println( "PC Builder WalkThrough" );
                    renderPCComponents( session );
                    runPCBuilderWalkThrough( session );
                    break;
                case 2:
                    System.out.println( "Shopping Cart" );
                    break;
                case 3:
                    System.out.println( "View Order" );
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
    public static Session startCustomerSession( String[] customerBasicInfo ){
        return new Session( customerBasicInfo );
    }


//    Helper Methods
    private void updateUserSelection(){
        Scanner scanner = new Scanner(System.in);
        setSelection( Integer.parseInt( scanner.next() ));
    }
    private void updateConfirmSelection(){
        Scanner scanner = new Scanner(System.in);
        setConfirmSelection( scanner.nextLine() );
    }
    private void welcomeTheCustomer(){
        System.out.println( " Welcome to PC Builder where..." );
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
    private void renderPCComponents(Session session){
        System.out.println("   Select which component you would like to view an inventory for");
        System.out.println("   [9] Return to Main Menu " );

        Map<String, Collection<Component>> fetchedInventoryMap = session.fetchMapOfInventory();
        int index = 1;
        for ( Map.Entry<String, Collection<Component>> entry : fetchedInventoryMap.entrySet() ) {
            System.out.print( "   ["+ index++ +"] "+entry.getKey() );
        }
    }
    private void runPCBuilderWalkThrough(Session session ){

//  TODO[ ]: keep customer in this menu until done selecting all components or return to main menu

        Map<String, Collection<Component>> fetchedInventoryMap = session.fetchMapOfInventory();
        Collection<Component> targetCollection;

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
    private void renderComponentCategory(
            Session session, Collection<Component> targetCollection, String collectionName ){

        String renderBar = "**********************************************";
        String renderDashes = "-------------------------------------------";
        int selectCounter = 1;

        String[] holdComponentIds = new String[ targetCollection.size() +1 ];

        System.out.println( renderBar );
        System.out.printf("%-5s | %-53s | %-10s | %-10s | %-20s ", "SELECT", collectionName , "PRICE", "RATING", "DESCRIPTION");
        System.out.println();
        System.out.println(renderDashes);

        for(Component component: targetCollection){
            holdComponentIds[ selectCounter ] = component.getProductId().toString();
            System.out.format("%6s | %-53s | %-10s | %-10s | %-20s",
                    selectCounter, component.getName(), component.getPrice(),
                    component.getRating(), component.getDescription());
            selectCounter++;
            System.out.println();
        }
        System.out.println( renderBar );

        String componentUUID = customerComponentSelection( holdComponentIds );
        session.updateSessionBuild( collectionName, componentUUID );

    }
    public String customerComponentSelection( String... componentIds ){

        boolean chooseToEdit = true;
        String targetID;

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


//    Accessor Methods
    public int getSelection() { return selection; }
    public void setSelection(int selection) { this.selection = selection; }
    public String getConfirmSelection() { return confirmSelection; }
    public void setConfirmSelection(String confirmSelection) { this.confirmSelection = confirmSelection; }


}