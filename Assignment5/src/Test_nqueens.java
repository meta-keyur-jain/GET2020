import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;


public class Test_nqueens {

    Nqueens nqueens_obj= new Nqueens();
    @Test
    public void test_nq(){
        try {
            int [][] result = nqueens_obj.solve_nq(4);
            int [][]expected = { { 0, 0, 1, 0 }, 
                                 { 1, 0, 0, 0 }, 
                                 { 0, 0, 0, 1 }, 
                                 { 0, 1, 0, 0 } };
            assertArrayEquals(expected,result);

            int [][] result1 = nqueens_obj.solve_nq(5);
            int [][]expected1 =  {{1, 0, 0, 0, 0},
                                  {0, 0, 0, 1, 0 },
                                  {0, 1, 0, 0, 0 },
                                  {0, 0, 0, 0, 1 },
                                  {0, 0, 1, 0, 0 }};
            assertArrayEquals(expected1,result1);

            int [][] result2 = nqueens_obj.solve_nq(3);
            int [][]expected2 =  {{0, 0, 0},
                                  {0, 0, 0},
                                  {0, 0, 0}};
            assertArrayEquals(expected2,result2);
            
            int [][] result3 = nqueens_obj.solve_nq(2);
            int [][]expected3 =  {{0, 0},
                                  {0, 0}};
            assertArrayEquals(expected3,result3);
            
            int [][] result4 = nqueens_obj.solve_nq(1);
            int [][]expected4 =  {{0}};
            assertArrayEquals(expected4,result4);
            
            

            int [][] result3 = nqueens_obj.solve_nq(0);




        } catch (AssertionError e) {
            String expected_res = "Size should be valid!!"; 
            assertEquals(expected_res,e.getMessage());    

        }


    }


}
