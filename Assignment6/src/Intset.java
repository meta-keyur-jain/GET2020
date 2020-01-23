import java.util.Arrays;

final public class Intset {

    final int set_arr[];

    /**
     * This is the method to initilize the array and it is basically constructor of class Inset.
     * It take number in range of 1-1000. 
     * @param arr is the integer array.
     */
    public Intset(int[] arr) {

        int [] temporary_arr = new int[arr.length];
        int count=0;

        Arrays.sort(arr);

        for(int index=0;index<arr.length-1;index++) {

            if(arr[index] != arr[index+1]) {
                temporary_arr[count] = arr[index];
                count++;
            }
        }

        temporary_arr[count] = arr[arr.length-1];
        count++;

        set_arr = new int[count];

        for(int index1=0;index1<count;index1++) {
            set_arr[index1] = temporary_arr[index1];
        }
    }

    /**
     * This validate the parameter value present in array or not.
     * @param value is the integer input.
     * @return boolean variable.
     */

    public boolean is_member(int value) {
        boolean result=false;
        int zero=0;
       if(value <= zero){
           throw new AssertionError("Enter value in given range");
       }
        

        for(int index=0 ; index<set_arr.length;index++) {

            if(set_arr[index]==value) {
                result = true;
            }
        }
        return result;
    }

    /**
     * This calculate the size of the array.
     * @return integer variable contain size.
     */
    public int size(){
        int size = set_arr.length;
        return size; 
    }
 
    /**
     * This method check that given array is subset or not.
     * @param is_obj is the integer input array.
     * @return boolean variable.
     */
 
    public boolean is_subset(Intset is_obj){

        boolean result = false;
        
        for(int index=0;index<is_obj.size();index++){
            if(is_obj.set_arr[index]<=0){
                throw new AssertionError("Enter value in given range");
            }
        }
        
        for(int index=0;index<is_obj.set_arr.length;index++) {

            for(int index1=0;index1<set_arr.length;index1++) {

                if(is_obj.set_arr[index]==set_arr[index1]) {
                    result=true;
                    break;
                }
                else{
                    result = false;
                }
            }
        }

        return result;
    }

    /**
     * This method can find the complement of the given array.  
     * @return the array which contain the compliment.
     */
    public int[] is_complement() {

        int size = 1000 - this.size();
        int count=0;
        int [] comp_arr = new int[size];

        for(int index=1;index<=1000;index++) {

            if(!(this.is_member(index))) { 
                comp_arr[count] = index;
                count++;
            }
        }

        return comp_arr;
    } 

    /**
     * This method calculate the union of two array.
     * @param arr1 is the integer input array.
     * @param arr2 is the integer input array.
     * @return integer array contain the union of two array.
     */
    public int [] union(int [] arr1,int []arr2) {

        int arr1_len = arr1.length;
        int arr2_len = arr2.length;
        int total_len = arr1_len  + arr2_len;
        int  union_set[] = new int[total_len];
        int count=0;
        int index = 0, index1 = 0; 
        int count1=0;

        while (index < arr1_len && index1 < arr2_len) {

            if (arr1[index] < arr2[index1]) {
                union_set[count] = arr1[index++];
                count++;
            }
            else if (arr2[index1] < arr1[index]){ 
                union_set[count] = arr2[index1++] ;
                count++;

            }
            else { 
                union_set[count] = arr2[index1++] ;
                count++;
 
                index++; 
            } 
        } 

        //  remaining elements of array 
        while(index < arr1_len) {
            union_set[count] = arr1[index++];
            count++;
        }
        while(index1 < arr2_len) { 
            union_set[count] = arr2[index1++] ;
            count++;
        }

        for(int index2=0;index2<union_set.length;index2++) {

            if(union_set[index2]!=0) {
                count1++;
            }    
            else {
                break;
            }
        }

        int [] final_set = new int[count1];
        for(int index3=0;index3<final_set.length;index3++) {

            final_set[index3] = union_set[index3];
        }
        
        Intset f_final = new Intset(final_set);
        final_set = f_final.set_arr;
        
        return final_set;
    }

}