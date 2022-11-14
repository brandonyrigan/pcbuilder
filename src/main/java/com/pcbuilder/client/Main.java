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
    }

}