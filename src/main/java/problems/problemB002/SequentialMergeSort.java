package problems.problemB002;

import base.algorithm.Algorithm;
import base.types.IntegerArrayType;

public class SequentialMergeSort implements Algorithm<IntegerArrayType, IntegerArrayType> {

    @Override
    public IntegerArrayType performAlgorithm(IntegerArrayType integerArrayType) {
        int[] ary = integerArrayType.getAry();
        int[] res = sort(ary);
        return new IntegerArrayType(res);
    }

    public static int[] sort(int[] ary) {
        int n = ary.length;
        if (n <= 1) {
            return ary;
        } else {
            int[] ary1 = new int[n/2];
            int[] ary2 = new int[n - (n/2)];
            System.arraycopy(ary, 0, ary1, 0, n/2);
            System.arraycopy(ary, n/2, ary2, 0, n - (n/2));
            int[] res1 = sort(ary1);
            int[] res2 = sort(ary2);
            return merge(res1, res2);
        }
    }

    public static int[] merge(int[] ary1, int[] ary2) {
        int[] res = new int[ary1.length + ary2.length];
        int i = 0;
        int j = 0;
        while (i < ary1.length || j < ary2.length) {
            if (i < ary1.length && (j >= ary2.length || ary1[i] < ary2[j])) {
                res[i+j] = ary1[i];
                i++;
            } else {
                res[i+j] = ary2[j];
                j++;
            }
        }
        return res;
    }

    @Override
    public String getVariantName() {
        return "Sequential Merge Sort";
    }
}
