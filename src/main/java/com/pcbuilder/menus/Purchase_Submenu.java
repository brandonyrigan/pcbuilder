package com.pcbuilder.menus;

import com.pcbuilder.session.Session;

import static com.pcbuilder.menus.DecorateEnum.*;

public class Purchase_Submenu extends MainMenu {


    public Purchase_Submenu(Session session) { super(session); }


    @Override
    public void renderOwnMenu() {
        System.out.println( "purchase submenu" );
        System.out.println( RENDER_BANNER_SUBMENU_PURCHASE.getDecoration() );
    }


}