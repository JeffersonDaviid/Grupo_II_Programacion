package DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import Framework.AppException;

public class IvaDAC extends DataHelper {

    public ResultSet getIvaById(int id) throws AppException {
        try {
            String sql = "SELECT NOMBRE FROM Iva WHERE ID_IVA = " + id;
            return getResultSet(sql);
        } catch (SQLException e) {
            throw new AppException(e, getClass(), "getIvaById()");
        }
    }

}
