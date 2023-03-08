package BusinnessLogic.Entities;

public class Venta {
	private int id;
	private String cliente;
	private String cedula;
	private String direccion;
	private String telefono;
	
	private double total;

	
public Venta() {
	
	}

public Venta(int id, String cliente, String cedula, String direccion, String telefono, double total, String fechaIngreso) {
	super();
	this.id = id;
	this.cliente = cliente;
	this.cedula = cedula;
	this.direccion = direccion;
	this.telefono = telefono;
	this.total = total;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCliente() {
	return cliente;
}

public void setCliente(String cliente) {
	this.cliente = cliente;
}

public double getTotal() {
	return total;
}

public void setTotal(double total) {
	this.total = total;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getCedula() {
	return cedula;
}

public void setCedula(String cedula) {
	this.cedula = cedula;
}

}
