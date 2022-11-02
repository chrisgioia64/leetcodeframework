package test.base.strategy;

import base.strategy.EvaluationStrategy;

import static org.testng.Assert.fail;

/**
 * The evaluation strategy when running TestNG tests
 */
public class TestEvaluationStrategy<X, Y> extends EvaluationStrategy<X, Y> {

    @Override
    protected void incorrectResult(X input, Y actualResult, Y expectedResult) {
        String s = String.format("The algorithm fails for input %s.. Actual output - %s, " +
                        "Expected output - %s",
                input.toString(), actualResult.toString(), expectedResult.toString());
        fail(s);
    }
}
