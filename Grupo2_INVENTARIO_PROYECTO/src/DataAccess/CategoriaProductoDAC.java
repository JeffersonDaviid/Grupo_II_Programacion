package DataAccess;

import java.sql.ResultSet;
import java.util.ArrayList;

import Framework.APP;
import Framework.AppException;

public class CategoriaProductoDAC extends DataHelper {

    public ResultSet getCategoriaById(int id) throws AppException {

        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.FK_ID_ESTADO + ", "
                    + APP.BASE_DATOS_MYSQL.NOMBRE
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_CATEGORIA_PRODUCTO
                    + " WHERE "
                    + APP.BASE_DATOS_MYSQL.PK_ID_CATEGORIA_PRODUCTO + " = " + id;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "getCategoriaById() " + e.getMessage());
        }
    }

    public ResultSet getAllCaterogia() throws AppException {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.FK_ID_ESTADO + ", "
                    + APP.BASE_DATOS_MYSQL.NOMBRE
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_CATEGORIA_PRODUCTO;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getAllCaterogia() " + e.getMessage());
        }
    }

}
