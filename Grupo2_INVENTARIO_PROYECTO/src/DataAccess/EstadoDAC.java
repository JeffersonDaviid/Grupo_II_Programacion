package DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import Framework.AppException;

public class EstadoDAC extends DataHelper {

    public ResultSet getEstadoById(int id) throws AppException {
        try {
            String sql = "SELECT * FROM Estado WHERE ID_ESTADO = " + id;
            return getResultSet(sql);
        } catch (SQLException e) {
            throw new AppException(e, getClass(), "getEstadoById()");
        }
    }

}
