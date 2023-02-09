import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class SortedLinkedListTests extends SortedLinkedList{
//    SortedLinkedList list = new SortedLinkedList();
//    list.

    /*
    TODO: tests
    - Make sure you have 100% code coverage
        + This also means you should break your tests up by method
    - Make sure you test the full functionality of this class...
      think edge cases (bounds, exceptions, etc...)
    - Use JUnit (you will not receive points for testing if you do
      not use JUnit)
     */
    @Test
    void insertTest() {
        SortedLinkedList expected = new SortedLinkedList();
        SortedLinkedList actual = new SortedLinkedList();
        //expected.insertSorted(1);
        //SortedLinkedList list = new SortedLinkedList();
        //list.insertSorted(1);
//        list.insertSorted(3);
//        list.insertSorted(6);

        expected.insertSorted(1);
        expected.insertSorted(2);
        actual.insertSorted(1);
        actual.insertSorted(2);
        assertEquals(expected, actual);

    }




    @Test
    void deleteTest() {
        SortedLinkedList list = new SortedLinkedList();

    }

    void searchTest() {

    }
}
