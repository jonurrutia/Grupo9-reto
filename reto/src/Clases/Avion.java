package Clases;

import java.util.ArrayList;
import java.util.List;

public class Avion {

    private int Id_avion;
    private String Modelo;
    private int capacidad;
    private double Tamaño;
    private int Deposito;
    private int Id_aeropuerto;
    private int Id_aerolinia;

    List<Vuelo> Vuelos = new ArrayList<>();

    public Avion(int id_avion, String modelo, int capacidad, double tamaño, int deposito, int id_aeropuerto, int id_aerolinia) {
        Id_avion = id_avion;
        Modelo = modelo;
        this.capacidad = capacidad;
        Tamaño = tamaño;
        Deposito = deposito;
        Id_aeropuerto = id_aeropuerto;
        Id_aerolinia = id_aerolinia;
    }

    public int getId_avion() {
        return Id_avion;
    }

    public String getModelo() {
        return Modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getTamaño() {
        return Tamaño;
    }

    public int getDeposito() {
        return Deposito;
    }

    public int getId_aeropuerto() {
        return Id_aeropuerto;
    }

    public int getId_aerolinia() {
        return Id_aerolinia;
    }

    public void setId_avion(int id_avion) {
        Id_avion = id_avion;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setTamaño(double tamaño) {
        Tamaño = tamaño;
    }

    public void setDeposito(int deposito) {
        Deposito = deposito;
    }

    public void setId_aeropuerto(int id_aeropuerto) {
        Id_aeropuerto = id_aeropuerto;
    }

    public void setId_aerolinia(int id_aerolinia) {
        Id_aerolinia = id_aerolinia;
    }
}
