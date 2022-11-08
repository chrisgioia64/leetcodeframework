package problems.problemB002;

import base.algorithm.Algorithm;
import base.types.IntegerArrayType;

import java.util.Arrays;

public class ArraySortUsingJavaSort implements Algorithm<IntegerArrayType, IntegerArrayType> {

    @Override
    public IntegerArrayType performAlgorithm(IntegerArrayType intArrayType) {
        int[] ary = intArrayType.getAry();
        int[] newAry = new int[ary.length];
        System.arraycopy(ary, 0, newAry, 0, ary.length);
        Arrays.sort(newAry);
        return new IntegerArrayType(newAry);
    }

    @Override
    public String getVariantName() {
        return "Use Java's built-in sort";
    }
}
