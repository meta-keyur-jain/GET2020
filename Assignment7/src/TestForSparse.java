import static org.junit.Assert.*;

import org.junit.Test;

public class TestForSparse 
{

    @Test
    public void testForTranspose()
    {
        Sparsematrix obj = new Sparsematrix(new int[][] {{1,0,0},{0,2,0},{0,0,1}});
        int expected[][] = new int[][]{{1,0,0},{0,2,0},{0,0,1}};
        int result[][] = obj.getTranspose();
        assertArrayEquals(expected, result);
        
        
        Sparsematrix obj1 = new Sparsematrix(new int[][] {{1,0,3},{0,2,0},{4,0,0}});
        int expected1[][] ={{1,0,4},{0,2,0},{3,0,0}};
        int result1[][] = obj1.getTranspose();
        assertArrayEquals(expected1, result1);
        
    }
    
    
    @Test
    public void testForSymmetry()
    {
        Sparsematrix obj = new Sparsematrix(new int[][] {{1,0,0},{0,2,0},{0,0,1}});
        boolean result = obj.isSymmetrical();
        assertEquals(true, result);
        
        Sparsematrix obj1 = new Sparsematrix(new int[][] {{0,4,9},{1,1,8},{2,0,4}});
        boolean result1 = obj1.isSymmetrical();
        assertEquals(false, result1);

    
    }
     
    @Test
    public void testForAdd()
    {
        Sparsematrix obj = new Sparsematrix(new int[][] {{1,0,0},{0,2,0},{0,0,1}});
        Sparsematrix obj1 = new Sparsematrix(new int[][] {{3,0,5},{0,2,0},{0,0,1}});
        int [][] addExpected = new int[][]{{4,0,5},{0,4,0},{0,0,2}};
        int[][] result = obj1.add(obj);
        assertArrayEquals(addExpected, result);
        
        
        Sparsematrix obj2 = new Sparsematrix(new int[][] {{0,0,1},{1,0,0},{0,2,0}});
        Sparsematrix obj3 = new Sparsematrix(new int[][]{{0,0,2},{0,9,3},{1,0,0}});
        int addExpected1[][] = new int [][]{{0, 0, 3},{1, 9, 3}, {1, 2, 0}};
        int[][] result1 = obj3.add(obj2);
        assertArrayEquals(addExpected1, result1);
        
        try{
            Sparsematrix obj4 = new Sparsematrix(new int[][] {{0,0,1},{1,0,0},{0,2,0},{1,0,0}});
            Sparsematrix obj5 = new Sparsematrix(new int[][]{{0,0,2},{0,9,3},{1,0,0}});
            int addExpected2[][] = new int [][]{{0, 0, 3},{1, 9, 3}, {1, 2, 0}};
            int[][] result2 = obj4.add(obj5);
            assertArrayEquals(addExpected2, result2);
        }
        catch(AssertionError e){
            String res = "Addition is not possible.";
            assertEquals(res,e.getMessage());
            
        }

         
        
    }
    
    @Test
    public void testForMulti()
    {
        Sparsematrix obj = new Sparsematrix(new int[][] {{1,0,0},{0,2,0},{0,0,1}});
        Sparsematrix obj1 = new Sparsematrix(new int[][] {{3,0,5},{0,2,0},{0,0,1}});
        int [][] multiExpected = new int[][]{{3,0,5},{0,4,0},{0,0,1}};
        int[][] result = obj1.multiply(obj);
        assertArrayEquals(multiExpected, result);
        
        Sparsematrix obj2 = new Sparsematrix(new int[][] {{1,0,0},{0,1,0},{0,0,1}});
        Sparsematrix obj3 = new Sparsematrix(new int[][] {{0,0,2},{0,1,3},{1,2,4}});
        int [][] multiExpected1 = new int[][]{{0, 0, 2},{0, 1, 3},{1, 2, 4}};
        int[][] result1 = obj3.multiply(obj2);
        assertArrayEquals(multiExpected1, result1);
        
       try{ 
        Sparsematrix obj4 = new Sparsematrix(new int[][] {{1,0,0},{0,1,0},{0,0,1},{1,0,0}});
        Sparsematrix obj5 = new Sparsematrix(new int[][] {{0,0,2},{0,1,3},{1,2,4}});
        int [][] multiExpected2 = new int[][]{{0, 0, 2},{0, 1, 3},{1, 2, 4}};
        int[][] result2 = obj4.multiply(obj5); 
        assertArrayEquals(multiExpected2, result2);
       }
        catch(AssertionError e){
            String res = "Number of columns of first matrix is not equal to number of rows in the second Matrix";
            assertEquals(res,e.getMessage());
        }
    }
}
 