package Modelos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Calendar;

public class Empleado {
    private int numemp;
    private int Sueldo;
    private String nombre;
    private String apellido;
    private String hora_Entrada;
    private String hora_salida;
    private String Trabajo;

    String password;

    public Empleado(int numemp, String nombre, String apellido, String trabajo, String hora_entrada, String hora_salida, int Sueldo, String password){
        this.numemp=numemp;
        this.Sueldo = Sueldo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.hora_Entrada=hora_entrada.replaceAll("1970-01-01","");
        this.hora_salida=hora_salida.replaceAll("1970-01-01","");;
        this.Trabajo=trabajo;
        this.password=password;
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

    public String getHora_Entrada() {
        return hora_Entrada;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public String getTrabajo() {
        return Trabajo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNumemp(int numemp) {
        this.numemp = numemp;
    }

    public void setSueldo(int sueldo) {
        Sueldo = sueldo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setHora_Entrada(String hora_Entrada) {
        this.hora_Entrada = hora_Entrada;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public void setTrabajo(String trabajo) {
        Trabajo = trabajo;
    }



}
