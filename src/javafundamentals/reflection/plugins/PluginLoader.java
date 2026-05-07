package javafundamentals.reflection.plugins;

public class PluginLoader {

    public static Plugin loadPlugin(String className) throws Exception {

        Class<?> clazz = Class.forName(className);

        if (!clazz.isAnnotationPresent(PluginMetadata.class)) {
            throw new RuntimeException("La clase no es un plugin válido");
        }

        return (Plugin) clazz.getDeclaredConstructor().newInstance();
    }
}      