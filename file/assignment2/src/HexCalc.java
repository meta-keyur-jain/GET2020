import java.util.Arrays;
import java.util.Scanner;

public class HexCalc {
	private static Scanner input = new Scanner(System.in);
	static String[] hex_arr = { "0", "1", "2", "3", "4", "5", "6", "7", "8",
		"9", "a", "b", "c", "d", "e", "f", "A", "B", "C", "D", "E", "F", };

	// for taking input of hexadecimal number
	public static String strinput() {

		String sc = "";
		String[] arrsplit;
		int flag = 1;
		while (flag == 1) {
			sc = input.next();
			arrsplit = sc.split("");
			for (int i = 0; i < arrsplit.length; i++) {
				boolean srt_present = Arrays.asList(hex_arr).contains(
						arrsplit[i]);

				if (!srt_present) {
					System.out.println("Invalid input.");
					System.out.println("Enter the no again");
					flag = 0;
					break;
				}
			}

			if (flag == 0)
				flag = 1;
			else
				break;
		}

		return sc;

	}

	// for taking input of integer number
	public static int intinput() {
		int inp_no=0;
		while (true) {
			try {
				inp_no = Integer.parseInt(input.next());
				return inp_no;
			} catch (Exception ex) {
				System.out.println("Invalid input." + ex.getMessage());
				System.out.println("Enter again....");
				return inp_no;
			}
		}
	}

	// convert hexadecimal to decimal
	public static int hextodeci(String first_no,int base) {
		int decimal = 0;
		try {
			decimal = 0;
			String hex_no;
			String digits = "0123456789ABCDEF";
			hex_no = first_no.toUpperCase();
			for (int i = 0; i < hex_no.length(); i++) {
				char hex_char_at = hex_no.charAt(i);
				int hex_index = digits.indexOf(hex_char_at);
				decimal = decimal * base + hex_index;
			}
			return decimal;
		} catch (Exception e) {
			System.out.println("Invalid operation please check input" + e.getMessage());
			return decimal;
		}


	}

	// convert decimal to hexadecimal
	public static String decitohex(int deci_no,int base) {
		String hex_no = null;
		try {
			int rem;
			hex_no = "";

			while (deci_no > 0) {
				rem = deci_no % base;
				hex_no = hex_arr[rem] + hex_no;
				deci_no = deci_no / base;
			}
			return hex_no;

		} catch (Exception e) {
			System.out.println("Invalid operation please check input" + e.getMessage());
			return hex_no;

		}

	}

	// implement convert to decimal operation
	public static int hex_deci(int base) {
		int deci_firstno=0;
		try {
			System.out.println("Enter number to convert");
			String first_no = HexCalc.strinput();
			 deci_firstno = hextodeci(first_no,base);

			return deci_firstno;
		} catch (Exception e) {
			System.out.println("Invalid operation please check input" + e.getMessage());
			return deci_firstno;
		}

	}

	// implement of hexadecimal number addition
	public static String hex_addition(String first_no, String second_no,int base) {
		String hex_result="";
		try {
			int convert_deci_firstno = hextodeci(first_no,base);
			int convert_deci_secondno = hextodeci(second_no,base);
			int result = convert_deci_firstno + convert_deci_secondno;
			 hex_result = decitohex(result,base);
			 return hex_result;
		} catch (Exception e) {
			System.out.println("Invalid operation please check " + e.getMessage());
			 return hex_result;


		}

	}

	// implement of hexadecimal number subtraction
	public static String  hex_subtraction(String first_no, String second_no,int base) {
		String hex_result = "";

		try {
			int convert_deci_firstno = hextodeci(first_no,base);
			int convert_deci_secondno = hextodeci(second_no,base);
			int result = convert_deci_firstno - convert_deci_secondno;
			if (result < 0) {
				result = result * (-1);
				 hex_result = decitohex(result,base);
				

			} else {
				 hex_result = decitohex(result,base);
				
			}
			 return hex_result;

		} catch (Exception e) {
			System.out.println("Invalid operation please check" + e.getMessage());
			 return hex_result;

		}
	}

	// implement of hexadecimal number Multiplication
	public static String hex_multiply(String first_no, String second_no,int base) {
		 String hex_result="";

		try {
			int convert_deci_firstno = hextodeci(first_no,base);
			int convert_deci_secondno = hextodeci(second_no,base);
			int result = convert_deci_firstno * convert_deci_secondno;
			 hex_result = decitohex(result,base);
			System.out.println("multiplication of  number are ---->"
					+ hex_result);
			 return hex_result;

		} catch (Exception e) {
			System.out.println("Invalid operation please check" + e.getMessage());
			 return hex_result;

		}

	}

