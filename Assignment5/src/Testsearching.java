import static org.junit.Assert.*;

import org.junit.Test;
public class Testsearching {
    
    Search search_obj = new Search();
    
    @Test
    public void SearchOperation() {
        try {
 
            int result = search_obj.binary_search(new int[]{1,2,3,4,5,6},5);
            int  expected = 5;
            assertEquals(expected,result);

            int result2 = search_obj.binary_search(new int[]{4,4,5,6,9,10},4);
            int  expected2 = 1; 
            assertEquals(expected2,result2);

            int result3 = search_obj.binary_search(new int[]{15,18,24,35,67},18);
            int  expected3 = 2;
            assertEquals(expected3,result3);

            int result1 = search_obj.binary_search(new int[]{},0);
            int  expected1 = -1;
            assertEquals(expected1,result1); 


        }
        catch(AssertionError e) {
            System.out.println("Assertion Error  "+e.getMessage());  

        }

        try {

            int result = search_obj.linear_search(new int[]{1,9,3,4,5,6},5);
            int  expected = 5;
            assertEquals(expected,result);

            int result2 = search_obj.linear_search(new int[]{4,4,5,6,9,10},4);
            int  expected2 = 1;
            assertEquals(expected2,result2);

            int result3 = search_obj.linear_search(new int[]{34,18,99,35,67},18);
            int  expected3 = 2;
            assertEquals(expected3,result3);

            int result4 = search_obj.linear_search(new int[]{10, 20, 80, 30, 60, 50,110, 100, 130, 170},110);
            int  expected4 = 7;
            assertEquals(expected4,result4);


            int result5 = search_obj.linear_search(new int[]{10, 20, 80, 30, 60, 50,110, 100, 130, 170},175);
            int  expected5 = -1;
            assertEquals(expected5,result5);

            int result1 = search_obj.linear_search(new int[]{},0);
            int  expected1 = -1;
            assertEquals(expected1,result1);




        }
        catch(AssertionError e) {
            System.out.println("Assertion Error  "+e.getMessage());  

        }


    }


}
