package bstmap;

import java.rmi.UnexpectedException;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>
{
    private BSTNode root;

    private class BSTNode {
        private K key;
        private V value;
        private BSTNode left, right;
        private int size;

        public BSTNode(K key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public BSTMap() {
    }

    @Override
    public void clear() {
        root.size = 0;
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(BSTNode x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        }
        else if (cmp > 0) {
            return get(x.right, key);
        }
        else {
            if (x.value == null) {
                return (V) new Object();
            }
            return x.value;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(BSTNode x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private BSTNode put(BSTNode x, K key, V value) {

        if (x == null) {
            return new BSTNode(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left =  put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        }
        else {
            x.value = value;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void printInOrder() {
        if (root == null) {
            return;
        }
        printInOrder(root);
    }

    public void printInOrder(BSTNode x) {
        if (x == null) {
            return;
        }
        printInOrder(x.left);
        System.out.print(x.key + " ");
        printInOrder(x.right);
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
