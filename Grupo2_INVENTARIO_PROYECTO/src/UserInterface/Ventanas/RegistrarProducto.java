package UserInterface.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BusinnessLogic.CategoriaProductoBL;
import BusinnessLogic.IvaBL;
import BusinnessLogic.ProductoBL;
import BusinnessLogic.Entities.Producto;
import DataAccess.ProductoDAC;
import Framework.APP;
import Framework.Validadores;
import UserInterface.UI_Component.CustomButton;
import UserInterface.UI_Component.CustomText;
import UserInterface.UI_Component.CustomTable.CustomTable;

public class RegistrarProducto extends JPanel {
    private DefaultTableModel modelo;
    //ProductoDAC product = new ProductoDAC();
    Producto nuevoProducto = new Producto();
    ProductoBL productoRegistrado = new ProductoBL();
    JTable tblProductos = new JTable();
    public ArrayList<Producto> lsProductosRegistrados = new ArrayList<Producto>();
    
    /**
     * @throws Exception para manejar las excepciones
     */
    public RegistrarProducto() throws Exception {
        
        /*
        * Se crean los paneles necesarios para organizar los componentes del formulario de registro de productos
        */
        setLayout(new BorderLayout(0, 0));
    	
    	JPanel panelPrincipal = new JPanel();
    	add(panelPrincipal);
    	panelPrincipal.setLayout(new BorderLayout(0, 0));
    	
    	JPanel panelSuperior = new JPanel();
    	panelPrincipal.add(panelSuperior, BorderLayout.NORTH);

        JPanel panelLateralIzquierdo = new JPanel();
        panelPrincipal.add(panelLateralIzquierdo, BorderLayout.WEST);
        panelLateralIzquierdo.setLayout(new GridLayout(0,1, 0, 0));
        
        JPanel panelCentral = new JPanel();
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);
        panelCentral.setLayout(new BorderLayout(0, 0));
        
        JPanel panelIngresoDatos = new JPanel();
        panelLateralIzquierdo.add(panelIngresoDatos);
        panelIngresoDatos.setLayout(new GridLayout(8, 2, 10, 10));
        
        
        /*
        * Labels de ayuda para dar un mejor aspecto a la ubicación de la tabla
        */
        JLabel lbCentralSuperior = new JLabel("      ");
        panelCentral.add(lbCentralSuperior, BorderLayout.NORTH);
        
        JLabel lbCentralInferior = new JLabel("      ");
        panelCentral.add(lbCentralInferior, BorderLayout.SOUTH);
        
        JLabel lbCentralIzquierdo = new JLabel("      ");
        panelCentral.add(lbCentralIzquierdo, BorderLayout.WEST);
        
        JLabel lbCentralDerecho = new JLabel("      ");
        panelCentral.add(lbCentralDerecho, BorderLayout.EAST);
        
        /*
        * Ahora, se crean los labels que acompañan a cada áreas de texto y combo boxes utilizados y el título
        * También se crean las áreas de texto donde se ingresa la información del producto por teclado.
        * Además se crean los combo boxes, en orden de aparición para que estén ordenados en el Grid Layaout
        */
        
        JLabel lbTittle = new JLabel("REGISTRAR PRODUCTO");
        lbTittle.setFont(new Font("Berlin Sans FB", Font.BOLD, 13));
        panelSuperior.add(lbTittle);

        JLabel lbNombreProducto = new JLabel("Nombre:");
        lbNombreProducto.setHorizontalAlignment(SwingConstants.CENTER);
        lbNombreProducto.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        panelIngresoDatos.add(lbNombreProducto);
         
        CustomText txtNombreProducto = new CustomText("Ingrese el nombre", "Campo vacío");
        panelIngresoDatos.add(txtNombreProducto);
        txtNombreProducto.setColumns(10);
 
        JLabel lbCodigoProducto = new JLabel("Código:");
        lbCodigoProducto.setHorizontalAlignment(SwingConstants.CENTER);
        lbCodigoProducto.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        panelIngresoDatos.add(lbCodigoProducto);
         
        CustomText txtCodigoProducto = new CustomText("Ingrese el código", "Campo vacío");
        panelIngresoDatos.add(txtCodigoProducto);
        txtCodigoProducto.setColumns(10);
 
        JLabel lbCategoriaProducto = new JLabel("Categoría:");
        lbCategoriaProducto.setHorizontalAlignment(SwingConstants.CENTER);
        lbCategoriaProducto.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        panelIngresoDatos.add(lbCategoriaProducto);
        
        //TODO Me da mala espina esta parte del cbxCategoria
        JComboBox cbxCategoriaProducto = new JComboBox();
        cbxCategoriaProducto.addItem("Hogar");
        cbxCategoriaProducto.addItem("Escuela");
        panelIngresoDatos.add(cbxCategoriaProducto);
        
