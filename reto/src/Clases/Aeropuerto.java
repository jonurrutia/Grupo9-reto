package Clases;

import java.util.ArrayList;
import java.util.List;

public class Aeropuerto {
    private int Id_Aeropuerto;
    private String pais;
    private String ciudad;
    private int tamaño;

    public Aeropuerto(int id_Aeropuerto, String pais, String ciudad, int tamaño) {
        Id_Aeropuerto = id_Aeropuerto;
        this.pais = pais;
        this.ciudad = ciudad;
        this.tamaño = tamaño;

    }

    public int getId_Aeropuerto() {
        return Id_Aeropuerto;
    }

    public String getPais() {
        return pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setId_Aeropuerto(int id_Aeropuerto) {
        Id_Aeropuerto = id_Aeropuerto;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

}
