package view;

import java.util.*;
import model.*;

/*
 * This class directly connect with controller class.
 */
public class Products {

    /*
     * This function is used to display the product.
     */
    public void displayProducts(List<Product> allProductsList) {
        for (int i = 0; i < allProductsList.size(); i++) {
            System.out.println(allProductsList.get(i));
        }
    }
}
