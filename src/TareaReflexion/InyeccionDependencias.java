package TareaReflexion;

// ============================================================
//  CONCEPTO 1: INYECCIÓN DE DEPENDENCIAS (Dependency Injection)
// ============================================================
//
//  ¿Qué es?
//  La inyección de dependencias es un patrón de diseño en el que
//  un objeto NO crea sus propias dependencias, sino que las recibe
//  desde el exterior. Esto hace que el código sea más flexible,
//  testeable y fácil de mantener.
//
//  Hay 3 tipos principales:
//    1. Inyección por CONSTRUCTOR (la más recomendada)
//    2. Inyección por SETTER
//    3. Inyección por INTERFAZ
//
//  En este ejemplo modelamos un sistema de notificaciones donde
//  un servicio puede enviar mensajes por Email o por SMS,
//  sin estar atado a ninguna implementación concreta.
// ============================================================


// --- PASO 1: Definir una INTERFAZ (el "contrato") ---
// La interfaz define QUÉ se puede hacer, sin decir CÓMO.
// Esto es clave: nuestro código dependerá de la abstracción,
// no de una implementación concreta.
interface Notificador {
    void enviarMensaje(String destinatario, String mensaje);
}


// --- PASO 2: Implementaciones concretas ---

// Implementación que envía notificaciones por EMAIL
class NotificadorEmail implements Notificador {
    @Override
    public void enviarMensaje(String destinatario, String mensaje) {
        // En un caso real, aquí iría la lógica de envío de email
        System.out.println("[EMAIL] Para: " + destinatario);
        System.out.println("        Mensaje: " + mensaje);
    }
}

// Implementación que envía notificaciones por SMS
class NotificadorSMS implements Notificador {
    @Override
    public void enviarMensaje(String destinatario, String mensaje) {
        // En un caso real, aquí iría la lógica de envío de SMS
        System.out.println("[SMS] Para: " + destinatario);
        System.out.println("      Mensaje: " + mensaje);
    }
}


// --- PASO 3: La clase que USA la dependencia ---
// ServicioUsuario necesita un Notificador para funcionar.
// En lugar de crearlo internamente (acoplamiento fuerte),
// lo RECIBE desde fuera (inyección de dependencias).
class ServicioUsuario {

    // Dependencia declarada como interfaz, no como clase concreta
    private final Notificador notificador;

    // =============================================
    // TIPO 1: INYECCIÓN POR CONSTRUCTOR
    // La dependencia se pasa al crear el objeto.
    // Es la forma más recomendada porque garantiza
    // que el objeto siempre tiene lo que necesita.
    // =============================================
    public ServicioUsuario(Notificador notificador) {
        this.notificador = notificador;
    }

    // Método que usa la dependencia inyectada
    public void registrarUsuario(String nombre, String contacto) {
        System.out.println(">> Registrando usuario: " + nombre);
        // No sabe NI LE IMPORTA si es Email o SMS; solo usa la interfaz
        notificador.enviarMensaje(contacto, "¡Bienvenido, " + nombre + "!");
    }
}


// --- PASO 4: Clase con inyección por SETTER (alternativa) ---
// Útil cuando la dependencia es opcional o puede cambiar en tiempo de ejecución
class ServicioReportes {

    private Notificador notificador; // Puede ser null inicialmente

    // =============================================
    // TIPO 2: INYECCIÓN POR SETTER
    // La dependencia se asigna después de crear el objeto.
    // Permite cambiar el notificador en cualquier momento.
    // =============================================
    public void setNotificador(Notificador notificador) {
        this.notificador = notificador;
    }

    public void generarReporte(String admin) {
        if (notificador != null) {
            notificador.enviarMensaje(admin, "El reporte mensual está listo.");
        } else {
            System.out.println("[REPORTE] Sin notificador configurado.");
        }
    }
}


// --- CLASE PRINCIPAL: Punto de entrada del programa ---
public class InyeccionDependencias {

    public static void main(String[] args) {

        System.out.println("=== INYECCIÓN POR CONSTRUCTOR ===\n");

        // Creamos las dependencias concretas
        Notificador email = new NotificadorEmail();
        Notificador sms   = new NotificadorSMS();

        // Inyectamos por constructor: misma clase, comportamiento diferente
        ServicioUsuario servicioConEmail = new ServicioUsuario(email);
        ServicioUsuario servicioConSMS   = new ServicioUsuario(sms);

        servicioConEmail.registrarUsuario("Ana",   "ana@email.com");
        System.out.println();
        servicioConSMS.registrarUsuario("Carlos", "+34 600 123 456");

        System.out.println("\n=== INYECCIÓN POR SETTER ===\n");

        ServicioReportes reportes = new ServicioReportes();

        // Primero sin notificador
        reportes.generarReporte("admin@empresa.com");

        // Luego inyectamos el notificador mediante setter
        reportes.setNotificador(email);
        reportes.generarReporte("admin@empresa.com");

        // Podemos cambiar la implementación en tiempo de ejecución
        reportes.setNotificador(sms);
        reportes.generarReporte("+34 611 999 888");

        // -------------------------------------------------------
        // VENTAJAS CLAVE DE LA INYECCIÓN DE DEPENDENCIAS:
        //
        //  ✔ Bajo acoplamiento: ServicioUsuario no conoce Email ni SMS
        //  ✔ Fácil de testear: se puede inyectar un "mock" en los tests
        //  ✔ Flexible: cambiar el canal de notificación no toca ServicioUsuario
        //  ✔ Principio SOLID: Dependency Inversion Principle (DIP)
        // -------------------------------------------------------
    }
}