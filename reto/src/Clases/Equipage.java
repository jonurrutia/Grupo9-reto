package Clases;

public class Equipage {

    private int Id_equipage;
    private double Preso;
    private String DNI;

    public Equipage(int id_equipage, double preso, String DNI) {
        Id_equipage = id_equipage;
        Preso = preso;
        this.DNI = DNI;
    }

    public int getId_equipage() {
        return Id_equipage;
    }

    public double getPreso() {
        return Preso;
    }

    public String getDNI() {
        return DNI;
    }

    public void setId_equipage(int id_equipage) {
        Id_equipage = id_equipage;
    }

    public void setPreso(double preso) {
        Preso = preso;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

}
