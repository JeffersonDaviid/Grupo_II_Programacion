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

import BusinnessLogic.UsuarioBL;
import BusinnessLogic.Entities.Usuario;
import DataAccess.UsuarioDAC;
import Framework.APP;
import Framework.Validadores;
import UserInterface.UI_Component.CustomButton;
import UserInterface.UI_Component.CustomText;
import UserInterface.UI_Component.CustomTable.CustomTable;

public class RegistrarTrabajador extends JPanel {
    private DefaultTableModel modelo;
    //CustomTable tblRegistrarTrabajador;
    UsuarioDAC user = new UsuarioDAC();
    Usuario nuevoTrabajador = new Usuario();
    UsuarioBL trabajadorRegistrado = new UsuarioBL();
    JTable tblTrabajadores = new JTable();
    public ArrayList<Usuario> lsTrabajadoresRegistrados = new ArrayList<Usuario>();
    
    /**
     * @throws Exception para manejar las excepciones
     */
    public RegistrarTrabajador() throws Exception {
        
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
        panelIngresoDatos.setLayout(new GridLayout(10, 2, 10, 10));
        
        
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
        
        JLabel lbTittle = new JLabel("REGISTRAR TRABAJADOR");
        lbTittle.setFont(new Font("Berlin Sans FB", Font.BOLD, 13));
        panelSuperior.add(lbTittle);
        
        // int idUsuario;
        // int FkIdEstado;
        // int FkIdRol;
        // String usuario;
        // String contrasena;
        // String email;
        // String primerNombre;
        // String segundoNombre;
        // String apellidoPaterno;
        // String apellidoMaterno;
        // String cedula;
        // String telefono;
        // ImageIcon foto;

        JLabel lbUsuarioTrabajador = new JLabel("Usuario:");
        lbUsuarioTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
        lbUsuarioTrabajador.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        panelIngresoDatos.add(lbUsuarioTrabajador);
         
        CustomText txtUsuarioTrabajador = new CustomText("Ingrese un usuario", "Campo vacío");
        panelIngresoDatos.add(txtUsuarioTrabajador);
        txtUsuarioTrabajador.setColumns(10);
 
        JLabel lbContrasenaTrabajador = new JLabel("Contraseña:");
        lbContrasenaTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
        lbContrasenaTrabajador.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        panelIngresoDatos.add(lbContrasenaTrabajador);
         
        CustomText txtContrasenaTrabajador = new CustomText("Ingrese una contraseña", "Campo vacío");
        panelIngresoDatos.add(txtContrasenaTrabajador);
        txtContrasenaTrabajador.setColumns(10);
 
        JLabel lbEmailTrabajador = new JLabel("Email:");
        lbEmailTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
        lbEmailTrabajador.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        panelIngresoDatos.add(lbEmailTrabajador);
        
        CustomText txtEmailTrabajador = new CustomText("Ingrese su email", "Campo vacío");
        panelIngresoDatos.add(txtEmailTrabajador);
        txtEmailTrabajador.setColumns(10);
        
        JLabel lbPrimerNombre = new JLabel("Primer Nombre:");
        lbPrimerNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lbPrimerNombre.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        panelIngresoDatos.add(lbPrimerNombre);
        
        CustomText txtPrimerNombre = new CustomText("Ingrese el primer nombre", "Campo vacío");
        txtPrimerNombre.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt){
                validarTexto(evt);
            }

        });
        panelIngresoDatos.add(txtPrimerNombre);
        txtPrimerNombre.setColumns(10);
        
        JLabel lbSegundoNombre = new JLabel("Segundo Nombre:");
        lbSegundoNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lbSegundoNombre.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        panelIngresoDatos.add(lbSegundoNombre);
        
        CustomText txtSegundoNombre = new CustomText("Ingrese el segundo nombre", "Campo vacío");
        txtSegundoNombre.addKeyListener(new KeyAdapter() {
            @Override
        	public void keyTyped(KeyEvent evt) {
                validarTexto(evt);
        	}
        });
        panelIngresoDatos.add(txtSegundoNombre);
        txtSegundoNombre.setColumns(10);
        
        JLabel lbApellidoPaterno = new JLabel("Apellido Paterno:");
        lbApellidoPaterno.setHorizontalAlignment(SwingConstants.CENTER);
        lbApellidoPaterno.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        panelIngresoDatos.add(lbApellidoPaterno);
        
        CustomText txtApellidoPaterno = new CustomText("Ingrese el apellido paterno", "Campo vacío");
        txtApellidoPaterno.addKeyListener(new KeyAdapter() {
            @Override
        	public void keyTyped(KeyEvent evt) {
                validarTexto(evt);
        	}
        });
        panelIngresoDatos.add(txtApellidoPaterno);
        txtApellidoPaterno.setColumns(10);
        
        JLabel lbApellidoMaterno = new JLabel("Apellido Materno:");
        lbApellidoMaterno.setHorizontalAlignment(SwingConstants.CENTER);
        lbApellidoMaterno.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        panelIngresoDatos.add(lbApellidoMaterno);
        
        CustomText txtApellidoMaterno = new CustomText("Ingrese el apellido materno", "Campo vacío");
        txtApellidoMaterno.addKeyListener(new KeyAdapter() {
            @Override
        	public void keyTyped(KeyEvent evt) {
                validarTexto(evt);
        	}
        });
        panelIngresoDatos.add(txtApellidoMaterno);
        txtApellidoMaterno.setColumns(10);
        
        JLabel lbCedula = new JLabel("Cédula:");
        lbCedula.setHorizontalAlignment(SwingConstants.CENTER);
        lbCedula.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        panelIngresoDatos.add(lbCedula);
        
        CustomText txtCedula = new CustomText("Ingrese el N° de cedula", "Campo vacío");
        txtApellidoMaterno.addKeyListener(new KeyAdapter() {
            @Override
        	public void keyTyped(KeyEvent evt) {
                validateNumericKeyEvent(evt);
                validarNumeroEntero(evt);
        	}
        });
        panelIngresoDatos.add(txtCedula);
        txtCedula.setColumns(10);

        JLabel lbTelefono = new JLabel("Teléfono:");
        lbTelefono.setHorizontalAlignment(SwingConstants.CENTER);
        lbTelefono.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        panelIngresoDatos.add(lbTelefono);

        CustomText txtTelefono = new CustomText("Ingrese el N° de teléfono", "Campo vacío");
        txtApellidoMaterno.addKeyListener(new KeyAdapter() {
            @Override
        	public void keyTyped(KeyEvent evt) {
                validateNumericKeyEvent(evt);
                validarNumeroEntero(evt);
        	}
        });
        panelIngresoDatos.add(txtTelefono);
        txtTelefono.setColumns(10);
        
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
        tblTrabajadores.setModel(modelo);
        
        getColumnasTabla();
        scroll.setViewportView(tblTrabajadores);

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
                // if( !"".equals(txtNombreProducto.getText()) ||
                // !"".equals(txtCodigoProducto.getText()) || 
                // !"".equals(cbxCategoriaProducto.getSelectedItem()) ||
                // !"".equals(txtStockProducto.getText()) ||
                //     !"".equals(txtPrecioCompra.getText()) ||
                //     !"".equals(txtPrecioVenta.getText()) ||
                //     !"".equals(cbxIvaProducto.getSelectedItem()))
                // {
                //     nuevoProducto.setProducto(txtNombreProducto.getText());
                //     nuevoProducto.setCodigoProducto(txtCodigoProducto.getText());
                //     //nuevoProducto.setFkCategoriaProducto(cbxCategoriaProducto.getSelectedItem().toString());
                //     nuevoProducto.setStock(Integer.parseInt(txtStockProducto.getText()));
                //     nuevoProducto.setPrecioCompra(Double.parseDouble(txtPrecioCompra.getText()));
                //     nuevoProducto.setPrecioVenta(Double.parseDouble(txtPrecioVenta.getText()));
                //     //nuevoProducto.setFkIva(cbxIvaProducto.getSelectedItem().toString());
                //     product.registrarProducto(nuevoProducto);
                //     lsProductosRegistrados.add(nuevoProducto);
                //     refrescarTabla();
                //     //product.RegistrarProducto(productoRegistrado);
                //     JOptionPane.showMessageDialog(null, "Producto Registrado");
                // }else{
                //     JOptionPane.showMessageDialog(null, "Error al agregar producto, verifica que los campos no esten vacíos");
                // }
                
            }
        });

        CustomButton btnLimpiar = new CustomButton("Limpiar","images/iconos/limpiar.png");
        btnLimpiar.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        btnLimpiar.setHorizontalAlignment(SwingConstants.CENTER);
        panelIngresoDatos.add(btnLimpiar);
        btnLimpiar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                txtUsuarioTrabajador.setText("");
                txtContrasenaTrabajador.setText("");
                txtPrimerNombre.setText("");
                txtSegundoNombre.setText("");
                txtApellidoPaterno.setText("");
                txtApellidoMaterno.setText("");
                txtCedula.setText("");
                txtTelefono.setText("");
            }
        });

        
        /*
        *Validadores que desactivan la opción de copiar, pegar y cortar de los componentes deseados 
         */
        Validadores.deshabilitarCVX(txtUsuarioTrabajador);
        Validadores.deshabilitarCVX(txtContrasenaTrabajador);
        Validadores.deshabilitarCVX(txtEmailTrabajador);
        Validadores.deshabilitarCVX(txtPrimerNombre);
        Validadores.deshabilitarCVX(txtSegundoNombre);
        Validadores.deshabilitarCVX(txtApellidoPaterno);
        Validadores.deshabilitarCVX(txtApellidoMaterno);
        Validadores.deshabilitarCVX(txtCedula);
        Validadores.deshabilitarCVX(txtTelefono);
        
    }
    
    /**
     * Método que asigna a cada columna de la tabla un título correspondiente
     */
    private void getColumnasTabla() {
        modelo.addColumn("N°");
        modelo.addColumn("Usuario");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Email");
        modelo.addColumn("Primer Nombre");
        modelo.addColumn("Segundo Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Cédula");
        modelo.addColumn("Teléfono");
    }

    private void refrescarTabla() {
        //borrar todos los elementos del modelo.
        while(modelo.getRowCount() > 0){
            modelo.removeRow(0);
        }

        // for (Producto nuevoProducto : lsProductosRegistrados) {
        //     Object p[] = new Object[8];
        //     p[0] = 1;
        //     p[1] = nuevoProducto.getProducto();
        //     p[2] = nuevoProducto.getCodigoProducto();
        //     p[3] = nuevoProducto.getFkCategoriaProducto();
        //     p[4] = nuevoProducto.getStock();
        //     p[5] = nuevoProducto.getPrecioCompra();
        //     p[6] = nuevoProducto.getPrecioVenta();
        //     p[7] = nuevoProducto.getFkIva();
        //     modelo.addRow(p);
        // }
        tblTrabajadores.setModel(modelo);
    }

    // public void llenarTabla(){

    // }
    
    /**
     * Método que valida que la entrada sea solo texto
     * @param evt
     */
    private void validarTexto(KeyEvent evt) {
        char ch = evt.getKeyChar();
        if (!Character.isLetter(ch) && !Character.isWhitespace(ch)) {
            evt.consume(); // Si el carácter ingresado no es una letra o un espacio en blanco, consume el evento para evitar que se muestre en el campo de texto.
        }
    }

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