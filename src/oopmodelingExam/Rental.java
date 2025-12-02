package oopmodelingExam;

import java.time.LocalDate; // Para trabajar con fechas
import java.time.temporal.ChronoUnit; // Para calcular la diferencia entre fechas

public class Rental { 
    private String id; // Identificador único del alquiler
    private Vehicle vehicle; // Vehículo alquilado
    private Customer customer; // Cliente que realiza el alquiler
    private LocalDate startDate; // Fecha de inicio del alquiler
    private LocalDate endDate; // Fecha de fin del alquiler
    private boolean returned = false; // Indica si el vehículo ha sido devuelto
    private double totalPrice = 0.0; // Precio total del alquiler
    private Payment payment; // Interfaz Payment que se encargará del pago

    // Constructor de la clase Rental
    public Rental(String id, Vehicle v, Customer c, LocalDate start, LocalDate end) {
        this.id = id; 
        vehicle = v; 
        customer = c; 
        startDate = start; 
        endDate = end;
    }

    // Método para obtener la duración del alquiler en días
    public long getDurationDays() {
        return ChronoUnit.DAYS.between(startDate, endDate) + 1; 
        // Calcula los días entre la fecha de inicio y fin, sumando 1 para incluir el día inicial
    }

    // Calcula el precio total del alquiler
    public void calculateTotal() {
        int days = (int) getDurationDays(); // Obtiene la duración del alquiler
        totalPrice = vehicle.calculatePrice(days); // Calcula el precio usando el método del vehículo
    }

    // Devuelve el precio total calculado
    public double getTotalPrice() { 
        return totalPrice; 
    }

    // Asigna el método de pago
    public void setPayment(Payment p) { 
        payment = p; 
    }

    // Marca el vehículo como devuelto y disponible
    public void markReturned() { 
        returned = true; 
        vehicle.setAvailable(true); 
    }

    // Representación en texto del alquiler
    public String toString() { 
        return id + " -> " + vehicle + " cliente: " + customer; 
    }
}