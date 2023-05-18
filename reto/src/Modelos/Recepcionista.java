package Modelos;

import java.sql.Time;

public class Recepcionista extends Empleado{

    private int Id_aeropuerto;

    public Recepcionista(int numemp, String nombre, String apellido, String trabajo, String hora_entrada, String hora_salida, int Sueldo, String password, int Id_aeropuerto) {
        super(numemp, nombre, apellido, trabajo, hora_entrada, hora_salida, Sueldo, password);
        this.Id_aeropuerto=Id_aeropuerto;
    }

    public int getId_aeropuerto() {
        return Id_aeropuerto;
    }

    public void setId_aeropuerto(int id_aeropuerto) {
        Id_aeropuerto = id_aeropuerto;
    }
}
