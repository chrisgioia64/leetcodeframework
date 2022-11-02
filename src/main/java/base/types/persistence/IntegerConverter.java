package base.types.persistence;

public class IntegerConverter implements PersistenceConverter<Integer> {

    @Override
    public String getDatabaseConversion(Integer type) {
        return String.valueOf(type);
    }

    @Override
    public Integer getJavaType(String databaseString) throws ParameterConversionException {
        try {
            int x = Integer.parseInt(databaseString);
            return x;
        } catch (NumberFormatException ex) {
            throw new ParameterConversionException(IntegerConverter.class, databaseString);
        }
    }
}
