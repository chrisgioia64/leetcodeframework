package base.utils;

/**
 * Utility methods for generating different inputs for algorithm testing
 */
public class InputGeneratorUtil {

    public static StringPermutationIterator generateStrings() {
        return new StringPermutationIterator(4, "abcd");
    }

}
