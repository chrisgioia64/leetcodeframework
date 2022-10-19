package base.problem.problem005;

import base.*;

import java.util.Collections;
import java.util.List;

public class PalindromicSubstringTemplate implements BootstrapTemplate<String, String> {

    @Override
    public Algorithm<String, String> simpleAlgorithm() {
        return (String x) -> "";
    }

    @Override
    public Algorithm<String, String> advancedAlgorithm() {
        return (String x) -> "";
    }

    @Override
    public InputGenerator<String> inputGenerator() {
        return null;
    }

    @Override
    public List<TestData<String, String>> testDataCollection() {
        TestData<String, String> inp1
                = new TestData<>("abbca","bb");
        TestData<String, String> inp2
                = new TestData<>("ababcdb","aba");
        TestData<String, String> inp3
                = new TestData<>("abcabc","a");
        TestData<String, String> inp4
                = new TestData<>("xabbayzzz","abba");
        return List.of(inp1, inp2, inp3, inp4);
    }

    @Override
    public SimilarityFunction<String, String> similarityFunction() {
        return (String input, String actualOutput, String expectedOutput) -> {
            if (actualOutput.length() != expectedOutput.length()) {
                return false;
            }
            for (int i = 0; i < input.length() - actualOutput.length() + 1; i++) {
                if (input.substring(i, i + actualOutput.length()).equals(expectedOutput)) {
                    return true;
                }
            }
            return false;
        };
    }
}
