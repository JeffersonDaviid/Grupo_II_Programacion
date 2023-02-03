package BusinnessLogic.Entities;

public class Estado {
    private int idEstado;
    private String estado;

    public Estado(int idEstado, String estado) {
        this.idEstado = idEstado;
        this.estado = estado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
