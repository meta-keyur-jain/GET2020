import java.util.ArrayList;

public class ArrOperation {

    /**
     * This method Return an array that contains exactly the same numbers as the
     * input array, but rearranged so that every X is immediately followed by a
     * Y.
     * 
     * @param fix_Arr
     *            is the integer input array.
     * @param x
     *            is the first value.
     * @param y
     *            is the second value
     * @return fix_Arr is the integer array with above functionalities.
     */
    public int[] Fix_method(int[] fix_Arr, int x, int y) {

        int fix_len = fix_Arr.length;
        int count = 0, x_len = 0, y_len = 0;
        ArrayList<Integer> x_arr = new ArrayList<Integer>();
        ArrayList<Integer> y_arr = new ArrayList<Integer>();

        if (fix_Arr.length == 0) {
            throw new AssertionError("  Array should not be null");
        }
        for (int index = 0; index < fix_len - 1; index++) {
            if (fix_Arr[index] == x && fix_Arr[index + 1] == x) {
                throw new AssertionError("No should not be followed immediately");
            }
        }

        for (int index = 0; index < fix_len; index++) {
            if (fix_Arr[index] == x) {
                x_arr.add(index);
                count++;
                x_len++;
            }
            if (fix_Arr[index] == y) {
                y_arr.add(index);
                y_len++;
            }
        }

        if (x_len != y_len || x_len == 0 || y_len == 0
                || fix_Arr[fix_len - 1] == x) {
            throw new AssertionError("last element of array no be first word");
        }

        for (int index = 0; index < count; index++) {
            int swap_var = fix_Arr[x_arr.get(index) + 1];
            fix_Arr[x_arr.get(index) + 1] = y;
            fix_Arr[y_arr.get(index)] = swap_var;
        }

        return fix_Arr;
    }

    /**
     * This method Return the index if there is a place to split the input
     * array, so that the sum of the numbers on one side is equal to the sum of
     * the numbers on the other side else return -1.
     * 
     * @param split_arr
     *            is the integer array.
     * @return count is the integer variable which return the index.
     */
    public int split_arr(int[] split_arr) {

        int split_len = split_arr.length;
        int total_sum = 0, split_sum = 0, count = 0;
        if (split_arr.length == 0) {
            throw new AssertionError("Array should not be null");
        }
        for (int index = 0; index < split_len; index++) {
            total_sum += split_arr[index];
        }
        for (int index = 0; index < split_len; index++) {
            if (total_sum % 2 == 0 && (int) (total_sum / 2) <= split_sum) {

                break;
            } else {
                split_sum += split_arr[index];
                count += 1;
            }

        }
        if (count == split_len || count == 0 || split_sum != (total_sum / 2)) {
            count = -1;
        }
        return count;

    }

    /**
     * In this method Mirror section in an array is a group of contiguous
     * elements such that somewhere in the array, the same group appears in
     * reverse order
     * 
     * @param mirror_arr
     *            is the integer array.
     * @param size
     *            is the integer variable.
     * @return maximum is the integer variable.
     */

    public int largest_mirror(int[] mirror_arr) {
        int size = mirror_arr.length;
        int maximum = 0;
        int[][] matrix_arr = new int[size + 1][size + 1];

        if (mirror_arr.length == 0) {
            throw new AssertionError("Array should not be null");
        }

        for (int index = 0; index <= size; index++) {

            for (int index1 = 0; index1 <= size; index1++) {

                if (index == 0 || index1 == 0) {
                    matrix_arr[index][index1] = 0;
                } else if (mirror_arr[index - 1] == mirror_arr[size - index1]) {
                    matrix_arr[index][index1] = matrix_arr[index - 1][index1 - 1] + 1;
                } else {
                    matrix_arr[index][index1] = 0;
                }
                if (maximum < matrix_arr[index][index1]) {
                    maximum = matrix_arr[index][index1];
                }
            }
        }
        return maximum;
    }

}
