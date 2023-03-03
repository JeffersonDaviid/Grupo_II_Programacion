package BusinnessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JComboBox;

import BusinnessLogic.Entities.Producto;
import DataAccess.CategoriaProductoDAC;
import DataAccess.IvaDAC;
import DataAccess.ProductoDAC;
import Framework.APP;
import Framework.AppException;

public class ProductoBL {

    /**
     * Obtiene todos los productos registrados en la BD y los almacena en un
     * ArrayList de tipo Producto
     * 
     * @return Retorna una Arraylist de todos los productos DISPONIBLES
     * @throws Exception
     * @return Retorna una Arraylist de todos los productos DISPONIBLES/NO
     *         DIPONIBLES
     * @throws Exception : indica las excepciones que se pueden lanzar durante la
     *                   ejecución
     */
    public ArrayList<Producto> getAllProducto() throws Exception {
        try {
            ArrayList<Producto> productos = new ArrayList<Producto>();
            ProductoDAC productoDac = new ProductoDAC();
            ResultSet rs = productoDac.getProductoDisponible();

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
                        rs.getFloat(APP.BASE_DATOS_MYSQL.PRECIO_COMPRA),
                        rs.getFloat(APP.BASE_DATOS_MYSQL.PRECIO_VENTA),
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
     * Permite obtener todos los producto pero filtrados segun la categoría
     * 
     * @return : retorna un Arraylist de todos los productos disponibles / no
     *         disponibles clasificados por categoría
     * @throws Exception : indica las excepciones que se pueden lanzar durante la
     *                   ejecución
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
                        rs.getFloat(APP.BASE_DATOS_MYSQL.PRECIO_COMPRA),
                        rs.getFloat(APP.BASE_DATOS_MYSQL.PRECIO_VENTA),
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

    /**
     * Método que obtiene un único producto de la base de datos
     * 
     * @param codigo : de tipo String, es el id / código del pruducto
     * @return : retorna un lista de productos iterables
     * @throws Exception : indica las excepciones que se pueden lanzar durante la
     *                   ejecución
     */
    public ArrayList<Producto> getProductoByIDOrCode(String codigo) throws Exception {
        try {
            ArrayList<Producto> productos = new ArrayList<Producto>();
            ProductoDAC productoDac = new ProductoDAC();
            ResultSet rs = productoDac.getProductoByIDOrCode(codigo);

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
                        rs.getFloat(APP.BASE_DATOS_MYSQL.PRECIO_COMPRA),
                        rs.getFloat(APP.BASE_DATOS_MYSQL.PRECIO_VENTA),
                        rs.getString(APP.BASE_DATOS_MYSQL.DESCRIPCION),
                        // rs.getImage(APP.BASE_DATOS_MYSQL.IMAGEN ),
                        null,
                        rs.getString(APP.BASE_DATOS_MYSQL.FECHA_CREACION),
                        rs.getString(APP.BASE_DATOS_MYSQL.FECHA_MODIFICACION));
                productos.add(p);
            }
            return productos;
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getProductoByIDOrCode(String codigo):" + e.getMessage());
        }
    }

    /**
     * Obtiene todos los datos del producto registrado
     * 
     * @param nuevoProducto : recibe un objeto de tipo Producto lo cual permite
     *                      crear un producto
     *                      con los datos obtenidos del formulario de registro.
     * @throws AppException : indica las excepciones que se pueden lanzar durante la
     *                      ejecución, especificadas en la clase AppException
     */
    public void getRegistrarProducto(Producto nuevoProducto) throws AppException {
        ProductoDAC registrarProducto = new ProductoDAC();
        registrarProducto.registrarProducto(nuevoProducto);
    }

    /**
     * Obtiene los nombres registrados en la tabla Iva, en este caso "si" y "no"
     * El objetivo de este método es respetar la arquitectura y pasar de la capa DAC
     * a la Bl y luego a la GUI
     * 
     * @param cbxIvaProducto : recibe un comboBox dado que los datos obtenidos se
     *                       van a presentar en dicho componente
     */
    public void getConsultarIVA(JComboBox cbxIvaProducto) {
        IvaDAC consultarIva = new IvaDAC();
        consultarIva.consultarIVA(cbxIvaProducto);
    }

    /**
     * Obtiene las categorías registradas en la tabla CategoriaProducto
     * El objetivo de este método es respetar la arquitectura y pasar de la capa DAC
     * a la Bl y luego a la GUI
     * 
     * @param cbxIvaProducto : recibe un comboBox dado que los datos obtenidos se
     *                       van a presentar en dicho componente
     */
    public void getConsultarCategorias(JComboBox cbxCategoriaProducto) {
        CategoriaProductoDAC consultarCategoria = new CategoriaProductoDAC();
        consultarCategoria.consultarCategorias(cbxCategoriaProducto);
    }

}
