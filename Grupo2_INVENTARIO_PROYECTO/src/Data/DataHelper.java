package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DataHelper {

    Connection conexion = null;

    public Connection getConexion() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_inventario", "root", "");
            // JOptionPane.showMessageDialog(null, "conexión exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión " + e.getMessage());
        }
        return conexion;
    }

    public Connection getConexion(String nombreBD) {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/" + nombreBD, "root", "");
            // JOptionPane.showMessageDialog(null, "conexión exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión " + e.getMessage());
        }
        return conexion;
    }
}
