package base.types.persistence;

public interface PersistenceConverter<T> {

    public String getDatabaseConversion(T type);

    public T getJavaType(String databaseString) throws ParameterConversionException;

}
