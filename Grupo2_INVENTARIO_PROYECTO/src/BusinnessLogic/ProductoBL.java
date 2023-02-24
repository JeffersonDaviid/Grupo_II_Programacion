package BusinnessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JComboBox;

import BusinnessLogic.Entities.Producto;
import DataAccess.ProductoDAC;
import Framework.APP;
import Framework.AppException;

public class ProductoBL {
    /**
     * 
     * @return Retorna una Arraylist de todos los productos DISPONIBLES / NO DIPONIBLES
     * @throws Exception
     */
    public ArrayList<Producto> getAllProducto() throws Exception {
        try {
            ArrayList<Producto> productos = new ArrayList<Producto>();
            ProductoDAC productoDac = new ProductoDAC();
            ResultSet rs = productoDac.getProducto();

            EstadoBL estado = new EstadoBL();
            CategoriaProductoBL categoria = new CategoriaProductoBL();
            IvaBL iva = new IvaBL();

            while (rs.next()) {
                Producto p = new Producto(
                        rs.getString(APP.BASE_DATOS_MYSQL.PK_ID_PRODUCTO),
                        rs.getString(APP.BASE_DATOS_MYSQL.CODIGO_PRODUCTO),
                        estado.getBLEstadoById(rs.getInt(APP.BASE_DATOS_MYSQL.FK_ID_ESTADO)),
                        categoria.getBLCategoriaProductoById(rs.getInt(APP.BASE_DATOS_MYSQL.FK_ID_CATEGORIA_PRODUCTO)),
                        iva.getBLIvaById(rs.getInt(APP.BASE_DATOS_MYSQL.FK_ID_IVA)),
                        rs.getString(APP.BASE_DATOS_MYSQL.PRODUCTO),
                        rs.getInt(APP.BASE_DATOS_MYSQL.STOCK),
                        rs.getDouble(APP.BASE_DATOS_MYSQL.PRECIO_COMPRA),
                        rs.getDouble(APP.BASE_DATOS_MYSQL.PRECIO_VENTA),
                        rs.getString(APP.BASE_DATOS_MYSQL.DESCRIPCION),
                        // rs.getImage( APP.BASE_DATOS_MYSQL.IMAGEN ),
                        null,
                        rs.getString(APP.BASE_DATOS_MYSQL.FECHA_CREACION),
                        rs.getString(APP.BASE_DATOS_MYSQL.FECHA_MODIFICACION));
                productos.add(p);
            }
            return productos;
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getAllProducto(): " + e.getMessage());
        }
    }

    /**
     * 
     * @return Retorna una Arraylist de todos los productos DISPONIBLES/NO
     *         DIPONIBLES clasificados por CATEGORIA
     * @throws Exception
     */
    public ArrayList<Producto> getProductoByCategoria(int idCategoria) throws Exception {
        try {
            ArrayList<Producto> productos = new ArrayList<Producto>();
            ProductoDAC productoDac = new ProductoDAC();
            ResultSet rs = productoDac.getProductoByCategoria(idCategoria);

            EstadoBL estado = new EstadoBL();
            CategoriaProductoBL categoria = new CategoriaProductoBL();
            IvaBL iva = new IvaBL();

            while (rs.next()) {
                Producto p = new Producto(
                        rs.getString(APP.BASE_DATOS_MYSQL.PK_ID_PRODUCTO),
                        rs.getString(APP.BASE_DATOS_MYSQL.CODIGO_PRODUCTO),
                        estado.getBLEstadoById(rs.getInt(APP.BASE_DATOS_MYSQL.FK_ID_ESTADO)),
                        categoria.getBLCategoriaProductoById(rs.getInt(APP.BASE_DATOS_MYSQL.FK_ID_CATEGORIA_PRODUCTO)),
                        iva.getBLIvaById(rs.getInt(APP.BASE_DATOS_MYSQL.FK_ID_IVA)),
                        rs.getString(APP.BASE_DATOS_MYSQL.PRODUCTO),
                        rs.getInt(APP.BASE_DATOS_MYSQL.STOCK),
                        rs.getDouble(APP.BASE_DATOS_MYSQL.PRECIO_COMPRA),
                        rs.getDouble(APP.BASE_DATOS_MYSQL.PRECIO_VENTA),
                        rs.getString(APP.BASE_DATOS_MYSQL.DESCRIPCION),
                        // rs.getImage(APP.BASE_DATOS_MYSQL.IMAGEN ),
                        null,
                        rs.getString(APP.BASE_DATOS_MYSQL.FECHA_CREACION),
                        rs.getString(APP.BASE_DATOS_MYSQL.FECHA_MODIFICACION));
                productos.add(p);
            }
            return productos;
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getProductoByCategoria():" + e.getMessage());
        }
    }

    public void getRegistrarProducto(Producto nuevoProducto){
        ProductoDAC registrarProducto = new ProductoDAC();
        registrarProducto.registrarProducto(nuevoProducto);
    }

    public void getConsultarIVA(JComboBox cbxIvaProducto){
        ProductoDAC consultarIva = new ProductoDAC();
        consultarIva.consultarIVA(cbxIvaProducto);
    }

}
