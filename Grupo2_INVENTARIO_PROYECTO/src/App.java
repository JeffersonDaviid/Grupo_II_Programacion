
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import UI_Interfaz.Disconected;
import UI_Interfaz.IniciarSesion;

public class App {

    public static void main(String[] args) throws Exception {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_usuarios", "root", "");
            IniciarSesion app = new IniciarSesion();
            app.setVisible(true);
            conexion.close();
        } catch (SQLException errorConectionInitial) {
            Disconected d = new Disconected();
            d.setVisible(true);
            // // sudo /opt/lampp/lampp start -> inicar
            // // sudo /opt/lampp/lampp stop -> parar
        }
    }
}
