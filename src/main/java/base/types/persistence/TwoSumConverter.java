package base.types.persistence;

import base.types.IntegerArrayType;
import base.types.TwoSumType;

public class TwoSumConverter implements PersistenceConverter<TwoSumType> {

    @Override
    public String getDatabaseConversion(TwoSumType type) {
        StringBuilder builder = new StringBuilder();
        IntegerArrayConverter intAryConverter = PersistentParameterRegistry.getInstance().getIntegerArrayConverter();
        String intAry = intAryConverter.getDatabaseConversion(new IntegerArrayType(type.getAry()));
        builder.append(intAry);
        builder.append(PersistentParameterConstants.DELIMITER);
        IntegerConverter intConverter = PersistentParameterRegistry.getInstance().getIntegerConverter();
        String intValue = intConverter.getDatabaseConversion(type.getTarget());
        builder.append(intValue);
        return builder.toString();
    }

    @Override
    public TwoSumType getJavaType(String databaseString) throws ParameterConversionException {
        String[] elements = databaseString.split(PersistentParameterConstants.DELIMITER);
        if (elements.length != 2) {
            String msg = "There were not 2 elements for the twosum representation " + databaseString;
            throw new ParameterConversionException(msg);
        }
        IntegerArrayType ary = PersistentParameterRegistry.getInstance().getIntegerArrayConverter()
                .getJavaType(elements[0]);
        Integer target = PersistentParameterRegistry.getInstance().getIntegerConverter()
                .getJavaType(elements[1]);
        TwoSumType twoSumType = new TwoSumType(ary.getAry(), target);
        return twoSumType;
    }
}
