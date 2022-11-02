package base.utils;

import base.types.IntegerArrayType;
import problems.problemB001.NextArrayAdvanced;

import java.util.Iterator;

public class NextArrayIteratorOptimized implements Iterator<IntegerArrayType> {

    private int n;
    private IntegerArrayType current;
    private NextArrayAdvanced nextIterator;

    public NextArrayIteratorOptimized(int n) {
        this.n = n;
        this.current = new IntegerArrayType(new int[n]);
        this.nextIterator = new NextArrayAdvanced();
    }

    @Override
    public boolean hasNext() {
        return this.current != null;
    }

    @Override
    public IntegerArrayType next() {
        IntegerArrayType prev = current;
        this.current = nextIterator.performAlgorithm(prev);
        zeroOutCurrent();
        return prev;
    }

    private void zeroOutCurrent() {
        for (int i = 0; i < current.getAry().length; i++) {
            if (current.getAry()[i] != 0) {
                return;
            }
        }
        this.current = null;
    }
}
