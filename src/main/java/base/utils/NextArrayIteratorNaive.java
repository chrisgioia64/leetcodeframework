package base.utils;

import base.types.IntegerArrayType;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NextArrayIteratorNaive implements Iterator<IntegerArrayType> {

    private int n;
    private List<IntegerArrayType> list;
    private Iterator<IntegerArrayType> iterator;

    public NextArrayIteratorNaive(int n) {
        this.n = n;
        this.list = new LinkedList<>();
        int index = 0;
        int limit = (int) Math.pow(2, n);
        while (index < limit) {
            int[] ary = generateArray(n, index);
            list.add(new IntegerArrayType(ary));
            index++;
        }
        iterator = list.iterator();
    }

    public static int[] generateArray(int n, int index) throws IllegalArgumentException {
        if (index < 0) {
            throw new IllegalArgumentException("the index is negative");
        }
        int limit = (int) Math.pow(2, n);
        if (index >= limit) {
            throw new IllegalArgumentException("the index is over the limit " + limit);
        }
        int[] ary = new int[n];
        int x = index;
        int j = n - 1;
        while (x > 0) {
            int val = x % 2;
            x = x / 2;
            ary[j] = val;
            j--;
        }
        return ary;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public IntegerArrayType next() {
        return iterator.next();
    }
}
