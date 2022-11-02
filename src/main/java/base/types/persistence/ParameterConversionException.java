package base.types.persistence;

public class ParameterConversionException extends Exception {

    public ParameterConversionException(String msg) {
        super(msg);
    }

    public ParameterConversionException(Class<?> clazz, String databaseString) {
        this(String.format("Could not convert the database representation `%s` to ", clazz.getName()));
    }

}
