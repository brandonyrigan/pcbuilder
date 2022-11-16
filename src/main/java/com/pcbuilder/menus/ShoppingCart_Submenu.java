package com.pcbuilder.menus;

import com.pcbuilder.session.Session;

import static com.pcbuilder.menus.DecorateEnum.RENDER_BANNER_SUBMENU_SHOPPINGCART;

/**
 * Created by dev0 on 11/15/22.
 */
public class ShoppingCart_Submenu extends MainMenu {

    public ShoppingCart_Submenu(Session session) { super(session); }

    @Override
    public void renderOwnMenu() {
        System.out.println( RENDER_BANNER_SUBMENU_SHOPPINGCART.getDecoration() );
        System.out.println( "shopping cart submenu" );
        createBuild();
    }



}