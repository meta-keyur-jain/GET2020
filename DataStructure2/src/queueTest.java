import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class queueTest {
    @Test
    public void test1() {
        try {
            queue testQueue = new queue(5);

            testQueue.enque(10);
            testQueue.enque(20);
            testQueue.enque(30);
            testQueue.enque(40);
            testQueue.enque(50);

            int[] result = testQueue.show();
            int[] expected1 = new int[] { 10, 20, 30, 40, 50 };
            assertArrayEquals(expected1, result);
        } catch (AssertionError e) {
            System.out.println("Assertion Error  " + e.getMessage());

        }
    }

    @Test
    public void test2() {
        try {
            queue testQueue = new queue(5);

            testQueue.enque(10);
            testQueue.enque(20);
            testQueue.enque(30);
            testQueue.enque(40);
            testQueue.enque(50);
            testQueue.deque();
            testQueue.deque();
            testQueue.enque(60);
            testQueue.enque(70);

            int[] result = testQueue.show();
            int[] expected1 = new int[] { 30, 40, 50, 60, 70 };
            assertArrayEquals(expected1, result);
        } catch (AssertionError e) {
            System.out.println("Assertion Error  " + e.getMessage());

        }
    }

    @Test
    public void test3() {
        try {
            queue testQueue = new queue(5);

            testQueue.enque(10);
            testQueue.enque(20);
            testQueue.enque(30);
            testQueue.enque(40);
            testQueue.enque(50);
            testQueue.enque(60);
            testQueue.enque(70);

            int[] result = testQueue.show();
            int[] expected1 = new int[] { 30, 40, 50, 60, 70 };
            assertArrayEquals(expected1, result);
        } catch (AssertionError e) {
            System.out.println("Assertion Error  " + e.getMessage());

        }
    }

    @Test
    public void test4() {
        try {
            queue testQueue = new queue(5);

            testQueue.deque();

            int[] result = testQueue.show();
            int[] expected1 = new int[] { 0, 0, 0, 0, 0 };
            assertArrayEquals(expected1, result);
        } catch (AssertionError e) {
            System.out.println("Assertion Error  " + e.getMessage());

        }
    }

    @Test
    public void test5() {
        try {
            queue testQueue = new queue(5);

            testQueue.enque(10);
            testQueue.enque(20);
            testQueue.enque(30);

            int[] result = testQueue.show();
            int[] expected1 = new int[] { 10, 20, 30, 0, 0 };
            assertArrayEquals(expected1, result);
        } catch (AssertionError e) {
            System.out.println("Assertion Error  " + e.getMessage());

        }
    }
}
