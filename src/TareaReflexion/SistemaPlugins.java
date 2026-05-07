package TareaReflexion;

// ============================================================
//  CONCEPTO 2: SISTEMA DE PLUGINS
// ============================================================
//
//  ¿Qué es?
//  Un sistema de plugins permite extender la funcionalidad de
//  una aplicación SIN modificar su código original.
//  Los plugins se registran dinámicamente y la aplicación
//  los descubre y ejecuta en tiempo de ejecución.
//
//  Casos reales: navegadores (extensiones), IDEs (plugins de
//  IntelliJ/VS Code), editores de imágenes (filtros), etc.
//
//  Componentes del patrón:
//    1. Interfaz Plugin  → el "contrato" que todo plugin debe cumplir
//    2. Plugins concretos → implementaciones específicas
//    3. PluginManager    → registra y ejecuta los plugins
//    4. Aplicación       → usa el manager sin conocer los plugins
// ============================================================


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// --- PASO 1: Definir la INTERFAZ del Plugin ---
// Todos los plugins DEBEN implementar esta interfaz.
// Es el contrato entre la aplicación y sus extensiones.
interface Plugin {

    // Nombre único que identifica al plugin
    String getNombre();

    // Descripción de lo que hace el plugin
    String getDescripcion();

    // Método principal que ejecuta la lógica del plugin.
    // Recibe texto de entrada y devuelve texto procesado.
    String ejecutar(String entrada);
}


// ============================================================
// --- PASO 2: Plugins CONCRETOS ---
// Cada uno extiende la app con una funcionalidad nueva,
// sin tocar el código de la aplicación principal.
// ============================================================

// Plugin que convierte el texto a MAYÚSCULAS
class PluginMayusculas implements Plugin {

    @Override
    public String getNombre() { return "mayusculas"; }

    @Override
    public String getDescripcion() { return "Convierte el texto a MAYÚSCULAS"; }

    @Override
    public String ejecutar(String entrada) {
        return entrada.toUpperCase();
    }
}

// Plugin que INVIERTE el texto carácter a carácter
class PluginInvertir implements Plugin {

    @Override
    public String getNombre() { return "invertir"; }

    @Override
    public String getDescripcion() { return "Invierte el texto (ej: 'Hola' → 'aloH')"; }

    @Override
    public String ejecutar(String entrada) {
        return new StringBuilder(entrada).reverse().toString();
    }
}

// Plugin que CIFRA el texto con el cifrado César (desplazamiento de 3)
class PluginCifradoCesar implements Plugin {

    private static final int DESPLAZAMIENTO = 3;

    @Override
    public String getNombre() { return "cesar"; }

    @Override
    public String getDescripcion() {
        return "Cifra el texto con el cifrado César (desplazamiento +" + DESPLAZAMIENTO + ")";
    }

    @Override
    public String ejecutar(String entrada) {
        StringBuilder resultado = new StringBuilder();
        for (char c : entrada.toCharArray()) {
            if (Character.isLetter(c)) {
                // Desplaza dentro del alfabeto (respeta mayúsculas/minúsculas)
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                resultado.append((char) ((c - base + DESPLAZAMIENTO) % 26 + base));
            } else {
                resultado.append(c); // Deja los espacios y símbolos igual
            }
        }
        return resultado.toString();
    }
}

// Plugin que CUENTA estadísticas básicas del texto
class PluginEstadisticas implements Plugin {

    @Override
    public String getNombre() { return "estadisticas"; }

    @Override
    public String getDescripcion() { return "Muestra estadísticas del texto"; }

    @Override
    public String ejecutar(String entrada) {
        int palabras = entrada.trim().isEmpty() ? 0 : entrada.trim().split("\\s+").length;
        long vocales = entrada.chars()
                              .filter(c -> "aeiouAEIOU".indexOf(c) >= 0)
                              .count();
        return String.format(
            "Caracteres: %d | Palabras: %d | Vocales: %d",
            entrada.length(), palabras, vocales
        );
    }
}


