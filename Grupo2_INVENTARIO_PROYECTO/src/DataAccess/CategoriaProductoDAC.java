package DataAccess;

import java.sql.ResultSet;

import Framework.AppException;

public class CategoriaProductoDAC extends DataHelper {

    public ResultSet getCategoriaById(int id) throws AppException {

        try {
            String sql = "SELECT FK_ID_ESTADO, NOMBRE FROM CategoriaProducto WHERE ID_CATEGORIA_PRODUCTO = " + id;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "getCategoriaById() " + e.getMessage());
        }
    }

    public ResultSet getAllCaterogia() throws AppException {
        try {
            String sql = "SELECT FK_ID_ESTADO, NOMBRE FROM CategoriaProducto";
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getAllCaterogia() " + e.getMessage());
        }
    }

}
