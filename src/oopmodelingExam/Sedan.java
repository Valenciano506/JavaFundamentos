package oopmodelingExam;

public class Sedan extends Vehicle { // La clase Sedan hereda de Vehicle
    private int seats; // Atributo específico de Sedan: número de asientos

    // Constructor de la clase Sedan
    public Sedan(String id, String make, String model, int year, String plate, double dailyRate, int seats) {
        super(id, make, model, year, plate, dailyRate); 
        // Llama al constructor de la clase padre (Vehicle) para inicializar los atributos heredados
        this.seats = seats; // Inicializa el número de asientos del Sedan
    }

    @Override
    public double calculatePrice(int days) { 
        // Método que calcula el precio del alquiler del Sedan según los días
        return getDailyRate() * days; 
        // Multiplica la tarifa diaria por los días para obtener el precio total
    }
}