package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private final Comparator<T> arrayComparator;

    public MaxArrayDeque(Comparator<T> c) {
        this.arrayComparator = c;
    }

    public T max() {
        return max(arrayComparator);
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        int maxDex = 0;
        for (int i = 0; i < size(); i++) {
            int cmp = c.compare(get(i), get(maxDex));
            if (cmp > 0) {
                maxDex = i;
            }
        }
        return get(maxDex);
    }
}
