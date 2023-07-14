package randomizedtest;
import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
public class RandomizedTest {
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> aList = new AListNoResizing<>();
        BuggyAList<Integer> bList = new BuggyAList<>();
        aList.addLast(4);
        aList.addLast(5);
        aList.addLast(6);

        bList.addLast(4);
        bList.addLast(5);
        bList.addLast(6);

        assertEquals(aList.size(), bList.size());
        assertEquals(aList.removeLast(), bList.removeLast());
        assertEquals(aList.removeLast(), bList.removeLast());
        assertEquals(aList.removeLast(), bList.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
            } else if (operationNumber == 2) {
                // getLast
                int size = L.size();
                if (size == 0) {
                    continue;
                }
                System.out.println("getLast: " + L.getLast());
            } else if (operationNumber == 3) {
                // removeLast
                int size = L.size();
                if (size == 0) {
                    continue;
                }
                System.out.println("removeLast: " + L.removeLast());
            }
        }
    }
}
