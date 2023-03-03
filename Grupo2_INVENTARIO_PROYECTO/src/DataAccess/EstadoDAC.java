package DataAccess;

import java.sql.ResultSet;

import Framework.APP;
import Framework.AppException;

public class EstadoDAC extends DataHelper {

    /**
     * Consulta y obtiene todos los atributos de los estados presentes en la tabla Estado de la Base de Datos
     * 
     * @return : retorna todos los estados posibles registrados en la tabla Estado
     * @throws Exception : indica las excepciones que se pueden lanzar durante la ejecución
     */
    public ResultSet getAllEstado() throws Exception {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.ESTADO
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_ESTADO;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getEstadoById() " + e.getMessage());
        }
    }

    /**
     * Consulta y obtiene los estados segun el id enviado como parametro
     * 
     * @param id : se envia el id del estado para consultar en la tabla Estado
     * @return : retorna el estado filtrado segun el id enviado
     * @throws Exception
     */
    public ResultSet getEstadoById(int id) throws Exception {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.ESTADO
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_ESTADO
                    + " WHERE "
                    + APP.BASE_DATOS_MYSQL.PK_ID_ESTADO + " = " + id;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getEstadoById() " + e.getMessage());
        }
    }

}
