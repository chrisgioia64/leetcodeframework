package base.result;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder
@Value
public class TestResult<X, Y> {

    @NonNull
    private final X input;
    @NonNull
    private final Y actualOutput;
    @NonNull
    private final Y expectedOutput;
    private final boolean isSimilar;

    public static void main(String[] args) {
        TestResult<String, String> testResult = TestResult.<String, String>builder().
                input("Oak").actualOutput("as").expectedOutput("ab").build();
        System.out.println(testResult);
    }
}
