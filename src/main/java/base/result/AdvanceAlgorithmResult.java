package base.result;

import base.Algorithm;
import lombok.Builder;
import lombok.Getter;

import java.util.List;


public class AdvanceAlgorithmResult<X, Y> extends AlgorithmResult<X, Y> {

    @Getter
    private final Algorithm<X, Y> advanceAlgorithm;

    AdvanceAlgorithmResult(List<TestResult<X, Y>> results, Algorithm<X, Y> simpleAlgorithm,
                           Algorithm<X, Y> advanceAlgorithm) {
        super(results, simpleAlgorithm);
        this.advanceAlgorithm = advanceAlgorithm;
    }

}
