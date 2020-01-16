import java.util.Scanner;

public class Area_calculator {
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
	 * This is a method for taking Double as a input.
	 * 
	 * @return that Double as output.
	 */
	public static double doubleinput() {
		while (true) {
			double inp_dou = 0;
			try {
				inp_dou = Double.parseDouble(input.next());
				return inp_dou;
			} catch (Exception ex) {
				System.out.println("Invalid input." + ex.getMessage());
				System.out.println("Enter the Operation again....");
				return inp_dou;
			}
		}
	}

	/**
	 * This is the method for calculate the area of a triangle. It will take two
	 * input as tringle_width and tringle_height and calculate the area by
	 * applying formula (0.5)*base*height.
	 * 
	 * @return float variable area_tringle which contain the calculated area.
	 */
	public static float area_ofTringle() {
		float area_tringle = 0;
		double for_tri = 0.5;
		try {
			float tringle_width, tringle_height;
			System.out.println("Enter width of tringle");
			tringle_width = (float) Area_calculator.doubleinput();
			System.out.println("Enter height of tringle");
			tringle_height = (float) Area_calculator.doubleinput();
			area_tringle = (float) ((for_tri) * (tringle_width * tringle_height));
			return area_tringle;

		} catch (Exception e) {
			System.out.println("Invalid operation" + e.getMessage());
			return area_tringle;

		}
	}

	/**
	 * This is the method for calculate the area of a rectangle. It will take
	 * two input as rectangle_width and rectangle_height and calculate the area
	 * by applying formula -(length*breadth).
	 * 
	 * @return float variable area_rectangle which contain the calculated area.
	 */
	public static float area_ofRectangle() {
		float area_rectangle = 0;
		try {
			float rectangle_width, rectangle_height;
			System.out.println("Enter width of rectangle");
			rectangle_width = (float) Area_calculator.doubleinput();
			System.out.println("Enter height of rectangle");
			rectangle_height = (float) Area_calculator.doubleinput();
			area_rectangle = (float) (rectangle_width * rectangle_height);
			return area_rectangle;

		} catch (Exception e) {
			System.out.println("Invalid operation" + e.getMessage());
			return area_rectangle;

		}
	}

	/**
	 * This is the method for calculate the area of a square. It will take one
	 * input as side_square and calculate the area by applying formula
	 * -(side*side).
	 * 
	 * @return float variable area_square which contain the calculated area.
	 */
	public static float area_ofSquare() {
		float area_square = 0;
		try {
			float side_square;
			System.out.println("Enter side of square");
			side_square = (float) Area_calculator.doubleinput();

			area_square = (float) (side_square * side_square);
			return area_square;

		} catch (Exception e) {
			System.out.println("Invalid operation" + e.getMessage());
			return area_square;

		}
	}

	/**
	 * This is the method for calculate the area of a circle. It will take one
	 * input as radious_circle and calculate the area by applying formula
	 * -(3.14)*(radius*radius).
	 * 
	 * @return float variable area_circle which contain the calculated area.
	 */
	public static float area_ofCircle() {
		float area_circle = 0;
		try {
			float radious_circle;
			System.out.println("Enter radious of circle");
			radious_circle = (float) Area_calculator.doubleinput();

			area_circle = (float) (Math.PI) * (radious_circle * radious_circle);
			return area_circle;

		} catch (Exception e) {
			System.out.println("Invalid operation" + e.getMessage());
			return area_circle;

		}
	}

	public static void main(String args[]) {
		int select_operation;
		float area_tringle, area_rectangle, area_square, area_circle;

		System.out.println("Choose the Operation");

		System.out
				.println("1 Tringle  2 Rectangle  3 Square  4 Circle  5 Exit ");
		select_operation = Area_calculator.intinput();

		while (true) {
			switch (select_operation) {
			case 1:
				area_tringle = Area_calculator.area_ofTringle();
				System.out.printf("%.2f", area_tringle);
				System.out.printf("\n");
				break;
			case 2:
				area_rectangle = Area_calculator.area_ofRectangle();
				System.out.printf("%.2f", area_rectangle);
				System.out.printf("\n");
				break;
			case 3:
				area_square = Area_calculator.area_ofSquare();
				System.out.printf("%.2f", area_square);
				System.out.printf("\n");
				break;
			case 4:
				area_circle = Area_calculator.area_ofCircle();
				System.out.printf("%.2f", area_circle);
				System.out.printf("\n");
				break;

			case 5:
				System.exit(0);
			}
			System.out
					.println("1 Tringle  2 Rectangle  3 Square  4 Circle  5 Exit ");
			select_operation = Area_calculator.intinput();
		}

	}
}
