package BusinnessLogic.Entities;

public class Compra {
    private int intCantidad;
    private Producto producto;

    public Compra(int intCantidad, Producto producto) {
        this.intCantidad = intCantidad;
        this.producto = producto;
    }

    public int getIntCantidad() {
        return intCantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setIntCantidad(int intCantidad) {
        this.intCantidad = intCantidad;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
