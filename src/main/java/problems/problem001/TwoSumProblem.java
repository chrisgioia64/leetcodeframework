package problems.problem001;

import base.algorithm.Algorithm;
import base.problem.*;
import base.types.IntegerArrayType;
import base.types.TwoSumType;
import base.utils.TwoSumTargetIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TwoSumProblem extends ProblemComponents<TwoSumType, IntegerArrayType> {

    @Override
    public ProblemInformation getProblemInformation() {
        return ProblemInformation.builder()
                .name("Two Sum")
                .difficulty(ProblemDifficulty.EASY)
                .number(1)
                .build();
    }

    @Override
    public Algorithm<TwoSumType, IntegerArrayType> getSimpleAlgorithm() {
        return new TwoSumSimple();
    }

    @Override
    public List<Algorithm<TwoSumType, IntegerArrayType>> getAdvancedAlgorithms() {
        return Arrays.asList(new TwoSumHash());
    }

    @Override
    public Iterator<TwoSumType> getInputGenerator() {
        return new TwoSumTargetIterator(
                Arrays.asList(3, 5, 7)
        );
    }

    @Override
    public List<TestData<TwoSumType, IntegerArrayType>> getTestDataCollection() {
        TestData<TwoSumType, IntegerArrayType> inp1 =
                new TestData<>(new TwoSumType(new int[] {1, 4, 6, 10}, 5),
                        new IntegerArrayType(new int[] {0, 1}));
        TestData<TwoSumType, IntegerArrayType> inp2 =
                new TestData<>(new TwoSumType(new int[] {1, 4, 6, 10}, 7),
                        new IntegerArrayType(new int[] {0, 2}));
        TestData<TwoSumType, IntegerArrayType> inp3 =
                new TestData<>(new TwoSumType(new int[] {1, 4, 6, 10}, 10),
                        new IntegerArrayType(new int[] {1, 2}));
        TestData<TwoSumType, IntegerArrayType> inp4 =
                new TestData<>(new TwoSumType(new int[] {1, 4, 6, 10}, 16),
                        new IntegerArrayType(new int[] {2, 3}));
        TestData<TwoSumType, IntegerArrayType> inp5 =
                new TestData<>(new TwoSumType(new int[] {4, 10, 6, 1}, 5),
                        new IntegerArrayType(new int[] {0, 3}));
        TestData<TwoSumType, IntegerArrayType> inp6 =
                new TestData<>(new TwoSumType(new int[] {4, 10, 6, 1}, 5),
                        new IntegerArrayType(new int[] {3, 0}));
        TestData<TwoSumType, IntegerArrayType> inp7 =
                new TestData<>(new TwoSumType(new int[] {4, 10, 6, 1}, 16),
                        new IntegerArrayType(new int[] {1, 2}));
        TestData<TwoSumType, IntegerArrayType> inp8 =
                new TestData<>(new TwoSumType(new int[] {4, 10, 6, 1}, 16),
                        new IntegerArrayType(new int[] {2, 1}));
        TestData<TwoSumType, IntegerArrayType> inp9 =
                new TestData<>(new TwoSumType(new int[] {-3, 8, 16, 1, 19, 12, 10, 5, 18}, 20),
                        new IntegerArrayType(new int[] {1, 5}));
        TestData<TwoSumType, IntegerArrayType> inp10 =
                new TestData<>(new TwoSumType(new int[] {-3, 8, 16, 1, 19, 12, 10, 5, 18}, 20),
                        new IntegerArrayType(new int[] {5, 1}));
        return List.of(inp1, inp2, inp3, inp4, inp5, inp6, inp7, inp8, inp9, inp10);
    }

    @Override
    public SimilarityFunction<TwoSumType, IntegerArrayType> getSimilarityFunction() {
        return (input, output1, output2) -> {
            int[] o1 = output1.getAry();
            int[] o2 = output2.getAry();
            return (o1[0] == o2[0] && o1[1] == o2[1]) || (o1[0] == o2[1] && o1[1] == o2[0]);
        };
    }
}
