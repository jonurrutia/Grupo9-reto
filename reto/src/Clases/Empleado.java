package Clases;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Empleado {
    private int numemp;
    private double Sueldo;
    private String nombre;
    private String apellido;
    private Time hora_Entrada;
    private Time hora_salida;
    private String Trabajo;

    Empleado(int numemp, double Sueldo, String nombre, String apellido, Time hora_entrada, Time hora_salida, String trabajo){
        this.numemp=numemp;
        this.Sueldo = Sueldo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.hora_Entrada=hora_entrada;
        this.hora_salida=hora_salida;
        this.Trabajo=trabajo;
    }

    public int getNumemp() {
        return numemp;
    }

    public double getSueldo() {
        return Sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Time getHora_Entrada() {
        return hora_Entrada;
    }

    public Time getHora_salida() {
        return hora_salida;
    }

    public String getTrabajo() {
        return Trabajo;
    }

    public void setNumemp(int numemp) {
        this.numemp = numemp;
    }

    public void setSueldo(double sueldo) {
        Sueldo = sueldo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setHora_Entrada(Time hora_Entrada) {
        this.hora_Entrada = hora_Entrada;
    }

    public void setHora_salida(Time hora_salida) {
        this.hora_salida = hora_salida;
    }

    public void setTrabajo(String trabajo) {
        Trabajo = trabajo;
    }

    public void Trabajar(Time hora_actual){

    }
}
