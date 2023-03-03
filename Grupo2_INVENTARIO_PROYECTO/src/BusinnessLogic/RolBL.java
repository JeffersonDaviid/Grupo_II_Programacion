package BusinnessLogic;

import java.sql.ResultSet;

import DataAccess.RolDAC;
import Framework.APP;
import Framework.AppException;

public class RolBL {

    /**
     * Obtiene los atributos de rol presentes en la tabla Rol a partir del id
     * 
     * @param id : recibe el identificador tipo INT para conocer el rol
     * @return : String que almacena el nombre ("rol")
     * @throws Exception : indica las excepciones que se pueden lanzar durante la ejecución
     */
    public String getRolById(int id) throws Exception {
        try {
            RolDAC rolDac = new RolDAC();
            ResultSet rs = rolDac.getUserRol();
            while (rs.next()) {
                if (rs.getInt(APP.BASE_DATOS_MYSQL.PK_ID_ROL) == id) {
                    return rs.getString(APP.BASE_DATOS_MYSQL.NOMBRE);
                }
            }
        } catch (AppException e) {
            throw new AppException(e, getClass(), "Error en getRolById(int id): " + e.getMessage());
        }
        return null;
    }

}
