package oopmodeling.adressbook;

/*
 * 
 *
 * @author Valenciano
 * 28 nov 2025
 */

public class Contact {
	
	/**
	 * Constructor used to create objects of this class 
	 * and assign values to this type of objects' fields
	 * @param nombre
	 * @param apellido
	 * @param numero
	 * @param email2
	 */
	
	public Contact(String nombre, String apellido, String numero, String email) {

		this.name = nombre;
		this.surename = apellido;
		this.phoneNumber = numero;
		this.email = email;
		
	}
	
	//Attributes or fields of the class
	private String phoneNumber;
	private String name;
	private String surename;
	private String email;
	
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the surename
	 */
	public String getSurename() {
		return surename;
	}
	/**
	 * @param surename the surename to set
	 */
	public void setSurename(String surename) {
		this.surename = surename;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + name + " Apellido: " + surename + " Numero: " + phoneNumber + " Email: " + email;
	}

}
