package base.strategy;

import base.Algorithm;
import base.ProblemComponents;
import base.SimilarityFunction;
import base.TestData;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.List;

@Getter
@Setter
public abstract class EvaluationStrategy<X, Y> {

    private final static Logger LOGGER = LogManager.getLogger(EvaluationStrategy.class);

    private ProblemComponents<X, Y> problem;

    public void testSimpleAlgorithm() {
        LOGGER.info("Testing simple algorithm. ");
        SimilarityFunction<X, Y> similarityFunction = problem.getSimilarityFunction();

        // Test the simple algorithm
        Algorithm<X, Y> simpleAlgorithm = problem.getSimpleAlgorithm();
        List<TestData<X, Y>> testDataCollection = problem.getTestDataCollection();
        for (TestData<X, Y> testData : testDataCollection) {
            X input = testData.getInput();
            Y output = testData.getOutput();
            Y actualOutput = simpleAlgorithm.performAlgorithm(input);
            if (!similarityFunction.isSimilar(input, actualOutput, output)) {
                LOGGER.info("Incorrect result for simple algorithm " + input + " -> " +
                        actualOutput + " vs. " + output);
            }
        }
    }

    public void testAllAdvancedAlgorithms() {
        for (Algorithm<X, Y> advancedAlgorithm : problem.getAdvancedAlgorithms()) {
            testAdvancedAlgorithm(advancedAlgorithm);
        }
    }

    public void testAdvancedAlgorithm(Algorithm<X, Y> advancedAlgorithm) {
        LOGGER.info("Testing the advanced algorithm");
        SimilarityFunction<X, Y> similarityFunction = problem.getSimilarityFunction();
        Algorithm<X, Y> simpleAlgorithm = problem.getSimpleAlgorithm();

        Iterator<X> iterator = problem.getInputGenerator();
        while (iterator.hasNext()) {
            X input = iterator.next();
            Y expectedOutput = simpleAlgorithm.performAlgorithm(input);
            Y actualOutput = advancedAlgorithm.performAlgorithm(input);
            if (!similarityFunction.isSimilar(input, actualOutput, expectedOutput)) {
                LOGGER.info("Incorrect result for advance algorithm. " + input + " -> "
                        + actualOutput + " vs. " + expectedOutput);
                break;
            }
        }
    }

    /**
     * Test the simple algorithm against the manually provided test data,
     * and then test all advanced algorithms against the simple algorithm (assuming correct)
     *  against the auto-generated input data
     */
    public void standardBootstrap() {
        testSimpleAlgorithm();
        testAllAdvancedAlgorithms();
    }

    protected abstract void incorrectResult(X input, Y actualResult, Y expectedResult);

}
