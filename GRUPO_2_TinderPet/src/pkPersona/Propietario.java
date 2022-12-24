package pkPersona;

public class Propietario extends Persona {
    private String nombre;

    public Propietario() {
    }

    public Propietario(String nombre) {
        this.nombre = nombre;
    }

    // GETTERS
    public String getNombre() {
        return nombre;
    }

    // SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
