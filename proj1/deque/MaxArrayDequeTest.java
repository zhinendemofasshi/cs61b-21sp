package deque;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Comparator;

public class MaxArrayDequeTest{

    private static class IntComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    private static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int l1 = o1.length();
            int l2 = o2.length();
            return l1 - l2;
        }
    }

    @Test
    public void testNoParam() {
        MaxArrayDeque<Integer> mad = new MaxArrayDeque<>(new IntComparator());
        mad.addFirst(4);
        mad.addFirst(3);
        mad.addFirst(-1);
        assertEquals((Integer) 4, mad.max());
    }

    @Test
    public void testStringMax() {
        MaxArrayDeque<String> mad = new MaxArrayDeque<>(new StringComparator());
        mad.addFirst("i");
        mad.addFirst("am");
        mad.addFirst("world");
        assertEquals("world", mad.max());
        assertEquals("world", mad.max(new StringComparator()));
    }
}
