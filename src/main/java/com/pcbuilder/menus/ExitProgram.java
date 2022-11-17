package com.pcbuilder.menus;

import com.pcbuilder.session.Session;

/**
 * Created by dev0 on 11/17/22.
 */
public class ExitProgram extends MainMenu{

    public ExitProgram(){}
    @Override
    public void renderOwnMenu() { System.exit(0); }
}