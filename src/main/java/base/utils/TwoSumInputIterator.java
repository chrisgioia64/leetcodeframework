package base.utils;

import base.types.IntegerArrayType;

import java.util.Iterator;
import java.util.function.Function;

public class TwoSumInputIterator implements Iterator<IntegerArrayType> {

    private int target;
    private Iterator<int[]> iter;

    public TwoSumInputIterator(int target) {
        this.target = target;
        NextArrayIteratorOptimized baseIter = new NextArrayIteratorOptimized(target + 1);
        FilterMapIterator<IntegerArrayType, int[]> filterIter =
                new FilterMapIterator<>(baseIter,
                        TwoSumInputIterator::isValid,TwoSumInputIterator::getNumbers);
        this.iter = new ProductIterator<>(filterIter,
                        x -> new PermutationValuesIterator(x));
    }

    public static boolean isValid(IntegerArrayType type) {
        int[] arr = type.getAry();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }
        if (count < 2) {
            return false;
        }
        int x = 0;
        for (int i = 0; i < arr.length/2; i++) {
            if (arr[i] == 1 && arr[arr.length-1-i] == 1) {
                x++;
            }
        }
        return x == 1;
    }

    public static int[] getNumbers(IntegerArrayType type) {
        int count = 0;
        int[] ary = type.getAry();
        for (int ele : ary) {
            if (ele == 1) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < ary.length; i++) {
            if (ary[i] == 1) {
                result[index++] = i;
            }
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public IntegerArrayType next() {
        int[] ary = iter.next();
        return new IntegerArrayType(ary);
    }
}
