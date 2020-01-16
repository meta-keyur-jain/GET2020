import java.util.Scanner;

public class Marksheet {

	private static Scanner input = new Scanner(System.in);

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
	 * This is the method to calculate the average of marks of all the students.
	 * 
	 * @param stu_arr
	 *            is the integer array which contain marks or grades of all
	 *            student.
	 * @return avg_stu the float variable which contain the average grades.
	 */
	public static float marks_average(int[] stu_arr) {
		int temp_stuavg = 0;
		float avg_stu = 0;
		try {
			float stu_len = stu_arr.length;
			for (int stu_no = 0; stu_no < stu_arr.length; stu_no++) {
				temp_stuavg = temp_stuavg + stu_arr[stu_no];
			}
			avg_stu = temp_stuavg / stu_len;
			return avg_stu;

		} catch (Exception e) {
			System.out.println("Invalid operation" + e.getMessage());
			return avg_stu;

		}

	}

	/**
	 * This is the method to find the maximum grades among all the students.
	 * 
	 * @param stu_arr
	 *            is the integer array which contain marks or grades of all
	 *            student.
	 * @return max_marks the integer variable contain the maximum grade among
	 *         all the student.
	 */
	public static int marks_maximum(int[] stu_arr) {
		int max_marks = stu_arr[0];
		try {
			for (int stu_no = 1; stu_no < stu_arr.length; stu_no++) {
				if (stu_arr[stu_no] > max_marks) {
					max_marks = stu_arr[stu_no];
				}

			}
			return max_marks;

		} catch (Exception e) {
			System.out.println("Invalid operation" + e.getMessage());
			return max_marks;

		}
	}

	/**
	 * This is the method to find the minimum grades among all the students.
	 * 
	 * @param stu_arr
	 *            is the integer array which contain marks or grades of all
	 *            student.
	 * @return min_marks the integer variable contain the minimum grade among
	 *         all the student.
	 */

	public static int marks_minimum(int[] stu_arr) {
		int min_marks = stu_arr[0];
		try {
			for (int stu_no = 1; stu_no < stu_arr.length; stu_no++) {
				if (stu_arr[stu_no] < min_marks) {
					min_marks = stu_arr[stu_no];
				}

			}
			return min_marks;

		} catch (Exception e) {
			System.out.println("Invalid operation" + e.getMessage());
			return min_marks;

		}
	}

	/**
	 * This method will calculate the percentage of passed student. if grade of
	 * student is greater than or equal to 40 then pass otherwise fail.
	 * 
	 * @param stu_arr
	 *            is the integer array which contain marks or grades of all
	 *            student.
	 * @return presant_studentpass is a integer variable contain the percentage
	 *         of passed student.
	 */
	public static float student_pass(int[] stu_arr) {
		int pass_mark=40,presant_no = 100;
		float presant_studentpass = 0;
		try {
			float stu_len = stu_arr.length;
			int total_studentpass = 0;
			for (int stu_no = 0; stu_no < stu_arr.length; stu_no++) {
				if (stu_arr[stu_no] >= pass_mark) {
					total_studentpass = total_studentpass + 1;
				}
			}

			presant_studentpass = (total_studentpass / stu_len) * presant_no;
			return presant_studentpass;
		} catch (Exception e) {
			System.out.println("Invalid operation" + e.getMessage());
			return presant_studentpass;

		}

	}

	public static void main(String args[]) {
		int total_student;
		int max_marks, min_marks;
		float avg_marks_student, stu_pass;
		System.out.println("Student Marksheet");
		System.out.println("Enter total no of students");
		total_student = Marksheet.intinput();
		int[] stu_arr = new int[total_student];
		System.out.println("Enter grades of students between 1 to 100");
		for (int stu_no = 0; stu_no < total_student; stu_no++) {
			System.out.println("Enter grades of student" + (stu_no + 1));
			stu_arr[stu_no] = Marksheet.intinput();
		}

		System.out
		.println("1 Average  2 Maximum  3 Minimum  4 Result  5 Exit ");
		int select_operation = Marksheet.intinput();

		while (true) {
			switch (select_operation) {
			case 1:
				avg_marks_student = Marksheet.marks_average(stu_arr);
				System.out.printf("%.2f", avg_marks_student);
				System.out.printf("\n");
				break;
			case 2:
				max_marks = Marksheet.marks_maximum(stu_arr);
				System.out.println(max_marks);
				break;
			case 3:
				min_marks = Marksheet.marks_minimum(stu_arr);
				System.out.println(min_marks);
				break;
			case 4:
				stu_pass = Marksheet.student_pass(stu_arr);
				System.out.printf("%.2f of students are pass", stu_pass);
				System.out.printf("\n");

				break;
			case 5:
				System.exit(0);
			}
			System.out
			.println("1 Average  2 Maximum  3 Minimum  4 Result  5 Exit ");
			select_operation = Marksheet.intinput();
		}

	}

}
