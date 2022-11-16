package com.pcbuilder.menus;

import com.pcbuilder.menus.MainMenu;
import com.pcbuilder.session.Session;

/**
 * Created by dev0 on 11/15/22.
 */
public class ShoppingCart_Submenu extends MainMenu {

    public ShoppingCart_Submenu(Session session) { super(session); }

    @Override
    public void renderOwnMenu() {

        System.out.println( "shopping cart submenu" );
        createBuild();
    }



}