package base.types.persistence;

import base.types.IntegerArrayType;
import base.types.TwoSumType;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Log4j2
public class PersistentParameterRegistry {

    private Map<Class<?>, Class<?>> typeToDatabaseParameterMap;

    private Map<Class<?>, PersistenceConverter<?>> converterMap;

    private static PersistentParameterRegistry singleton;

    @Getter
    private IntegerConverter integerConverter;
    @Getter
    private AlphanumericStringConverter stringConverter;
    @Getter
    private IntegerArrayConverter integerArrayConverter;


    private PersistentParameterRegistry() {
        initializeMaps();
    }

    public static PersistentParameterRegistry getInstance() {
        if (singleton == null) {
            singleton = new PersistentParameterRegistry();
        }
        return singleton;
    }

    private void initializeMaps() {
        // this is deprecated
        typeToDatabaseParameterMap = new HashMap<>();

        this.stringConverter = new AlphanumericStringConverter();
        this.integerConverter = new IntegerConverter();
        this.integerArrayConverter = new IntegerArrayConverter();

        converterMap = new HashMap<>();
        converterMap.put(String.class, stringConverter);
        converterMap.put(Integer.class, integerConverter);
        converterMap.put(IntegerArrayType.class, integerArrayConverter);
        converterMap.put(TwoSumType.class, new TwoSumConverter());
    }

    public PersistenceConverter<?> getConverter(Class<?> clazz) {
        return converterMap.get(clazz);
    }

    /**
     * Verifies via reflection that all persistent parameter types have a factory method
     * for creating their type from a database string representation, and that this
     * factory method is annotated with "@ReadFromDb"
     * @return
     */
    public boolean createFromDbMethodExists() {
        for (Class<?> clazz : typeToDatabaseParameterMap.values()) {
            boolean found = false;
            for (Method declaredMethod : clazz.getDeclaredMethods()) {
                if (declaredMethod.isAnnotationPresent(ReadFromDb.class)) {
                    if (declaredMethod.getParameterTypes().length != 1) {
                        log.info("The class " + clazz.getName() + " has a " +
                                "createMethod with the incorrect # of arguments");
                        return false;
                    }
                    Class<?> paramClass = declaredMethod.getParameterTypes()[0];
                    if (paramClass != String.class) {
                        log.info("The class " + clazz.getName() + " has a  " +
                                "method with parameter type " + paramClass.getName());
                        return false;
                    }
                    Class<?> returnType = declaredMethod.getReturnType();
                    if (returnType != clazz) {
                        log.info("The class " + clazz.getName() + " has a " +
                                "method with return type " + returnType.getName());
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                log.info("The class " + clazz.getName() + " has no method marked " +
                        "with the annotation @ReadFromDb");
                return false;
            }
        }
        return true;
    }

    public <T, V> V createTypeFromDatabaseString(T type)  {
        Class<?> typeClass = type.getClass();
        Class<?> parameterClass = typeToDatabaseParameterMap.get(typeClass);
        if (parameterClass != null) {
            Constructor<?>[] constructors = parameterClass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                if (constructor.getParameterTypes().length == 1 &&
                    constructor.getParameterTypes()[0] == typeClass) {
                    try {
                        V v = (V) constructor.newInstance(type);
                        return v;
                    } catch (InstantiationException
                            | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
            throw new IllegalArgumentException("No valid constructor argument for: "
                    + parameterClass.getName());
        } else {
            throw new IllegalArgumentException("The type "
                    + typeClass.getName() + " is not in the registry");
        }
    }

}
