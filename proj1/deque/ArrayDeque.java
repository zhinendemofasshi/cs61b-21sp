package deque;

import java.util.Arrays;
import java.util.Objects;

public class ArrayDeque<T> {
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
        T temp = items[(nextFirst + 1) % items.length];
        items[(nextFirst + 1) % items.length] = null;
        nextFirst += 1;
        return temp;
    }

    public T removeLast() {
        T temp = items[(nextLast - 1 + items.length) % items.length];
        items[(nextLast - 1 + items.length) % items.length] = null;
        nextLast -= 1;
        return temp;
    }

    public void printDeque() {
        for (T item :
                items) {
            if (item != null) {
                System.out.print(item + " ");
            }
        }
        System.out.println();
    }
    public T get(int index) {
        return items[index];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayDeque<?> that = (ArrayDeque<?>) o;
        return size == that.size && Arrays.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }
}
