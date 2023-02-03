package DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import Framework.AppException;

public class CategoriaProductoDAC extends DataHelper {

    public ResultSet getCategoriaById(int id) throws AppException {

        try {
            String sql = "SELECT FK_ID_ESTADO, NOMBRE FROM CategoriaProducto WHERE ID_CATEGORIA_PRODUCTO = " + id;
            return getResultSet(sql);
        } catch (SQLException e) {
            throw new AppException(e, getClass(), "getCategoriaById()");
        }
    }

}
