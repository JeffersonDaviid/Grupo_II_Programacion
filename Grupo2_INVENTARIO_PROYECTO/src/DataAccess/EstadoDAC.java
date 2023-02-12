package DataAccess;

import java.sql.ResultSet;

import Framework.APP;
import Framework.AppException;

public class EstadoDAC extends DataHelper {

    public ResultSet getAllEstado() throws Exception {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.ESTADO
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_ESTADO;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getEstadoById() " + e.getMessage());
        }
    }

    public ResultSet getEstadoById(int id) throws Exception {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.ESTADO
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_ESTADO
                    + " WHERE "
                    + APP.BASE_DATOS_MYSQL.PK_ID_ESTADO + " = " + id;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getEstadoById() " + e.getMessage());
        }
    }

}
