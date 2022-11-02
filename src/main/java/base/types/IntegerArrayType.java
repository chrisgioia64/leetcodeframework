package base.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
@ToString
public class IntegerArrayType {

    private final int[] ary;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IntegerArrayType) {
            IntegerArrayType other = (IntegerArrayType) obj;
            return Arrays.equals(ary, other.ary);
         }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(ary);
    }

}
