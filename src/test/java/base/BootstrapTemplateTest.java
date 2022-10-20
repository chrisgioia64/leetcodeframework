package base;

import lombok.RequiredArgsConstructor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.fail;

public abstract class BootstrapTemplateTest<X, Y> {

    protected BootstrapTemplate<X, Y> template;

    @BeforeClass
    public abstract void setup();

    @Test
    public void testSimpleAlgorithm() {
        SimilarityFunction<X, Y> similarityFn = template.similarityFunction();
        Algorithm<X, Y> algorithm = template.simpleAlgorithm();
        List<TestData<X, Y>> testData = template.testDataCollection();
        for (TestData<X, Y> testDatum : testData) {
            X input = testDatum.getInput();
            Y expectedOutput = testDatum.getOutput();
            Y actualOutput = algorithm.performAlgorithm(input);
            assertTrue(similarityFn, input, actualOutput, expectedOutput);
        }
    }

    @Test
    public void testAdvanceAlgorithm() {
        SimilarityFunction<X, Y> similarityFn = template.similarityFunction();
        Algorithm<X, Y> simpleAlgorithm = template.advancedAlgorithm();
        Algorithm<X, Y> advancedAlgorithm = template.advancedAlgorithm();
        Iterator<X> iterator = template.inputGenerator();
        while (iterator.hasNext()) {
            X input = iterator.next();
            Y expectedOutput = simpleAlgorithm.performAlgorithm(input);
            Y actualOutput = advancedAlgorithm.performAlgorithm(input);
            assertTrue(similarityFn, input, actualOutput, expectedOutput);
        }
    }

    private void assertTrue(SimilarityFunction<X, Y> fn, X input,
                            Y actualOutput, Y expectedOutput) {
        if (!fn.isSimilar(input, actualOutput, expectedOutput)) {
            String s = String.format("The algorithm fails for input %s.. Actual output - %s, " +
                    "Expected output - %s",
                    input.toString(), actualOutput.toString(), expectedOutput.toString());
            fail(s);
        }
    }

}
