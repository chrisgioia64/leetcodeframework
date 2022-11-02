package base.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
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

    public static void main(String[] args) {
        int[] ary1 = new int[] {1, 2, 3};
        int[] ary2 = new int[] {1, 2, 3};
        System.out.println(Arrays.hashCode(ary1));
        System.out.println(Arrays.hashCode(ary2));
    }


}
