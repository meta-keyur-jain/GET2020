package client;

import java.io.*;
import controller.ShoppingCartController;

/*
 * This is client class which directly intrect with client.
 */
public class Client {

    public static void main(String[] args) throws IOException {
        ShoppingCartController control = new ShoppingCartController();
        control.inputChoice();
    }
}
