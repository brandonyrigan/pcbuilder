package com.pcbuilder.menus;

import com.pcbuilder.inventory.Component;
import com.pcbuilder.session.Session;
import java.util.Collection;
import java.util.Map;
import static com.pcbuilder.menus.DecorateEnum.*;

public class PCComponents_SubMenu extends MainMenu {

    public PCComponents_SubMenu( Session session ) {
        super(session);
    }

    @Override
    public void renderOwnMenu() {
        renderSubmenuPCComponentsMenu();
        runPCComponentsSubmenu();
    }

    //  PC Builder Submenu
    private void renderSubmenuPCComponentsMenu(){
        System.out.println( RENDER_BANNER_SUBMENU_PCCOMPONENTS.getDecoration() );
        System.out.println("   Select which component you would like to view an inventory for");
        System.out.println("   [9] Return to Main Menu  [0] Shopping Cart" );

        Session session = getSession();
        Map<String, Collection<Component>> fetchedInventoryMap = session.fetchMapOfInventory();
        int index = 1;
        for ( Map.Entry<String, Collection<Component>> entry : fetchedInventoryMap.entrySet() ) {
            System.out.print( "   ["+ index++ +"] "+entry.getKey() );
        }
        System.out.println();
    }
    private void runPCComponentsSubmenu(){

//TODO[X]: keep customer in this menu until done selecting all components or return to main menu
//TODO[ ] - Refactor multiple switch statements
        do {
            Session session = getSession();
            Map<String, Collection<Component>> fetchedInventoryMap = session.fetchMapOfInventory();
            Collection<Component> targetCollection = null;

            if (componentCount == 8) {
                displayBuildCompleteMessage();
            }

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
                    targetCollection = fetchedInventoryMap.get("Motherboard");
                    renderComponentCategory(session, targetCollection, "Motherboard");
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
                case 0:
                    Menu targetSubmenu = new ShoppingCart_Submenu( session );
                    targetSubmenu.renderOwnMenu();
                default:
                    break;
            }
            renderCurrentSessionBuild();
            renderSubmenuPCComponentsMenu();
        } while (getSelection() != 9);

    }
    private void renderComponentCategory(Session session, Collection<Component> targetCollection, String collectionName ){

        int selectionCounter = 1;
        String componentId = "";
        String componentName = "";
//  TODO[ ]- FIX: NUllPointerException
        String[] holdComponentNameAndId = new String[ targetCollection.size() +1 ];

        System.out.println(RENDER_SHORT_BAR.getDecoration());
        Double[] holdComponentPrices = new Double[targetCollection.size() + 1];
        System.out.printf("%-5s | %-53s | %-10s | %-10s | %-20s ", "SELECT", collectionName , "PRICE", "RATING", "DESCRIPTION");
        System.out.println();
        System.out.println(RENDER_DASHES.getDecoration());

        for(Component component: targetCollection){

            componentId = component.getProductId().toString();
            componentName = component.getName();
            holdComponentPrices[selectionCounter] = component.getPrice();
            holdComponentNameAndId[ selectionCounter ] = componentName + "," + componentId  ;

            System.out.format("%6s | %-53s | %-10s | %-10s | %-20s",
                    selectionCounter, component.getName(), component.getPrice(),
                    component.getRating(), component.getDescription());
            selectionCounter++;
            System.out.println();
        }
        System.out.println(RENDER_LONG_BAR.getDecoration());
//
        String componentNameAndId = customerComponentSelection( collectionName, holdComponentPrices, holdComponentNameAndId );

//      TODO[ ]- FIX: componentCount not being updated at ParentClass
        if (!session.getSessionBuild().containsKey(collectionName)) {
            componentCount++;
        }

//      Update Sessions temp Build
        session.updateSessionBuild( collectionName, componentNameAndId );

    }
    public String customerComponentSelection( String collectionName, Double[] componentPrices, String... componentNameAndId){
        boolean chooseToEdit = true;
        String targetComponentNameAndId = "";
        do{
            System.out.print( "\nPlease, make your selection : ");
            updateUserSelection();

            targetComponentNameAndId = componentNameAndId[ getSelection() ];

            System.out.println( "You entered " + " ["+getSelection()+"]" + ", did we get that right? Yes/No" );
            updateConfirmSelection();
//            String editChoice = getConfirmSelection().toUpperCase().substring(0);
            String editChoice = getConfirmSelection();
            if( editChoice.equalsIgnoreCase("yes") ) chooseToEdit = false;
        }
        while( chooseToEdit );

        currentBuildPrices.put(collectionName, componentPrices[getSelection()]);

        return targetComponentNameAndId;
    }


}