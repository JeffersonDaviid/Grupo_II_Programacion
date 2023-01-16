
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import UI_Interfaz.Disconected;
import UI_Interfaz.IniciarSesion;

public class App extends JFrame {

    public static void main(String[] args) throws Exception {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_inventario", "root", "");
            IniciarSesion app = new IniciarSesion();
            app.setVisible(true);
            conexion.close();
        } catch (SQLException errorConectionInitial) {
            Disconected d = new Disconected();
            d.setVisible(true);
            System.out.println(errorConectionInitial);
            // // sudo /opt/lampp/lampp start -> inicar
            // // sudo /opt/lampp/lampp stop -> parar
        }
    }

    public App() {
        try {
            setIconImage(new ImageIcon(getClass().getResource("logoEmpresa.png")).getImage());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
