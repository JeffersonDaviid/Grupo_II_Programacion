package UserInterface.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BusinnessLogic.CategoriaProductoBL;
import BusinnessLogic.EstadoBL;
import BusinnessLogic.IvaBL;
import BusinnessLogic.ProductoBL;
import BusinnessLogic.Entities.Producto;
import Framework.APP;
import UserInterface.UI_Component.CustomButton;
import UserInterface.UI_Component.CustomText;
import UserInterface.UI_Component.CustomTable.CustomTable;

public class ActualizarInventario extends JPanel {
    DefaultTableModel modelo = null;
    CustomTable tblInventario;
    CustomText i_busqueda = new CustomText("Ingrese un valor", "Campo vacio");
    public ArrayList<Producto> lsProductos;
    private static ArrayList<String> lsEstadoNombre;
    private static ArrayList<String> lsCategoriaProductoNombre;
    private static ArrayList<String> lsIvaNombre;

    public ActualizarInventario() throws Exception {
        EstadoBL estadoBL = new EstadoBL();
        lsEstadoNombre = estadoBL.getAllEstadoNombre();
        CategoriaProductoBL categoriaBL = new CategoriaProductoBL();
        lsCategoriaProductoNombre = categoriaBL.getAllCategoriaNombre();
        IvaBL ivaBL = new IvaBL();
        lsIvaNombre = ivaBL.getAllIvaNombre();

        ProductoBL productoCategoria = new ProductoBL();
        lsProductos = productoCategoria.getAllProducto();
        tblInventario = new CustomTable(getColumnasTabla(), lsProductos);
        // productoCategoria.getProductoByCategoria(comboBox.getSelectedIndex () + 1));
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
        cargarComboItems(comboCategoria, lsCategoriaProductoNombre, "Categoria");

        CustomButton btn_buscar_filtrar = new CustomButton("FILTRAR");
        panelFiltroInventario.add(btn_buscar_filtrar);
        btn_buscar_filtrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (i_busqueda.getText().trim().equals("Ingrese un valor")
                            || i_busqueda.getText().trim().equals("Campo vacio")
                            || i_busqueda.getText().trim().isEmpty()) {
                        if (comboCategoria.getSelectedIndex() == APP.BASE_DATOS_MYSQL.NINGUN_FILTRO) {
                            lsProductos = productoCategoria.getAllProducto();
                            tblInventario.construirTabla(getColumnasTabla(), lsProductos);
                        } else {
                            tblInventario.construirTabla(getColumnasTabla(),
                                    productoCategoria.getProductoByCategoria(comboCategoria.getSelectedIndex()));
                            // System.out.println(comboCategoria.getSelectedIndex());
                        }
                    } else {
                        lsProductos = productoCategoria.getProductoPorIdOCodigo(i_busqueda.getText());
                        tblInventario.construirTabla(getColumnasTabla(), lsProductos);
                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

        });

        i_busqueda.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {

                if ((i_busqueda.getText().trim().equals("Ingrese un valor")
                        || i_busqueda.getText().trim().equals("Campo vacio")
                        || i_busqueda.getText().trim().isEmpty())) {
                    btn_buscar_filtrar.setText("FILTRAR");
                } else {
                    btn_buscar_filtrar.setText("BUSCAR");
                }

            }

            @Override
            public void focusLost(FocusEvent e) {

                if ((i_busqueda.getText().trim().equals("Ingrese un valor")
                        || i_busqueda.getText().trim().equals("Campo vacio")
                        || i_busqueda.getText().trim().isEmpty())) {
                    btn_buscar_filtrar.setText("FILTRAR");
                } else {
                    btn_buscar_filtrar.setText("BUSCAR");
                }

            }
        });
        panelFiltroInventario.add(i_busqueda);

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
        cargarComboItems(comboBox_1, lsEstadoNombre, "Estado");
        panelFiltroInventario.add(comboBox_1);

        JComboBox comboBox_2 = new JComboBox();
        cargarComboItems(comboBox_2, lsIvaNombre, "Iva");
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

    /**
     * Método que permite obtener las columnas de la tabla de productos
     * 
     * @return : retorna una lista iterable con los nombres de la tabla
     */
    public ArrayList<String> getColumnasTabla() {
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
        // titulosList.add("Imagen");
        // titulosList.add(" ");
        titulosList.add(" ");
        return titulosList;
    }

    private void cargarInventario() {
        ProductoBL producto = new ProductoBL();

    }

    /**
     * Método que permite cargar items en un comboBox
     * 
     * @param combo            : elemento donde se insertarán los items
     * @param lsItem           : lista iterable con los nombres de los items
     * @param comboItemDefecto : String con nombre de un elemento valor por defecto
     */
    private void cargarComboItems(JComboBox combo, ArrayList<String> lsItem, String comboItemDefecto) {
        combo.addItem(comboItemDefecto);
        for (String item : lsItem) {
            combo.addItem(item);
        }
    }

    /**
     * Método que permite cargar items en un comboBox
     * 
     * @param combo  : elemento donde se insertarán los items
     * @param lsItem : lista iterable con los nombres de los items
     */
    private void cargarComboItems(JComboBox combo, ArrayList<String> lsItem) {
        combo.addItem("Seleccione");
        for (String item : lsItem) {
            combo.addItem(item);
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

    /**
     * Permite validar que el nombre ingresado solo contenga letras
     * 
     * @param valor : recibe el nombre a validar
     * @return : true si el nombre es válido y false si no e válido
     */
    public boolean validarNombre(String valor) {
        return valor.trim().matches("^([a-z]|[A-Z]| [a-z]| [A-Z])+$");
    }

}
