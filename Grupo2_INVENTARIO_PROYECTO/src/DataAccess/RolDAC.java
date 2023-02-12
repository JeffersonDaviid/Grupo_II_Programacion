package DataAccess;

import java.sql.ResultSet;

import Framework.APP;
import Framework.AppException;

public class RolDAC extends DataHelper {

    public ResultSet getUserRol() throws AppException {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.PK_ID_ROL + ", "
                    + APP.BASE_DATOS_MYSQL.NOMBRE
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_USUARIO;

            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getUserRol() " + e.getMessage());
        }
    }

}
