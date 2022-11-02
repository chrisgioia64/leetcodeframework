package problems.problemB001;

import base.algorithm.Algorithm;
import base.types.IntegerArrayType;

public class NextArrayAdvanced implements Algorithm<IntegerArrayType, IntegerArrayType> {

    @Override
    public IntegerArrayType performAlgorithm(IntegerArrayType integerArrayType) {
        int[] oldAry = integerArrayType.getAry();
        int n = oldAry.length;
        int[] ary = new int[n];
        System.arraycopy(oldAry, 0, ary, 0, n);
        for (int i = n-1; i >= 0 ; i--) {
            if (ary[i] == 0) {
                ary[i] = 1;
                break;
            } else {
                ary[i] = 0;
            }
        }
        return new IntegerArrayType(ary);
    }

    @Override
    public String getVariantName() {
        return "Optimized";
    }
}
