package base;

import java.util.Iterator;
import java.util.List;

public interface BootstrapTemplate<X, Y> {

    default void templateMethod() {
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
        Iterator<X> iterator = inputGenerator().generateInput();
        Algorithm<X, Y> advanceAlgorithm = advancedAlgorithm();
        while (iterator.hasNext()) {
            X input = iterator.next();
            Y expectedOutput = simpleAlgorithm.performAlgorithm(input);
            Y actualOutput = advanceAlgorithm.performAlgorithm(input);
            if (!similarityFunction.isSimilar(input, actualOutput, expectedOutput)) {
                System.out.println("Advance Algorithm: " + input + " -> " + actualOutput + " vs. " + expectedOutput);
            }
        }
    }

    Algorithm<X, Y> simpleAlgorithm();

    Algorithm<X, Y> advancedAlgorithm();

    InputGenerator<X> inputGenerator();

    List<TestData<X, Y>> testDataCollection();

    default SimilarityFunction<X, Y> similarityFunction() {
        return (input, actualOutput, expectedOutput) -> actualOutput.equals(expectedOutput);
    }

}
