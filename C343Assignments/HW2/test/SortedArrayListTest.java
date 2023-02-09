import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SortedArrayListTest {
    /*
    TODO: write test cases testing the accuracy of the methods marked with TODO. Write an efficiency test which asserts that the
    SortedArrayTest is faster than the ArrayList. Be sure to test for edge cases.
     */
    @Test
    void addTest() {

        SortedArrayList<Integer> expected = new SortedArrayList<>();
        SortedArrayList<Integer> actual = new SortedArrayList<>();
        long startTime = System.currentTimeMillis();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
        actual.add(1);
        actual.add(2);
        actual.add(4);
        actual.add(5);
        assertEquals(expected.toString(), actual.toString());
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Duration: " + duration + " milliseconds");
    }
    @Test
    void deleteTest() {
        SortedArrayList<Integer> expected = new SortedArrayList<Integer>();
        SortedArrayList<Integer> actual = new SortedArrayList<>();
        long startTime = System.currentTimeMillis();

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
        SortedArrayList expected = new SortedArrayList<>();
        long startTime = System.currentTimeMillis();

        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.search(2);
        assertEquals(1,expected.search(2));
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Duration: " + duration + " milliseconds");

    }
}
