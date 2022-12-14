package com.pcbuilder.menus;

/**
 * Created by dev0 on 11/15/22.
 */
public enum DecorateEnum {
    RENDER_TXT_SPACE("  "),
    RENDER_TXT_SPACEx2("    "),
    RENDER_SHORT_BAR("═════════════════════════════════════════════════"),
    RENDER_LONG_BAR("═══════════════════════════════════════════════════════════════════════════════════════════════════════════"),
    RENDER_DASHES("-------------------------------------------"),
    RENDER_BANNER_WELCOME(
                      "╔═════════════════════════════════════════════════════════════════════════════════════════════════════════╗"+
                    "\n║                                            WELCOME TO PC BUILDER                                        ║"+
                    "\n╚═════════════════════════════════════════════════════════════════════════════════════════════════════════╝"
    ),
    RENDER_BANNER_MENU_MAINMENU(
                      "╔═════════════════════════════════════════════════════════════════════════════════════════════════════════╗"+
                    "\n║                                                  MAIN MENU                                              ║"+
                    "\n╚═════════════════════════════════════════════════════════════════════════════════════════════════════════╝"
    ),
    RENDER_BANNER_SUBMENU_PCCOMPONENTS(
                      "╔═════════════════════════════════════════════════════════════════════════════════════════════════════════╗"+
                    "\n║                                                  PC COMPONENTS                                          ║"+
                    "\n╚═════════════════════════════════════════════════════════════════════════════════════════════════════════╝"
    ),
    RENDER_BANNER_SUBMENU_SHOPPINGCART(
                      "╔═════════════════════════════════════════════════════════════════════════════════════════════════════════╗"+
                    "\n║                                                  SHOPPING CART                                          ║"+
                    "\n╚═════════════════════════════════════════════════════════════════════════════════════════════════════════╝"
    ),
    RENDER_BANNER_SUBMENU_ORDER(
                      "╔═════════════════════════════════════════════════════════════════════════════════════════════════════════╗"+
                    "\n║                                                    VIEW ORDER                                           ║"+
                    "\n╚═════════════════════════════════════════════════════════════════════════════════════════════════════════╝"
    ),
    RENDER_BANNER_SUBMENU_PURCHASE(
                      "╔═════════════════════════════════════════════════════════════════════════════════════════════════════════╗"+
                    "\n║                                                     CHECKOUT                                            ║"+
                    "\n╚═════════════════════════════════════════════════════════════════════════════════════════════════════════╝"
    ),
    RENDER_BANNER_SUBMENU_UPDATE_PROFILE(
                      "╔═════════════════════════════════════════════════════════════════════════════════════════════════════════╗"+
                    "\n║                                               UPDATE CUSTOMER INFO                                      ║"+
                    "\n╚═════════════════════════════════════════════════════════════════════════════════════════════════════════╝"
    ),
    RENDER_BANNER_THANKYOU(
                      "╔═════════════════════════════════════════════════════════════════════════════════════════════════════════╗"+
                    "\n║                                          THANK YOU FOR YOUR PURCHASE                                    ║"+
                    "\n╚═════════════════════════════════════════════════════════════════════════════════════════════════════════╝"
    );

    DecorateEnum(String decoration) { this.decoration = decoration; }
    private final String decoration;
    public String getDecoration(){
        return this.decoration;
    }
}