package UserInterface.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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

import BusinnessLogic.ProductoBL;
import BusinnessLogic.Entities.Producto;
import DataAccess.DataHelper;
import UserInterface.UI_Component.CustomTable;
import UserInterface.UI_Component.CustomText;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ActualizarInventario extends JPanel {
    DefaultTableModel modelo = null;;
    public ArrayList<Producto> lsProductos;

    private CustomTable tblInventario = new CustomTable();

    public ActualizarInventario() {
        setBackground(new Color(156, 84, 75));
        setLayout(new BorderLayout(0, 0));

        // cargarInventario();
        add(tblInventario, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1);

        JLabel lbTittle = new JLabel("INVENTARIO");
        panel_1.add(lbTittle);

        JPanel panel_2 = new JPanel();
        panel.add(panel_2);
        GridBagLayout gbl_panel_2 = new GridBagLayout();
        gbl_panel_2.columnWidths = new int[] { 150, 150, 150, 0 };
        gbl_panel_2.rowHeights = new int[] { 24, 0, 0 };
        gbl_panel_2.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
        gbl_panel_2.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
        panel_2.setLayout(gbl_panel_2);

        JButton btnNewButton = new JButton("SALIR");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                removeAll();
            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 0;
        panel_2.add(btnNewButton, gbc_btnNewButton);

        JButton btnNewButton_2 = new JButton("ACTUALIZAR");
        GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
        gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
        gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton_2.gridx = 1;
        gbc_btnNewButton_2.gridy = 0;
        panel_2.add(btnNewButton_2, gbc_btnNewButton_2);

        // textField = new JTextField("Ingrese un valor");
        // textField.setForeground(Color.GRAY);
        // textField.setMinimumSize(new Dimension(20, 20));
        // textField.addFocusListener(new FocusAdapter() {
        // @Override
        // public void focusGained(FocusEvent e) {
        // if (textField.getText().trim().equalsIgnoreCase("No pueden dejar campos sin
        // llenar")) {
        // textField.setText("");
        // }

        // if (textField.getText().trim().equalsIgnoreCase("Ingrese un valor")) {
        // textField.setText("");
        // }
        // textField.setForeground(Color.BLACK);
        // }

        // @Override
        // public void focusLost(FocusEvent e) {
        // if (textField.getText().trim().length() == 0) {
        // textField.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.RED));
        // textField.setForeground(Color.GRAY);
        // textField.setText("No pueden dejar campos sin llenar");
        // } else {
        // // textField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
        // textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
        // }

        // if (validarNombre(textField.getText())) {
        // // JOptionPane.showMessageDialog(null, "El dato es valido");
        // } else {
        // JOptionPane.showMessageDialog(null, "El dato NO es valido");
        // }

        // }
        // });
        // textField.setCaretColor(Color.BLACK);
        // textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
        // // textField.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        CustomText textField = new CustomText("Ingrese un valor", "Campo vacio");
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.fill = GridBagConstraints.BOTH;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 0;
        panel_2.add(textField, gbc_textField);
        textField.setColumns(10);
    }

    private void cargarInventario() {
        String[] titulos = { "ID", "Codigo", "Estado", "Categoria", "Iva", "Producto", "Precio compra",
                "Precio venta", "Descripcion", "Precio compra", "Fecha Creacion", "Fecha Modificacion" };
        String[] registros = new String[12];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        try {
            ProductoBL producto = new ProductoBL();
            for (Producto p : producto.getAllProducto()) {
                // Mostrar datos en fila de tabla
                registros[0] = p.getIdProducto().toString();
                registros[1] = p.getCodigoProducto();
                registros[2] = p.getFkEstado().getEstado();
                registros[3] = p.getFkCategoriaProducto().getNombre();
                registros[4] = p.getFkIva().getNombre();
                registros[5] = p.getProducto();
                registros[6] = "25.50";// p.getPrecioCompra();
                registros[7] = "155.63";// p.getPrecioVenta();
                registros[8] = p.getDescripcion();
                registros[9] = p.getStock() + "";
                registros[10] = p.getFechaIngreso();
                registros[11] = p.getFechaModificacion();
                modelo.addRow(registros);
            }

            // tblInventario.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos " + e);
        }

    }

    public void actualizarPorCodigo() {

        // try {
        // // Variable que almacena sentencia UPDATE
        // String SQL = "update inventario set
        // Articulo=?,Unidad=?,Precio=?,Comentario=?,Foto=?,Fecha=?,Hora=? where
        // Codigo=?";

        // // Crear objeto para igualar a conexion
        // PreparedStatement pat = conexion.prepareStatement(SQL);
        // // Referencia a columnas
        // pat.setString(1, "hola");
        // pat.execute();

        // JOptionPane.showMessageDialog(null, "ACTUALIZACION EXITOSA");

        // } catch (Exception e) {
        // JOptionPane.showMessageDialog(null, "No se podido actulizar el inventario " +
        // e.getMessage());
        // }
    }

    public boolean validarNombre(String valor) {
        return valor.trim().matches("^([a-z]|[A-Z]| [a-z]| [A-Z])+$");
    }

}
