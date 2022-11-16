package com.pcbuilder.menus;

import com.pcbuilder.menus.MainMenu;
import com.pcbuilder.session.Session;

public class Purchase_Submenu extends MainMenu {


    public Purchase_Submenu(Session session) { super(session); }


    @Override
    public void renderOwnMenu() {
        System.out.println( "purchase submenu" );
    }


}