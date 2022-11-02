package base.types.persistence;

import base.types.IntegerArrayType;

import java.util.Arrays;

public class IntegerArrayConverter implements PersistenceConverter<IntegerArrayType> {

    @Override
    public String getDatabaseConversion(IntegerArrayType type) {
        StringBuilder b = new StringBuilder();
        b.append("[");
        for (int x : type.getAry()) {
            b.append(x + ",");
        }
        b.append("]");
        return b.toString();
    }

    @Override
    public IntegerArrayType getJavaType(String databaseString) throws ParameterConversionException {
        if (databaseString.length() < 2) {
            throw new ParameterConversionException(IntegerArrayConverter.class, databaseString);
        }
        if (databaseString.charAt(0) != '['
                || databaseString.charAt(databaseString.length()-1) != ']') {
            throw new ParameterConversionException(IntegerArrayConverter.class, databaseString);
        }
        String stripped = databaseString.substring(1, databaseString.length()-1);
        String[] elements = stripped.split(",");
        System.out.println(Arrays.toString(elements));
        if (elements.length == 1 && elements[0].equals("")) {
            return new IntegerArrayType(new int[0]);
        }
        int n = elements.length;
        int[] ary = new int[n];
        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];
            try {
                int x = Integer.parseInt(element);
                ary[i] = x;
            } catch (NumberFormatException ex) {
                String msg = String.format("The element %s could not be converted to an integer",
                        element);
                throw new ParameterConversionException(msg);
            }
        }
        return new IntegerArrayType(ary);
    }
}
