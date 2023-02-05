package BusinnessLogic.Entities;

import javax.swing.ImageIcon;

public class Producto {

    private String idProducto;
    private String codigoProducto;
    private Estado fkEstado;
    private CategoriaProducto fkCategoriaProducto;
    private Iva fkIva;
    private String producto;
    private int stock;
    private double precioCompra;;
    private double precioVenta;
    private String descripcion;
    private ImageIcon imagen;
    private String fechaIngreso;
    private String fechaModificacion;

    public Producto(String idProducto, String codigoProducto, Estado fkEstado, CategoriaProducto fkCategoriaProducto,
            Iva fkIva, String producto, int stock, double precioCompra, double precioVenta, String descripcion,
            ImageIcon imagen, String fechaIngreso, String fechaModificacion) {
        this.idProducto = idProducto;
        this.codigoProducto = codigoProducto;
        this.fkEstado = fkEstado;
        this.fkCategoriaProducto = fkCategoriaProducto;
        this.fkIva = fkIva;
        this.producto = producto;
        this.stock = stock;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.fechaIngreso = fechaIngreso;
        this.fechaModificacion = fechaModificacion;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Estado getFkEstado() {
        return fkEstado;
    }

    public void setFkEstado(Estado fkEstado) {
        this.fkEstado = fkEstado;
    }

    public CategoriaProducto getFkCategoriaProducto() {
        return fkCategoriaProducto;
    }

    public void setFkCategoriaProducto(CategoriaProducto fkCategoriaProducto) {
        this.fkCategoriaProducto = fkCategoriaProducto;
    }

    public Iva getFkIva() {
        return fkIva;
    }

    public void setFkIva(Iva fkIva) {
        this.fkIva = fkIva;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

}