package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public abstract class DataHelper {

    private static Connection conexion = null;

    public static Connection getConexion() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_inventario", "root", "");
            // JOptionPane.showMessageDialog(null, "conexión exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión " + e.getMessage());
        }
        return conexion;
    }

    protected Connection getConexion(String nombreBD) {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/" + nombreBD, "root", "");
            // JOptionPane.showMessageDialog(null, "conexión exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión " + e.getMessage());
        }
        return conexion;
    }

    protected static ResultSet getResultSet(String sql) throws SQLException {
        Connection conn = null; // OJO me parece que no estoy despediciando memoria
        Statement stmt = null;
        ResultSet rs = null;

        conn = getConexion();
        stmt = conn.createStatement(); // CRUD : select * ...
        rs = stmt.executeQuery(sql);
        return rs;
    }

}
