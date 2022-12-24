package pkPersona;

public class Propietario extends Persona {
    // variable
    // private String nombre;
    // constante | no existe setter
    private final String nombre;

    public Propietario(String nombre) {
        this.nombre = nombre;
    }

    // GETTERS
    public String getNombre() {
        return nombre;
    }

}
