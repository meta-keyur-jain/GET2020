import static org.junit.Assert.*;

import org.junit.Test;


public class stackTest {
    @Test
    public void test1() {
        stackImpl si = new stackImpl();
        try {
           String str = "((2*5)+(6/2))";
           int result  = si.infixevalution(str);
           int expected = 13;
            assertEquals(expected, result);
        } catch (AssertionError e) {
            System.out.println("Assertion Error  " + e.getMessage());

        }
    }
    @Test
    public void test2() { 
        stackImpl si = new stackImpl();
        try {
           String str = "(((2 * 5) - (1 * 2)) / (11 - 9))";
           int result  = si.infixevalution(str);
           int expected = 4;
            assertEquals(expected, result);
        } catch (AssertionError e) {
            System.out.println("Assertion Error  " + e.getMessage());

        }
    }
    @Test
    public void test3() {
        stackImpl si = new stackImpl();
        try {
           String str = "((3^2)+(8/4)-6)";
           int result  = si.infixevalution(str);
           int expected = 5;
            assertEquals(expected, result);
        } catch (AssertionError e) {
            System.out.println("Assertion Error  " + e.getMessage());

        }
    }
    @Test
    public void test4() {
        stackImpl si = new stackImpl();
        try {
           String str = "4-4*4/7+5";
           int result  = si.infixevalution(str);
           int expected = -1;
            assertEquals(expected, result);
        } catch (AssertionError e) {
            System.out.println("Assertion Error  " + e.getMessage());

        }
    }
    @Test
    public void test5() {
        stackImpl si = new stackImpl();
        try {
           String str = "";
           int result  = si.infixevalution(str);
           int expected = -1;
            assertEquals(expected, result);
        } catch (AssertionError e) {
            System.out.println("Assertion Error  " + e.getMessage());

        }
    }
}
