public class Search {

    /**
     * This method is the implementation of the binary search algorithm.
     * In this input array is sorted.
     * @param binary_arr is the integer input array.
     * @param element is the integer element to search.
     * @param start is the starting index.
     * @param end is the last index of array.
     */
    public int binary_searchimplement(int []binary_arr,int element,int start,int end) {
        
        int mid; 

        if(start>=end) {
            if(binary_arr[start]==element) {
                return start+1;
                }
            
            else {
                return -1; 
            }
        }
        
        else { 
            mid = (start+end)/2;
        
            if(binary_arr[mid]==element) {
                return mid+1;
            }
            
            else if(binary_arr[mid]>element) {
                end = mid-1;
                return binary_searchimplement(binary_arr,element,start,end);
            }
            
            else {
                start = mid+1;
                return binary_searchimplement(binary_arr,element,start,end);
            }
        }



    }
    /**
     * This method call the method binary_searchimplement and store the result return by it.
     * @param binary_arr is the integer input array.
     * @param element is the integer element to search.
     * @return element_index is the index of element on which it is found. 
     */
    public int binary_search(int [] binary_arr,int element) {
        
        int start=0,end=binary_arr.length-1;
        int element_index;
        
        if(binary_arr.length == 0) {
            throw new AssertionError("array should not be empty");
        }
        
        element_index = binary_searchimplement(binary_arr,element,start,end);
        return element_index;
    } 



    /**
     * This method is the implementation of the linear search algorithm.
     * @param search_arr is the integer input array.
     * @param element is the integer element to search.
     * @param start is the starting index.
     * @param end is the last index of array.
     */


    public int linear_searchimplementation(int []search_arr,int element,int start,int end){
        int arr_result;
        if(end<start){
            arr_result= -1;
            return arr_result;
        }
        if(search_arr[start]==element){
            arr_result = start+1;
            return arr_result;
        }
        if(search_arr[end]==element){
            arr_result = end+1;
            return arr_result;

        }
        return linear_searchimplementation(search_arr,element,start+1,end-1);
    }


    /**
     * This method call the method linear_searchimplementation and store the result return by it.
     * @param search_arr is the integer input array.
     * @param element is the integer element to search.
     * @return element_index is the index of element on which it is found. 
     */
    public int linear_search(int [] search_arr,int element){
        int end = search_arr.length-1, start =0;
        if(search_arr.length == 0)
        {
            throw new AssertionError("array should not be empty");
        }
        int element_index = linear_searchimplementation(search_arr,element,start,end);
        return element_index;

    }


}



