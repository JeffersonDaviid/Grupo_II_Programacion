package PkgBusinnessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;

import PkgBusinnessLogic.Entities.Producto;
import PkgDataAccess.ProductoDAC;
import PkgFramework.APP;
import PkgFramework.AppException;

public class ProductoBL {

    /**
     * Obtiene todos los productos registrados en la BD y los almacena en un
     * ArrayList de tipo Producto
     * 
     * @return Retorna una Arraylist de todos los productos DISPONIBLES
     * @throws Exception
     * @return Retorna una Arraylist de todos los productos DISPONIBLES/NO
     *         DIPONIBLES
     * @throws Exception Indica las excepciones que se pueden lanzar durante la
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
     * @return Retorna un Arraylist de todos los productos disponibles / no
     *         disponibles clasificados por categoría
     * @throws Exception Indica las excepciones que se pueden lanzar durante la
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
     * @param codigo De tipo String, es el id / código del pruducto
     * @return Retorna un lista de productos iterables
     * @throws Exception Indica las excepciones que se pueden lanzar durante la
     *                   ejecución
     */
    public static ArrayList<Producto> getProductoPorIdOCodigo(String codigo) throws Exception {
        try {
            ArrayList<Producto> productos = new ArrayList<Producto>();
            ProductoDAC productoDac = new ProductoDAC();
            ResultSet rs = productoDac.getProductoPorIdOCodigo(codigo);

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
            throw new AppException(e, "Error en getProductoPorIdOCodigo(String codigo):" + e.getMessage());
        }
    }

    /**
     * Obtiene todos los datos del producto registrado
     * 
     * @param nuevoProducto Recibe un objeto de tipo Producto lo cual permite
     *                      crear un producto con los datos obtenidos del formulario
     *                      de registro.
     * @throws AppException Indica las excepciones que se pueden lanzar durante la
     *                      ejecución, especificadas en la clase AppException
     */
    public void getRegistrarProducto(Producto nuevoProducto) throws AppException {
        ProductoDAC registrarProducto = new ProductoDAC();
        registrarProducto.registrarProducto(nuevoProducto);
    }

    /**
     * Obtiene el método validarProducto de la capa DAC con el objetivo de respetar
     * la arquitectura establecida
     * 
     * @param idProducto     Id del producto a validar
     * @param codigoProducto Codigo del producto a validar
     * @param nombreProducto Nombre del producto a validar
     * @return Retorna el método original creado en la capa DAC
     * @throws AppException
     */
    public String getValidarProducto(String idProducto, String codigoProducto, String nombreProducto)
            throws AppException {
        ProductoDAC verificarProducto = new ProductoDAC();
        return verificarProducto.validarExistenciaProducto(idProducto, codigoProducto, nombreProducto);
    }

}
