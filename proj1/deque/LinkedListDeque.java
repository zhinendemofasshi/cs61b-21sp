package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private int size;
    private IntNode sentinel;

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private int wizPos;

        LinkedListIterator() {
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

    private class IntNode {
        private IntNode prev;
        private IntNode next;
        private T item;
        IntNode(T item, IntNode prev, IntNode next) {
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

    @Override
    public void addFirst(T item) {
        sentinel.next = new IntNode(item, sentinel, sentinel.next);
        size += 1;
        sentinel.next.next.prev = sentinel.next;
    }

    @Override
    public void addLast(T item) {
        sentinel.prev = new IntNode(item, sentinel.prev, sentinel);
        size += 1;
        sentinel.prev.prev.next = sentinel.prev;
    }
    @Override
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
    @Override
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

    @Override
    public T get(int index) {
        IntNode p = sentinel;
        for (int i = 0; i < size; i++) {
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

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            IntNode p = sentinel;
            p = p.next;
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o instanceof LinkedListDeque linkedListDeque) {
//            if (this.size != linkedListDeque.size) {
//                return false;
//            }
//            for (int i = 0; i < size; i++) {
//                if (!linkedListDeque.get(i).equals(this.get(i))) {
//                    return false;
//                }
//            }
//            return true;
//        }
//        return false;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o.getClass() == ArrayDeque.class) {
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
        if (this.getClass() != o.getClass()) {
            return false;
        }
        LinkedListDeque<?> lld = (LinkedListDeque<?>) o;
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
    public int size() {
        return size;
    }
}
