package Businness.Persona;

public class Persona {
    private final String nombre;
    private final String cedula;
    private int edad;
    private final String sexo;

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
