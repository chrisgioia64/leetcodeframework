package problems.problemB002;

import base.algorithm.Algorithm;
import base.types.IntegerArrayType;

import java.util.Arrays;

public class ParallelMergeSort implements Algorithm<IntegerArrayType, IntegerArrayType> {

    @Override
    public IntegerArrayType performAlgorithm(IntegerArrayType integerArrayType) {
        int[] ary = integerArrayType.getAry();
        int[] res = null;
        if (ary.length < 5) {
            res = SequentialMergeSort.sort(ary);
            return new IntegerArrayType(res);
        }
        int n = ary.length;
        int m = n / 2;
        int k = m / 2;
        int l = m - k;
        int[] ary1 = new int[k];
        System.arraycopy(ary, 0, ary1, 0, k);
        MergeSort runnable1 = new MergeSort(ary1);
        Thread t1 = new Thread(runnable1);
        t1.start();

        int[] ary2 = new int[l];
        System.arraycopy(ary, k, ary2, 0, l);
        MergeSort runnable2 = new MergeSort(ary2);
        Thread t2 = new Thread(runnable2);
        t2.start();

        int otherHalf = n - m;
        int q = otherHalf / 2;
        int[] ary3 = new int[q];
        System.arraycopy(ary, k+l, ary3, 0, q);

        MergeSort runnable3 = new MergeSort(ary3);
        Thread t3 = new Thread(runnable3);
        t3.start();

        int r = otherHalf - q;
        int[] ary4 = new int[r];
        System.arraycopy(ary, k+l+q, ary4, 0, r);

        MergeSort runnable4 = new MergeSort(ary4);
        Thread t4 = new Thread(runnable4);
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            ary1 = runnable1.ary;
            ary2 = runnable2.ary;
            ary3 = runnable3.ary;
            ary4 = runnable4.ary;

            int[] res1 = SequentialMergeSort.merge(ary1, ary2);
            int[] res2 = SequentialMergeSort.merge(ary3, ary4);
            int[] result = SequentialMergeSort.merge(res1, res2);
            return new IntegerArrayType(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static class MergeSort implements Runnable {
        private int[] ary;

        public MergeSort(int[] ary) {
            this.ary = ary;
        }

        /**
         * Using ad-hoc thread confinement.
         * The array will not be shared across threads.
         */
        @Override
        public void run() {
            this.ary = SequentialMergeSort.sort(ary);
        }
    }

    @Override
    public String getVariantName() {
        return "Parallel Merge Sort";
    }
}
