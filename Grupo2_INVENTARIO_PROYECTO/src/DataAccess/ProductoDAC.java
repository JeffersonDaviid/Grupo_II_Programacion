package DataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;

import BusinnessLogic.Entities.Producto;
import Framework.APP;
import Framework.AppException;

public class ProductoDAC extends DataHelper {

    PreparedStatement ps;
    ResultSet rs;

    /**
     * Se conecta con la base de datos y permite registrar los datos ingresados en
     * el formulario de registrar productos directamente con la tabla Producto.
     * 
     * @param pro : del tipo Producto la cual es la entidad donde se alojan las
     *            variables, getters y setters del producto
     * @throws AppException : indica las excepciones que se pueden lanzar durante la
     *                      ejecución, especificadas en la clase AppException
     */
    public void registrarProducto(Producto pro) throws AppException {
        String sql = "INSERT INTO " + APP.BASE_DATOS_MYSQL.TABLA_PRODUCTO + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = DataHelper.getConexion().prepareStatement(sql);
            ps.setString(1, pro.getIdProducto()); // idproducto
            ps.setString(2, pro.getCodigoProducto()); // codigo
            ps.setInt(3, 1); // estado, por defecto siempre esta disponible cuando se registra
            ps.setInt(4, pro.getFkCategoriaProducto().getIdCategoriaProducto()); // categoría
            ps.setInt(5, pro.getFkIva().getId()); // iva
            ps.setString(6, pro.getProducto()); // nombre
            ps.setInt(7, pro.getStock()); // stock
            ps.setDouble(8, pro.getPrecioCompra()); // preciocompra
            ps.setDouble(9, pro.getPrecioVenta()); // precioventa
            ps.setString(10, ""); // descripcion
            ps.setString(11, null); // imagen
            ps.setString(12, pro.getFechaIngreso()); // fecha creacion
            ps.setString(13, "No modificado"); // fecha modificación, por defecto es no modificado
            ps.executeUpdate();
            DataHelper.cerrarConexion();
        } catch (Exception e) {
            throw new AppException(e, getClass(), "registrarProducto() " + e.getMessage());
            // JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Consulta y obtiene todos los productos registrados en la Base de Datos
     * 
     * @return : retorna el producto que se encuentra en la tabla Productos de la
     *         Base de Datos
     * @throws AppException : indica las excepciones que se pueden lanzar durante la
     *                      ejecución, especificadas en la clase AppException
     */
    public ResultSet getProductoDisponible() throws AppException {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.PK_ID_PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.CODIGO_PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_ESTADO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_CATEGORIA_PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_IVA
                    + ", " + APP.BASE_DATOS_MYSQL.PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.STOCK
                    + ", " + APP.BASE_DATOS_MYSQL.PRECIO_COMPRA
                    + ", " + APP.BASE_DATOS_MYSQL.PRECIO_VENTA
                    + ", " + APP.BASE_DATOS_MYSQL.DESCRIPCION
                    + ", " + APP.BASE_DATOS_MYSQL.IMAGEN
                    + ", " + APP.BASE_DATOS_MYSQL.FECHA_CREACION
                    + ", " + APP.BASE_DATOS_MYSQL.FECHA_MODIFICACION
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_PRODUCTO
                    + " WHERE "
                    + APP.BASE_DATOS_MYSQL.FK_ID_ESTADO + " = " + 1;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "getProductoDisponible() " + e.getMessage());
        }
    }

    /**
     * Permite obtener un producto de la Base de Datos por medio de su categoría
     * específica
     * 
     * @param idCategoria : se envia el id de la categoría del producto requerido
     * @return : retorna el producto según la categoría solicitada
     * @throws AppException : indica las excepciones que se pueden lanzar durante la
     *                      ejecución, especificadas en la clase AppException
     */
    public ResultSet getProductoByCategoria(int idCategoria) throws AppException {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.PK_ID_PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.CODIGO_PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_ESTADO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_CATEGORIA_PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_IVA
                    + ", " + APP.BASE_DATOS_MYSQL.PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.STOCK
                    + ", " + APP.BASE_DATOS_MYSQL.PRECIO_COMPRA
                    + ", " + APP.BASE_DATOS_MYSQL.PRECIO_VENTA
                    + ", " + APP.BASE_DATOS_MYSQL.DESCRIPCION
                    + ", " + APP.BASE_DATOS_MYSQL.IMAGEN
                    + ", " + APP.BASE_DATOS_MYSQL.FECHA_CREACION
                    + ", " + APP.BASE_DATOS_MYSQL.FECHA_MODIFICACION
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_PRODUCTO
                    + " WHERE "
                    + APP.BASE_DATOS_MYSQL.FK_ID_CATEGORIA_PRODUCTO + " = " + idCategoria;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getProductoByCategoria(int idCategoria) " + e.getMessage());
        }
    }

    /**
     * Obtiene un producto de la Base de Datos por medio del código o del id del
     * producto enviado
     * 
     * @param codigo : se envia el código del producto requerido
     * @return : retorna el producto filtrado según el código del mismo
     * @throws AppException : indica las excepciones que se pueden lanzar durante la
     *                      ejecución, especificadas en la clase AppException
     */
    public ResultSet getProductoPorIdOCodigo(String codigo) throws AppException {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.PK_ID_PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.CODIGO_PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_ESTADO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_CATEGORIA_PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_IVA
                    + ", " + APP.BASE_DATOS_MYSQL.PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.STOCK
                    + ", " + APP.BASE_DATOS_MYSQL.PRECIO_COMPRA
                    + ", " + APP.BASE_DATOS_MYSQL.PRECIO_VENTA
                    + ", " + APP.BASE_DATOS_MYSQL.DESCRIPCION
                    + ", " + APP.BASE_DATOS_MYSQL.IMAGEN
                    + ", " + APP.BASE_DATOS_MYSQL.FECHA_CREACION
                    + ", " + APP.BASE_DATOS_MYSQL.FECHA_MODIFICACION
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_PRODUCTO
                    + " WHERE "
                    + APP.BASE_DATOS_MYSQL.PK_ID_PRODUCTO + " = '" + codigo + "'"
                    + " OR "
                    + APP.BASE_DATOS_MYSQL.CODIGO_PRODUCTO + " = '" + codigo + "'";
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getProductoPorIdOCodigo(String codigo) " + e.getMessage());
        }
    }

    /**
     * Permite realizar cambios en las características de un producto, utilizado
     * cuando se requiere actualizar un producto
     * 
     * @param id                : envia un nuevo id si se modifica dicho valor en la
     *                          tabla de actualizar
     * @param codigo            : envia un nuevo código si se modifica dicho valor
     *                          en la tabla de actualizar
     * @param estado            : envia un nuevo estado si se modifica dicho valor
     *                          en la tabla de actualizar
     * @param categoriaProducto : envia un nuevo categoría si se modifica dicho
     *                          valor en la tabla de actualizar
     * @param iva               : envia un nuevo iva si se modifica dicho valor en
     *                          la tabla de actualizar
     * @param producto          : envia un nuevo nombre del producto si se modifica
     *                          dicho valor en la tabla de actualizar
     * @param stock             : envia un nuevo stock si se modifica dicho valor en
     *                          la tabla de actualizar
     * @param precioCompra      : envia un nuevo precio de compra si se modifica
     *                          dicho valor en la tabla de actualizar
     * @param precioVenta       : envia un nuevo precio de venta si se modifica
     *                          dicho valor en la tabla de actualizar
     * @param descripcion       : envia una nueva descripcion si se modifica dicho
     *                          valor en la tabla de actualizar
     * @param imagen            : envia una nueva imagen si se modifica dicho valor
     *                          en la tabla de actualizar
     * @param fechaModificacion : envia una fecha de modificación si se modifica
     *                          dicho valor en la tabla de actualizar
     * @return : retorna el producto con los atributos actualizados según hayan sido
     *         modificados
     * @throws Exception : indica las excepciones que se pueden lanzar durante la
     *                   ejecución
     */
    public boolean setProducto(String id, String codigo, int estado, int categoriaProducto, int iva, String producto,
            int stock, float precioCompra, float precioVenta, String descripcion, ImageIcon imagen,
            String fechaModificacion)
            throws Exception {
        try {
            String sql = "UPDATE "
                    + APP.BASE_DATOS_MYSQL.TABLA_PRODUCTO
                    + " SET "
                    + APP.BASE_DATOS_MYSQL.PK_ID_PRODUCTO + " = '" + id + "' ,"
                    // + APP.BASE_DATOS_MYSQL.CODIGO_PRODUCTO + " = "+ +" ," // NUNCA CAMBIA
                    + APP.BASE_DATOS_MYSQL.FK_ID_ESTADO + " = " + estado + " ,"
                    + APP.BASE_DATOS_MYSQL.FK_ID_CATEGORIA_PRODUCTO + " = " + categoriaProducto + " ,"
                    + APP.BASE_DATOS_MYSQL.FK_ID_IVA + " = " + iva + " ,"
                    + APP.BASE_DATOS_MYSQL.PRODUCTO + " = '" + producto + "' ,"
                    + APP.BASE_DATOS_MYSQL.STOCK + " = " + stock + " ,"
                    + APP.BASE_DATOS_MYSQL.PRECIO_COMPRA + " = " + precioCompra + " ,"
                    + APP.BASE_DATOS_MYSQL.PRECIO_VENTA + " = " + precioVenta + " ,"
                    + APP.BASE_DATOS_MYSQL.DESCRIPCION + " = '" + descripcion + "' ,"
                    // + APP.BASE_DATOS_MYSQL.IMAGEN + " = " + imagen + " ," // PROXIMA
                    // ACTUALIZACION
                    // + APP.BASE_DATOS_MYSQL.FECHA_CREACION + " = "+ +" ," // NUNCA CAMBIA
                    + APP.BASE_DATOS_MYSQL.FECHA_MODIFICACION + " = '" + fechaModificacion + "'"
                    + " WHERE "
                    + APP.BASE_DATOS_MYSQL.CODIGO_PRODUCTO + " = '" + codigo + "'";

            // JOptionPane.showMessageDialog(null, "ACTUALIZACION EXITOSA");

            return setResultSet(sql);

        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en setProducto() " + e.getMessage());

        }
    }

}
