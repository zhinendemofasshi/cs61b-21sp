package deque;

import java.util.Objects;

public class LinkedListDeque<T> {
    private int size;
    private IntNode sentinel;
    private class IntNode{
        public IntNode prev;
        public IntNode next;
        public T item;
        public IntNode(T item, IntNode prev, IntNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
    public LinkedListDeque() {
        this.size = 0;
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(T item) {
        sentinel.next = new IntNode(item, sentinel, sentinel.next);
        size += 1;
        sentinel.next.next.prev = sentinel.next;
    }

    public void addLast(T item) {
        sentinel.prev = new IntNode(item, sentinel.prev, sentinel);
        size += 1;
        sentinel.prev.prev.next = sentinel.prev;
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T temp = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return temp;
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T temp = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return temp;
    }
    public T get(int index) {
        for (int i = 0; i < size; i++) {
            IntNode p = sentinel;
            p = p.next;
            if (i == index) {
                return p.item;
            }
        }
        return null;
    }
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }
    private T getRecursiveHelper(int index, IntNode p) {
        if (index == 0) {
            return p.item;
        }
        return getRecursiveHelper(index - 1, p.next);
    }
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            IntNode p = sentinel;
            p = p.next;
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedListDeque<?> that = (LinkedListDeque<?>) o;
        return size == that.size && Objects.equals(sentinel, that.sentinel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, sentinel);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

}
