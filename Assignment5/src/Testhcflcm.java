import static org.junit.Assert.*;

import org.junit.Test;


public class Testhcflcm {

@Test
public void hcf_testcase(){
    Hcf_lcm hcf_lcm_obj = new Hcf_lcm(); 
    
    try {
        int result1 = hcf_lcm_obj.hcf(15,9);
        int expected1 = 3 ;
        assertEquals(expected1,result1);
        
        int result2 = hcf_lcm_obj.hcf(9,15);
        int expected2 = 3;
        assertEquals(expected2,result2);
        
        int result3 = hcf_lcm_obj.hcf(98,56);  
        int expected3 = 14;
        assertEquals(expected3,result3);
        
        
        int result = hcf_lcm_obj.hcf(0,0);
        int expected = 0;
        assertEquals(expected,result);
    } 
    catch (AssertionError e) {
        String expected_res = "divide by zero error"; 
        assertEquals(expected_res,e.getMessage());  

    }
}
@Test
public void lcm_testcase() {
    
    try {
        Hcf_lcm hcf_lcm_obj = new Hcf_lcm();
        
        int result1 = hcf_lcm_obj.lcm(15,25);
        int expected1 = 75;
        assertEquals(expected1,result1);
        
        int result2 = hcf_lcm_obj.lcm(15,20);
        int expected2 = 60;
        assertEquals(expected2,result2);
        
        int result3 = hcf_lcm_obj.lcm(5,7);
        int expected3 = 35; 
        assertEquals(expected3,result3);
        
        
        int result = hcf_lcm_obj.lcm(0,0);
        
    } 
    
    catch(AssertionError e) {
        String expected_res = "divide by zero error"; 
        assertEquals(expected_res,e.getMessage());  

    }
}
} 
    

