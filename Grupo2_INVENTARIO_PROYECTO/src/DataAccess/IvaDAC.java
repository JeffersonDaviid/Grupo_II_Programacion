package DataAccess;

import java.sql.ResultSet;

import Framework.APP;
import Framework.AppException;

public class IvaDAC extends DataHelper {

    public ResultSet getIvaById(int id) throws AppException {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.NOMBRE
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_IVA
                    + " WHERE "
                    + APP.BASE_DATOS_MYSQL.PK_ID_IVA + " = " + id;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getIvaById() " + e.getMessage());
        }
    }

    public ResultSet getAllIva() throws AppException {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.NOMBRE
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_IVA;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getAllIva() " + e.getMessage());
        }
    }

}
