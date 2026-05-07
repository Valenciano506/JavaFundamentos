package TareaReflexion;



import java.io.*;
import java.util.ArrayList;
import java.util.List;



class Jugador implements Serializable {

// Identificador de versión para la serialización binaria.
// Si cambia la estructura de la clase, este número debería actualizarse.
private static final long serialVersionUID = 1L;

private String nombre;
private int    nivel;
private int    puntuacion;
private List<String> inventario;

// La palabra clave 'transient' indica que este campo NO se serializa.
// Útil para datos sensibles (contraseñas) o datos que se recalculan.
private transient String tokenSesion;

// Constructor
public Jugador(String nombre, int nivel, int puntuacion) {
    this.nombre      = nombre;
    this.nivel       = nivel;
    this.puntuacion  = puntuacion;
    this.inventario  = new ArrayList<>();
    this.tokenSesion = "TOKEN-" + nombre.hashCode(); // No se guardará
}

public void agregarItem(String item) {
    inventario.add(item);
}

// Getters
public String       getNombre()      { return nombre; }
public int          getNivel()       { return nivel; }
public int          getPuntuacion()  { return puntuacion; }
public List<String> getInventario()  { return inventario; }
public String       getTokenSesion() { return tokenSesion; }

@Override
public String toString() {
    return String.format(
        "Jugador{nombre='%s', nivel=%d, puntuacion=%d, inventario=%s, token=%s}",
        nombre, nivel, puntuacion, inventario, tokenSesion
    );
}
}



class SerializacionBinaria {

private static final String ARCHIVO = "jugador.ser";

// SERIALIZAR: Objeto → Archivo binario
public static void serializar(Jugador jugador) throws IOException {
    // ObjectOutputStream envuelve un FileOutputStream
    try (ObjectOutputStream oos = new ObjectOutputStream(
                                      new FileOutputStream(ARCHIVO))) {
        oos.writeObject(jugador); // Convierte el objeto a bytes y lo escribe
        System.out.println("[Binario] Jugador serializado en: " + ARCHIVO);
    }
}

// DESERIALIZAR: Archivo binario → Objeto
public static Jugador deserializar() throws IOException, ClassNotFoundException {
    // ObjectInputStream lee los bytes y reconstruye el objeto
    try (ObjectInputStream ois = new ObjectInputStream(
                                     new FileInputStream(ARCHIVO))) {
        Jugador jugador = (Jugador) ois.readObject(); // Cast al tipo esperado
        System.out.println("[Binario] Jugador deserializado desde: " + ARCHIVO);
        return jugador;
    }
}
}



class SerializacionJSON {

// SERIALIZAR: Objeto Jugador → String JSON
public static String serializar(Jugador jugador) {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");

    // Campos simples: nombre, nivel, puntuacion
    sb.append("  \"nombre\": \"").append(jugador.getNombre()).append("\",\n");
    sb.append("  \"nivel\": ").append(jugador.getNivel()).append(",\n");
    sb.append("  \"puntuacion\": ").append(jugador.getPuntuacion()).append(",\n");

    // Campo lista: inventario → array JSON
    sb.append("  \"inventario\": [");
    List<String> items = jugador.getInventario();
    for (int i = 0; i < items.size(); i++) {
        sb.append("\"").append(items.get(i)).append("\"");
        if (i < items.size() - 1) sb.append(", ");
    }
    sb.append("]\n");

    // Nota: tokenSesion NO se incluye (equivalente a 'transient' en binario)
    sb.append("}");
    return sb.toString();
}


public static Jugador deserializar(String json) {
    // Extraemos cada campo con un método auxiliar
    String nombre     = extraerCadena(json, "nombre");
    int    nivel      = Integer.parseInt(extraerValor(json, "nivel"));
    int    puntuacion = Integer.parseInt(extraerValor(json, "puntuacion"));

    Jugador jugador = new Jugador(nombre, nivel, puntuacion);

    // Extraemos el array de inventario
    int inicioArr = json.indexOf("[") + 1;
    int finArr    = json.indexOf("]");
    String contenidoArr = json.substring(inicioArr, finArr).trim();

    if (!contenidoArr.isEmpty()) {
        for (String item : contenidoArr.split(",")) {
            // Limpiamos comillas y espacios de cada elemento
            jugador.agregarItem(item.trim().replace("\"", ""));
        }
    }

    return jugador;
}

// Extrae el valor de un campo entre comillas: "campo": "valor"
private static String extraerCadena(String json, String campo) {
    String patron = "\"" + campo + "\": \"";
    int inicio = json.indexOf(patron) + patron.length();
    int fin    = json.indexOf("\"", inicio);
    return json.substring(inicio, fin);
}

// Extrae el valor de un campo numérico: "campo": valor
private static String extraerValor(String json, String campo) {
    String patron = "\"" + campo + "\": ";
    int inicio = json.indexOf(patron) + patron.length();
    int fin    = json.indexOf("\n", inicio);
    // Elimina la posible coma al final del valor
    return json.substring(inicio, fin).replace(",", "").trim();
}
}



