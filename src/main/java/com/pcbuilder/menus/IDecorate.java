package com.pcbuilder.menus;

/**
 * Created by dev0 on 11/15/22.
 */
public enum IDecorate {
    RENDER_BAR("**********************************************"),
    RENDER_DASHES("-------------------------------------------");
    IDecorate(String decoration) { this.decoration = decoration; }
    private final String decoration;
    public String getDecoration(){
        return this.decoration;
    }

//    public static void clearSystemOut(){
//        System.out.print( "\\033[H\\033[2J" );
//        System.out.flush();
//    }
}