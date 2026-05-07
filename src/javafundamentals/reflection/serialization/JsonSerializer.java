package javafundamentals.reflection.serialization;

import java.lang.reflect.Field;

public class JsonSerializer {

    public static String toJson(Object object) throws Exception {

        StringBuilder json = new StringBuilder("{");

        Field[] fields = object.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {

            fields[i].setAccessible(true);

            json.append("\"")
                .append(fields[i].getName())
                .append("\":");

            Object value = fields[i].get(object);

            if (value instanceof String) {
                json.append("\"").append(value).append("\"");
            } else {
                json.append(value);
            }

            if (i < fields.length - 1) {
                json.append(",");
            }
        }

        json.append("}");

        return json.toString();
    }
}