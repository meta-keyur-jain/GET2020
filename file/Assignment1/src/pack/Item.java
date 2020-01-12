package pack;

import java.util.Scanner;

public class Item {
 private String item_name;
 private int item_quantity;
 private int item_no;
 
 public String getItem_name() {
	return item_name;
}

public void setItem_name(String item_name) {
	this.item_name = item_name;
}


public int getItem_quantity() {
	return item_quantity;
}



public void setItem_quantity(int item_quantity) {
	this.item_quantity = item_quantity;
}


public int getItem_no() {
	return item_no;
}



public void setItem_no(int item_no) {
	this.item_no = item_no;
}



/*double item_total_price;
 
 String Item_name[] =  {"Orange","Apple","Mango","Banana"};
 double Item_price[] = {30.00,40.00,50.00,10.00};
 int Item_total[] = new int[4];
 
 
 
 //display the items
 public void display(){
	 for(int i=0;i<=3;i++){
		 int t=i;
		 System.out.println(++t +" "+Item_name[i] + "="+Item_price[i]);
	 }

 }
 
 
 
//add the item
public void Item_add() {

	display();
	Scanner value = new Scanner(System.in);
	int item_no = value.nextInt();
	//System.out.println(Item_price[item_no-1]);
	System.out.println("Enter the quantity you want..... ");
	int item_quantity = value.nextInt();
	item_total_price = item_quantity*Item_price[item_no-1];
	System.out.println(item_total_price);
*/
	
}

