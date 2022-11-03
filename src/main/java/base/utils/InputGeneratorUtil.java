package base.utils;

/**
 * Utility methods for generating different inputs for algorithm testing
 */
public class InputGeneratorUtil {

    public static StringProductIterator generateStrings() {
        return new StringProductIterator(5, "abcd");
    }
    

}
