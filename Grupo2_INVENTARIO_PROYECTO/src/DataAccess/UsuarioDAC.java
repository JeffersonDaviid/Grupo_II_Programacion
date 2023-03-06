package DataAccess;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Framework.APP;
import Framework.AppException;

public class UsuarioDAC extends DataHelper {

    /**
     * Obtiene todos los usuarios que ya se encuentran registrados en la Base de
     * Datos
     * 
     * @return : retorna los usuarios registrados
     * @throws AppException : indica las excepciones que se pueden lanzar durante la
     *                      ejecución, especificadas en la clase AppException
     */
    public ResultSet getUser() throws AppException {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.PK_ID_USUARIO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_ESTADO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_ROL
                    + ", " + APP.BASE_DATOS_MYSQL.USUARIO
                    + ", " + APP.BASE_DATOS_MYSQL.CONTRASENA
                    + ", " + APP.BASE_DATOS_MYSQL.EMAIL
                    + ", " + APP.BASE_DATOS_MYSQL.PRIMER_NOMBRE
                    + ", " + APP.BASE_DATOS_MYSQL.SEGUNDO_NOMBRE
                    + ", " + APP.BASE_DATOS_MYSQL.APELLIDO_PATERNO
                    + ", " + APP.BASE_DATOS_MYSQL.APELLIDO_MATERNO
                    + ", " + APP.BASE_DATOS_MYSQL.CEDULA
                    + ", " + APP.BASE_DATOS_MYSQL.TELEFONO
                    + ", " + APP.BASE_DATOS_MYSQL.FOTO
                    + " FROM " + APP.BASE_DATOS_MYSQL.TABLA_USUARIO;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getAllUser() " + e.getMessage());
        }
    }

    /**
     * Permite realizar cambios en las características de un usuario, utilizado
     * cuando se requiere actualizar un usuario
     * 
     * @param usuario         : envia el id del usuario
     * @param contrasena      : envia la contraseña del usuario
     * @param email           : envia el email correspondiente del usuario
     * @param primerNombre    : registra el primer nombre del usuario
     * @param segundoNombre   : registra el segundo nombre del usuario
     * @param apellidoPaterno : registra el apellido paterno del usuario
     * @param apellidoMaterno : registra el apellido materno del usuario
     * @param cedula          : envia el número de cédula del usuario
     * @param telefono        : envia el número de teléfono del usuario
     * @return : retorna el usuario con los atributos actualizados según hayan sido
     *         modificados
     * @throws AppException : indica las excepciones que se pueden lanzar durante la
     *                      ejecución, especificadas en la clase AppException
     */
    public boolean setUser(
            String usuario, String contrasena, String email, String primerNombre, String segundoNombre,
            String apellidoPaterno, String apellidoMaterno,
            String cedula, String telefono) throws AppException {
        try {
            String sql = "INSERT INTO "
                    + APP.BASE_DATOS_MYSQL.TABLA_USUARIO

                    + "( " + APP.BASE_DATOS_MYSQL.FK_ID_ROL
                    + ", " + APP.BASE_DATOS_MYSQL.USUARIO
                    + ", " + APP.BASE_DATOS_MYSQL.CONTRASENA
                    + ", " + APP.BASE_DATOS_MYSQL.EMAIL
                    + ", " + APP.BASE_DATOS_MYSQL.PRIMER_NOMBRE
                    + ", " + APP.BASE_DATOS_MYSQL.SEGUNDO_NOMBRE
                    + ", " + APP.BASE_DATOS_MYSQL.APELLIDO_PATERNO
                    + ", " + APP.BASE_DATOS_MYSQL.APELLIDO_MATERNO
                    + ", " + APP.BASE_DATOS_MYSQL.CEDULA
                    + ", " + APP.BASE_DATOS_MYSQL.TELEFONO + " )"

                    + " VALUES ( "
                    + 2 // Por defecto se registrará como trabajador
                    + ", '" + usuario + "'"
                    + ", '" + contrasena + "'"
                    + ", '" + email + "'"
                    + ", '" + primerNombre + "'"
                    + ", '" + segundoNombre + "'"
                    + ", '" + apellidoPaterno + "'"
                    + ", '" + apellidoMaterno + "'"
                    + ", '" + cedula + "'"
                    + ", '" + telefono + "'"
                    + " ) ";
            return setResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en setUser() " + e.getMessage());
        }
    }

}
