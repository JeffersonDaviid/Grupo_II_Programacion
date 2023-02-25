package DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import Framework.APP;
import Framework.AppException;
import java.sql.PreparedStatement;

public class IvaDAC extends DataHelper {
    PreparedStatement ps;
    ResultSet rs;

    /**
     * Permite consultar en la BD la tabla iva y asì obtener los estados de iva disponible para mostrarlos en el ComboBox
     * @param iva : recibe como paràmetro el JComboBox de IVA
     */
    public void consultarIVA(JComboBox iva){
        String sql = "SELECT NOMBRE FROM iva";
        try {
            ps = DataHelper.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                iva.addItem(rs.getString("NOMBRE"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public ResultSet getIvaById(int id) throws AppException {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.NOMBRE
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_IVA
                    + " WHERE "
                    + APP.BASE_DATOS_MYSQL.PK_ID_IVA + " = " + id;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getIvaById() " + e.getMessage());
        }
    }

    public ResultSet getAllIva() throws AppException {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.NOMBRE
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_IVA;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getAllIva() " + e.getMessage());
        }
    }

}
