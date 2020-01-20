import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestClump
{
    @Parameters
    static public Collection <Object[]> array()
    {
        return Arrays.asList(new Object[][]{
                {new int[] {1, 2, 2, 3, 4, 4},2},
                {new int[] {1, 1, 2, 1, 1},2},
                {new int[] {1,1,1,1,1},1},
                {new int[] {},-1}
            
        }); 
    }
    
    private int fInput[];
    private int fExpected;
    public TestClump(int input[],int expected)
    {
        this.fInput=input;
        this.fExpected=expected;
    }
    @Test
    public void test() 
    {
        try {
            Clump instance=new Clump();
            assertEquals(fExpected, Clump.clump_implement(fInput));
        } 
        catch (AssertionError e) {
            System.out.println("Assertion Error"+e.getMessage());  
           
        }
    }
}