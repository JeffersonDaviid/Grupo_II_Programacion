package PkgDataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import PkgFramework.APP;
import PkgFramework.AppException;

public class IvaDAC extends DataHelper {

    PreparedStatement ps;
    ResultSet rs;

    /**
     * Consulta y obtiene el iva registrado en la tabla Iva según el id del mismo
     * 
     * @param id Se envia el id del iva requerido para realizar la consulta
     * @return Retorna el iva filtrado segun el id enviado
     * @throws AppException Indica las excepciones que se pueden lanzar durante la
     *                      ejecución, especificadas en la clase AppException
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
     * @return Retorna todos los casos posibles para el iva
     * @throws AppException Indica las excepciones que se pueden lanzar durante la
     *                      ejecución, especificadas en la clase AppException
     */
    public ResultSet getIvaNombre() throws AppException {
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
