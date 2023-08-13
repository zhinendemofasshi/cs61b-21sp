package deque;

import org.junit.Test;
import static org.junit.Assert.*;
public class ArrayDequeTest {
    @Test
    public void testEmptySize() {
        ArrayDeque<String> ad1 = new ArrayDeque<>();
        assertEquals(0, ad1.size());
    }

    @Test
    public void testAddAndSize() {
        ArrayDeque<String> L = new ArrayDeque<>();
        L.addFirst("hello");
        L.addLast("world");
        assertEquals(2, L.size());
    }

    @Test
    public void testAddLotOfStringsAndSize() {
        ArrayDeque<String> L = new ArrayDeque<>();
        L.addFirst("hello");
        L.addFirst("hello");
        L.addFirst("hello");
        L.addFirst("hello");
        L.addFirst("hello");
        L.addLast("world");
        L.addLast("world");
        L.addLast("world");
        assertEquals(8, L.size());
        L.removeFirst();
        L.removeFirst();
        L.removeFirst();
        L.removeFirst();
        L.removeFirst();
        L.removeFirst();
        L.removeFirst();
        L.removeFirst();
        assertEquals(0, L.size());
    }

    @Test
    public void testAddAndRemove() {
        ArrayDeque<String> L = new ArrayDeque<>();
        L.addFirst("hello");
        L.addFirst("hello");
        L.addFirst("hello");
        L.addFirst("hello");
        L.addFirst("hello");
        assertEquals("hello", L.removeFirst());
        assertEquals("hello", L.removeFirst());
        assertEquals("hello", L.removeFirst());
        assertEquals("hello", L.removeFirst());
        assertEquals("hello", L.removeFirst());
        L.addLast("hello");
        L.addLast("world");
        assertEquals("world", L.removeLast());
        assertEquals("hello", L.removeLast());
    }

    @Test
    public void testAddAndGet() {
        ArrayDeque<String> L = new ArrayDeque<>();
        L.addFirst("f");
        L.addLast("c");
        L.addLast("a");
        L.addLast("b");
        L.addLast("d");
        L.addLast("e");
        assertEquals("f", L.get(0));
        assertEquals("c", L.get(1));
        assertEquals("a", L.get(2));
        assertEquals("b", L.get(3));
        assertEquals("d", L.get(4));
        assertEquals("e", L.get(5));
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 100; i++) {
            ad1.addLast(i);
            assertEquals((Integer) i, ad1.get(i));
        }
        ad1.addFirst(-1);
        for (int i = 0; i < 100; i++) {
            ad1.addFirst(i);
            assertEquals((Integer) i, ad1.get(0));
        }
    }

    @Test
    public void emptyNullReturnTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        ArrayDeque<String> L = new ArrayDeque<>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, L.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, L.removeLast());
    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {

        ArrayDeque<String>  dq1 = new ArrayDeque<>();
        ArrayDeque<Double>  dq2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> dq3 = new ArrayDeque<Boolean>();

        dq1.addFirst("string");
        dq2.addFirst(3.14159);
        dq3.addFirst(true);

        String s = dq1.removeFirst();
        double d = dq2.removeFirst();
        boolean b = dq3.removeFirst();
    }

    @Test
    public void testRemoveFromEmpty() {
        ArrayDeque<String> adq1 = new ArrayDeque<>();
        adq1.addFirst("a");
        assertEquals(1, adq1.size());
        assertFalse(adq1.isEmpty());
        adq1.removeFirst();
        adq1.removeFirst();
        adq1.removeFirst();
        assertEquals(0, adq1.size());
        assertTrue(adq1.isEmpty());
    }

    @Test
    public void testPrintDeque() {
        ArrayDeque<String> adq1 = new ArrayDeque<>();
        adq1.addLast("a");
        adq1.addLast("b");
        adq1.addLast("d");
        adq1.addLast("e");
        adq1.addFirst("c");
        adq1.addFirst("f");
        // It should look like "f c a b d e"
        adq1.printDeque();
    }

    @Test
    public void iterableTest() {
        ArrayDeque<Integer> lld = new ArrayDeque<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        assertEquals((Integer) 1, lld.get(0));
        assertEquals((Integer) 2, lld.get(1));
        assertEquals((Integer) 3, lld.get(2));
        for (int x : lld) {
            System.out.println(x);
        }
    }

    @Test
    public void equalsTest() {
        // different size
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(1);
        lld1.addFirst(2);
        ArrayDeque<Integer> lld2 = new ArrayDeque<>();
        lld2.addFirst(1);
        assertFalse(lld1.equals(lld2));
        // same arrays
        lld2.addFirst(2);
        // same LinkedList
        LinkedListDeque<Integer> lld3 = new LinkedListDeque<>();
        lld3.addFirst(1);
        lld3.addFirst(2);
        assertTrue(lld1.equals(lld3));
        assertTrue(lld1.equals(lld2));
        assertTrue(lld1.equals(lld1));
        // same size but different contents
        lld1.addFirst(3);
        lld2.addFirst(5);
        assertFalse(lld1.equals(lld2));
        // different class
        LinkedListDeque<Integer> arrayDeque = new LinkedListDeque<>();
        assertFalse(lld1.equals(arrayDeque));

    }
}
