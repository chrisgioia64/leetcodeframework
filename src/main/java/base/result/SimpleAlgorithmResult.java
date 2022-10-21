package base.result;

import base.Algorithm;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class SimpleAlgorithmResult<X, Y> extends AlgorithmResult<X, Y> {

    protected SimpleAlgorithmResult(List<TestResult<X, Y>> testResults, Algorithm<X, Y> simpleAlgorithm) {
        super(testResults, simpleAlgorithm);
    }

}
