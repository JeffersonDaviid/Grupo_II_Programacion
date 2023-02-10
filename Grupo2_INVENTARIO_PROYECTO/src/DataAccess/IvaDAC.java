package DataAccess;

import java.sql.ResultSet;

import Framework.AppException;

public class IvaDAC extends DataHelper {

    public ResultSet getIvaById(int id) throws AppException {
        try {
            String sql = "SELECT NOMBRE FROM Iva WHERE ID_IVA = " + id;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getIvaById() " + e.getMessage());
        }
    }

}
