package com.pcbuilder.menus;

import com.pcbuilder.session.Session;

import static com.pcbuilder.menus.DecorateEnum.RENDER_BANNER_WELCOME;

public class RenderMenusUI {


    public RenderMenusUI(){ renderMenu(); }


    public void renderMenu(){ startNewCustomerSession();}
    private void startNewCustomerSession(  ){
        welcomeTheCustomer();
        generateNewMenu();
    }
    private void welcomeTheCustomer(){
//        System.out.println( "Welcome to PC Builder App");
//            System.out.println("╔═══════════════════════════════════╗");
//            System.out.println("║        Welcome to PC Builder      ║");
//            System.out.println("╚═══════════════════════════════════╝");
        System.out.println( RENDER_BANNER_WELCOME.getDecoration() );
        System.out.println( "Browse and Build a personal PC from an existing inventory of PC Components");
    }
    private String[] generateDefaultGuestCustomerInformation(){
        String[] defaultGuestInfo = {"defFirstName", "defLastName", "defEmail"};
        return defaultGuestInfo;
    }
    public Session generateNewSessionObject(String[] customerBasicInfo ){
        System.out.println( " starting new Session " );
        Session newSession = new Session(customerBasicInfo);
        return newSession;
    }
    public void generateNewMenu( ){
        String[] defaultGuestCustomerInfo = generateDefaultGuestCustomerInformation();
        Session newSession = generateNewSessionObject( defaultGuestCustomerInfo );
        MainMenu mainMenu = new MainMenu(newSession, defaultGuestCustomerInfo);
        mainMenu.renderOwnMenu();
    }


}