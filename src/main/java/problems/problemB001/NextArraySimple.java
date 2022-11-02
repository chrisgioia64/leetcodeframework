package problems.problemB001;

import base.algorithm.Algorithm;
import base.types.IntegerArrayType;
import base.utils.NextArrayIteratorNaive;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class NextArraySimple implements Algorithm<IntegerArrayType, IntegerArrayType> {

    @Override
    public IntegerArrayType performAlgorithm(IntegerArrayType integerArrayType) {
        int[] ary = integerArrayType.getAry();
        int sum = 0;
        int val = 1;
        for (int i = ary.length - 1; i >= 0 ; i--) {
            if (ary[i] == 1) {
                sum += val;
            }
            val *= 2;
        }
        int limit = (int) Math.pow(2, ary.length);
        int[] nextArray = NextArrayIteratorNaive.generateArray(ary.length, (sum + 1) % limit);
        return new IntegerArrayType(nextArray);
    }

    @Override
    public String getVariantName() {
        return "Naive";
    }
}
