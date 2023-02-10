package BusinnessLogic;

import java.sql.ResultSet;

import DataAccess.RolDAC;
import Framework.APP;
import Framework.AppException;

public class RolBL {

    public String getRolById(int id) throws Exception {
        try {
            RolDAC rolDac = new RolDAC();
            ResultSet rs = rolDac.getUserRol();
            while (rs.next()) {
                if (rs.getInt(APP.BASE_DATOS_MYSQL.ID_ROL) == id) {
                    return rs.getString(APP.BASE_DATOS_MYSQL.NOMBRE);
                }
            }
        } catch (AppException e) {
            throw new AppException(e, getClass(), "Error en getRolById(int id): " + e.getMessage());
        }
        return null;
    }

}
