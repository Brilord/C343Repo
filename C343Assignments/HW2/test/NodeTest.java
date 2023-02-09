import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
        /*
    TODO: write test cases testing the accuracy of the methods marked with TODO.s.
     */
    @Test
    void compareToTest() {
        Node node1 = new Node("Hello",1);
        Node node2 = new Node("Abraham",1);
        assertEquals(node1.compareTo(node2), 7);
    }
    @Test
    void equalsTest() {
        Node node1 = new Node("Hello",1);
        Node node2 = new Node("Abraham",1);
        assertFalse(node1.equals(node2));
    }
    @Test
    void equalsTest1() {
        Node node1 = new Node("Hello",1);
        Node node2 = new Node("Hello",1);
        assertTrue(node1.equals(node2));
    }

}
