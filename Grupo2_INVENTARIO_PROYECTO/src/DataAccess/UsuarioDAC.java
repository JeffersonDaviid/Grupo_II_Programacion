package DataAccess;

import java.sql.ResultSet;

import Framework.APP;
import Framework.AppException;

public class UsuarioDAC extends DataHelper {

    public ResultSet getUser() throws AppException {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.PK_ID_USUARIO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_ESTADO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_ROL
                    + ", " + APP.BASE_DATOS_MYSQL.USUARIO
                    + ", " + APP.BASE_DATOS_MYSQL.CONTRASENA
                    + ", " + APP.BASE_DATOS_MYSQL.EMAIL
                    + ", " + APP.BASE_DATOS_MYSQL.PRIMER_NOMBRE
                    + ", " + APP.BASE_DATOS_MYSQL.SEGUNDO_NOMBRE
                    + ", " + APP.BASE_DATOS_MYSQL.APELLIDO_PATERNO
                    + ", " + APP.BASE_DATOS_MYSQL.APELLIDO_MATERNO
                    + ", " + APP.BASE_DATOS_MYSQL.CEDULA
                    + ", " + APP.BASE_DATOS_MYSQL.TELEFONO
                    + ", " + APP.BASE_DATOS_MYSQL.FOTO
                    + " FROM " + APP.BASE_DATOS_MYSQL.TABLA_USUARIO;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getAllUser() " + e.getMessage());
        }
    }

}