package pkMascota;

public class Mascota {
    public String nombre;
    public String tipo;
    public String raza;
    public int edad;
    public boolean estadoMatch;
    public String propietario;
    public String observacion;

    // NO BORRAR CONSTRUCTOR POR DEFECTO
    public Mascota() {
    }

    public Mascota(String nombre,
            String tipo,
            String raza,
            int edad,
            boolean estadoMatch,
            String propietario,
            String observacion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.raza = raza;
        this.edad = edad;
        this.estadoMatch = estadoMatch;
        this.propietario = propietario;
        this.observacion = observacion;
    }
}
