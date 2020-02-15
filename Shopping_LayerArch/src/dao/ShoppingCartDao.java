package dao;

import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ShoppingCartDao {

    private List<Product> products;

    /*
     * This function contain the data of cart.
     */
    public ShoppingCartDao() {
        products = new ArrayList<Product>();
        Product product1 = new Product(123, "Furniture", "chair", 200, 0);
        products.add(product1);
        Product product2 = new Product(124, "Furniture", "table", 500, 0);
        products.add(product2);
        Product product3 = new Product(125, "Furniture", "bed", 1000, 0);
        products.add(product3);
    }

    /*
     * This function take the product object and add the new product in cart.
     */
    public void addProduct(Product product) {
        int flag = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(product.getName())) {
                flag = 1;
                products.get(i).setQuantity(
                        products.get(i).getQuantity() + product.getQuantity());
                break;
            }
        }
        if (flag == 0)
            products.add(product);
    }

    /*
     * This function is used to remove product from cart.
     */
    public void removeProduct(Product product) {
        int flag = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(product.getName())
                    && products.get(i).getQuantity() > 0) {
                flag = 1;
                products.get(i).setQuantity(
                        products.get(i).getQuantity() - product.getQuantity());
                break;
            }
        }
        if (flag == 0)
            products.remove(product);
    }

    /*
     * This function return the product object which send the data to cart.
     */
    public List<Product> sendCart() {
        return products;
    }

}
