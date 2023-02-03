package DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import Framework.AppException;

public class ProductoDAC extends DataHelper {
    public ResultSet getProducto() throws AppException {
        try {
            String sql = "SELECT ID_PRODUCTO, CODIGO_PRODUCTO, FK_ID_ESTADO, FK_ID_CATEGORIA_PRODUCTO, PK_ID_IVA, PRODUCTO, STOCK, PRECIO_COMPRA, PRECIO_VENTA, DESCRIPCION, IMAGEN, FECHA_CREACION, FECHA_MODIFICA FROM Producto";
            return getResultSet(sql);
        } catch (SQLException e) {
            throw new AppException(e, getClass(), "getProducto()");
        }
    }
}
