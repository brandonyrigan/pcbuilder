package com.pcbuilder.client;

import com.pcbuilder.menus.RenderMenusUI;

// TODO [ ] - Refactor: WalkThroughUI (not needed)
    // TODO [X] - replace with RenderMenusUI
    // TODO [X] - add abstract Menu and implement MainMenu with renderOwnMenu
    // TODO [X] - extend submenus from MainMenu Parent Class and implement Override renderOwnMenu

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
// DONE[x] : SHOPPING CART
//      - TODO[x] add Build to cart
//      - TODO[x] remove Build from cart
//      - TODO[x] view contents
// TODO[ ] : ORDER
//      - TODO[x] create new order
//      - TODO[x] display order to customer
//      - TODO[ ] display total price
//      - TODO[ ] display total price after tax (?)
//      - TODO[x] prompt customer to return to main menu
//      - TODO[x] prompt customer to proceed to payment
//      - TODO[x] prompt customer to confirm order
// TODO[ ] : PAYMENT
//      - TODO[] prompt customer to select payment type

public class Main {

    public static void main(String[] args) {
//        new WalkThroughUI();
        new RenderMenusUI();
    }

}