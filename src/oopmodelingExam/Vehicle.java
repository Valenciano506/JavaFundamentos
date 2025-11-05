package oopmodelingExam;

public abstract class Vehicle { 
    // Clase abstracta que servirá como base para tipos de vehículos específicos (Sedan, SUV, etc.)

    private String id; // Identificador único del vehículo
    private String make; // Marca del vehículo (ej. Toyota)
    private String model; // Modelo del vehículo (ej. Corolla)
    private int year; // Año de fabricación
    private String plate; // Matrícula del vehículo
    private double dailyRate; // Tarifa diaria de alquiler
    private boolean available = true; // Indica si el vehículo está disponible para alquilar

    // Constructor de la clase Vehicle
    public Vehicle(String id, String make, String model, int year, String plate, double dailyRate) {
        this.id = id; 
        this.make = make; 
        this.model = model; 
        this.year = year;
        this.plate = plate; 
        this.dailyRate = dailyRate;
    }

    // Getters y setters
    public String getId() { return id; } // Devuelve el ID del vehículo
    public boolean isAvailable() { return available; } // Devuelve si está disponible
    public void setAvailable(boolean available) { this.available = available; } // Cambia la disponibilidad
    public double getDailyRate() { return dailyRate; } // Devuelve la tarifa diaria

    // Método abstracto que deben implementar las subclases para calcular el precio del alquiler
    public abstract double calculatePrice(int days);

    @Override
    public String toString() { 
        // Representación en texto del vehículo mostrando su ID, marca, modelo, año, tarifa y disponibilidad
        return id + " - " + make + " " + model + " (" + year + ") - €" + dailyRate + "/día - " 
               + (available ? "Disponible" : "Alquilado");
    }
}