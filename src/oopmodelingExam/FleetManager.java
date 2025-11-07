package oopmodelingExam;

import java.util.ArrayList;
import java.util.List;

// Importamos las clases del paquete Model que usaremos


/**
 * Clase FleetManager
 * ------------------
 * Se encarga de gestionar toda la lógica del sistema:
 * - Guarda las listas de vehículos, clientes y alquileres.
 * - Permite añadir vehículos y clientes.
 * - Crea alquileres (rentals).
 * - Muestra los vehículos disponibles.
 * 
 * Esta clase actúa como el "gestor principal" del sistema.
 */
public class FleetManager {
    
    // Lista de todos los vehículos del sistema (flota)
    private List<Vehicle> vehicles = new ArrayList<>();
    
    // Lista con todos los alquileres realizados
    private List<Rental> rentals = new ArrayList<>();
    
    // Lista de todos los clientes registrados
    private List<Customer> customers = new ArrayList<>();

    /**
     * Añade un nuevo vehículo a la flota.
     * @param v objeto Vehicle que se desea agregar
     */
    public void addVehicle(Vehicle v){ 
        vehicles.add(v); 
    }

    /**
     * Añade un nuevo cliente al sistema.
     * @param c objeto Customer que se desea registrar
     */
    public void addCustomer(Customer c){ 
        customers.add(c); 
    }

    /**
     * Devuelve una lista con todos los vehículos disponibles (no alquilados).
     * @return lista de objetos Vehicle que están disponibles
     */
    public List<Vehicle> listAvailable(){
        List<Vehicle> out = new ArrayList<>();
        // Recorre la lista de vehículos y agrega los que están disponibles
        for(Vehicle v : vehicles) 
            if(v.isAvailable()) 
                out.add(v);
        return out; // Devuelve la lista de vehículos disponibles
    }

    /**
     * Crea un nuevo alquiler (Rental) si el vehículo y el cliente existen.
     * 
     * @param rentalId   identificador único del alquiler
     * @param vehicleId  identificador del vehículo a alquilar
     * @param customerId identificador del cliente que alquila
     * @param start      fecha de inicio del alquiler
     * @param end        fecha de fin del alquiler
     * @return un objeto Rental creado o null si algo falla
     */
    public Rental createRental(String rentalId, String vehicleId, String customerId, 
                               java.time.LocalDate start, java.time.LocalDate end){

        // Busca el vehículo por ID y verifica que esté disponible
        Vehicle v = vehicles.stream()
                .filter(x -> x.getId().equals(vehicleId) && x.isAvailable())
                .findFirst()
                .orElse(null);

        // Busca el cliente por ID
        Customer c = customers.stream()
                .filter(x -> x.getId().equals(customerId))
                .findFirst()
                .orElse(null);

        // Si no existe el vehículo o el cliente, no se crea el alquiler
        if(v == null || c == null) 
            return null;

        // Crea el nuevo alquiler (Rental) con los datos proporcionados
        Rental r = new Rental(rentalId, v, c, start, end);

        // Marca el vehículo como "no disponible" porque está alquilado
        v.setAvailable(false);

        // Calcula el precio total del alquiler según los días
        r.calculateTotal();

        // Añade el alquiler a la lista de rentals (historial)
        rentals.add(r);

        // Devuelve el alquiler recién creado
        return r;
    }

    /**
     * Devuelve una lista con todos los alquileres realizados hasta el momento.
     * @return lista de objetos Rental
     */
    public List<Rental> listRentals(){ 
        return rentals; 
    }
}