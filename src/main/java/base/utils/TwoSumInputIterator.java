package base.utils;

import base.types.IntegerArrayType;

import java.util.Iterator;

public class TwoSumInputIterator implements Iterator<IntegerArrayType> {

    private int target;

    public TwoSumInputIterator(int target) {
        this.target = target;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public IntegerArrayType next() {
        return null;
    }
}
