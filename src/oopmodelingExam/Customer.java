package oopmodelingExam;

public class Customer {
    private String id;
    private String name;
    private String licenseNumber;
    private String phone;

    public Customer(String id, String name, String licenseNumber, String phone) {
        this.id = id; this.name = name; this.licenseNumber = licenseNumber; this.phone = phone;
    }

    public String getId(){return id;}
    @Override
    public String toString(){ return id + " - " + name + " (Carnet: " + licenseNumber + ")"; }
}