package BusinnessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinnessLogic.Entities.Usuario;
import DataAccess.UsuarioDAC;
import Framework.AppException;

public class UsuarioBL {

    public ArrayList<Usuario> getAllUser() throws AppException {
        try {
            UsuarioDAC userDAC = new UsuarioDAC();
            ArrayList<Usuario> users = new ArrayList<Usuario>();
            ResultSet rs = userDAC.getUser();
            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("ID_USUARIO"),
                        rs.getInt("FK_ID_ESTADO"),
                        rs.getInt("FK_ID_ROL"),
                        rs.getString("USUARIO"),
                        rs.getString("CONTRASENA"),
                        rs.getString("EMAIL"),
                        rs.getString("PRIMER_NOMBRE"),
                        rs.getString("SEGUNDO_NOMBRE"),
                        rs.getString("APELLIDO_PATERNO"),
                        rs.getString("APELLIDO_MATERNO"),
                        rs.getString("CEDULA"),
                        rs.getString("TELEFONO"),
                        // rs.getImage("FOTO")
                        null);
                users.add(u);
            }
            return users;
        } catch (SQLException errorSesion) {
            System.out.println("ERROR al obtener lista de usuarios " + "en getAllUser() " + errorSesion.getMessage());
        }
        return null;
    }

    // public Usuario getUserLogin(String usuario, char[] constrasena, int rol)
    // throws AppException {
    public Usuario getUserLogin(String usuario, char[] constrasena) throws AppException {
        try {
            UsuarioDAC userDAC = new UsuarioDAC();
            ResultSet rs = userDAC.getUser();
            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("ID_USUARIO"),
                        rs.getInt("FK_ID_ESTADO"),
                        rs.getInt("FK_ID_ROL"),
                        rs.getString("USUARIO"),
                        rs.getString("CONTRASENA"),
                        rs.getString("EMAIL"),
                        rs.getString("PRIMER_NOMBRE"),
                        rs.getString("SEGUNDO_NOMBRE"),
                        rs.getString("APELLIDO_PATERNO"),
                        rs.getString("APELLIDO_MATERNO"),
                        rs.getString("CEDULA"),
                        rs.getString("TELEFONO"),
                        // rs.getImage("FOTO")
                        null);
                if (u.getUsuario().equalsIgnoreCase(usuario) && u.getContrasena().equals(new String(constrasena))
                // && u.getFkIdRol() == rol) {
                ) {
                    return u;
                }
            }
        } catch (

        SQLException errorSesion) {
            System.out.println("ERROR al obtener lista de usuarios " + "en getAllUser() " + errorSesion.getMessage());
        }
        return null;
    }
}
