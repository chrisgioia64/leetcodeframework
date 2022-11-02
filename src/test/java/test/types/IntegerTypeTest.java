package test.types;

import java.util.Arrays;

public class IntegerTypeTest extends BasePersistentTypeTest<Integer> {

    @Override
    public void setupData() {
        this.invalidDatabaseRepresentations = Arrays.asList("1.0", "566666666663333", "-1-", "1a",
                "1#");
        this.persistentTypes = Arrays.asList(0, 1, 1000000000, -500000000);
    }
}
