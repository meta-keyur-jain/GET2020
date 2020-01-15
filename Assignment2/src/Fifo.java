import java.util.Scanner;

public class Fifo {
	private static int[][] input_arr;
	private static Scanner input = new Scanner(System.in);

	public int intinput() {
		while (true) {
			try {
				return Integer.parseInt(input.next());
			} catch (Exception ex) {
				System.out.println("Invalid input.");
				System.out.println("Enter again....");
			}
		}
	}

	// sorting of array
	public int[][] arrival_sort(int[][] input_arr, int no_of_process) {
		try {
			int id_arrtime = 0, id_brusttime = 1;

			for (int j = 0; j <= no_of_process; j++) {
				for (int i = 0; i < (no_of_process - 1); i++) {
					if (input_arr[i][id_arrtime] > input_arr[i + 1][id_arrtime]) {
						int temp1, temp2;
						temp1 = input_arr[i + 1][id_arrtime];
						temp2 = input_arr[i + 1][id_brusttime];

						input_arr[i + 1][id_arrtime] = input_arr[i][id_arrtime];
						input_arr[i + 1][id_brusttime] = input_arr[i][id_brusttime];

						input_arr[i][id_arrtime] = temp1;
						input_arr[i][id_brusttime] = temp2;

					}
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid");
		}
		return input_arr;

	}

	// completion time
	public int[] completion_time(int[][] sort_arr, int no_of_process) {

		int[] completion_timearr = new int[0];
		try {
			completion_timearr = new int[no_of_process];
			for (int i = 0; i < no_of_process; i++) {
				if (i == 0) {
					completion_timearr[i] = sort_arr[i][0] + sort_arr[i][1];
				} else {
					if (sort_arr[i][0] > completion_timearr[i - 1]) {
						completion_timearr[i] = sort_arr[i][0] + sort_arr[i][1];
					} else {
						completion_timearr[i] = completion_timearr[i - 1]
								+ sort_arr[i][1];

					}
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid");

		}
		return completion_timearr;
	}

	// turnaround_time
	public int[] turnaround_time(int[][] sort_arr, int[] completion_timearr,
			int no_of_process) {
		int[] turnaround_timearr = new int[0];
		try {
			turnaround_timearr = new int[no_of_process];
			for (int i = 0; i < no_of_process; i++) {
				turnaround_timearr[i] = completion_timearr[i] - sort_arr[i][0];
			}
		} catch (Exception e) {
			System.out.println("Invalid");

		}
		return turnaround_timearr;
	}

	// waiting time
	public int[] waiting_time(int[][] sort_arr, int[] turnaround_timearr,
			int no_of_process) {
		int[] waiting_timearr = new int[0];
		try {
			waiting_timearr = new int[no_of_process];

			for (int i = 0; i < no_of_process; i++) {
				waiting_timearr[i] = turnaround_timearr[i] - sort_arr[i][1];

			}
		} catch (Exception e) {
			System.out.println("Invalid");

		}
		return waiting_timearr;
	}

	// display
	public void display(int[][] sort_arr, int[] completion_timearr,
			int[] turnaround_timearr, int[] waiting_timearr, int no_of_process) {
		try {
			System.out.println("Arrival Time" + "\t" + "Brust time "
					+ " \t Completion Time" + "\t Turn around time"
					+ "\tWaiting Time");
			for (int i = 0; i < no_of_process; i++) {

				for (int j = 0; j < 2; j++) {

					System.out.print(sort_arr[i][j] + "\t");
					System.out.print("\t");
				}
				System.out.print("\t" + completion_timearr[i] + "\t\t\t");
				System.out.print(turnaround_timearr[i] + "\t\t\t");
				System.out.print(waiting_timearr[i] + "\t\t\t");
				System.out.println("\n");
			}
		} catch (Exception e) {
			System.out.println("Invalid");

		}

	}

	public static void main(String args[]) {
		int no_of_process;
		int[][] sort_arr;
		int[] completion_timearr;
		int[] turnaround_timearr;
		int[] waiting_timearr;

		Fifo fifo_obj = new Fifo();

		System.out.println("Enter the total no of process");
		no_of_process = fifo_obj.intinput();

		input_arr = new int[no_of_process][2];
		sort_arr = new int[no_of_process][2];
		System.out.println("Enter the arrival and brust time in seconds....");
		for (int i = 0; i < no_of_process; i++) {
			System.out.println("Enter the arrival time of process P" + i);
			input_arr[i][0] = fifo_obj.intinput();
			System.out.println("Enter the burst time of process P" + i);
			input_arr[i][1] = fifo_obj.intinput();

		}

		sort_arr = fifo_obj.arrival_sort(input_arr, no_of_process);
		completion_timearr = fifo_obj.completion_time(sort_arr, no_of_process);
		turnaround_timearr = fifo_obj.turnaround_time(sort_arr,
				completion_timearr, no_of_process);
		waiting_timearr = fifo_obj.waiting_time(sort_arr, turnaround_timearr,
				no_of_process);
		fifo_obj.display(sort_arr, completion_timearr, turnaround_timearr,
				waiting_timearr, no_of_process);

	}
}