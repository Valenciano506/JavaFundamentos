package oopmodelingExam;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FleetManager manager = new FleetManager();
        // crear vehículos
        manager.addVehicle(new Sedan("V1","Toyota","Corolla",2020,"ABC123",30.0,5));
        manager.addVehicle(new SUV("V2","Nissan","XTrail",2021,"DEF456",45.0,4));
        // crear cliente
        Customer c = new Customer("C1","Juan Perez","L1234567","600600600");
        manager.addCustomer(c);
        // mostrar disponibles
        System.out.println("Disponibles:");
        manager.listAvailable().forEach(System.out::println);
        // crear rental 3 días
        Rental r = manager.createRental("R1","V1","C1", LocalDate.now(), LocalDate.now().plusDays(2));
        if(r!=null){
            System.out.println("Alquiler creado: " + r);
            // procesar pago
            Payment p = new CreditCardPayment("1234567812345678");
            boolean ok = p.process(r.getTotalPrice());
            if(ok) {
                r.setPayment(p);
                System.out.println("Pago correcto: " + p.getReceipt() + " Total: " + r.getTotalPrice());
            }
            // devolver
            r.markReturned();
            System.out.println("Devolución procesada.");
        }
    }
}