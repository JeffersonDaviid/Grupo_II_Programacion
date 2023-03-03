package DataAccess;

import java.sql.ResultSet;

import Framework.APP;
import Framework.AppException;

public class RolDAC extends DataHelper {

    /**
     * Obtiene el rol del usuario registrado en la tabla Usuario
     * 
     * @return : retorna todos los roles disponibles 
     * @throws AppException : indica las excepciones que se pueden lanzar durante la ejecución, especificadas en la clase AppException
     */
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
