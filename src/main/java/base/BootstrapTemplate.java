package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.List;

public abstract class BootstrapTemplate<X, Y> {

    private final static Logger LOGGER = LogManager.getLogger(BootstrapTemplate.class);

    public void templateMethod() {
        LOGGER.info("Starting template method. ");
        SimilarityFunction<X, Y> similarityFunction = similarityFunction();

        // Test the simple algorithm
        Algorithm<X, Y> simpleAlgorithm = simpleAlgorithm();
        List<TestData<X, Y>> testDataCollection = testDataCollection();
        for (TestData<X, Y> testData : testDataCollection) {
            X input = testData.getInput();
            Y output = testData.getOutput();
            Y actualOutput = simpleAlgorithm.performAlgorithm(input);
            if (!similarityFunction.isSimilar(input, actualOutput, output)) {
                System.out.println("Simple Algorithm: " + input + " -> " + actualOutput + " vs. " + output);
            }
        }

        // Test the advanced algorithm
        Iterator<X> iterator = inputGenerator();
        Algorithm<X, Y> advanceAlgorithm = advancedAlgorithm();
        while (iterator.hasNext()) {
            X input = iterator.next();
            Y expectedOutput = simpleAlgorithm.performAlgorithm(input);
            Y actualOutput = advanceAlgorithm.performAlgorithm(input);
            if (!similarityFunction.isSimilar(input, actualOutput, expectedOutput)) {
                System.out.println("Advance Algorithm: " + input + " -> " + actualOutput + " vs. " + expectedOutput);
                break;
            }
        }
    }

    public abstract Algorithm<X, Y> simpleAlgorithm();

    public abstract Algorithm<X, Y> advancedAlgorithm();

    public abstract Iterator<X> inputGenerator();

    public abstract List<TestData<X, Y>> testDataCollection();

    public SimilarityFunction<X, Y> similarityFunction() {
        return (input, actualOutput, expectedOutput) -> actualOutput.equals(expectedOutput);
    }

}
