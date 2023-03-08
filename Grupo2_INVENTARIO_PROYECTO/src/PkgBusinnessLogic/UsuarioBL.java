package PkgBusinnessLogic;

import java.sql.ResultSet;

import PkgBusinnessLogic.Entities.Usuario;
import PkgDataAccess.UsuarioDAC;
import PkgFramework.APP;
import PkgFramework.AppException;

public class UsuarioBL {

    /**
     * Método que devuelve el usuario que se va a ingresar al sistema, que recibe
     * como parámetros el usuario, contraseña y el rol que ejerce.
     * 
     * @param usuario     : recibe el nombre de usuario del personal a buscar
     * @param constrasena : recibe la contraseña del usuario requerido
     * @param rol         : se envia el rol del personal
     * @return : retorna los datos del usuario filtrado según los parámetros
     *         enviados
     * @throws Exception : indica las excepciones que se pueden lanzar durante la
     *                   ejecución
     */
    public Usuario getUserLogin(String usuario, char[] constrasena, int rol) throws Exception {
        try {
            UsuarioDAC userDAC = new UsuarioDAC();
            ResultSet rs = userDAC.getUser(usuario, new String(constrasena), rol);
            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt(APP.BASE_DATOS_MYSQL.PK_ID_USUARIO),
                        rs.getInt(APP.BASE_DATOS_MYSQL.FK_ID_ESTADO),
                        rs.getInt(APP.BASE_DATOS_MYSQL.FK_ID_ROL),
                        rs.getString(APP.BASE_DATOS_MYSQL.USUARIO),
                        rs.getString(APP.BASE_DATOS_MYSQL.CONTRASENA),
                        rs.getString(APP.BASE_DATOS_MYSQL.EMAIL),
                        rs.getString(APP.BASE_DATOS_MYSQL.PRIMER_NOMBRE),
                        rs.getString(APP.BASE_DATOS_MYSQL.SEGUNDO_NOMBRE),
                        rs.getString(APP.BASE_DATOS_MYSQL.APELLIDO_PATERNO),
                        rs.getString(APP.BASE_DATOS_MYSQL.APELLIDO_MATERNO),
                        rs.getString(APP.BASE_DATOS_MYSQL.CEDULA),
                        rs.getString(APP.BASE_DATOS_MYSQL.TELEFONO),
                        // rs.getImage("FOTO")
                        null);

                if (u.getUsuario().equalsIgnoreCase(usuario)
                        && u.getContrasena().equals(new String(constrasena)))
                    if (u.getFkIdRol() == rol)
                        return u;
            }
        } catch (Exception e) {
            throw new AppException(e, getClass(),
                    "Error en getUserLogin(String usuario, char[] constrasena, int rol): " + e.getMessage());
        }
        return null;
    }
}
