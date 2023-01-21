package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionMySQL {
    Connection conexion = null;

    public Connection conexion() {
        try {
            // Enlace a la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_inventario", "root", "");
            // JOptionPane.showMessageDialog(null, "conexión exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión " + e.getMessage());
            // sudo /opt/lampp/lampp stop -> parar
        }
        return conexion;
    }
}
