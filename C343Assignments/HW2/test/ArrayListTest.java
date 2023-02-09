import org.junit.jupiter.api.Test;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest extends ArrayList{
    /*
    TODO: write test cases testing the accuracy of the methods marked with TODO. Write an efficiency test which asserts that the
    SortedArrayTest is faster than the ArrayList. Be sure to test for edge cases.
     */

    @Test
    void addTest() {
        ArrayList expected = new ArrayList();
        ArrayList actual = new ArrayList();
        long startTime = System.currentTimeMillis();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);

        assertEquals(expected.toString(), actual.toString());
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Duration: " + duration + " milliseconds");
    }
    @Test
    void deleteTest() {
        long startTime = System.currentTimeMillis();
        ArrayList expected = new ArrayList();
        ArrayList actual = new ArrayList();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.delete(2);
        assertEquals(expected.toString(), actual.toString());
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Duration: " + duration + " milliseconds");
    }
    @Test
    void searchTest() {
        long startTime = System.currentTimeMillis();
        ArrayList expected = new ArrayList(3);
        expected.add(1);
        expected.add(2);
        expected.add(4);
        assertEquals(expected.search(2), 4);
        assertEquals(expected.search(5), -1);

    }

}
