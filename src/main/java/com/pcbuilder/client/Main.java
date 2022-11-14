package com.pcbuilder.client;

import com.pcbuilder.inventory.Component;
import com.pcbuilder.session.Session;
import com.pcbuilder.session.WalkThroughUI;

import java.util.*;

//DONE Step 0: Greet and Process Customer
//  DONE[x] Welcome the User and Capture Customer Info
//  DONE[x] Creating a new Session
//DONE STEP 1: Display Current Build
//  DONE[X] render build
//DONE STEP 2: Render each Component Category and Save customers selection
//  DONE[x] Iterate through all Keys of the mapOfInventory
//  DONE[x] fetch component list
//  DONE[x] display list
//  Done[x] user can select item from Category list
//  DONE[x] add selected item ( only a reference ) to the current Build
//DONE STEP 3: Render each Component Category and Save customers selection
//  DONE[x] message customer of completed Build
//  DONE[x] render current Build
// TODO[ ] : Shopping cart
//      - TODO[ ] add Build to cart
//      - TODO[ ] remove Build from cart
//      - TODO[ ] view contents

public class Main {

    public static void main(String[] args) {
        new WalkThroughUI();
//        runPCBuilderAPP();
    }

    public static void runPCBuilderAPP(){
        String[] customerBasicInfo = welcomeTheCustomer();
        Session session = startCustomerSession( customerBasicInfo );
        HashMap<String, String> currentAcceptedBuild = runPCBuilderWalkThrough(session);
//        runCheckout( currentAcceptedBuild );

    }

    public static String [] welcomeTheCustomer(){
        String welcomeMessage = " Welcome to PC Builder where... ";
        System.out.println( welcomeMessage );
        String[] customerInputBasicInfo = captureCustomerInformation();
        return customerInputBasicInfo;
    }
    public static String[] captureCustomerInformation(){
//      TODO[ ]: allow user to go back and edit any input
//      TODO[ ]: allow user to exit the App

        Scanner scanner = new Scanner(System.in);

        String[] customerInputValues = new String[3];
        String customerFirstName;
        String customerLastName;
        String customerEmail;

        System.out.print("\nEnter your first name: ");
        customerFirstName = scanner.next();
        System.out.print("Value entered: " + customerFirstName.toUpperCase() + ", is this correct?  Yes/No");

        System.out.print("\nEnter your last name: ");
        customerLastName = scanner.next();
        System.out.print("Value entered: " + customerLastName.toUpperCase() + ", is this correct? Yes/No");

        System.out.print("\nEnter your email: ");
        customerEmail = scanner.next();
        System.out.print("Value entered: " + customerEmail.toUpperCase() + ", is this correct? Yes/No" );

        System.out.println( "\nIs the following information correct? Yes/No" );
        System.out.println( "name : " + customerLastName + "," + customerFirstName );
        System.out.println( "email: " + customerEmail );

        customerInputValues[0] = customerFirstName;
        customerInputValues[1] = customerLastName;
        customerInputValues[2] = customerEmail;

        return customerInputValues;
    }
    public static Session startCustomerSession( String[] customerBasicInfo ){
        return new Session( customerBasicInfo );
    }


    private static HashMap<String, String> runPCBuilderWalkThrough( Session session ) {
        Map<String, Collection<Component>> fetchedInventoryMap = session.fetchMapOfInventory();
        HashMap<String, String> currentSessionBuild = new HashMap<>();

        for ( Map.Entry<String, Collection<Component>> entry : fetchedInventoryMap.entrySet() ) {
            renderTargetList(
                    entry.getValue() ,
                    currentSessionBuild,
                    entry.getKey() );
        }

        renderCompletedSessionBuild( currentSessionBuild );
        return currentSessionBuild;
    }

//    REFACTOR: Create new class WalkThroughUI ( runPCBuilderWalkThrough() )
    public static void renderTargetList(
            Collection<Component> targetComponent,
            HashMap<String,String> temporarySessionBuild ,
            String keyName )
    {
//  reference : https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
//        DONE[x]: render target category name
//        TODO[ ]: generate dynamic table fields when rendering components
//        TODO[ ]: smooth transition from one component to another
//        TODO[ ]: holdComponentID should use the UUID not the name as an identifier
        String renderBar = "**********************************************" +
                "**********************************************" +
                "**********************************************" +
                "**********************************************";
        String renderDashes = "---------------------------------------------"+
                "------------------------------------------------"+
                "------------------------------------------------"+
                "-------------------------------------------";
        int selectCounter = 0;

        String[] holdComponentIds = new String[ targetComponent.size() ];

        System.out.println( renderBar );
        System.out.printf("%-5s | %-53s | %-10s | %-10s | %-20s ", "SELECT", keyName , "PRICE", "RATING", "DESCRIPTION");
        System.out.println();
        System.out.println(renderDashes);

        for(Component component: targetComponent){
            holdComponentIds[ selectCounter ] = component.getName();
            System.out.format("%6s | %-53s | %-10s | %-10s | %-20s",
                        selectCounter, component.getName(), component.getPrice(),
                        component.getRating(), component.getDescription());
            selectCounter++;
            System.out.println();
        }
        System.out.println( renderBar );
        String customerSelection = customerInputComponentSelection( holdComponentIds );
        String selectedComponentInformation = createComponentIdentifierInformation( keyName, customerSelection );
        addComponentToCurrentSessionBuild( selectedComponentInformation, temporarySessionBuild );

    };
    public static String customerInputComponentSelection( String... componentIds )
    {
        Scanner scanner = new Scanner(System.in);
        String customerSelectionNumber = "";
        String targetID = "";
        boolean chooseToEdit = true;
        int index = 0;
        while( chooseToEdit ){
            String componentId = componentIds[index++];
            System.out.print( "\nPlease, make your selection : ");
            customerSelectionNumber = scanner.next();
            System.out.print("You entered: " + customerSelectionNumber );
            System.out.print( ", Did we get that right? Y/N: " );
            String customerChoseToEditInput = scanner.next().toUpperCase().substring(0);
            if( customerChoseToEditInput.equals("Y") ) {
                chooseToEdit = false;
                targetID = componentId;
            }
        }
        return targetID;
    }
    public static String createComponentIdentifierInformation(
            String categoryName, String selectedComponentUUID )
    {
//  TODO[ ] - parse UUID from selectedComponent string value
        return categoryName +","+ selectedComponentUUID;
    }
    public static void addComponentToCurrentSessionBuild(
            String componentToAdd, HashMap<String, String>  tempMapSessionBuild )
    {

        String[] catNameAndComponentId = componentToAdd.split(",");
        String categoryName = catNameAndComponentId[0];
        String componentUUID = catNameAndComponentId[1];

        tempMapSessionBuild.put( categoryName, componentUUID );

    }
    public static void renderCompletedSessionBuild(HashMap<String, String> mapOfCompletedBuild )
    {
        System.out.print( "Congratulations! Here is your PC Build : " +"\n" );
        for (Map.Entry<String, String> component : mapOfCompletedBuild.entrySet()) {
            System.out.println( component.getKey() + ": " + component.getValue() );
        }

    }


}