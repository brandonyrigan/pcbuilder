package com.pcbuilder.menus;

import com.pcbuilder.checkout.ShoppingCart;
import com.pcbuilder.inventory.Component;
import com.pcbuilder.menus.MainMenu;
import com.pcbuilder.session.Session;
import java.util.Collection;
import java.util.Map;

import static com.pcbuilder.menus.DecorateEnum.RENDER_BANNER_SUBMENU_SHOPPINGCART;


public class ShoppingCart_Submenu extends MainMenu {

    public ShoppingCart_Submenu(Session session) { super(session); }

    @Override
    public void renderOwnMenu() {
        System.out.println( RENDER_BANNER_SUBMENU_SHOPPINGCART.getDecoration() );
        renderCurrentSessionBuild();
        renderSubmenuShoppingCartMenu();
    }

    private void renderSubmenuShoppingCartMenu(){
        ShoppingCart cart = session.getShoppingCart();

        System.out.println("   Select an option");
        System.out.println("   [9] Return to Main Menu " );
        System.out.println("   [1] Add Current Build to Cart  [2] Remove A Build From Cart  [3] View All Items in Cart");
        updateUserSelection();
        switch ( getSelection() ) {
            case 1:
                createBuild();
                renderSubmenuShoppingCartMenu();
                break;
            case 2:
                selectBuildToRemoveFromCart(cart);
                renderSubmenuShoppingCartMenu();
                break;
            case 3:
                cart.showItemsInCart();
                if (cart.getCartItems().size() == 0) System.out.println("There are no items in the cart");
                renderSubmenuShoppingCartMenu();
                break;
            case 9:
                System.out.println();
                break;
            default:
                break;
        } while (getSelection() != 9);
    }

    private void selectBuildToRemoveFromCart(ShoppingCart cart) {
        if (cart.getCartItems().size() == 0) {
            System.out.println("There are no items in the cart");
        } else {
            cart.showItemsInCart();
            System.out.println("   Please choose a build to remove.");
            updateUserSelection();
            cart.removeFromCart(getSelection());
        }
    }

}