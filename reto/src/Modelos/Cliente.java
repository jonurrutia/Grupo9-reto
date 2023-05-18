package Modelos;

public class Cliente {

    private String DNI;
    private String Nombre;
    private String Apellido;
    private int Telefono;
    private String Correo;
    private String Contraseña;

    public Cliente(String DNI, String nombre, String apellido, int telefono, String correo, String contraseña) {
        this.DNI = DNI;
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telefono;
        Correo = correo;
        Contraseña=contraseña;

    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public int getTelefono() {
        return Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }
}
