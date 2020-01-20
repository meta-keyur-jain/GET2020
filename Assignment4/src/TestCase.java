import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCase { 
    ArrOperation arr_obj = new ArrOperation(); 
    @Test
    public void ArrOperation(){
     try{
     
     int []result = arr_obj.Fix_method(new int[]{1, 4, 5, 1, 1, 4,5},4,5);
     int [] expected = new int []{1, 4, 5, 1, 1, 4, 5};
     assertArrayEquals(expected,result);
     
     int []result1 = arr_obj.Fix_method(new int[]{5, 4, 9, 4, 9, 5},4,5);
     int [] expected1 = new int []{9, 4, 5, 4, 5, 9};
     assertArrayEquals(expected1,result1);
     
     int []result2 = arr_obj.Fix_method(new int[]{1, 4, 1, 5},4,5);
     int [] expected2 = new int []{1, 4, 5, 1};
     assertArrayEquals(expected2,result2);
      
     int []result3 = arr_obj.Fix_method(new int[0],4,5);
     int [] expected3 = new int [0];
     assertArrayEquals(expected3,result3);
     
     
     int []result4 = arr_obj.Fix_method(new int[]{1, 4, 1, 5,4},4,5);
     int [] expected4 = new int []{1, 4, 1, 5,4};
     assertArrayEquals(expected4,result4);
     
     int []result5 = arr_obj.Fix_method(new int[]{1,4,4, 1, 5},4,5);
     int [] expected5 = new int []{1,4,4, 1, 5};
     assertArrayEquals(expected5,result5);
        }
        catch (AssertionError e) {
            System.out.println("Assertion Error"+e.getMessage());  
           
        }
     try {
        int split_result1 = arr_obj.split_arr(new int[]{1, 1, 1, 2, 1});
         int split_expected1 = 3;
         assertEquals(split_expected1,split_result1);
         
         int split_result2 = arr_obj.split_arr(new int[]{2, 1, 1, 2, 1});
         int split_expected2 = -1;
         assertEquals(split_expected2,split_result2);
         
         int split_result3 = arr_obj.split_arr(new int[]{10,10});
         int split_expected3 = 1;
         assertEquals(split_expected3,split_result3);
         
         int split_result4 = arr_obj.split_arr(new int[]{});
         int split_expected4 = -1;
         assertEquals(split_expected4,split_result4);
         
         
         
    } catch (AssertionError e) {
        System.out.println("Assertion Error  "+e.getMessage());  

    }

     try {
         int largest_result1 = arr_obj.largest_mirror(new int[]{1, 2, 3, 8, 9, 3, 2, 1});
          int largest_expected1 = 3;
          assertEquals(largest_expected1,largest_result1);
          
          int largest_result2 = arr_obj.largest_mirror(new int[]{7, 1, 4, 9, 7, 4, 1});
          int largest_expected2 = 2;
          assertEquals(largest_expected2,largest_result2);
          
          int largest_result3 = arr_obj.largest_mirror(new int[]{1, 2, 1, 4});
          int largest_expected3 = 3;
          assertEquals(largest_expected3,largest_result3);
          
          int largest_result4 = arr_obj.largest_mirror(new int[]{1, 4, 5, 3, 5, 4, 1});
          int largest_expected4 = 7;
          assertEquals(largest_expected4,largest_result4);

//          int largest_result5 = arr_obj.largest_mirror(new int[]{});
//          int largest_expected5 = 0;
          
          
          
          
     } catch (AssertionError e) {
                  assertEquals("Null Message",e.getMessage());

     }
    
    }
}
 