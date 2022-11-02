package base.utils;

import com.google.common.base.Function;

import java.util.Iterator;
import java.util.function.Predicate;

public class FilterMapIterator<T, V> implements Iterator<V> {

    private Iterator<T> originalIterator;
    private Predicate<T> pred;
    private Function<T, V> func;
    private boolean end;
    private V last;

    public FilterMapIterator(Iterator<T> originalIterator, Predicate<T> pred, Function<T, V> func) {
        this.originalIterator = originalIterator;
        this.pred = pred;
        this.func = func;
        this.end = false;
        moveForward();
    }

    private void moveForward() {
        while (originalIterator.hasNext()) {
            T value = originalIterator.next();
            if (pred.test(value)) {
                this.last = func.apply(value);
                return;
            }
        }
        this.end = true;
    }

    @Override
    public boolean hasNext() {
        return !this.end;
    }

    @Override
    public V next() {
        V returnValue = this.last;
        moveForward();
        return returnValue;
    }
}
