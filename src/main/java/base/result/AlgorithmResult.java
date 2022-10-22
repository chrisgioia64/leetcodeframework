package base.result;

import base.Algorithm;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

public abstract class AlgorithmResult<X, Y> {

    @Getter
    protected final List<TestResult<X, Y>> results;

    @Getter
    protected final Algorithm<X, Y> simpleAlgorithm;

    @Getter
    protected int numCorrect;

    protected AlgorithmResult(List<TestResult<X, Y>> results, Algorithm<X, Y> simpleAlgorithm) {
        this.results = results;
        this.simpleAlgorithm = simpleAlgorithm;
        computeStatistics();
    }

    protected void computeStatistics() {
        int numCorrect = 0;
        for (TestResult result : results) {
            if (result.isSimilar()) {
                numCorrect++;
            }
        }
    }

}
