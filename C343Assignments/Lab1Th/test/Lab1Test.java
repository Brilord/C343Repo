import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Lab1Test {

    @Test
    public void Task1Simple(){
        Lab1 lab = new Lab1();
        assertEquals(9, lab.getDigitSum(126));

    }

    @Test
    public void Task2Simple(){
        Lab1.countSevens(717); // 2
        assertEquals(2,Lab1.countSevens(717)); // 2
    }

    @Test
    public void Task3Simple(){
        Lab1.printInBinary(0); // 0
    }

    @Test
    public void Task4Simple(){
        // write a test for this one if you decide to do it
    }

    @Test
    void getDigitSum() {
    }

    @Test
    void countSevens() {
    }

    @Test
    void printInBinary() {
    }

    @Test
    void multiply() {
    }
}
