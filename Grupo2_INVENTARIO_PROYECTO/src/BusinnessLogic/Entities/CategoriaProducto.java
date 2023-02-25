package BusinnessLogic.Entities;

public class CategoriaProducto {
    private int idCategoriaProducto;
    private Estado fkIdEstado;
    private String nombre;

    
    public CategoriaProducto(){

    }
    
    public CategoriaProducto(int idCategoriaProducto, Estado fkIdEstado, String nombre) {
        this.idCategoriaProducto = idCategoriaProducto;
        this.fkIdEstado = fkIdEstado;
        this.nombre = nombre;
    }

    public int getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(int idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public Estado getFkIdEstado() {
        return fkIdEstado;
    }

    public void setFkIdEstado(Estado fkIdEstado) {
        this.fkIdEstado = fkIdEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
