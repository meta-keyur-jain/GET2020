package dao;

import model.Product;
import java.util.*;

/*
 * This class contain all the database.
 */
public class ProductDao {

    List<Product> allproducts = new ArrayList<Product>();

    /*
     * This function contain the data of product.
     */
    public ProductDao() {
        Product product1 = new Product(123, "Furniture", "chair", 200, 10);
        allproducts.add(product1);
        Product product2 = new Product(124, "Furniture", "table", 500, 10);
        allproducts.add(product2);
        Product product3 = new Product(125, "Furniture", "bed", 1000, 10);
        allproducts.add(product3);
    }

    public List<Product> ProductList() {
        return allproducts;
    }

}
