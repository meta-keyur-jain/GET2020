package view;

/*
 * This class directly intrect with controller class.
 */
public class MenuView {
    /*
     * This function is used to display menu message.
     */
    public void displayMenu() {
        System.out.println();
        System.out
                .println("Enter 1 if you want to see the items present which are present in the store");
        System.out.println("Enter 2 if you want to add a product in the cart");
        System.out
                .println("Enter 3 if you want to remove a product from the cart");
        System.out.println("Enter 4 if you want to see your shopping cart");
        System.out.println("Enter 5 if you want to see the bill");
        System.out.println("Enter 6 if you want to exit from the store");
    }

    /*
     * This function is used to print message to add the item to add in cart.
     */
    public void itemMenu() {
        System.out.println("Enter 0 if you want to select chair");
        System.out.println("Enter 1 if you want to select table");
        System.out.println("Enter 2 if you want to select bed");
    }

    /*
     * This function is used to print the enter quantity message.
     */
    public void askQuantity() {
        System.out.println("Enter the quantity");
    }

}
