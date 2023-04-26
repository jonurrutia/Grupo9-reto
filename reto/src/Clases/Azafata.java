package Clases;

import java.sql.Time;

public class Azafata extends Empleado{

    private int Id_aerolinia;

    Azafata(int numemp, double Sueldo, String nombre, String apellido, Time hora_entrada, Time hora_salida, String trabajo, int Id_aerolinia) {
        super(numemp, Sueldo, nombre, apellido, hora_entrada, hora_salida, trabajo);
        this.Id_aerolinia=Id_aerolinia;
    }
}
