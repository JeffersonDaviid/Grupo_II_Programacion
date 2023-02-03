package DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import Framework.AppException;

public class RolDAC extends DataHelper {

    public ResultSet getUser() throws AppException {
        try {
            String sql = "SELECT ID_USUARIO , FK_ID_ESTADO, FK_ID_ROL, USUARIO, CONTRASENA, EMAIL, PRIMER_NOMBRE, SEGUNDO_NOMBRE, APELLIDO_PATERNO, APELLIDO_MATERNO, CEDULA, TELEFONO, FOTO FROM Usuario";
            return getResultSet(sql);
        } catch (SQLException e) {
            throw new AppException(e, getClass(), "getAllUser()");
        }
    }
}
