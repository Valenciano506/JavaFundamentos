package oopmodeling;

public class CelestialBody {

    //Las variables por defecto
	protected double size = 200;
    //Without specifying a modifier, by defeault it is protected
	String name = "churrigueresca";
    double mass = 25;
    float radius = 80;
    private int age = 1000;//millions of years

    //constructor of this class
    public CelestialBody(String name){
        this.name = name;
    }
    public CelestialBody(double mass, String name){
        this.name = name;
        this.mass = mass;
    }
    public CelestialBody(){

    }
}