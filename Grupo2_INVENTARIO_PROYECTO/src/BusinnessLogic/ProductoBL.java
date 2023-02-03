package BusinnessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;

import BusinnessLogic.Entities.Producto;
import DataAccess.ProductoDAC;

public class ProductoBL {

    /**
     * 
     * @return Retorna una Arraylist de todos los productos DISPONIBLES/NO
     *         DIPONIBLES
     */
    public ArrayList<Producto> getAllProducto() {
        try {
            ArrayList<Producto> productos = new ArrayList<Producto>();
            ProductoDAC productoDac = new ProductoDAC();
            ResultSet rs = productoDac.getProducto();

            // EstadoDAC estadoCategoriaDac = new EstadoDAC();
            // CategoriaProductoDAC categoriaDAC = new CategoriaProductoDAC();
            // IvaDAC ivaDAc = new IvaDAC();

            while (rs.next()) {

                EstadoBL estado = new EstadoBL();
                CategoriaProductoBL categoria = new CategoriaProductoBL();
                IvaBL iva = new IvaBL();
                // ResultSet rsEstadoCategoria = estadoCategoriaDac
                // .getEstadoById(rs.getInt("FK_ID_CATEGORIA_PRODUCTO"));
                // Estado estadoCategoria = new Estado(rs.getInt("FK_ID_CATEGORIA_PRODUCTO"),
                // rsEstadoCategoria.getString("ESTADO"));

                // ResultSet rsCategoriaProducto =
                // categoriaDAC.getCategoriaById(rs.getInt("FK_ID_CATEGORIA_PRODUCTO"));
                // CategoriaProducto categoria = new
                // CategoriaProducto(rs.getInt("FK_ID_CATEGORIA_PRODUCTO"),
                // estadoCategoria, rsCategoriaProducto.getString("NOMBRE"));

                // ResultSet rsIvaDac = ivaDAc.getIvaById(rs.getInt("PK_ID_IVA"));
                // Iva iva = new Iva(rs.getInt("PK_ID_IVA"), rsIvaDac.getString("NOMBRE"));

                Producto p = new Producto(
                        rs.getInt("ID_PRODUCTO"),
                        rs.getString("CODIGO_PRODUCTO"),
                        estado.getBLEstadoById(rs.getInt("FK_ID_ESTADO")),
                        categoria.getBLCategoriaProductoById(rs.getInt("FK_ID_CATEGORIA_PRODUCTO")),
                        iva.getBLIvaById(rs.getInt("PK_ID_IVA")),
                        rs.getString("PRODUCTO"),
                        rs.getInt("STOCK"),
                        rs.getDouble("PRECIO_COMPRA"),
                        rs.getDouble("PRECIO_VENTA"),
                        rs.getString("DESCRIPCION"),
                        // rs.getImage("IMAGEN"),
                        null,
                        rs.getString("FECHA_CREACION"),
                        rs.getString("FECHA_MODIFICA"));
                productos.add(p);
            }
            return productos;
        } catch (Exception e) {
            System.out.println("ERROR al obtener lista de usuarios " + "en getAllProducto() " + e.getMessage());
        }
        return null;
    }
}