	// implement of hexadecimal number division
	public static String hex_divide(String first_no, String second_no,int base) {
		String hex_quotient="",hex_reminder="";

		try {
			int convert_deci_firstno = hextodeci(first_no,base);
			int convert_deci_secondno = hextodeci(second_no,base);

			int result = convert_deci_firstno / convert_deci_secondno;
			int reminder = convert_deci_firstno - result
					* convert_deci_secondno;
			 hex_quotient = decitohex(result,base);
			 hex_reminder = decitohex(reminder,base);
			if (hex_quotient == "" || hex_quotient == null) {
				hex_quotient = "0";
			}
			System.out.println("division of  number are ---->" + "\n"
					+ "Quotient---->" + hex_quotient + "\n" + "Reminder---->"
					+ hex_reminder);
			return ("Quotient"+hex_quotient+"Reminder"+  hex_reminder);
		} catch (Exception e) {
			System.out.println("Invalid operation please check" + e.getMessage());
			return ("Quotient"+hex_quotient+"Reminder"+  hex_reminder);

		}

	}

	// implement deci to hex operation
	public static String deci_hex(int base) {
		String hex_no="";
		try {
			System.out.println("Enter the decimal no.");
			int deci_no = intinput();
			hex_no = decitohex(deci_no,base);
			return hex_no;
		} catch (Exception e) {
			System.out.println("Invalid operation please check" + e.getMessage());
			return hex_no;
		}
	}

	// implement of hexadecimal comparision no
	public static int hex_compare(String first_no, String second_no) {
		int output =2; 
		try {
			if (first_no != null && second_no != null && first_no.length() == second_no.length()) {

				int result = first_no.compareToIgnoreCase(second_no);

				if (result > 0) {
					output =  1;
			} else if (result < 0) {
					output =  -1;

				} else {
					output =  0;

				}
			} else if (first_no.length() > second_no.length()) {
				output =  1;
			} else {
				output =  -1;
				 
			}
			return output;
		} catch (Exception e) {
			System.out.println("Invalid operation please check" + e.getMessage());
			return output;

		}
	}
	
	public static void main(String args[]) {
		String first_no,second_no;
		System.out.println("Hexadecimal Calculator");
		System.out.println("Enter base in which you have to perform operation");
		int base = HexCalc.intinput();
		System.out
		.println("1 Add  2 Subtract  3 Multiply  4 Divide  5 Convert to Decimal  6 Compare  7 Deci to hexadecimal  8 Exit ");
		System.out.println("Enter the choice");
		int select_operation = HexCalc.intinput();
		
		


		while (true) {
			switch (select_operation) {
			case 1:
				System.out.println("Enter First number");
				 first_no = HexCalc.strinput();
				System.out.println("Enter Second number");
				 second_no = HexCalc.strinput();
				String add_result  = HexCalc.hex_addition(first_no, second_no,base);
				System.out.println(add_result);

				break;
			case 2:
				System.out.println("Enter First number");
				 first_no = HexCalc.strinput();
				System.out.println("Enter Second number");
				 second_no = HexCalc.strinput();
				String sub_result = HexCalc.hex_subtraction(first_no, second_no,base);
				System.out.println(sub_result);
				break;
			case 3:
				System.out.println("Enter First number");
				 first_no = HexCalc.strinput();
				System.out.println("Enter Second number");
				 second_no = HexCalc.strinput();
				String mul_result = HexCalc.hex_multiply(first_no, second_no,base);
				System.out.println(mul_result);
				break;
			case 4:
				System.out.println("Enter First number");
				 first_no = HexCalc.strinput();
				System.out.println("Enter Second number");
				 second_no = HexCalc.strinput();
				String div_result = HexCalc.hex_divide(first_no, second_no,base);
				System.out.println(div_result);

				break;
			case 5:
				int deci_firstno = HexCalc.hex_deci(base);
				System.out.println("converted number are" +
						 "---->" + deci_firstno + "\n");
				break;
			case 6:
				System.out.println("Enter First number");
				 first_no = HexCalc.strinput();
				System.out.println("Enter Second number");
				 second_no = HexCalc.strinput();
				int output = HexCalc.hex_compare(first_no, second_no);
				System.out.println("output 1 ----> first is greater  -1---->second is greater   0---->both equl \n"+output);

				break;
			case 7:
				String converted_str = HexCalc.deci_hex(base);
				System.out.println(converted_str);
				break;
			case 8:
				System.exit(0);
			}
			System.out
			.println("1 Add  2 Subtract  3 Multiply  4 Divide  5 Convert to Decimal  6 Compare  7 Deci to hexadecimal  8 Exit ");
			select_operation = HexCalc.intinput();
		}

	}
}