package javafundamentals.reflection.serialization;

import java.lang.reflect.Field;

public class JsonDeserializer {

    public static <T> T fromJson(String json, Class<T> clazz) throws Exception {

        T object = clazz.getDeclaredConstructor().newInstance();

        json = json.replace("{", "")
                   .replace("}", "")
                   .replace("\"", "");

        String[] pairs = json.split(",");

        for (String pair : pairs) {

            String[] keyValue = pair.split(":");

            String key = keyValue[0];
            String value = keyValue[1];

            Field field = clazz.getDeclaredField(key);
            field.setAccessible(true);

            if (field.getType() == int.class) {
                field.set(object, Integer.parseInt(value));
            } else {
                field.set(object, value);
            }
        }

        return object;
    }
}