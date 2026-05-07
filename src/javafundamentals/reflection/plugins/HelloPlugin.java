package javafundamentals.reflection.plugins;

@PluginMetadata(name = "hello")
public class HelloPlugin implements Plugin {

    @Override
    public void execute() {
        System.out.println("Hola desde el plugin");
    }
}