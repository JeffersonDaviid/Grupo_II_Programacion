package BusinnessLogic.Entities;

public class Trabajador extends Persona {
    private final int codigo;
    private String cargo;

    public Trabajador(String nombre, String cedula, int edad, String sexo, int codigo, String cargo) {
        super(nombre, cedula, edad, sexo);
        this.codigo = codigo;
        this.cargo = cargo;
    }

    // GETTERS
    public int getCodigo() {
        return codigo;
    }

    public String getCargo() {
        return cargo;
    }

    // SETTERS
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
