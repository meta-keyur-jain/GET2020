
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class Polytest {
    Poly p1;
    Poly p2;
    Poly p3;
    Poly p4;
    Poly p5;
    Poly p6;
    
    @Before
    public void beforeTest()
    {
        p1 = new Poly(new int[]{4,2,1}, new int[]{3,2,1});
        p2 = new Poly(new int[]{4,2,1}, new int[]{3,2,1});
        p3 = new Poly(new int[]{2,1}, new int[]{2,1});
        p4 = new Poly(new int[]{1,1}, new int[]{2,1});
        p5 = new Poly(new int[]{2,1,0,5} , new int[]{3,1,1,3});
        p6 = new Poly(new int[]{2,1,0,7} , new int[]{2,5,1,5});
    }
    
    @Test
    public void testForSolve()
    {
        float result=p3.evalauate(4);
        float expected = 36;
        assertEquals(expected, result,2); 
        
        float result1=p3.evalauate(5);
        float expected1 = 55;
        assertEquals(expected1, result1,2);


    }
    @Test
    public void testForDegree()
    {
       
       int result =  p1.degree(); 
        int expected = 4; 
        assertEquals(expected,result);
        
        int result1 =  p3.degree(); 
        int expected1 = 2;
        assertEquals(expected1,result1);
        
         
        
    }
    
    @Test
    public void testForaddPoly()
    {
        Poly result;
    
        result = Poly.poly_add(p1, p2);
        assertArrayEquals(new int[]{1,2,4},result.getpower());
        assertArrayEquals(new int[]{2,4,6},result.getcoff());
        
        result = Poly.poly_add(p5, p6);
        assertArrayEquals(new int[]{0,1,2,5,7},result.getpower());
        assertArrayEquals(new int[]{2,6,5,3,5},result.getcoff());
        
        
          
    }
  @Test
  public void testForMul()
  { 
      Poly result,result1;
  
      result = Poly.multiply(p5, p6);
      assertArrayEquals(new int[]{5,6,7,9,12},result.getpower());
      assertArrayEquals(new int[]{3,15,6,15,15},result.getcoff());
       
      result1 = Poly.poly_add(p1,p2);
      assertArrayEquals(new int[]{1,2,4},result1.getpower());
      assertArrayEquals(new int[]{2,4,6},result1.getcoff());
      
  } 
 

} 
