package base.strategy;

import base.algorithm.Algorithm;
import base.problem.ProblemComponents;
import base.problem.SimilarityFunction;
import base.problem.TestData;
import base.result.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Log4j2
public abstract class EvaluationStrategy<X, Y> {

    private ProblemComponents<X, Y> problem;

    public SimpleAlgorithmResult<X, Y> testSimpleAlgorithm() {
        log.info("Testing simple algorithm. ");
        SimilarityFunction<X, Y> similarityFunction = problem.getSimilarityFunction();

        // Test the simple algorithm
        List<TestResult<X, Y>> testResultList = new LinkedList<>();
        Algorithm<X, Y> simpleAlgorithm = problem.getSimpleAlgorithm();
        List<TestData<X, Y>> testDataCollection = problem.getTestDataCollection();
        for (TestData<X, Y> testData : testDataCollection) {
            X input = testData.getInput();
            Y output = testData.getOutput();
            Y actualOutput = simpleAlgorithm.performAlgorithm(input);
            boolean isSimilar = similarityFunction.isSimilar(input, actualOutput, output);
            if (!isSimilar) {
                log.info("Incorrect result for simple algorithm " + input + " -> " +
                        actualOutput + " vs. " + output);
                incorrectResult(input, actualOutput, output);
            }
            TestResult<X, Y> testResult = TestResult.<X, Y>builder()
                    .input(input).actualOutput(actualOutput).expectedOutput(output).isSimilar(isSimilar)
                    .build();
            testResultList.add(testResult);
        }

        return AlgorithmResultFactory.createSimpleAlgorithmResult(testResultList, simpleAlgorithm);
    }

    public List<AdvanceAlgorithmResult<X, Y>> testAllAdvancedAlgorithms() {
        List<AdvanceAlgorithmResult<X, Y>> result = new LinkedList<>();
        for (Algorithm<X, Y> advancedAlgorithm : problem.getAdvancedAlgorithms()) {
            result.add(testAdvancedAlgorithm(advancedAlgorithm));
        }
        return result;
    }

    public AdvanceAlgorithmResult<X, Y> testAdvancedAlgorithm(Algorithm<X, Y> advancedAlgorithm) {
        log.info("Testing the advanced algorithm");
        SimilarityFunction<X, Y> similarityFunction = problem.getSimilarityFunction();
        Algorithm<X, Y> simpleAlgorithm = problem.getSimpleAlgorithm();

        List<TestResult<X, Y>> testResultList = new LinkedList<>();
        Iterator<X> iterator = problem.getInputGenerator();
        while (iterator.hasNext()) {
            X input = iterator.next();
            Y expectedOutput = simpleAlgorithm.performAlgorithm(input);
            Y actualOutput = advancedAlgorithm.performAlgorithm(input);
            boolean isSimilar = similarityFunction.isSimilar(input, actualOutput, expectedOutput);
            if (!isSimilar) {
                log.info("Incorrect result for advance algorithm. " + input + " -> "
                        + actualOutput + " vs. " + expectedOutput);
                incorrectResult(input, actualOutput, expectedOutput);
            }
            TestResult<X, Y> testResult = TestResult.<X, Y>builder()
                    .input(input).actualOutput(actualOutput).expectedOutput(expectedOutput).isSimilar(isSimilar)
                    .build();
            testResultList.add(testResult);
        }

        return AlgorithmResultFactory.createAdvancedAlgorithmResult(testResultList,
                simpleAlgorithm, advancedAlgorithm);
    }

    /**
     * Test the simple algorithm against the manually provided test data,
     * and then test all advanced algorithms against the simple algorithm (assuming correct)
     *  against the auto-generated input data
     */
    public BootstrapAlgorithmResult<X, Y> standardBootstrap() {
        SimpleAlgorithmResult<X, Y> simpleResult = testSimpleAlgorithm();
        List<AdvanceAlgorithmResult<X, Y>> advancedResult = testAllAdvancedAlgorithms();
        return new BootstrapAlgorithmResult<X, Y>(simpleResult, advancedResult);
    }

    /**
     * Let subclasses (application and testing strategies) implement this method
     * to provide custom behavior (e.g. perform an assertion in a unit test)
     */
    protected abstract void incorrectResult(X input, Y actualResult, Y expectedResult);

}
