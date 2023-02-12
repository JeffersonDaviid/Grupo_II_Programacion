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
import UserInterface.UI_Component.CustomButton;
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

        JPanel panelHeader = new JPanel();
        add(panelHeader, BorderLayout.NORTH);
        panelHeader.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_1 = new JPanel();
        panelHeader.add(panel_1);

        JLabel lbTittle = new JLabel("INVENTARIO");
        panel_1.add(lbTittle);

        JPanel panelFiltroInventario = new JPanel();
        panelFiltroInventario.setBorder(new EmptyBorder(3, 15, 3, 15));
        panelHeader.add(panelFiltroInventario);
        panelFiltroInventario.setLayout(new GridLayout(2, 5, 15, 8));

        JLabel lblNewLabel = new JLabel("Filtrar por:");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panelFiltroInventario.add(lblNewLabel);

        JComboBox comboCategoria = new JComboBox();
        CategoriaProductoBL categoriaProducto = new CategoriaProductoBL();
        comboCategoria.addItem("Ninguno");
        for (String p : categoriaProducto.getAllCategoriaNombre()) {
            comboCategoria.addItem(p);
        }

        CustomButton btnNewButton_2 = new CustomButton("BUSCAR");
        panelFiltroInventario.add(btnNewButton_2);
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ProductoBL productoCategoria = new ProductoBL();
                    if (comboCategoria.getSelectedIndex() == APP.BASE_DATOS_MYSQL.NINGUN_FILTRO) {
                        tblInventario.construirTabla(getColumnasTabla(),
                                productoCategoria.getAllProducto());
                    } else {
                        tblInventario.construirTabla(getColumnasTabla(),
                                productoCategoria.getProductoByCategoria(comboCategoria.getSelectedIndex()));
                        System.out.println(comboCategoria.getSelectedIndex());
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        CustomText textField = new CustomText("Ingrese un valor", "Campo vacio");
        panelFiltroInventario.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("");
        panelFiltroInventario.add(lblNewLabel_1);

        JLabel lblNewLabel_6 = new JLabel("");
        panelFiltroInventario.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("");
        panelFiltroInventario.add(lblNewLabel_7);

        JLabel lblNewLabel_2 = new JLabel("");
        panelFiltroInventario.add(lblNewLabel_2);

        panelFiltroInventario.add(comboCategoria);

        JComboBox comboBox_1 = new JComboBox();
        panelFiltroInventario.add(comboBox_1);

        JComboBox comboBox_2 = new JComboBox();
        panelFiltroInventario.add(comboBox_2);

        JButton btnNewButton = new JButton("SALIR");
        panelFiltroInventario.add(btnNewButton);
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                removeAll();
                Bienvenida bienvenida = new Bienvenida("images/img_bienvenidosApp.jpg");
                bienvenida.setVisible(true);
            }
        });

        JLabel lblNewLabel_8 = new JLabel("");
        panelFiltroInventario.add(lblNewLabel_8);

        JLabel lblNewLabel_3 = new JLabel("");
        panelFiltroInventario.add(lblNewLabel_3);

        JLabel lblNewLabel_5 = new JLabel("");
        panelFiltroInventario.add(lblNewLabel_5);
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
