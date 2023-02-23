package DataAccess;

import java.nio.charset.CodingErrorAction;
import java.sql.ResultSet;

import javax.swing.ImageIcon;

import Framework.APP;
import Framework.AppException;

public class ProductoDAC extends DataHelper {

    public ResultSet getProducto() throws AppException {
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
                    + APP.BASE_DATOS_MYSQL.TABLA_PRODUCTO;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "getProducto() " + e.getMessage());
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
            float precioCompra, float precioVenta, String descripcion, ImageIcon imagen) throws Exception {
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
                    + APP.BASE_DATOS_MYSQL.DESCRIPCION + " = '" + descripcion + "'"
                    // + APP.BASE_DATOS_MYSQL.IMAGEN + " = " + imagen + " ,"
                    // + APP.BASE_DATOS_MYSQL.IMAGEN + " = " + imagen
                    // + APP.BASE_DATOS_MYSQL.FECHA_CREACION + " = "+ +" ," // NUNCA CAMBIA
                    // + APP.BASE_DATOS_MYSQL.FECHA_MODIFICACION + " = " + +" ";
                    + " WHERE "
                    + APP.BASE_DATOS_MYSQL.CODIGO_PRODUCTO + " = '" + codigo + "'";

            // JOptionPane.showMessageDialog(null, "ACTUALIZACION EXITOSA");

            return setResultSet(sql);

        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en setProducto() " + e.getMessage());

        }
    }

}
