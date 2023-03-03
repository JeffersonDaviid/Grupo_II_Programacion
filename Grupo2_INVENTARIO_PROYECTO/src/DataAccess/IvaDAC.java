package DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import java.sql.PreparedStatement;

import Framework.APP;
import Framework.AppException;

public class IvaDAC extends DataHelper {

    PreparedStatement ps;
    ResultSet rs;

    /**
     * Permite consultar en la Base de Datos la tabla iva y asi obtener los estados de iva
     * disponible para mostrarlos en el ComboBox
     * 
     * @param iva : recibe como parámetro el JComboBox de IVA
     */
    public void consultarIVA(JComboBox iva) {
        String sql = "SELECT " + APP.BASE_DATOS_MYSQL.NOMBRE + " FROM " + APP.BASE_DATOS_MYSQL.TABLA_IVA;
        try {
            ps = DataHelper.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                iva.addItem(rs.getString(APP.BASE_DATOS_MYSQL.NOMBRE));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Consulta y obtiene el iva registrado en la tabla Iva según el id del mismo
     * 
     * @param id : se envia el id del iva requerido para realizar la consulta
     * @return : retorna el iva filtrado segun el id enviado
     * @throws AppException : indica las excepciones que se pueden lanzar durante la ejecución, especificadas en la clase AppException
     */
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

    /**
     * Consulta y obtiene todos los casos de iva registrados en la tabla Iva
     * 
     * @return : retorna todos los casos posibles para el iva
     * @throws AppException : indica las excepciones que se pueden lanzar durante la ejecución, especificadas en la clase AppException
     */
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
