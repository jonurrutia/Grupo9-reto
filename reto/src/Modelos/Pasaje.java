package Modelos;

public class Pasaje {

    private int Id_pasaje;

    private String DNI;
    private Clase clase;
    private int Asiento;
    private double Precio;
    private int Id_vuelo;

    public Pasaje(int id_pasaje, Clase clase, int asiento, double precio, int id_vuelo, String DNI) {
        Id_pasaje = id_pasaje;
        this.clase = clase;
        Asiento = asiento;
        Precio = precio;
        Id_vuelo = id_vuelo;
        this.DNI=DNI;
    }

    public int getId_pasaje() {
        return Id_pasaje;
    }

    public Clase getClase() {
        return clase;
    }

    public int getAsiento() {
        return Asiento;
    }

    public double getPrecio() {
        return Precio;
    }

    public int getId_vuelo() {
        return Id_vuelo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setId_pasaje(int id_pasaje) {
        Id_pasaje = id_pasaje;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public void setAsiento(int asiento) {
        Asiento = asiento;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public void setId_vuelo(int id_vuelo) {
        Id_vuelo = id_vuelo;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
