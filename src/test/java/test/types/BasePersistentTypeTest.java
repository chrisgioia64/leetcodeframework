package test.types;

import base.types.persistence.ParameterConversionException;
import base.types.persistence.PersistenceConverter;
import base.types.persistence.PersistentParameterRegistry;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

@Log4j2
public abstract class BasePersistentTypeTest<T> {

    protected final static String VALID_STRINGS = "valid1";
    protected final static String INVALID_STRINGS = "invalid1";
    protected final static String TYPES = "types";

    protected List<String> invalidDatabaseRepresentations;
    protected List<T> persistentTypes;

    public abstract void setupData();

    public Class<?> getTypeClass() {
        return persistentTypes.get(0).getClass();
    }

    @BeforeClass
    public void setup() {
        setupData();
    }

    public Object[][] getData(List<?> list) {
        Object[][] obj = new Object[list.size()][1];
        int i = 0;
        for (Object repr : list) {
            obj[i++][0] = repr;
        }
        return obj;
    }

    @Test(dataProvider = TYPES)
    public void testPersistAndRetrieveGeneric(T type) throws ParameterConversionException {
        PersistenceConverter<T> converter
                = (PersistenceConverter<T>) PersistentParameterRegistry.getInstance().getConverter(type.getClass());
        log.info("original type: " + type.toString());
        String dbRepresentation = converter.getDatabaseConversion(type);
        log.info("db representation: " + dbRepresentation);
        T retrievedType = converter.getJavaType(dbRepresentation);
        assertEquals(retrievedType, type);
    }

    @Test(dataProvider = BasePersistentTypeTest.INVALID_STRINGS)
    public void testInvalidRepresentations(String invalidRepresentation) {
        try {
            PersistenceConverter<T> converter
                    = (PersistenceConverter<T>) PersistentParameterRegistry.getInstance().getConverter(getTypeClass());
            T retrievedType = converter.getJavaType(invalidRepresentation);
            log.info("Returned value: " + retrievedType.toString());
            fail("should have thrown an exception");
        } catch (ParameterConversionException ex) {
            assertTrue(true);
        }
    }


    @DataProvider(name = INVALID_STRINGS)
    public Object[][] getInvalidData() {
        return getData(invalidDatabaseRepresentations);
    }

    @DataProvider(name = TYPES)
    public Object[][] getTypes() {
        return getData(persistentTypes);
    }

}
