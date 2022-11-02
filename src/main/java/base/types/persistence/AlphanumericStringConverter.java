package base.types.persistence;

public class AlphanumericStringConverter implements PersistenceConverter<String> {

    @Override
    public String getDatabaseConversion(String type) {
        return type;
    }

    @Override
    public String getJavaType(String databaseString) throws ParameterConversionException {
        char[] ary = databaseString.toCharArray();
        for (char c : ary) {
            if (!isAlphanumeric(c)) {
                throw new ParameterConversionException(
                        AlphanumericStringConverter.class, databaseString);
            }
        }
        return databaseString;
    }

    public static boolean isAlphanumeric(char c) {
        int index = c - '0';
        if (index >= 0 && index <= 9) {
            return true;
        }
        index = c - 'a';
        if (index >= 0 && index <= 25) {
            return true;
        }
        index = c - 'A';
        if (index >= 0 && index <= 25) {
            return true;
        }
        return false;
    }
}
