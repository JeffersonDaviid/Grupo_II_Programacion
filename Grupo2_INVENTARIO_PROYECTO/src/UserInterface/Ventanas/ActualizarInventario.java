package UserInterface.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Businness.Producto.Producto;
import Data.ConnectionMySQL;

public class ActualizarInventario extends JPanel {
    DefaultTableModel modelo = null;;
    public ArrayList<Producto> lsProductos;

    ConnectionMySQL cc = new ConnectionMySQL();
    Connection conexion = cc.conexion();
    private JTable tblInventario = new JTable();

    public ActualizarInventario() {
        setBackground(new Color(156, 84, 75));
        setLayout(new BorderLayout(0, 0));

        // String[] titulos = { "Código", "Artículo", "Unidad", "Precio", "Comentario",
        // "Fecha" };
        cargarInventario();
        // String[][] datos = {
        // { "HOLA 1", "HOLA 2", "HOLA 3", "HOLA 4", "HOLA 5", "HOLA 6" },
        // { "HOLA 1", "HOLA 2", "HOLA 3", "HOLA 4", "HOLA 5", "HOLA 6" },
        // { "HOLA 1", "HOLA 2", "HOLA 3", "HOLA 4", "HOLA 5", "HOLA 6" },
        // { "HOLA 1", "HOLA 2", "HOLA 3", "HOLA 4", "HOLA 5", "HOLA 6" }
        // };
        // tblInventario = new JTable(datos, titulos);
        add(tblInventario, BorderLayout.CENTER);
        // add(modelo, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1);

        JLabel lbTittle = new JLabel("INVENTARIO");
        panel_1.add(lbTittle);

        JPanel panel_2 = new JPanel();
        panel.add(panel_2);

        JButton btnNewButton = new JButton("SALIR");
        panel_2.add(btnNewButton);

        JButton btnNewButton_2 = new JButton("ACTUALIZAR");
        panel_2.add(btnNewButton_2);

    }

    private void cargarInventario() {
        String[] titulos = { "Código", "Artículo", "Unidad", "Precio", "Comentario", "Fecha" };
        String[] registros = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        // Almacenar consulta SELECT
        String SQL = "select * from inventario";

        try {
            // Objeto igualado a conexion
            Statement st = conexion.createStatement();
            // Obtener resultado
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                // Mostrar datos en fila de tabla
                registros[0] = rs.getString("Codigo");
                registros[1] = rs.getString("Articulo");
                registros[2] = rs.getString("Unidad");
                registros[3] = rs.getString("Precio");
                registros[4] = rs.getString("Comentario");
                registros[5] = rs.getString("Fecha");
                modelo.addRow(registros);
            }
            tblInventario.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos " + e);
        }

    }

    public void actualizarPorCodigo() {

        try {
            // Variable que almacena sentencia UPDATE
            String SQL = "update inventario set Articulo=?,Unidad=?,Precio=?,Comentario=?,Foto=?,Fecha=?,Hora=? where Codigo=?";

            // Crear objeto para igualar a conexion
            PreparedStatement pat = conexion.prepareStatement(SQL);
            // Referencia a columnas
            pat.setString(1, "hola");
            pat.execute();

            JOptionPane.showMessageDialog(null, "ACTUALIZACION EXITOSA");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se podido actulizar el inventario " + e.getMessage());
        }
    }

}
