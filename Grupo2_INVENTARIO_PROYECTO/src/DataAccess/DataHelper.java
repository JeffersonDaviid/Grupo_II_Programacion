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
     * Método estático que realiza la conexión con la Base de Datos MySQL
     * 
     * @return retorna un objeto de tipo Connection
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
     * Método estático que realiza una conexión a la Base de Datos personalizada, es
     * decir se debe colocar el nombre de la base datos
     * 
     * @param nombreBD : nombre de la base de datos
     * @return : retorna un objeto de tipo Connection
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
     * Método estático que realiza una petición a la Base de Datos
     * 
     * @param sql : es la petición a la Base de Datos
     * @return : retorna la respuesta de la Base de Datos, objeto de tipo ResultSet
     * @throws AppException : indica las excepciones que se pueden lanzar durante la ejecución, especificadas en la clase AppException
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

    /**
     * Permite enviar los nombres de los datos a obtener en las tablas creadas en la Base de Datos
     * 
     * @param sql : String que almacena el comando u orden de SQL para realizar consultas, etc
     * @return : retorna la ejecución del ResultSet acorde a la sentencia almacenada en el String
     * @throws SQLException : indica las excepciones que se pueden lanzar durante la ejecución, del tipo SQLException
     */
    protected static boolean setResultSet(String sql) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        boolean rs = false;

        try {
            conn = getConexion();
            stmt = conn.createStatement(); // CRUD : select * ...
            rs = stmt.execute(sql);
        } catch (Exception e) {
            System.out.println("Error al obtener respuesta en : setResultSet(String sql) " + e.getMessage());
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

    /**
     * Permite enviar los nombres de los datos a obtener en las tablas creadas en la Base de Datos
     * 
     * @param sql : String que almacena el comando u orden de SQL para realizar consultas, etc
     * @return : retorna la ejecuciónn del ResultSet acorde a la sentencia almacenada en el String
     * @throws SQLException : indica las excepciones que se pueden lanzar durante la ejecución, del tipo SQLException
     */
    protected static int setResultSet1(String sql) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        int rs = 0;

        try {
            conn = getConexion();
            stmt = conn.createStatement(); // CRUD : select * ...
            rs = stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error al obtener respuesta en : setResultSet(String sql) " + e.getMessage());
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

    /**
     * Permite cerrar la conexión con la Base de Datos
     * 
     * @throws SQLException : indica las excepciones que se pueden lanzar durante la ejecución, del tipo SQLException
     */
    public static void cerrarConexion() throws SQLException {
        try {
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            conexion.close();
        } finally {
            conexion.close();
        }
    }

}
