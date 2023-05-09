package Modelos;

public class Vuelo {

    private int Id_vuelo;
    private String Salida;
    private String Destino;
    private String Hora_salida;
    private String Hora_llegada;

    public Vuelo(int id_vuelo, String salida, String destino, String hora_salida, String hora_llegada) {
        Id_vuelo = id_vuelo;
        Salida = salida;
        Destino = destino;
        Hora_salida = hora_salida;
        Hora_llegada = hora_llegada;
    }

    public int getId_vuelo() {
        return Id_vuelo;
    }

    public String getSalida() {
        return Salida;
    }

    public String getDestino() {
        return Destino;
    }

    public String getHora_salida() {
        return Hora_salida;
    }

    public String getHora_llegada() {
        return Hora_llegada;
    }

    public void setId_vuelo(int id_vuelo) {
        Id_vuelo = id_vuelo;
    }

    public void setSalida(String salida) {
        Salida = salida;
    }

    public void setDestino(String destino) {
        Destino = destino;
    }

    public void setHora_salida(String hora_salida) {
        Hora_salida = hora_salida;
    }

    public void setHora_llegada(String hora_llegada) {
        Hora_llegada = hora_llegada;
    }
}
