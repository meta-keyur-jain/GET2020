import java.util.Scanner;

public class String_compare {
	private static String str_one, str_two;
	private static Scanner input = new Scanner(System.in);

	/**
	 * This is a method for taking string as a input and store it in a string
	 * variable.
	 * 
	 * @return that string variable as output.
	 */

	// string input
	public static String str_input() {
		int enter = 10;
		String str_inp = "";
		try {
			int flag = 1;
			str_inp = "";
			while (flag == 1) {
				str_inp = input.nextLine();
				try {

					if (str_inp.charAt(0) == enter) {
						System.out.println("Enter correct string");
					}
				} catch (Exception e) {
					System.out.println("Invalid Input Enter the string again");
					flag = 0;

				}
				if (flag == 0) {
					flag = 1;
				} else {
					break;
				}
			}
			return str_inp;

		} catch (Exception e) {
			System.out.println("Invalid Input" + e.getMessage());
			return str_inp;

		}

	}

	/**
	 * This is a method for taking integer as a input.
	 * 
	 * @return that Integer as output.
	 */

	public static int intinput() {
		while (true) {
			int inp_no = 0;
			try {
				inp_no = Integer.parseInt(input.next());
				return inp_no;
			} catch (Exception e) {
				System.out.println("Invalid Input" + e.getMessage());
				System.out.println("Enter the Operation again....");
				return inp_no;
			}
		}
	}

	/**
	 * This is method for comparison of two string. String should not be null.
	 * 
	 * @param str_one
	 *            is the first string .
	 * @param str_two
	 *            is the second string.
	 * @return it will return 1 if both string are same and 0 if both are
	 *         different.
	 */
	public static String compare_string(String str_one, String str_two) {
		String compare_output = "";
		try {
			compare_output = "0";
			char[] str_first = str_one.toCharArray();
			char[] str_second = str_two.toCharArray();
			if (str_first != null && str_second != null
					&& str_first.length == str_second.length) {
				for (int i = 0; i < str_first.length; i++) {
					if (str_first[i] != str_second[i]) {
						compare_output = "1";
						break;
					}
				}

			} else {
				compare_output = "1";
			}

			return compare_output;

		} catch (Exception e) {
			System.out.println("Invalid Input" + e.getMessage());
			return compare_output;

		}

	}

	/**
	 * This is the method to reverse the string.
	 * 
	 * @param str_one
	 *            is the string input to be reversed.
	 * @return it will return reversed string.
	 */

	// reverse
	public static String reverse_string(String str_one) {
		String rev_str = "";
		try {
			char[] str_first = str_one.toCharArray();

			int str_len = str_first.length;
			for (int i = str_len - 1; i >= 0; i--) {

				rev_str += str_first[i];

			}
			return rev_str;
		} catch (Exception e) {
			System.out.println("Invalid operation : " + e.getMessage());
			return rev_str;

		}

	}

	/**
	 * This method is used to change the case of string i.e. change the lower
	 * case to upper case and vice versa.
	 * 
	 * @param str_one
	 *            is the string to change case.
	 * @return the string whose case is change,all lower case string change to
	 *         upper case and vice versa
	 */
	public static String change_case(String str_one) {
		String case_str = "";
		int ascii_value=32;
		try {
			char[] str_first = str_one.toCharArray();
			int str_len = str_first.length;

			for (int i = 0; i < str_len; i++) {

				if (str_first[i] >= 'a' && str_first[i] <= 'z') {
					str_first[i] = (char) (str_first[i] - ascii_value);
				} else if (str_first[i] >= 'A' && str_first[i] <= 'Z') {
					str_first[i] = (char) (str_first[i] + ascii_value);
				} else {
					str_first[i] = str_first[i];
				}
			}
			case_str = String.copyValueOf(str_first);
			return case_str;
		} catch (Exception e) {
			System.out.println("Invalid operation : " + e.getMessage());
			return case_str;

		}

	}

	/**
	 * This is the method to find the largest word among the string given.
	 * 
	 * @param str_sentence
	 *            is the string input from which we have to find the largest
	 *            word.
	 * @return the string whose length is greater in whole string and if two
	 *         word of same string then it will return last word.
	 */
	public static String largest_string(String str_sentence) {
		String max_str = "";
		try {
			int max_len = 0;
			String[] words = str_sentence.split("\\s+");

			for (int i = 0; i < words.length; i++) {
				if (max_len <= words[i].length()) {
					max_len = words[i].length();
					max_str = words[i];
				}

			}
			return max_str;
		} catch (Exception e) {
			System.out.println("Invalid operation : " + e.getMessage());
			return max_str;

		}
	}

	public static void main(String args[]) {
		int operation;
		System.out.println("Enter the string");
		System.out.println("Enter First  string");
		str_one = String_compare.str_input();
		System.out.println("Enter second  string");
		str_two = String_compare.str_input();

		System.out.println("Enter the Operation to perform" + '\n'
				+ "1 Compare  2 Reverse  3 Case Change 4 Largest Word  5 Exit");
		operation = String_compare.intinput();
		while (true) {

			switch (operation) {
			case 1:
				String compare_output = String_compare.compare_string(str_one,
						str_two);
				System.out.println(compare_output);
				break;
			case 2:
				String compare_one = String_compare.reverse_string(str_one);
				System.out.println(compare_one);
				String compare_two = String_compare.reverse_string(str_two);
				System.out.println(compare_two);
				break;
			case 3:
				String rev_strone = String_compare.change_case(str_one);
				System.out.println(rev_strone);
				String rev_strtwo = String_compare.change_case(str_two);
				System.out.println(rev_strtwo);

				break;
			case 4:
				String largest_strone = String_compare.largest_string(str_one);
				System.out.println("First string");
				System.out.println("String---->" + largest_strone);
				System.out.println("Length--->" + largest_strone.length());
				String largest_strtwo = String_compare.largest_string(str_two);
				System.out.println("Second string");
				System.out.println("String---->" + largest_strtwo);
				System.out.println("Length--->" + largest_strtwo.length());
				break;
			case 5:
				System.exit(0);
			}
			System.out
			.println("Enter the Operation to perform"
					+ '\n'
					+ "1 Compare  2 Reverse  3 Case Change 4 Largest Word 5 Exit");
			operation = String_compare.intinput();

		}

	}

}
