package base.utils;

import java.util.Iterator;

public class PermutationValuesIterator implements Iterator<int[]> {

    private int[] original;
    private PermutationIterator baseIterator;

    public PermutationValuesIterator(int[] original) {
        this.original = original;
        this.baseIterator = new PermutationIterator(original.length);
    }

    @Override
    public boolean hasNext() {
        return baseIterator.hasNext();
    }

    @Override
    public int[] next() {
        int[] indices = baseIterator.next();
        return getPermutedValues(indices, original);
    }

    public int[] getPermutedValues(int[] indices, int[] values) {
        int[] result = new int[indices.length];
        for (int i = 0; i < indices.length; i++) {
            result[i] = values[indices[i]];
        }
        return result;
    }
}
