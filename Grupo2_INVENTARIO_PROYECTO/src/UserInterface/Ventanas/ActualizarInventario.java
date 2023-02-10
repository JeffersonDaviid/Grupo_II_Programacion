package UserInterface.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BusinnessLogic.CategoriaProductoBL;
import BusinnessLogic.ProductoBL;
import BusinnessLogic.Entities.Producto;
import Framework.APP;
import UserInterface.UI_Component.CustomText;
import UserInterface.UI_Component.CustomTable.CustomTable;

public class ActualizarInventario extends JPanel {
    DefaultTableModel modelo = null;
    CustomTable tblInventario;
    public ArrayList<Producto> lsProductos;

    public ActualizarInventario() throws Exception {
        ProductoBL productoCategoria = new ProductoBL();
        tblInventario = new CustomTable(getColumnasTabla(), productoCategoria.getAllProducto());
        // productoCategoria.getProductoByCategoria(comboBox.getSelectedIndex() + 1));
        setBackground(new Color(156, 84, 75));
        setLayout(new BorderLayout(0, 0));
        tblInventario.setBorder(new EmptyBorder(0, 15, 0, 10));
        add(tblInventario, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1);

        JLabel lbTittle = new JLabel("INVENTARIO");
        panel_1.add(lbTittle);

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new EmptyBorder(3, 15, 3, 15));
        panel.add(panel_3);
        panel_3.setLayout(new GridLayout(2, 5, 15, 8));

        JLabel lblNewLabel = new JLabel("Filtrar por:");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel_3.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        panel_3.add(lblNewLabel_1);

        JLabel lblNewLabel_6 = new JLabel("");
        panel_3.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("");
        panel_3.add(lblNewLabel_7);

        JLabel lblNewLabel_2 = new JLabel("");
        panel_3.add(lblNewLabel_2);

        JComboBox comboBox = new JComboBox();
        CategoriaProductoBL categoriaProducto = new CategoriaProductoBL();
        comboBox.addItem("Ninguno");
        for (String p : categoriaProducto.getAllCategoriaProducto()) {
            comboBox.addItem(p);
        }

        panel_3.add(comboBox);

        JLabel lblNewLabel_8 = new JLabel("");
        panel_3.add(lblNewLabel_8);

        JLabel lblNewLabel_3 = new JLabel("");
        panel_3.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("");
        panel_3.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("");
        panel_3.add(lblNewLabel_5);

        JPanel panel_2 = new JPanel();
        panel.add(panel_2);

        JButton btnNewButton = new JButton("SALIR");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                removeAll();
                Bienvenida bienvenida = new Bienvenida("images/img_bienvenidosApp.jpg");
                bienvenida.setVisible(true);
            }
        });

        JButton btnNewButton_2 = new JButton("ACTUALIZAR");
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ProductoBL productoCategoria = new ProductoBL();
                    if (comboBox.getSelectedIndex() == APP.BASE_DATOS_MYSQL.NINGUN_FILTRO) {
                        tblInventario.construirTabla(getColumnasTabla(),
                                productoCategoria.getAllProducto());
                    } else {
                        tblInventario.construirTabla(getColumnasTabla(),
                                productoCategoria.getProductoByCategoria(comboBox.getSelectedIndex()));
                        System.out.println(comboBox.getSelectedIndex());
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

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
        textField.setColumns(10);
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
                gl_panel_2.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addGap(323)
                                .addComponent(btnNewButton)
                                .addGap(18)
                                .addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 145,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(40)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addGap(68)));
        gl_panel_2.setVerticalGroup(
                gl_panel_2.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
                                .addComponent(btnNewButton)
                                .addComponent(btnNewButton_2)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)));
        panel_2.setLayout(gl_panel_2);
    }

    private ArrayList<String> getColumnasTabla() {
        ArrayList<String> titulosList = new ArrayList<String>();

        titulosList.add("ID");
        titulosList.add("Código");
        titulosList.add("Estado");
        titulosList.add("Categoria");
        titulosList.add("IVA");
        titulosList.add("Producto");
        titulosList.add("Stock");
        titulosList.add("P. Compra");
        titulosList.add("P. Venta");
        titulosList.add("Descripción");
        titulosList.add("Fec. Registro");
        titulosList.add("Fec. Modificación");
        titulosList.add("Imagen");
        titulosList.add(" ");
        titulosList.add(" ");
        return titulosList;
    }

    private void cargarInventario() {
        ProductoBL producto = new ProductoBL();

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
