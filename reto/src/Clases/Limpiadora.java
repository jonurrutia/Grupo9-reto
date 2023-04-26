package Clases;

import java.sql.Time;

public class Limpiadora extends Empleado{

    private int Id_aeropuerto;

    Limpiadora(int numemp, double Sueldo, String nombre, String apellido, Time hora_entrada, Time hora_salida, String trabajo, int Id_aeropuerto) {
        super(numemp, Sueldo, nombre, apellido, hora_entrada, hora_salida, trabajo);
        this.Id_aeropuerto=Id_aeropuerto;
    }
}
