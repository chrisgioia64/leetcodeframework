package base.utils;

import base.types.IntegerArrayType;

import java.util.Iterator;
import java.util.Random;

public class RandomIntegerArrayIterator implements Iterator<IntegerArrayType> {
    private int index;
    private int numArrays;
    private int arraySize;
    private int elementLimit;
    private Random random;

    public RandomIntegerArrayIterator(int numArrays, int arraySize, int elementLimit) {
        this.numArrays = numArrays;
        this.arraySize = arraySize;
        this.elementLimit = elementLimit;
        this.index = 0;
        this.random = new Random();
    }

    @Override
    public boolean hasNext() {
        return index < numArrays;
    }

    @Override
    public IntegerArrayType next() {
        int[] newAry = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            int element = random.nextInt(this.elementLimit);
            newAry[i] = element;
        }
        this.index++;
        return new IntegerArrayType(newAry);
    }
}
