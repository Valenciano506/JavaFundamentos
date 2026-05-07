package javafundamentals.reflection.di;

import java.lang.reflect.Field;

public class DIContainer {

    public static <T> T createInstance(Class<T> clazz) throws Exception {

        T instance = clazz.getDeclaredConstructor().newInstance();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(Inject.class)) {

                Object dependency = field.getType()
                        .getDeclaredConstructor()
                        .newInstance();

                field.setAccessible(true);
                field.set(instance, dependency);
            }
        }

        return instance;
    }
}