public class SerializacionDeserializacion {

public static void main(String[] args) {

    // Creamos un jugador con datos de ejemplo
    Jugador jugadorOriginal = new Jugador("ElvaQueManda", 42, 15000);
    jugadorOriginal.agregarItem("Espada Legendaria");
    jugadorOriginal.agregarItem("Escudo de Roble");
    jugadorOriginal.agregarItem("Poción de Vida");

    System.out.println("=== OBJETO ORIGINAL ===\n");
    System.out.println(jugadorOriginal);
    System.out.println("(tokenSesion existe en memoria: " + jugadorOriginal.getTokenSesion() + ")");


    System.out.println("\n=== A) SERIALIZACIÓN BINARIA ===\n");

    try {
        // SERIALIZAR: guardamos el jugador en disco
        SerializacionBinaria.serializar(jugadorOriginal);

        // DESERIALIZAR: recuperamos el jugador desde el archivo
        Jugador jugadorRecuperado = SerializacionBinaria.deserializar();

        System.out.println("\nJugador recuperado: " + jugadorRecuperado);
        System.out.println("tokenSesion después de deserializar: "
            + jugadorRecuperado.getTokenSesion()); // → null (era transient)

        // Verificación: ¿los datos son los mismos?
        System.out.println("\n¿Nombre correcto? " +
            jugadorOriginal.getNombre().equals(jugadorRecuperado.getNombre()));
        System.out.println("¿Inventario correcto? " +
            jugadorOriginal.getInventario().equals(jugadorRecuperado.getInventario()));

    } catch (IOException | ClassNotFoundException e) {
        System.err.println("Error en serialización binaria: " + e.getMessage());
    }



    System.out.println("\n=== B) SERIALIZACIÓN A JSON ===\n");

    // SERIALIZAR: objeto → string JSON
    String jsonResultado = SerializacionJSON.serializar(jugadorOriginal);
    System.out.println("JSON generado:\n" + jsonResultado);

    // DESERIALIZAR: string JSON → objeto
    System.out.println("\n--- DESERIALIZANDO JSON ---\n");
    Jugador jugadorDesdeJson = SerializacionJSON.deserializar(jsonResultado);
    System.out.println("Jugador reconstruido: " + jugadorDesdeJson);

    // Verificación de los datos
    System.out.println("\n¿Nivel correcto?      " +
        (jugadorOriginal.getNivel() == jugadorDesdeJson.getNivel()));
    System.out.println("¿Puntuación correcta? " +
        (jugadorOriginal.getPuntuacion() == jugadorDesdeJson.getPuntuacion()));
    System.out.println("¿Inventario correcto? " +
        jugadorOriginal.getInventario().equals(jugadorDesdeJson.getInventario()));



 }
}