        JLabel lbStockProducto = new JLabel("Stock:");
        lbStockProducto.setHorizontalAlignment(SwingConstants.CENTER);
        lbStockProducto.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        panelIngresoDatos.add(lbStockProducto);
        
        CustomText txtStockProducto = new CustomText("Ingrese el stock", "Campo vacío");
        txtStockProducto.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent evt) {
                validateNumericKeyEvent(evt);
                validarNumeroEntero(evt);
        	}

        });
        panelIngresoDatos.add(txtStockProducto);
        txtStockProducto.setColumns(10);
        
        JLabel lbPrecioCompraProducto = new JLabel("Precio Compra:");
        lbPrecioCompraProducto.setHorizontalAlignment(SwingConstants.CENTER);
        lbPrecioCompraProducto.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        panelIngresoDatos.add(lbPrecioCompraProducto);
        
        CustomText txtPrecioCompra = new CustomText("Ingrese p. compra", "Campo vacío");
        txtPrecioCompra.addKeyListener(new KeyAdapter() {
            @Override
        	public void keyTyped(KeyEvent evt) {
                validateNumericKeyEvent(evt);
        	}
        });
        panelIngresoDatos.add(txtPrecioCompra);
        txtPrecioCompra.setColumns(10);
        
        JLabel lbPrecioVentaProducto = new JLabel("Precio Venta:");
        lbPrecioVentaProducto.setHorizontalAlignment(SwingConstants.CENTER);
        lbPrecioVentaProducto.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        panelIngresoDatos.add(lbPrecioVentaProducto);
        
        CustomText txtPrecioVenta = new CustomText("Ingrese p. venta", "Campo vacío");
        txtPrecioVenta.addKeyListener(new KeyAdapter() {
            @Override
        	public void keyTyped(KeyEvent evt) {
                validateNumericKeyEvent(evt);
        	}
        });
        panelIngresoDatos.add(txtPrecioVenta);
        txtPrecioVenta.setColumns(10);
        
        JLabel lbIvaProducto = new JLabel("IVA:");
        lbIvaProducto.setHorizontalAlignment(SwingConstants.CENTER);
        lbIvaProducto.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        panelIngresoDatos.add(lbIvaProducto);
        
        //TODO revisar esta parte, me estoy saltando de capas
        JComboBox cbxIvaProducto = new JComboBox();
        productoRegistrado.getConsultarIVA(cbxIvaProducto); //Consulta en la tabla iva la expresión almacenado en "NOMBRE"
        panelIngresoDatos.add(cbxIvaProducto);

        /*
        * Creación de la tabla donde se mostraran los productos recien registrados
        */

        //TODO Realizar la tabla donde se muestran los productos, solo falta crear la tabla
        //Creación de la tabla donde se muestran los productos registrados
        // tblRegistrarProducto = new CustomTable(getColumnasTabla(),productoRegistrado.getAllProducto());
        // setBackground(new Color(156, 84, 75));
        // setLayout(new BorderLayout(0, 0));
        // tblRegistrarProducto.setBorder(new EmptyBorder(0, 15, 0, 10));
        // add(tblRegistrarProducto, BorderLayout.CENTER);
        
        String [][] datos = {{"1", "Fernando", "Castillo", "Ecuador", "xd", "xd", "xd", "xd"},
                             {"2", "Isabel", "Aguirre", "Colombiana", "xd", "xd", "xd", "xd"},
                             {"3", "Jerry", "Romero", "Peru", "xd", "xd", "xd", "xd"},};

        String [] cabezera = {"N°", "Nombre", "Código", "Categoría", "Stock", "Precio Compra", "Precio Venta", "IVA"};

        JScrollPane scroll = new JScrollPane();
        panelCentral.add(scroll);
        //JTable tblProductos = new JTable();
        //TODO ojo aqui
        modelo = new DefaultTableModel();
        refrescarTabla();
        tblProductos.setModel(modelo);
        
        getColumnasTabla();
        scroll.setViewportView(tblProductos);

        /* Creación de los botones Agregar y Limpiar
         * @btnAgregar: se encarga de agregar los datos del producto a la base de datos
         * @btnLimpiar: se encarga de limpiar los datos ingresados en los txt y cbx de la interfaz  
         */
        //TODO Falta hacer que los datos ingresados se registren en la base de datos
        CustomButton btnAgregar = new CustomButton("Agregar","images/iconos/save.png");
        btnAgregar.setBackground(Color.RED);
        btnAgregar.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        btnAgregar.setHorizontalAlignment(SwingConstants.CENTER);
        panelIngresoDatos.add(btnAgregar);
        btnAgregar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                //A continuación validamos que los campos del formulario no esten vacíos para un correcto guardado del producto
                if( !"".equals(txtNombreProducto.getText()) ||
                    !"".equals(txtCodigoProducto.getText()) || 
                    !"".equals(cbxCategoriaProducto.getSelectedItem()) ||
                    !"".equals(txtStockProducto.getText()) ||
                    !"".equals(txtPrecioCompra.getText()) ||
                    !"".equals(txtPrecioVenta.getText()) ||
                    !"".equals(cbxIvaProducto.getSelectedItem()))
                {
                    nuevoProducto.setProducto(txtNombreProducto.getText());
                    nuevoProducto.setCodigoProducto(txtCodigoProducto.getText());
                    //nuevoProducto.setFkCategoriaProducto(cbxCategoriaProducto.getSelectedItem().toString());
                    nuevoProducto.setStock(Integer.parseInt(txtStockProducto.getText()));
                    nuevoProducto.setPrecioCompra(Double.parseDouble(txtPrecioCompra.getText()));
                    nuevoProducto.setPrecioVenta(Double.parseDouble(txtPrecioVenta.getText()));
                    //nuevoProducto.setFkIva(cbxIvaProducto.getSelectedItem().toString());
                    productoRegistrado.getRegistrarProducto(nuevoProducto);
                    lsProductosRegistrados.add(nuevoProducto);
                    refrescarTabla();
                    //product.RegistrarProducto(productoRegistrado);
                    JOptionPane.showMessageDialog(null, "Producto Registrado");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al agregar producto, verifica que los campos no esten vacíos");
                }
                
            }
        });

        CustomButton btnLimpiar = new CustomButton("Limpiar","images/iconos/limpiar.png");
        btnLimpiar.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        btnLimpiar.setHorizontalAlignment(SwingConstants.CENTER);
        panelIngresoDatos.add(btnLimpiar);
        btnLimpiar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                txtNombreProducto.setText("");
                txtCodigoProducto.setText("");
                cbxCategoriaProducto.setSelectedIndex(0);
                txtStockProducto.setText("");
                txtPrecioCompra.setText("");
                txtPrecioVenta.setText("");
                cbxIvaProducto.setSelectedIndex(0);
            }
        });

        
        /*
         *Validadores que desactivan la opción de copiar, pegar y cortar de los componentes deseados 
         */
        Validadores.deshabilitarCVX(txtNombreProducto);
        Validadores.deshabilitarCVX(txtCodigoProducto);
        Validadores.deshabilitarCVX(txtStockProducto);
        Validadores.deshabilitarCVX(txtPrecioCompra);
        Validadores.deshabilitarCVX(txtPrecioVenta);
        
    }
    
    /**
     * Método que asigna a cada columna de la tabla un título correspondiente
     */
    private void getColumnasTabla() {
        modelo.addColumn("N°");
        modelo.addColumn("Nombre");
        modelo.addColumn("Código");
        modelo.addColumn("Categoría");
        modelo.addColumn("Stock");
        modelo.addColumn("Precio Compra");
        modelo.addColumn("Precio Venta");
        modelo.addColumn("IVA");
    }

    private void refrescarTabla() {
        //borrar todos los elementos del modelo.
        while(modelo.getRowCount() > 0){
            modelo.removeRow(0);
        }

        for (Producto nuevoProducto : lsProductosRegistrados) {
            Object p[] = new Object[8];
            p[0] = 1;
            p[1] = nuevoProducto.getProducto();
            p[2] = nuevoProducto.getCodigoProducto();
            p[3] = nuevoProducto.getFkCategoriaProducto();
            p[4] = nuevoProducto.getStock();
            p[5] = nuevoProducto.getPrecioCompra();
            p[6] = nuevoProducto.getPrecioVenta();
            p[7] = nuevoProducto.getFkIva();
            modelo.addRow(p);
        }
        tblProductos.setModel(modelo);
    }

    // public void llenarTabla(){

    // }
    

    /**
     * Método para validar que las entradas ingresadas sean solo números
     * @param evt evento tipo KeyEvent que se activa cada vez que se teclea en la caja de texto
     */
    private void validateNumericKeyEvent(KeyEvent evt) {
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Error, solo se admiten entradas numéricas.");
        }
    }

    /**
     * Método para validar que las entradas ingresadas sean solo números enteros, en este caso, ignora entradas como "." y "," entre otros.
     * @param evt evento tipo KeyEvent que se activa cada vez que se teclea en la caja de texto
     */
    private void validarNumeroEntero(KeyEvent evt) {
        char validarEntero = evt.getKeyChar();
        if (validarEntero < '0' || validarEntero > '9') {
            evt.consume(); // Ignora la entrada no válida
        }
    }
}