// ============================================================
// --- PASO 3: El GESTOR DE PLUGINS (PluginManager) ---
// Es el corazón del sistema. Se encarga de:
//   - Registrar nuevos plugins
//   - Listar los disponibles
//   - Ejecutar un plugin por nombre
// ============================================================
class PluginManager {

    // Mapa que almacena los plugins registrados (nombre → plugin)
    private final Map<String, Plugin> plugins = new HashMap<>();

    // Registra un plugin en el sistema
    public void registrar(Plugin plugin) {
        plugins.put(plugin.getNombre(), plugin);
        System.out.println("[Manager] Plugin registrado: '" + plugin.getNombre() + "'");
    }

    // Devuelve la lista de plugins disponibles
    public List<Plugin> getPluginsDisponibles() {
        return new ArrayList<>(plugins.values());
    }

    // Ejecuta un plugin por su nombre sobre el texto de entrada
    public String ejecutarPlugin(String nombrePlugin, String texto) {
        Plugin plugin = plugins.get(nombrePlugin);

        if (plugin == null) {
            return "[ERROR] Plugin '" + nombrePlugin + "' no encontrado.";
        }

        System.out.println("[Manager] Ejecutando plugin: '" + nombrePlugin + "'");
        return plugin.ejecutar(texto);
    }

    // Aplica TODOS los plugins registrados en cadena (pipeline)
    public String ejecutarTodos(String texto) {
        System.out.println("[Manager] Ejecutando pipeline con todos los plugins...");
        String resultado = texto;
        for (Plugin plugin : plugins.values()) {
            resultado = plugin.ejecutar(resultado);
        }
        return resultado;
    }
}


// ============================================================
// --- CLASE PRINCIPAL: Punto de entrada del programa ---
// ============================================================
public class SistemaPlugins {

    public static void main(String[] args) {

        // La aplicación solo conoce el PluginManager, no los plugins concretos
        PluginManager manager = new PluginManager();

        System.out.println("=== REGISTRANDO PLUGINS ===\n");

        // Los plugins se registran dinámicamente (podrían venir de un JAR externo)
        manager.registrar(new PluginMayusculas());
        manager.registrar(new PluginInvertir());
        manager.registrar(new PluginCifradoCesar());
        manager.registrar(new PluginEstadisticas());

        System.out.println("\n=== PLUGINS DISPONIBLES ===\n");

        for (Plugin p : manager.getPluginsDisponibles()) {
            System.out.printf("  %-16s → %s%n", p.getNombre(), p.getDescripcion());
        }

        String textoOriginal = "Hola Mundo";
        System.out.println("\n=== EJECUTANDO PLUGINS INDIVIDUALMENTE ===");
        System.out.println("Texto original: \"" + textoOriginal + "\"\n");

        String resultado1 = manager.ejecutarPlugin("mayusculas", textoOriginal);
        System.out.println("Resultado [mayusculas]:    " + resultado1);

        String resultado2 = manager.ejecutarPlugin("invertir", textoOriginal);
        System.out.println("Resultado [invertir]:      " + resultado2);

        String resultado3 = manager.ejecutarPlugin("cesar", textoOriginal);
        System.out.println("Resultado [cesar]:         " + resultado3);

        String resultado4 = manager.ejecutarPlugin("estadisticas", textoOriginal);
        System.out.println("Resultado [estadisticas]:  " + resultado4);

        System.out.println("\n=== INTENTAR PLUGIN INEXISTENTE ===\n");
        System.out.println(manager.ejecutarPlugin("plugin_fantasma", textoOriginal));

        // -------------------------------------------------------
        // VENTAJAS CLAVE DEL SISTEMA DE PLUGINS:
        //
        //  ✔ Open/Closed Principle: la app está abierta a extensión,
        //    cerrada a modificación
        //  ✔ Nuevos plugins se añaden SIN tocar código existente
        //  ✔ Fácil de probar cada plugin de forma aislada
        //  ✔ Arquitectura escalable usada en IDEs, navegadores, etc.
        // -------------------------------------------------------
    }
}