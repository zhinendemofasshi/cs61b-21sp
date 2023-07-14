package randomizedtest;
import static org.junit.Assert.*;
import org.junit.Test;
public class testThreeAddThreeRemove {
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
}
