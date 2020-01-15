import java.util.Arrays;
import java.util.Scanner;

public class HexCalc {
	private static Scanner input = new Scanner(System.in);
	static String[] hex_arr = { "0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "a", "b", "c", "d", "e", "f", "A", "B", "C", "D", "E", "F", };
	
	//for taking input of hexadecimal number
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
   //for taking input of integer number
	public static int intinput() {
		while (true) {
			try {
				return Integer.parseInt(input.next());
			} catch (Exception ex) {
				System.out.println("Invalid input.");
				System.out.println("Enter the Operation again....");
			}
		}
	}
 //convert hexadecimal to decimal 
	public static int hextodeci(String first_no) {
		int decimal = 0;
		try {
			decimal = 0;
			String hex_no;
			String digits = "0123456789ABCDEF";
			hex_no = first_no.toUpperCase();
			for (int i = 0; i < hex_no.length(); i++) {
				char hex_char_at = hex_no.charAt(i);
				int hex_index = digits.indexOf(hex_char_at);
				decimal = decimal * 16 + hex_index;
			}
		} catch (Exception e) {
			System.out.println("Invalid operation please check input");
		}

		return decimal;
	}
//convert decimal to hexadecimal
	public static String decitohex(int deci_no) {
		String hex_no = null;
		try {
			int rem;
			hex_no = "";

			while (deci_no > 0) {
				rem = deci_no % 16;
				hex_no = hex_arr[rem] + hex_no;
				deci_no = deci_no / 16;
			}
		} catch (Exception e) {
			System.out.println("Invalid operation please check input");

		}
		return hex_no;

	}

	// implement  convert to decimal operation
	public static void hex_deci(String first_no, String second_no) {
		try {
			int deci_firstno = hextodeci(first_no);
			int deci_secondno = hextodeci(second_no);
			System.out.println("converted number are" + "\n" + first_no + "---->"
					+ deci_firstno + "\n" + second_no + "---->" + deci_secondno);
		} catch (Exception e) {
			System.out.println("Invalid operation please check input");

		}

	}

	// implement of hexadecimal number addition 
	public static void hex_addition(String first_no, String second_no) {

		try {
			int convert_deci_firstno = hextodeci(first_no);
			int convert_deci_secondno = hextodeci(second_no);
			int result = convert_deci_firstno + convert_deci_secondno;
			String hex_result = decitohex(result);
			System.out.println("addition of  number are ---->" + hex_result);
		} catch (Exception e) {
			System.out.println("Invalid operation please check input");

		}

	}

	//implement of hexadecimal number subtraction
	public static void hex_subtraction(String first_no, String second_no) {

		try {
			int convert_deci_firstno = hextodeci(first_no);
			int convert_deci_secondno = hextodeci(second_no);
			int result = convert_deci_firstno - convert_deci_secondno;
			if (result < 0) {
				result = result * (-1);
				String hex_result = decitohex(result);
				System.out.println("subtraction of  number are ---->" + "-"
						+ hex_result);

			} else {
				String hex_result = decitohex(result);
				System.out.println("subtraction of  number are ---->" + hex_result);
			}
		} catch (Exception e) {
			System.out.println("Invalid operation please check input");

		}
	}

	// implement of hexadecimal number Multiplication
	public static void hex_multiply(String first_no, String second_no) {

		try {
			int convert_deci_firstno = hextodeci(first_no);
			int convert_deci_secondno = hextodeci(second_no);
			int result = convert_deci_firstno * convert_deci_secondno;
			String hex_result = decitohex(result);
			System.out.println("multiplication of  number are ---->" + hex_result);
		} catch (Exception e) {
			System.out.println("Invalid operation please check input");

		}

	}

	// implement of hexadecimal number division
	public static void hex_divide(String first_no, String second_no) {

		try {
			int convert_deci_firstno = hextodeci(first_no);
			int convert_deci_secondno = hextodeci(second_no);
			int result = convert_deci_firstno / convert_deci_secondno;
			int reminder = convert_deci_firstno - result * convert_deci_secondno;
			String hex_quotient = decitohex(result);
			String hex_reminder = decitohex(reminder);
			if(hex_quotient=="" || hex_quotient == null){
				hex_quotient="0";
			}
			System.out.println("division of  number are ---->" + "\n"
					+ "Quotient---->" + hex_quotient + "\n" + "Reminder---->"
					+ hex_reminder);
		} catch (Exception e) {
			System.out.println("Invalid operation please check input");

		}

	}

	// implement deci to hex operation
	public static void deci_hex() {
		try {
			System.out.println("Enter the decimal no.");
			int deci_no = intinput();
			String hex_no = decitohex(deci_no);
			System.out.println("Hexadecimal no is----->" + hex_no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid operation please check input");
		}
	}

	// implement of hexadecimal comparision  no
	public static void hex_compare(String first_no, String second_no) {

		try {
			if (first_no.length() == second_no.length()) {

				int result = first_no.compareTo(second_no);

				if (result > 0) {
					System.out
							.println(first_no + "  is greater than  " + second_no);
				} else if (result < 0) {
					System.out.println(first_no + "  is lesser than  " + second_no);

				} else {
					System.out.println(first_no + "  is equl to   " + second_no);

				}
			} else if (first_no.length() > second_no.length()) {
				System.out.println(first_no + "  is greater than  " + second_no);
			} else {
				System.out.println(second_no + "  is greater than  " + first_no);

			}
		} catch (Exception e) {
			System.out.println("Invalid operation please check input");

		}
	}

	public static void main(String args[]) {
		System.out.println("Hexadecimal Calculator");
		System.out.println("Enter two number");
		System.out.println("Enter First number");
		String first_no = HexCalc.strinput();
		System.out.println("Enter Second number");
		String second_no = HexCalc.strinput();
		System.out.println("Enter the choice");
		System.out
				.println("1 Add  2 Subtract  3 Multiply  4 Divide  5 Convert to Decimal  6 Compare  7 Deci to hexadecimal  8 Exit ");
		int select_operation = HexCalc.intinput();

		while (true) {
			switch (select_operation) {
			case 1:
				HexCalc.hex_addition(first_no, second_no);
				break;
			case 2:
				HexCalc.hex_subtraction(first_no, second_no);
				break;
			case 3:
				HexCalc.hex_multiply(first_no, second_no);
				break;
			case 4:
				HexCalc.hex_divide(first_no, second_no);
				break;
			case 5:
				HexCalc.hex_deci(first_no, second_no);
				break;
			case 6:
				HexCalc.hex_compare(first_no, second_no);
				break;
			case 7:
				HexCalc.deci_hex();
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