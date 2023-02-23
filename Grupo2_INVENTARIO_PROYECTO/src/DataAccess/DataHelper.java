package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Framework.APP;
import Framework.AppException;

public abstract class DataHelper {

    private static Connection conexion = null;

    /**
     * Método ESTÁTICO que realiza la conexión con la base de datos MYSQL
     * 
     * @return retorna un objeto de tipo CONNECTION
     */
    public static Connection getConexion() {
        try {
            conexion = DriverManager.getConnection(APP.GLOBAL.DB_NAME, APP.GLOBAL.DB_USER, APP.GLOBAL.DB_PASSWORD);
            // JOptionPane.showMessageDialog(null, "conexión exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión en: getConexion() " + e.getMessage());
        }
        return conexion;
    }

    /***
     * Método ESTÁTICO que realiza una conexión a la base de datos personalizada, es
     * decir se debe colocar el nombre de la base datos
     * 
     * @param nombreBD nombre de la base de datos
     * @return retorna un objeto de tipo CONNECTION
     */
    private static Connection getConexion(String nombreBD) {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/" + nombreBD, "root", "");
            // JOptionPane.showMessageDialog(null, "conexión exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión " + e.getMessage());
        }
        return conexion;
    }

    /***
     * Método ESTÁTICO que realiza una petición a la base de datos
     * 
     * @param sql Es la petición a la base de datos
     * @return retorna la respuesta de la base de datos, objeto de RESULSET
     * @throws AppException
     */
    protected static ResultSet getResultSet(String sql) {
        Connection conn = null; // OJO me parece que no estoy despediciando memoria
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConexion();
            stmt = conn.createStatement(); // CRUD : select * ...
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al obtener respuesta en : getResultSet(String sql) " + e.getMessage());
        }
        return rs;
    }

    // protected static boolean setResultSet(String sql) {
    // Connection conn = null; // OJO me parece que no estoy despediciando memoria
    // Statement stmt = null;
    // boolean rs = false;

    // try {
    // conn = getConexion();
    // stmt = conn.createStatement(); // CRUD : select * ...
    // rs = stmt.execute(sql);
    // } catch (Exception e) {
    // System.out.println("Error al obtener respuesta en : getResultSet(String sql)
    // " + e.getMessage());
    // }
    // return rs;
    // }

    protected static boolean setResultSet(String sql) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        boolean rs = false;

        try {
            conn = getConexion();
            stmt = conn.createStatement(); // CRUD : select * ...
            rs = stmt.execute(sql);
        } catch (Exception e) {
            System.out.println("Error al obtener respuesta en : getResultSet(String sql) " + e.getMessage());
        } finally { // Added finally block to ensure resources are closed properly
            if (stmt != null) { // Added check for statement object to prevent NullPointerException
                stmt.close(); // Close statement object
            }

            if (conn != null) { // Added check for connection object to prevent NullPointerException
                conn.close(); // Close connection object
            }
        }
        return rs; // Return result set boolean value
    }

}
