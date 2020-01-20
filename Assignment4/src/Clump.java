public class Clump {

    
    /**
     * This method is used to find the no of clump .
     * Clump in an array is a series of 2 or more adjacent elements of the same value
     * @param clump_arr is the integer input array.
     * @return count is the integer variable that consist the no of clump.
     */
    public static int clump_implement(int[] clump_arr) {
        int flag = 0, no_ofClump = 0;
        
            if (clump_arr.length == 0) {
                throw new AssertionError("  Array should not be null");
            }            int size_arr = clump_arr.length;
            for (int i = 0; i < size_arr - 1; i++) {
                if (clump_arr[i] == clump_arr[i + 1]) { 
                    if (flag != 1) { 
                        no_ofClump++;
                        flag = 1;
                    }
                } else {
                    flag = 0;
                } 
            }
         
       return no_ofClump;
    }

    
}
