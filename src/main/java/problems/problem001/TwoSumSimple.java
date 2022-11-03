package problems.problem001;

import base.algorithm.Algorithm;
import base.types.IntegerArrayType;
import base.types.TwoSumType;

public class TwoSumSimple implements Algorithm<TwoSumType, IntegerArrayType> {

    @Override
    public IntegerArrayType performAlgorithm(TwoSumType twoSumType) {
        int[] ary = twoSumType.getAry();
        for (int i = 0; i < ary.length; i++) {
            for (int j = 1; j < ary.length; j++) {
                if (ary[i] + ary[j] == twoSumType.getTarget()) {
                    return new IntegerArrayType(new int[] {i, j});
                }
            }
        }
        return null;
    }

    @Override
    public String getVariantName() {
        return "Simple";
    }
}
