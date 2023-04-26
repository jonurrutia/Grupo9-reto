package Clases;

public class Aerolinia {
    private int Id_aerolinia;
    private String nombre;
    private String Direccion;
    private int telefono;

    public Aerolinia(int id_aerolinia, String nombre, String direccion, int telefono) {
        Id_aerolinia = id_aerolinia;
        this.nombre = nombre;
        Direccion = direccion;
        this.telefono = telefono;
    }

    public int getId_aerolinia() {
        return Id_aerolinia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setId_aerolinia(int id_aerolinia) {
        Id_aerolinia = id_aerolinia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
