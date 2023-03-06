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
import UserInterface.UI_Component.CustomJPanel;
import UserInterface.UI_Component.CustomText;
import UserInterface.UI_Component.CustomTable.CustomTable;

public class ActualizarInventario extends JPanel {
    DefaultTableModel modelo = null;
    CustomTable tblInventario;
    CustomText txtBusqueda = new CustomText("Ingrese un valor", "Campo vacio");
    public ArrayList<Producto> lsProductos;
    private static ArrayList<String> lsEstadoNombre;
    private static ArrayList<String> lsCategoriaProductoNombre;
    private static ArrayList<String> lsIvaNombre;

    public ActualizarInventario() throws Exception {
        setOpaque(false);
        EstadoBL estadoBL = new EstadoBL();
        lsEstadoNombre = estadoBL.getAllEstadoNombre();
        CategoriaProductoBL categoriaBL = new CategoriaProductoBL();
        lsCategoriaProductoNombre = categoriaBL.getAllCategoriaNombre();
        IvaBL ivaBL = new IvaBL();
        lsIvaNombre = ivaBL.getAllIvaNombre();

        ProductoBL productoCategoria = new ProductoBL();
        lsProductos = productoCategoria.getAllProducto();
        // productoCategoria.getProductoByCategoria(comboBox.getSelectedIndex () + 1));
        setBackground(new Color(156, 84, 75));
        setLayout(new BorderLayout(0, 0));

        CustomJPanel panelPrincipal = new CustomJPanel("images/img_fondoRegistro.jpeg");
        add(panelPrincipal, BorderLayout.CENTER);
        panelPrincipal.setLayout(new BorderLayout(0, 0));

        JPanel panelHeader = new JPanel();
        panelPrincipal.add(panelHeader, BorderLayout.NORTH);
        panelHeader.setOpaque(false);
        panelHeader.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_1 = new JPanel();
        panelHeader.setOpaque(false);
        panelHeader.add(panel_1);

        JLabel lbTittle = new JLabel("INVENTARIO");
        panel_1.add(lbTittle);

        JPanel panelFiltroInventario = new JPanel();
        panelFiltroInventario.setOpaque(false);
        panelFiltroInventario.setBorder(new EmptyBorder(3, 15, 3, 15));
        panelHeader.add(panelFiltroInventario);
        panelFiltroInventario.setLayout(new GridLayout(2, 5, 15, 8));

        JLabel lblNewLabel = new JLabel("Filtrar por:");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panelFiltroInventario.add(lblNewLabel);

        JComboBox<String> cbxCategoria = new JComboBox<>();
        cargarComboItems(cbxCategoria, lsCategoriaProductoNombre, "Categoria");

        CustomButton btnBuscarFiltrar = new CustomButton("FILTRAR");
        panelFiltroInventario.add(btnBuscarFiltrar);
        btnBuscarFiltrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (txtBusqueda.getText().trim().equals("Ingrese un valor")
                            || txtBusqueda.getText().trim().equals("Campo vacio")
                            || txtBusqueda.getText().trim().isEmpty()) {
                        if (cbxCategoria.getSelectedIndex() == APP.BASE_DATOS_MYSQL.NINGUN_FILTRO) {
                            lsProductos = productoCategoria.getAllProducto();
                            tblInventario.construirTabla(getColumnasTabla(), lsProductos);
                        } else {
                            tblInventario.construirTabla(getColumnasTabla(),
                                    productoCategoria.getProductoByCategoria(cbxCategoria.getSelectedIndex()));
                            // System.out.println(cbxCategoria.getSelectedIndex());
                        }
                    } else {
                        lsProductos = productoCategoria.getProductoPorIdOCodigo(txtBusqueda.getText());
                        tblInventario.construirTabla(getColumnasTabla(), lsProductos);
                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

        });

        txtBusqueda.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {

                if ((txtBusqueda.getText().trim().equals("Ingrese un valor")
                        || txtBusqueda.getText().trim().equals("Campo vacio")
                        || txtBusqueda.getText().trim().isEmpty())) {
                    btnBuscarFiltrar.setText("FILTRAR");
                } else {
                    btnBuscarFiltrar.setText("BUSCAR");
                }

            }

            @Override
            public void focusLost(FocusEvent e) {

                if ((txtBusqueda.getText().trim().equals("Ingrese un valor")
                        || txtBusqueda.getText().trim().equals("Campo vacio")
                        || txtBusqueda.getText().trim().isEmpty())) {
                    btnBuscarFiltrar.setText("FILTRAR");
                } else {
                    btnBuscarFiltrar.setText("BUSCAR");
                }

            }
        });
        panelFiltroInventario.add(txtBusqueda);

        JLabel lblNewLabel_1 = new JLabel("");
        panelFiltroInventario.add(lblNewLabel_1);

        JLabel lblNewLabel_6 = new JLabel("");
        panelFiltroInventario.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("");
        panelFiltroInventario.add(lblNewLabel_7);

        JLabel lblNewLabel_2 = new JLabel("");
        panelFiltroInventario.add(lblNewLabel_2);

        panelFiltroInventario.add(cbxCategoria);

        JComboBox<String> cbxEstado = new JComboBox<>();
        cbxEstado.setVisible(false);
        cargarComboItems(cbxEstado, lsEstadoNombre, "Estado");
        panelFiltroInventario.add(cbxEstado);

        JComboBox<String> cbxIva = new JComboBox<>();
        cbxIva.setVisible(false);
        cargarComboItems(cbxIva, lsIvaNombre, "Iva");
        panelFiltroInventario.add(cbxIva);

        JButton btnNewButton = new JButton("SALIR");
        btnNewButton.setVisible(false);
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
        tblInventario = new CustomTable(getColumnasTabla(), lsProductos);
        panelPrincipal.add(tblInventario, BorderLayout.CENTER);
        tblInventario.setBorder(new EmptyBorder(0, 15, 0, 10));
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
        titulosList.add(" ");
        return titulosList;
    }

    /**
     * Método que permite cargar items en un comboBox
     * 
     * @param cbxContenedor     : elemento donde se insertarán los items
     * @param lsItem            : lista iterable con los nombres de los items
     * @param cbxItemPorDefecto : String con nombre de un elemento valor por defecto
     */
    private void cargarComboItems(JComboBox<String> cbxContenedor, ArrayList<String> lsItem, String cbxItemPorDefecto) {
        cbxContenedor.addItem(cbxItemPorDefecto);
        lsItem.forEach(cbxContenedor::addItem);
    }

}
