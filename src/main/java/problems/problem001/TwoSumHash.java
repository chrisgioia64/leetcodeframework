package problems.problem001;

import base.algorithm.Algorithm;
import base.types.IntegerArrayType;
import base.types.TwoSumType;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSumHash implements Algorithm<TwoSumType, IntegerArrayType> {
    @Override
    public IntegerArrayType performAlgorithm(TwoSumType twoSumType) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < twoSumType.getAry().length; i++) {
            int value = twoSumType.getAry()[i];
            int complement = twoSumType.getTarget() - value;
            if (map.containsKey(complement)) {
                return new IntegerArrayType(new int[] {map.get(complement), i});
            }
            map.put(value, i);
        }
        return null;
    }

    @Override
    public String getVariantName() {
        return "Hash";
    }
}
