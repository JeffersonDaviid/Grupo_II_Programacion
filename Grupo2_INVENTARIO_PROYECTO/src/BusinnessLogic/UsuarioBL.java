package BusinnessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;

import BusinnessLogic.Entities.Usuario;
import DataAccess.UsuarioDAC;
import Framework.APP;
import Framework.AppException;

public class UsuarioBL {
    /**
     * Método que devuelve todos los usuarios registrados en la base de datos los
     * activos y los inactivos
     * 
     * @return
     * @throws Exception
     */
    public ArrayList<Usuario> getAllUser() throws Exception {
        try {
            UsuarioDAC userDAC = new UsuarioDAC();
            ArrayList<Usuario> users = new ArrayList<Usuario>();
            ResultSet rs = userDAC.getUser();
            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt(APP.BASE_DATOS_MYSQL.ID_USUARIO),
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
                users.add(u);
            }
            return users;
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getAllUser: " + e.getMessage());
        }
    }

    /**
     * Método que devuelve el usuario que se va a ingresar al sistema, que recibe
     * como parametros el usuario, contreaña y el rol que ejerce.
     * 
     * @param usuario
     * @param constrasena
     * @param rol
     * @return
     * @throws Exception
     */
    public Usuario getUserLogin(String usuario, char[] constrasena, int rol) throws Exception {
        try {
            UsuarioDAC userDAC = new UsuarioDAC();
            ResultSet rs = userDAC.getUser();
            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt(APP.BASE_DATOS_MYSQL.ID_USUARIO),
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
