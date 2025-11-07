package oopmodeling;

public class Planet extends CelestialBody {

    //Constructors used to create objects of the class Planet

    //Constructor vacío que no hace nada
    public Planet(){
        super();
    }

    //Contructor con 2 parámetros
    public Planet(double mass, String nameOf){

        super(nameOf);
        name = nameOf;
        this.mass = mass;

    }

    //Contructor con 3 parámetros
    public Planet(double mass, String name, float radius){

        super(mass, name);
        this.mass = mass;
        this.name = name;
        this.radius = radius;

    }


	public void setMass(int i) {


	}
	public void setName(String string) {

		
	}
	public void setSize(int i) {

		
	}
	public String getName() {

		return null;
	}
	public String getSize() {

		return null;
	}
}
