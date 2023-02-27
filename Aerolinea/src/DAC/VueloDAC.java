package DAC;

import java.sql.ResultSet;
import java.sql.SQLException;

import FWK.APP;
import FWK.AppException;

public class VueloDAC extends DataHelperSQLite {

    public VueloDAC() throws AppException {
        super(APP.getProperty (APP.GLOBAL.KEY_DB_FULLPATH));
    }

    public ResultSet getAllVuelos() throws AppException{
        try {
            String sql = "SELECT ID, NOMBRE, APELLIDO FROM PERSONA";
            return getResultSet(sql);
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "getAllPet()");
        }
    }

    public ResultSet obtenerVuelos() throws SQLException {
        String sql = "SELECT * FROM VUELOS";
        ResultSet rs = getResultSet(sql);
        return rs;
    }

}
