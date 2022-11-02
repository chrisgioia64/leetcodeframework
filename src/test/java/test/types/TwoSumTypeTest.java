package test.types;

import base.types.TwoSumType;

import java.util.Arrays;

public class TwoSumTypeTest extends BasePersistentTypeTest<TwoSumType> {

    @Override
    public void setupData() {
        this.invalidDatabaseRepresentations = Arrays.asList("[1,2,3];5.0", "5;5", "[1,2,3,4,5]");
        this.persistentTypes = Arrays.asList(
          new TwoSumType(new int[] {1, 2, 3, 4}, 6),
            new TwoSumType(new int[] {}, 6),
            new TwoSumType(new int[] {-56, 200}, 100000)
        );
    }
}
