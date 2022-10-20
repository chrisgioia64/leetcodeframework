package base.problem.problem005;

import base.*;
import base.utils.InputGeneratorUtil;

import java.util.Iterator;
import java.util.List;

public class PalindromicSubstringProblem extends ProblemComponents<String, String> {

    @Override
    public Algorithm<String, String> getSimpleAlgorithm() {
        return new PalindromicSubstringSimple();
    }

    @Override
    public List<Algorithm<String, String>> getAdvancedAlgorithms() {
        return List.of(
                new PalindromicSubstringAdvanced()
        );
    }

    @Override
    public Iterator<String> getInputGenerator() {
        return InputGeneratorUtil.generateStrings();
    }

    @Override
    public List<TestData<String, String>> getTestDataCollection() {
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
    public SimilarityFunction<String, String> getSimilarityFunction() {
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