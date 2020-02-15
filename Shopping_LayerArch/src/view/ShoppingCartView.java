package view;

import model.*;
import java.util.*;

/*
 * This class directly connect with controller class.
 */
public class ShoppingCartView {
    /*
     * This function is used to display the product in cart.
     */
    public void displayShoppingCart(List<Product> cartProducts) {
        for (int i = 0; i < cartProducts.size(); i++) {
            if (cartProducts.get(i).getQuantity() > 0) {
                System.out.println("Item Name: "
                        + cartProducts.get(i).getName() + "   " + "Quantity: "
                        + cartProducts.get(i).getQuantity());
            }

        }
    }

    /*
     * This function is used to display the bill.
     */
    public void displayBill(int bill) {
        System.out.println("Your bill is: Rs." + bill);
    }

    /*
     * This function is used to display error.
     */
    public void displayError() {
        System.out.println("INVALID REMOVAL");
    }

}
