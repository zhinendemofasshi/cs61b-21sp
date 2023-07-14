/** Array based list.
 *  @author Josh Hug
 */

public class AList {
    /** Creates an empty list. */
    int size = 0;
    int[] items;
    public AList() {
        items = new int[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        items[size] = x;
        size += 1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        if (size == 0) {
            return -1;
        }
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int last = items[size - 1];
        items[size - 1] = null;
        return last;
    }
} 