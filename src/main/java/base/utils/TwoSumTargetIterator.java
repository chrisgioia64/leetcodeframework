package base.utils;

import base.types.IntegerArrayType;
import base.types.TwoSumType;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TwoSumTargetIterator implements Iterator<TwoSumType> {

    private List<Integer> targets;
    private Iterator<IntegerArrayType> arrayIterator;
    private Iterator<Integer> targetsIterator;

    private Integer currentTarget;
    private IntegerArrayType currentArray;

    public TwoSumTargetIterator(List<Integer> targets) {
        this.targets = targets;
        this.targetsIterator = targets.iterator();
        evaluate();
    }

    private void evaluate() {
        if (arrayIterator == null) {
            currentTarget = targetsIterator.next();
            arrayIterator = new TwoSumInputIterator(currentTarget);
        }
        if (arrayIterator.hasNext()) {
            currentArray = arrayIterator.next();
        } else if (targetsIterator.hasNext()) {
            currentTarget = targetsIterator.next();
            arrayIterator = new TwoSumInputIterator(currentTarget);
            currentArray = arrayIterator.next();
        } else {
            currentTarget = null;
            currentArray = null;
        }
    }

    @Override
    public boolean hasNext() {
        return currentTarget != null;
    }

    @Override
    public TwoSumType next() {
        Integer returnedTarget = currentTarget;
        IntegerArrayType returnedAry = currentArray;
        evaluate();
        return new TwoSumType(returnedAry.getAry(), returnedTarget);
    }
}
