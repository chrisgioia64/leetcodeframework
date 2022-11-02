package test.types;

import base.types.IntegerArrayType;

import java.util.Arrays;

public class IntegerArrayTypeTest extends BasePersistentTypeTest<IntegerArrayType> {

    @Override
    public void setupData() {
        this.invalidDatabaseRepresentations = Arrays.asList(
                "[10000000000000000000,]", "[10,15,0.4,]", "[45,a,50,]", "[1", "", "]"
        );
        this.persistentTypes = Arrays.asList(
                new IntegerArrayType(new int[] {1, 5, -101, 10000000}),
                new IntegerArrayType(new int[] {}),
                new IntegerArrayType(new int[] {-6000009})
                );
    }
}
