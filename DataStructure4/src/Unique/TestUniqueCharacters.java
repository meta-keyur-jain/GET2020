package Unique;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestUniqueCharacters {
    UniqueCharacters object = new UniqueCharacters();

    @Test
    public void test1() {
        String str = "helLo";
        int expected = 3;
        assertEquals(expected, object.getUniqueCharactersInAString(str));
    }
 
    @Test
    public void test2() {
        String str = "keyur";
        int expected = 5;
        assertEquals(expected, object.getUniqueCharactersInAString(str));

    }
 
    @Test
    public void test3() {
        String str = "aaaaa";
        int expected = 0;
        assertEquals(expected, object.getUniqueCharactersInAString(str));

        String str1 = "aaaaa";
        int expected1 = 0;
        assertEquals(expected1, object.getUniqueCharactersInAString(str1));

    }

    @Test
    public void test4() {
        String str = "";
        int expected = 0;
        assertEquals(expected, object.getUniqueCharactersInAString(str));

    }

    @Test
    public void test5() {
        String str = "jitender";
        int expected = 6;
        assertEquals(expected, object.getUniqueCharactersInAString(str));

    }

}