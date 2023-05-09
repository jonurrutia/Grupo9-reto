package Modelos;

import java.sql.Time;

public class Piloto extends Empleado{

    private int Id_aerolinia;

    public Piloto(int numemp, String nombre, String apellido, String trabajo, String hora_entrada, String hora_salida, int Sueldo, String password, int Id_aerolinia) {
        super(numemp, nombre, apellido, trabajo, hora_entrada, hora_salida, Sueldo, password);
        this.Id_aerolinia=Id_aerolinia;
    }

    public int getId_aerolinia() {
        return Id_aerolinia;
    }

    public void setId_aerolinia(int id_aerolinia) {
        Id_aerolinia = id_aerolinia;
    }
}
