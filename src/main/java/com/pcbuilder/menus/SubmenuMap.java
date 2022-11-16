package com.pcbuilder.menus;
import com.pcbuilder.session.Session;

import java.util.HashMap;
import java.util.Map;

// TODO[ ] - should this be an interface implementation instead? only used to create NEW submenus
public class SubmenuMap {

    private Session session;
    private Map<Integer, Menu> mapSubmenus;


    SubmenuMap(Session session ){ this.session = session;}


//  Helper Methods
    public void createSubmenus(){
        Map<Integer, Menu> mapSubmenus = new HashMap<>();

        mapSubmenus.put( 1, new PCComponents_SubMenu( session ) );
        mapSubmenus.put( 2, new ShoppingCart_Submenu( session ) );
        mapSubmenus.put( 3, new Order_Submenu( session ) );
        mapSubmenus.put( 4, new Purchase_Submenu( session ) );
        mapSubmenus.put( 5, new UpdateCustomerInfo_Submenu( session ) );

        setSubmenuMap( mapSubmenus );
    }
    public Menu runSubmenu( Integer selection ){
        Map<Integer, Menu> mapSubmenus = getMapSubmenus();
        Menu submenu = mapSubmenus.get( selection );
        return submenu;
    }


//  Accessor Methods
    private void setSubmenuMap(Map<Integer, Menu> mapSubmenus) {
        this.mapSubmenus = mapSubmenus;
    }
    public Map<Integer, Menu> getMapSubmenus() { return this.mapSubmenus; }


}