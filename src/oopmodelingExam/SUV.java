package oopmodelingExam;

public class SUV extends Vehicle { // La clase SUV hereda de la clase Vehicle
    private int seats; // Atributo específico de SUV que indica el número de asientos

    // Constructor de la clase SUV
    public SUV(String id, String make, String model, int year, String plate, double dailyRate, int b) {
        super(id, make, model, year, plate, dailyRate); 
        // Llama al constructor de la clase padre (Vehicle) para inicializar los atributos heredados
        this.seats = b; // Inicializa el número de asientos del SUV
    }

    @Override
    public double calculatePrice(int days) { 
        // Método que calcula el precio del alquiler de un SUV por un número de días
        return getDailyRate() * days; 
        // Multiplica la tarifa diaria por la cantidad de días para obtener el precio total
    }
}