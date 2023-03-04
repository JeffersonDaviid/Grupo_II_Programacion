package DataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Framework.APP;
import Framework.AppException;

public class CategoriaProductoDAC extends DataHelper {
    PreparedStatement ps;
    ResultSet rs;

    /**
     * Permite consultar en la Base de Datos específicamente en la tabla
     * CategoriaProducto y así obtener los tipos
     * de categorías disponibles pero filtrado según el id enviado como parámetro
     * 
     * @param id : se envia el id de la categoría requerida
     * @return : retorna la categoría con sus atributos, es decir, id y nombre
     * @throws AppException : indica las excepciones que se pueden lanzar durante la
     *                      ejecución, especificadas en la clase AppException
     */
    public ResultSet getCategoriaById(int id) throws AppException {

        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.FK_ID_ESTADO + ", "
                    + APP.BASE_DATOS_MYSQL.NOMBRE
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_CATEGORIA_PRODUCTO
                    + " WHERE "
                    + APP.BASE_DATOS_MYSQL.PK_ID_CATEGORIA_PRODUCTO + " = " + id;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "getCategoriaById() " + e.getMessage());
        }
    }

    /**
     * Permite consultar en la Base de Datos específicamente en la tabla
     * CategoriaProducto
     * y así obtener todos los tipos de categorías disponibles
     * 
     * @return : retorna todas las categorias registradas en la tabla
     *         CategoriaProducto de la Base de Datos
     * @throws AppException : indica las excepciones que se pueden lanzar durante la
     *                      ejecución, especificadas en la clase AppException
     */
    public ResultSet getAllCaterogia() throws AppException {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.FK_ID_ESTADO + ", "
                    + APP.BASE_DATOS_MYSQL.NOMBRE
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_CATEGORIA_PRODUCTO;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getAllCaterogia() " + e.getMessage());
        }
    }

}
