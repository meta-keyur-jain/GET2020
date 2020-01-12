package pack;
import pack.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Cart {
 String Item_name[] = {
  "Orange",
  "Apple",
  "Mango",
  "Banana"
 };
 double Item_price[] = {
  30.00,
  40.00,
  50.00,
  10.00
 };
 double item_total_price;
 int item_quantity, item_no;

 //map of a shopping item list
 Map < Integer, Item > itemMap = new HashMap < Integer, Item > ();


 //display the items
 public void display() {
  for (int i = 0; i <= 3; i++) {
   int t = i;
   System.out.println(++t + " " + Item_name[i] + "=" + Item_price[i]);
  }

 }



 //add the item
 public void Item_add() {

  display();

  System.out.println("Enter the id of item  you want..... ");
  Scanner value = new Scanner(System.in);
  int item_no = value.nextInt();
  //System.out.println(Item_price[item_no-1]);

  System.out.println("Enter the quantity you want..... ");
  int item_quantity = value.nextInt();
  item_total_price = item_quantity * Item_price[item_no - 1];
  //System.out.println(item_total_price);

  Item item = new Item();
  item.setItem_name(Item_name[item_no - 1]);
  item.setItem_no(item_no - 1);
  item.setItem_quantity(item_quantity);


  if (itemMap.containsKey(item_no)) {
   int old_quantity_value = itemMap.get(item_no).getItem_quantity();
   int new_quantity_value = item_quantity + old_quantity_value;
   itemMap.get(item_no).setItem_quantity(new_quantity_value);
  } else {
   itemMap.put(item_no, item);

  }

 }

 void showItems() {
  System.out.println("item no" + " " + "Item name" + " " + "item quantity");
  for (Map.Entry < Integer, Item > entry: itemMap.entrySet())

   System.out.println("" + entry.getKey() +
    "       " + entry.getValue().getItem_name() + "           " + entry.getValue().getItem_quantity());
 }


 //update the shopping list
 public void item_update() {
  //take the item id 
  display();
  System.out.println("Enter the id of element you want to update?");
  Scanner input = new Scanner(System.in);
  int update_id = input.nextInt();

  //take the quantity of item
  System.out.println("Enter the updated quantity of element?");
  int update_quantity = input.nextInt();

  //update the hashmap

  Item up_item = itemMap.get(update_id);
  up_item.setItem_quantity(update_quantity);
 }


 //delete the item from the cart
 public void item_remove() {

  showItems();

  System.out.println("Enter the item no you want to remove from your cart?");
  Scanner input = new Scanner(System.in);
  int remove_id = input.nextInt();

  if (itemMap.containsKey(remove_id)) {
   itemMap.remove(remove_id);
  } else {
   System.out.println("Sorry,This item does not exists in the cart...");
  }
 }

 //print the bill
 public void get_bill() {
  int cart_quantity, cart_key;
  double cart_bill = 0, cart_price, cart_item_price;
  for (Map.Entry < Integer, Item > entry: itemMap.entrySet()) {
   cart_key = entry.getKey();
   cart_price = Item_price[cart_key - 1];
   cart_quantity = entry.getValue().getItem_quantity();
   cart_item_price = cart_quantity * cart_price;
   cart_bill += cart_item_price;
  }
  System.out.println("The final price of cart is" + cart_bill);

 }






 public static void main(String args[]) {

  Scanner input = new Scanner(System.in);

  System.out.println("Shopping Cart");
  System.out.println("What Do you Want? ----------->   1. Add 2. Update 3. Delete 4. Get Bill  5.Show cart");
  int item_operation = input.nextInt();


  //object of class Cart
  Cart cartobj = new Cart();

  while (true) {

   switch (item_operation) {

    case 1:
     cartobj.Item_add();
     break;
    case 2:
     cartobj.item_update();
     break;
    case 3:
     cartobj.item_remove();
     break;
    case 4:
     cartobj.get_bill();
     break;
    case 5:
     cartobj.showItems();
     break;

   }
   System.out.println("What Do you Want? ----------->   1. Add 2. Update 3. Delete 4. Get Bill  5.Show cart");
   item_operation = input.nextInt();
  }
 }
}