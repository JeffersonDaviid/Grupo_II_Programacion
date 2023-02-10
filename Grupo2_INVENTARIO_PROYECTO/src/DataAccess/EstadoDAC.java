package DataAccess;

import java.sql.ResultSet;

import Framework.AppException;

public class EstadoDAC extends DataHelper {

    public ResultSet getAllEstado() throws Exception {
        try {
            String sql = "SELECT * FROM Estado";
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getEstadoById() " + e.getMessage());
        }
    }

    public ResultSet getEstadoById(int id) throws Exception {
        try {
            String sql = "SELECT * FROM Estado WHERE ID_ESTADO = " + id;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getEstadoById() " + e.getMessage());
        }
    }

}
