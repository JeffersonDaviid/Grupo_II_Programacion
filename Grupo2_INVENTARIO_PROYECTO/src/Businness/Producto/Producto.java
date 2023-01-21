package Businness.Producto;

public class Producto {
    private String codigo;
    private String articulo;
    private int unidades;
    private double precio;
    private String comentario;
    private String fecha;

    private String img;
    private String hora;

    public Producto(String codigo, String articulo, int unidades, double precio, String comentario, String fecha,
            String img, String hora) {
        this.codigo = codigo;
        this.articulo = articulo;
        this.unidades = unidades;
        this.precio = precio;
        this.comentario = comentario;
        this.fecha = fecha;

        this.img = img;
        this.hora = hora;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getArticulo() {
        return articulo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public String getComentario() {
        return comentario;
    }

    public String getFecha() {
        return fecha;
    }

    public String getImg() {
        return img;
    }

    public String getHora() {
        return hora;
    }

}
