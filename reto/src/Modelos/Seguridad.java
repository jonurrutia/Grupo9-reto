package Modelos;

import java.sql.Time;

public class Seguridad extends Empleado{

    private int Id_aeropuerto;

    public Seguridad(int numemp, String nombre, String apellido, String trabajo, String hora_entrada, String hora_salida, int Sueldo, String password, int Id_aerolinia) {
        super(numemp, nombre, apellido, trabajo, hora_entrada, hora_salida, Sueldo, password);
        this.Id_aeropuerto=Id_aeropuerto;
    }
}
