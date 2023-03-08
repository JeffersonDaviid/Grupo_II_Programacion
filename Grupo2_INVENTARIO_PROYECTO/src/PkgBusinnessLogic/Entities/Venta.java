package PkgBusinnessLogic.Entities;

public class Venta {
	private int intCantidad;
	private Producto producto;

	public Venta(int intCantidad, Producto producto) {
		this.intCantidad = intCantidad;
		this.producto = producto;
	}

	public int getIntCantidad() {
		return intCantidad;
	}

	public void setIntCantidad(int intCantidad) {
		this.intCantidad = intCantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
