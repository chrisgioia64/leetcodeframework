package problems.problemB001;

import base.algorithm.Algorithm;
import base.problem.ProblemComponents;
import base.problem.ProblemDifficulty;
import base.problem.ProblemInformation;
import base.problem.TestData;
import base.types.IntegerArrayType;
import base.utils.NextArrayIteratorNaive;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NextArrayProblem extends ProblemComponents<IntegerArrayType, IntegerArrayType> {

    @Override
    public ProblemInformation getProblemInformation() {
        return ProblemInformation.builder()
                .number(2001)
                .name("Get the next array in sequence")
                .difficulty(ProblemDifficulty.MEDIUM)
                .build();
    }

    @Override
    public Algorithm<IntegerArrayType, IntegerArrayType> getSimpleAlgorithm() {
        return new NextArraySimple();
    }

    @Override
    public List<Algorithm<IntegerArrayType, IntegerArrayType>> getAdvancedAlgorithms() {
        return List.of(new NextArrayAdvanced());
    }

    @Override
    public Iterator<IntegerArrayType> getInputGenerator() {
        return new NextArrayIteratorNaive(5);
    }

    @Override
    public List<TestData<IntegerArrayType, IntegerArrayType>> getTestDataCollection() {
        TestData<IntegerArrayType, IntegerArrayType> dp1 =
                new TestData<>(new IntegerArrayType(new int[] {0}),
                               new IntegerArrayType(new int[] {1}));
        TestData<IntegerArrayType, IntegerArrayType> dp2 =
                new TestData<>(new IntegerArrayType(new int[] {1}),
                        new IntegerArrayType(new int[] {0}));
        TestData<IntegerArrayType, IntegerArrayType> dp3 =
                new TestData<>(new IntegerArrayType(new int[] {0, 0, 0}),
                        new IntegerArrayType(new int[] {0, 0, 1}));
        TestData<IntegerArrayType, IntegerArrayType> dp4 =
                new TestData<>(new IntegerArrayType(new int[] {0, 0, 1}),
                        new IntegerArrayType(new int[] {0, 1, 0}));
        TestData<IntegerArrayType, IntegerArrayType> dp5 =
                new TestData<>(new IntegerArrayType(new int[] {0, 1, 1}),
                        new IntegerArrayType(new int[] {1, 0, 0}));
        TestData<IntegerArrayType, IntegerArrayType> dp6 =
                new TestData<>(new IntegerArrayType(new int[] {1, 0, 0}),
                        new IntegerArrayType(new int[] {1, 0, 1}));
        TestData<IntegerArrayType, IntegerArrayType> dp7 =
                new TestData<>(new IntegerArrayType(new int[] {1, 0, 1}),
                        new IntegerArrayType(new int[] {1, 1, 0}));
        TestData<IntegerArrayType, IntegerArrayType> dp8 =
                new TestData<>(new IntegerArrayType(new int[] {1, 1, 1}),
                        new IntegerArrayType(new int[] {0, 0, 0}));
        return List.of(dp1, dp2, dp3, dp4, dp5, dp6, dp7, dp8);
    }
}
