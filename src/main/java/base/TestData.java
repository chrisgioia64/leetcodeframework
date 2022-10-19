package base;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestData<X, Y> {

    private final X input;
    private final Y output;

}
