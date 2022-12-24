package pkMascota;

import pkPersona.Propietario;

public class Mascota {
    private String nombre;
    private String tipo;
    private String raza;
    private int edad;
    private boolean estadoMatch;
    private Propietario propietario;
    private String observacion;

    // NO BORRAR CONSTRUCTOR POR DEFECTO
    public Mascota() {
    }

    public Mascota(String nombre,
            String tipo,
            String raza,
            int edad,
            Propietario propietario,
            String observacion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.raza = raza;
        this.edad = edad;
        this.estadoMatch = true;
        this.propietario = propietario;
        this.observacion = observacion;
    }

    // METODOS ACCESORES

    // SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEstadoMatch(Boolean estadoMatch) {
        this.estadoMatch = estadoMatch;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    // GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdad() {
        return edad;
    }

    public boolean getEstadoMatch() {
        return estadoMatch;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public String getObservacion() {
        return observacion;
    }

}
