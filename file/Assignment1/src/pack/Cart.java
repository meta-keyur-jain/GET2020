package pack;

import pack.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cart {
	private static Scanner input = new Scanner(System.in);
	String item_name[] = { "Orange", "Apple", "Mango", "Banana" };
	double item_price[] = { 30.00, 40.00, 50.00, 10.00 };
	double item_total_price;
	int item_quantity, item_no;

	// map of a shopping item list
	Map<Integer, Item> itemMap = new HashMap<Integer, Item>();

	// display the items
	public void display() {
		for (int i = 0; i <= 3; i++) {
			int t = i;
			System.out.println(++t + " " + item_name[i] + "=" + item_price[i]);
		}

	}

	// add the item
	public void Item_add() {

		display();

		System.out.println("Enter the id of item  you want..... ");
		int item_no = getIntegerOnly();

		System.out.println("Enter the quantity you want..... ");
		int item_quantity = getIntegerOnly();
		if(item_no>=4){
			System.out.println("Please Enter valid id....");

		}
		else{
		item_total_price = item_quantity * item_price[item_no - 1];

		Item item = new Item();
		item.setItem_name(item_name[item_no - 1]);
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
	}
	// To display item list
	void showItems() {
		System.out.println("item id" + " " + "item name" + " "
				+ "item quantity");
		for (Map.Entry<Integer, Item> entry : itemMap.entrySet()) {
			System.out.println("" + entry.getKey() + "       "
					+ entry.getValue().getItem_name() + "           "
					+ entry.getValue().getItem_quantity());
		}
	}

	// update the shopping list
	public void item_update() {
		
		display();
		System.out.println("Enter the id of element you want to update?");
		int update_id = getIntegerOnly();
		
		
		
		System.out.println("Enter the updated quantity of element?");
		int update_quantity = getIntegerOnly();

		if (itemMap.containsKey(update_id)) {
			Item up_item = itemMap.get(update_id);
			up_item.setItem_quantity(update_quantity);
		} else {
			System.out.println("Sorry,This item does not exists in the cart...");
		}
		
		
	}

	// delete the item from the cart
	public void item_remove() {

		showItems();

		System.out.println("Enter the item no you want to remove from your cart?");
		int remove_id = getIntegerOnly();

		if (itemMap.containsKey(remove_id)) {
			itemMap.remove(remove_id);
		} else {
			System.out.println("Sorry,This item does not exists in the cart...");
		}
	}

	// print the bill
	public void get_bill() {
		int cart_quantity, cart_key;
		double cart_bill = 0, cart_price, cart_item_price;
		for (Map.Entry<Integer, Item> entry : itemMap.entrySet()) {
			cart_key = entry.getKey();
			cart_price = item_price[cart_key - 1];
			cart_quantity = entry.getValue().getItem_quantity();
			cart_item_price = cart_quantity * cart_price;
			cart_bill += cart_item_price;
		}
		System.out.println("The final price of cart is" + cart_bill);

	}

	public int getIntegerOnly() {
		while (true) {
			try {
				return Integer.parseInt(input.nextLine());
			} catch (Exception ex) {
				System.out.println("Invalid input.");
				main_func();
			}
		}
	}

	// main function
	public void main_func() {

		System.out.println("Shopping Cart");
		System.out
				.println("What Do you Want? ----------->   1. Add 2. Update 3. Delete 4. Get Bill  5.Show cart  6. Exit ");
		int item_operation = getIntegerOnly();

		// object of class Cart
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
			case 6:
				System.exit(0);

			}
			System.out
					.println("What Do you Want? ----------->   1. Add 2. Update 3. Delete 4. Get Bill  5.Show cart  6. Exit ");
			item_operation = getIntegerOnly();
		}
	}

	public static void main(String args[]) {

		Cart cobj = new Cart();
		cobj.main_func();

	}
}