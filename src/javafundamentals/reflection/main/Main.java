package javafundamentals.reflection.main;

import javafundamentals.reflection.di.DIContainer;
import javafundamentals.reflection.di.UserService;
import javafundamentals.reflection.plugins.Plugin;
import javafundamentals.reflection.plugins.PluginLoader;
import javafundamentals.reflection.plugins.HelloPlugin;
import javafundamentals.reflection.serialization.JsonDeserializer;
import javafundamentals.reflection.serialization.JsonSerializer;
import javafundamentals.reflection.serialization.Person;

public class Main {

    public static void main(String[] args) {

        try {

            System.out.println("=== INYECCION DE DEPENDENCIAS ===");

            UserService service = DIContainer.createInstance(UserService.class);
            service.registerUser("Carlos");

            System.out.println("\n=== SERIALIZACION JSON ===");

            Person person = new Person("Ana", 22);

            String json = JsonSerializer.toJson(person);

            System.out.println("JSON: " + json);

            Person newPerson =
                    JsonDeserializer.fromJson(json, Person.class);

            System.out.println("Objeto: "
                    + newPerson.getName()
                    + " - "
                    + newPerson.getAge());

            System.out.println("\n=== SISTEMA DE PLUGINS ===");

            Plugin plugin = PluginLoader.loadPlugin(
                    "javafundamentals.reflection.plugins.HelloPlugin");

            plugin.execute();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}