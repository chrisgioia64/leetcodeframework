package test.types;

import base.types.persistence.AlphanumericStringConverter;
import base.types.persistence.ParameterConversionException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class AlphanumericStringTest extends BasePersistentTypeTest<String> {

    public static final String IS_ALPHANUMERIC = "isAlphanumeric";

    @Test(dataProvider = IS_ALPHANUMERIC)
    public void testIsAlphanumericMethod(char c, boolean isAlphanumeric) {
        if (isAlphanumeric) {
            assertTrue(AlphanumericStringConverter.isAlphanumeric(c));
        } else {
            assertFalse(AlphanumericStringConverter.isAlphanumeric(c));
        }
    }

    @DataProvider(name = IS_ALPHANUMERIC)
    public Object[][] getDataProvider() {
        Object[][] result = new Object[14][2];
        result[0] = new Object[] {'a', true};
        result[1] = new Object[] {'c', true};
        result[2] = new Object[] {'z', true};
        result[3] = new Object[] {'A', true};
        result[4] = new Object[] {'C', true};
        result[5] = new Object[] {'Z', true};
        result[6] = new Object[] {'0', true};
        result[7] = new Object[] {'1', true};
        result[8] = new Object[] {'9', true};
        result[9] = new Object[] {'!', false};
        result[10] = new Object[] {'_', false};
        result[11] = new Object[] {'~', false};
        result[12] = new Object[] {'[', false};
        result[13] = new Object[] {'$', false};
        return result;
    }

    @Override
    public void setupData() {
        this.invalidDatabaseRepresentations = Arrays.asList("az!", "#", "b0_b");
        this.persistentTypes = Arrays.asList("abc123", "aABC4Z", "abcABCXYZ123");
    }

}
