package deque;

import java.util.Arrays;
import java.util.Objects;
import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private int size;
    private int nextFirst = 4;
    private int nextLast = 5;
    private T[] items;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }


    public void addFirst(T item) {
        if (size == items.length) {
            resize(size + 1);
        }
        items[nextFirst] = item;
        size += 1;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size + 1);
        }
        items[nextLast] = item;
        size += 1;
        nextLast = (nextLast + 1) % items.length;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        int first = (nextFirst + 1) % items.length;
        T temp = items[first];
        items[first] = null;
        nextFirst = first;
        size -= 1;
        return temp;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        int last = (nextLast - 1 + items.length) % items.length;
        T temp = items[last];
        items[last] = null;
        nextLast = last;
        size -= 1;
        return temp;
    }

    public void printDeque() {
        int p = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i++) {
            System.out.print(items[p] + " ");
            p += 1;
            p = p % items.length;
        }
        System.out.println();
    }
    public T get(int index) {
        if (index > size - 1) {
            return null;
        }
        // p points to the first item in this array.
        int p = (nextFirst + 1) % items.length;
        for (int i = 0; i < index; i++) {
            p += 1;
            p = p % items.length;
        }
        return items[p];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<T> iterator() {
        // ToDo lecture 11
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        private int wizPos;

        public ArrayIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T returnItem = get(wizPos);
            wizPos += 1;
            return returnItem;
        }
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o instanceof ArrayDeque arrayDeque) {
//            if (this.size != arrayDeque.size) {
//                return false;
//            }
//            for (int i = 0; i < size; i++) {
//                if (!arrayDeque.get(i).equals(this.get(i))) {
//                    return false;
//                }
//            }
//            return true;
//        }
//        return false;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayDeque<?> lld = (ArrayDeque<?>) o;
        if (lld.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (lld.get(i) != get(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }
}
