package base;

import java.util.Iterator;
import java.util.List;

public abstract class ProblemComponents<X, Y> {

    public abstract Algorithm<X, Y> getSimpleAlgorithm();

    public abstract List<Algorithm<X, Y>> getAdvancedAlgorithms();

    public abstract Iterator<X> getInputGenerator();

    public abstract List<TestData<X, Y>> getTestDataCollection();

    public SimilarityFunction<X, Y> getSimilarityFunction() {
        return (input, actualOutput, expectedOutput) -> actualOutput.equals(expectedOutput);
    }

}
