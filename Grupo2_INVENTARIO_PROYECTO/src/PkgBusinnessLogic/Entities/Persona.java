package PkgBusinnessLogic.Entities;

public class Persona {
    private String nombre;
    private String cedula;
    private int edad;
    private String sexo;

    public Persona(String nombre, String cedula, int edad, String sexo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.sexo = sexo;
    }

    // GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    // SETTERS
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
