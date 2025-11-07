package oopmodeling;

public class SolarSystem {

    public static void main(String[] args) {

        Object obj = new Planet();
        Planet obj2 = new Planet();
        Planet jupiter = new Planet(324234, "Jupiter");
        Planet jupiter2 = new Planet(324234, "Jupiter");
        Planet mars = new Planet(435345, "Mars", 2343);
        CelestialBody body3 = new Planet();
        //SolarSystem ss = new Planet();
        System.out.println(obj);
        System.out.println(obj2);
        obj = obj2;
        System.out.println(obj);

        System.out.println(jupiter.mass);
        System.out.println(jupiter.name);

        System.out.println(mars.mass);
        System.out.println(mars.name);
        System.out.println(mars.radius);

    }

}
