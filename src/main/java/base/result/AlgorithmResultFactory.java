package base.result;

import base.Algorithm;

import java.util.List;

public class AlgorithmResultFactory {

    /**
     * Factory method.
     */
    public static <X, Y> SimpleAlgorithmResult<X, Y> createSimpleAlgorithmResult(
            List<TestResult<X, Y>> results,
            Algorithm<X, Y> algorithm) {
        return new SimpleAlgorithmResult<X, Y>(results, algorithm);
    }

    /**
     * Factory method.
     */
    public static <X, Y> AdvanceAlgorithmResult<X, Y> createAdvancedAlgorithmResult(
            List<TestResult<X, Y>> results,
            Algorithm<X, Y> simpleAlgorithm,
            Algorithm<X, Y> advancedAlgorithm) {
        return new AdvanceAlgorithmResult<X, Y>(results, simpleAlgorithm, advancedAlgorithm);
    }


}
