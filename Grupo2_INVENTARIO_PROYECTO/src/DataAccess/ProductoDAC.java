package DataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import BusinnessLogic.Entities.Producto;
import Framework.APP;
import Framework.AppException;

public class ProductoDAC extends DataHelper {

    PreparedStatement ps;
    ResultSet rs;

    /**
     * Se conecta con la base de datos y permite registrar los datos ingresados en
     * el formulario
     * directamente con la tabla producto.
     * 
     * @param pro : del tipo Producto la cual es la entidad donde se alojan las
     *            variables, getters y setters del producto
     */
    public void registrarProducto(Producto pro) {
        String sql = "insert into " + APP.BASE_DATOS_MYSQL.TABLA_PRODUCTO + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = DataHelper.getConexion().prepareStatement(sql);
            ps.setString(1, pro.getIdProducto()); // idproducto
            ps.setString(2, pro.getCodigoProducto()); // codigo
            ps.setInt(3, 1); // estado (ez)
            ps.setInt(4, pro.getFkCategoriaProducto().getIdCategoriaProducto()); // categoria
            ps.setInt(5, pro.getFkIva().getId()); // iva
            ps.setString(6, pro.getProducto()); // nombre
            ps.setInt(7, pro.getStock()); // stock
            ps.setDouble(8, pro.getPrecioCompra()); // preciocompra
            ps.setDouble(9, pro.getPrecioVenta()); // precioventa
            ps.setString(10, ""); // descripcion
            ps.setString(11, null); // imagen
            ps.setString(12, pro.getFechaIngreso()); // fecha creacion
            ps.setString(13, "No modificado"); // fecha modificacion
            ps.executeUpdate();
            DataHelper.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Busca en la base de datos todos los productos DISPONIBLES
     * 
     * @return Resulset: con los datos extraídos
     * @throws AppException
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

    public ResultSet getProductoByIDOrCode(String codigo) throws AppException {
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
                    + APP.BASE_DATOS_MYSQL.PK_ID_PRODUCTO + " = " + codigo
                    + " OR "
                    + APP.BASE_DATOS_MYSQL.CODIGO_PRODUCTO + " = " + codigo;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getProductoByIDOrCode(String codigo) " + e.getMessage());
        }
    }

    public boolean setProducto(String id, String codigo, int estado, int categoriaProducto, int iva, String producto,
            int stock,
            float precioCompra, float precioVenta, String descripcion, ImageIcon imagen, String fechaModificacion)
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
