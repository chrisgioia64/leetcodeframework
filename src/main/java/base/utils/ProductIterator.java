package base.utils;


import java.util.Iterator;
import java.util.function.Function;

public class ProductIterator<T, V> implements Iterator<V> {

    private Iterator<T> outerIterator;
    private Function<T, Iterator<V>> innerIteratorSupplier;
    private Iterator<V> innerIterator;
    private V last;
    private boolean end;

    public ProductIterator(Iterator<T> outerIterator, Function<T, Iterator<V>> innerIteratorSupplier) {
        this.outerIterator = outerIterator;
        this.innerIteratorSupplier = innerIteratorSupplier;
        this.end = false;
        moveForward();
    }

    private void moveForward() {
        if (outerIterator.hasNext() && innerIterator == null) {
            innerIterator = innerIteratorSupplier.apply(outerIterator.next());
        }

        if (innerIterator.hasNext()) {
            this.last = innerIterator.next();
        } else if (outerIterator.hasNext()) {
            innerIterator = innerIteratorSupplier.apply(outerIterator.next());
            if (innerIterator.hasNext()) {
                this.last = innerIterator.next();
            } else {
                throw new IllegalArgumentException("the inner iterator does not have any elements");
            }
        } else {
            this.end = true;
        }
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
