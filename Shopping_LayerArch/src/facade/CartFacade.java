package facade;

import dao.*;
import java.util.*;
import model.*;

/*
 * This class directly connect with dow class.
 */
public class CartFacade {

    List<Product> productList = new ArrayList<Product>();
    ShoppingCartDao cart = new ShoppingCartDao();

    public List<Product> ProductListFacade() {
        ProductDao productdao = new ProductDao();
        productList = productdao.ProductList();
        return productList;
    }

    /*
     * This function is used to add the product in cart.
     */
    public void addProductFacade(Product product) {

        cart.addProduct(product);
    }

    /*
     * This function is used to remove the product from cart.
     */
    public void removeProductFacade(Product product) {
        cart.removeProduct(product);
    }

    /*
     * This function is used to show existing product in cart.
     */
    public List<Product> viewCart() {
        List<Product> products = new ArrayList<Product>();
        products = cart.sendCart();
        return products;
    }

    /*
     * This function is used to generate bill.
     */
    public int bill() {
        List<Product> billProducts = new ArrayList<Product>();
        billProducts = viewCart();
        int bill = 0;
        for (int index = 0; index < billProducts.size(); index++) {
            bill += billProducts.get(index).getQuantity()
                    * billProducts.get(index).getPrice();
        }
        return bill;
    }

}
