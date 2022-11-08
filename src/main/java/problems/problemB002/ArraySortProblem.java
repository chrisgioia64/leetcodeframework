package problems.problemB002;

import base.algorithm.Algorithm;
import base.problem.*;
import base.types.IntegerArrayType;
import base.utils.RandomIntegerArrayIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArraySortProblem extends ProblemComponents<IntegerArrayType, IntegerArrayType> {

    @Override
    public ProblemInformation getProblemInformation() {
        return ProblemInformation.builder()
                .name("Sort an integer array")
                .difficulty(ProblemDifficulty.MEDIUM)
                .number(2002)
                .build();
    }

    @Override
    public Algorithm<IntegerArrayType, IntegerArrayType> getSimpleAlgorithm() {
        return new ArraySortUsingJavaSort();
    }

    @Override
    public List<Algorithm<IntegerArrayType, IntegerArrayType>> getAdvancedAlgorithms() {
        return List.of(new SequentialMergeSort(), new ParallelMergeSort());
    }

    @Override
    public Iterator<IntegerArrayType> getInputGenerator() {
        return new RandomIntegerArrayIterator(1000, 8, 1000);
    }

    @Override
    public List<TestData<IntegerArrayType, IntegerArrayType>> getTestDataCollection() {
        TestData<IntegerArrayType, IntegerArrayType> dp1 =
                new TestData<>(new IntegerArrayType(new int[] {3, 5, 4, 2, 1}),
                               new IntegerArrayType(new int[] {1, 2, 3, 4, 5}));
        TestData<IntegerArrayType, IntegerArrayType> dp2 =
                new TestData<>(new IntegerArrayType(new int[] {2, 1, 3, 2, 2}),
                        new IntegerArrayType(new int[] {1, 2, 2, 2, 3}));
        TestData<IntegerArrayType, IntegerArrayType> dp3 =
                new TestData<>(new IntegerArrayType(new int[] {6, 5, 4, 3, 2, 1}),
                        new IntegerArrayType(new int[] {1, 2, 3, 4, 5, 6}));
        TestData<IntegerArrayType, IntegerArrayType> dp4 =
                new TestData<>(new IntegerArrayType(new int[] {}),
                        new IntegerArrayType(new int[] {}));
        TestData<IntegerArrayType, IntegerArrayType> dp5 =
                new TestData<>(new IntegerArrayType(new int[] {2}),
                        new IntegerArrayType(new int[] {2}));
        return List.of(dp1, dp2, dp3, dp4, dp5);
    }

}
