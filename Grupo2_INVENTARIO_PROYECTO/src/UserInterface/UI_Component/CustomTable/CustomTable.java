package UserInterface.UI_Component.CustomTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import BusinnessLogic.EstadoBL;
import BusinnessLogic.Entities.Producto;
import Framework.Utilities.Tabla;

public class CustomTable extends JPanel implements MouseListener {

	private static JScrollPane scrollPaneTabla;
	private static JTable tabla;
	private static ArrayList<Producto> lsProductos; // Producto de la base de datos

	ModeloTabla modelo;// modelo definido en la clase ModeloTabla
	private int filasTabla;
	private int columnasTabla;

	public CustomTable(ArrayList<String> titulosList, ArrayList<Producto> lsProductos) {
		iniciarComponentes();
		construirTabla(titulosList, lsProductos);
	}

	private void iniciarComponentes() {
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setLayout(new BorderLayout(0, 0));

		JLabel lblTabla = new JLabel("Tabla Productos");
		lblTabla.setHorizontalAlignment(SwingConstants.CENTER);
		lblTabla.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTabla.setFont(new Font("Rockwell", Font.BOLD, 25));
		this.add(lblTabla, BorderLayout.NORTH);

		scrollPaneTabla = new JScrollPane();
		add(scrollPaneTabla);

		tabla = new JTable();
		tabla.setBackground(Color.WHITE);
		tabla.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		tabla.addMouseListener(this);
		// tablaSeguimiento.addKeyListener(this);
		tabla.setOpaque(false);
		scrollPaneTabla.setViewportView(tabla);

	}

	private void iniciarComponentes(String titulo) {
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setLayout(new BorderLayout(0, 0));

		JLabel lblTabla = new JLabel(titulo);
		lblTabla.setHorizontalAlignment(SwingConstants.CENTER);
		lblTabla.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTabla.setFont(new Font("Rockwell", Font.BOLD, 25));
		this.add(lblTabla, BorderLayout.NORTH);

		scrollPaneTabla = new JScrollPane();
		add(scrollPaneTabla);

		tabla = new JTable();
		tabla.setBackground(Color.WHITE);
		tabla.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		tabla.addMouseListener(this);
		// tablaSeguimiento.addKeyListener(this);
		tabla.setOpaque(false);
		scrollPaneTabla.setViewportView(tabla);

	}

	/**
	 * Metodo que permite construir la tabla de personas
	 * se crean primero las columnas y luego se asigna la informaci�n
	 */
	public void construirTabla(ArrayList<String> titulosList, ArrayList<Producto> lsProductos) {
		// se asignan las columnas al arreglo para enviarse al momento de construir la
		// tabla
		String titulos[] = new String[titulosList.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = titulosList.get(i);
		}
		/*
		 * obtenemos los datos de la lista y los guardamos en la matriz
		 * que luego se manda a construir la tabla
		 */
		Object[][] data = obtenerMatrizDatos(titulosList, lsProductos);
		construirTabla(titulos, data);
	}

	/**
	 * Llena la informaci�n de la tabla usando la lista de personas trabajada
	 * anteriormente, guardandola en una matriz que se retorna con toda
	 * la informaci�n para luego ser asignada al modelo
	 * 
	 * @param titulosList
	 * @return
	 */
	private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList, ArrayList<Producto> lsProductos) {

		/*
		 * se crea la matriz donde las filas son dinamicas pues corresponde
		 * a todos los usuarios, mientras que las columnas son estaticas
		 * correspondiendo a las columnas definidas por defecto
		 */
		String informacion[][] = new String[lsProductos.size()][titulosList.size()];

		for (int x = 0; x < informacion.length; x++) {
			DecimalFormat df = new DecimalFormat("#.##");
			informacion[x][Tabla.ID] = lsProductos.get(x).getIdProducto() + "";
			informacion[x][Tabla.CODIGO] = lsProductos.get(x).getCodigoProducto() + "";
			informacion[x][Tabla.ESTADO] = lsProductos.get(x).getFkEstado().getEstado() + "";
			informacion[x][Tabla.CATEGORIA] = lsProductos.get(x).getFkCategoriaProducto().getNombre() + "";
			informacion[x][Tabla.IVA] = lsProductos.get(x).getFkIva().getNombre() + "";
			informacion[x][Tabla.PRODUCTO] = lsProductos.get(x).getProducto() + "";
			informacion[x][Tabla.STOCK] = lsProductos.get(x).getStock() + "";
			informacion[x][Tabla.PRECIO_COMPRA] = "$"
					+ Double.parseDouble(df.format(lsProductos.get(x).getPrecioCompra()))
					+ "";
			informacion[x][Tabla.PRECIO_VENTA] = lsProductos.get(x).getPrecioVenta() + "";
			informacion[x][Tabla.DESCRIPCION] = lsProductos.get(x).getDescripcion() + "";
			informacion[x][Tabla.FECHA_CREACION] = lsProductos.get(x).getFechaIngreso() + "";
			informacion[x][Tabla.FECHA_MODIFICACION] = lsProductos.get(x).getFechaModificacion() + "";
			informacion[x][Tabla.IMAGEN] = "";// lsProductos.get(x).getImagen() + "";
			// se asignan las plabras clave para que en la clase GestionCeldas se use para
			// asignar el icono correspondiente
			informacion[x][Tabla.PERFIL] = "PERFIL";
			informacion[x][Tabla.EVENTO] = "EVENTO";
		}
		return informacion;
	}

	/**
	 * Con los titulos y la información a mostrar se crea el modelo para
	 * poder personalizar la tabla, asignando tamaño de celdas tanto en ancho como
	 * en alto
	 * así como los tipos de datos que va a poder soportar.
	 * 
	 * @param titulos
	 * @param data
	 */
	private void construirTabla(String[] titulos, Object[][] data) {
		modelo = new ModeloTabla(data, titulos);
		// se asigna el modelo a la tabla
		tabla.setModel(modelo);

		filasTabla = tabla.getRowCount();
		columnasTabla = tabla.getColumnCount();
		// ---------------------- OJO ----------------------------------------------
		// se asigna el tipo de dato que tendrán las celdas de cada columna definida
		// respectivamente para validar su personalización
		tabla.getColumnModel().getColumn(Tabla.STOCK).setCellRenderer(new GestionCeldas("numerico"));
		tabla.getColumnModel().getColumn(Tabla.PRECIO_COMPRA).setCellRenderer(new GestionCeldas("numerico"));
		tabla.getColumnModel().getColumn(Tabla.PRECIO_VENTA).setCellRenderer(new GestionCeldas("numerico"));
		tabla.getColumnModel().getColumn(Tabla.IMAGEN).setCellRenderer(new GestionCeldas("icono"));
		tabla.getColumnModel().getColumn(Tabla.PERFIL).setCellRenderer(new GestionCeldas("icono"));
		tabla.getColumnModel().getColumn(Tabla.EVENTO).setCellRenderer(new GestionCeldas("icono"));
		// tabla.getColumnModel().getColumn(Tabla.ESTADO).setCellRenderer(new
		// GestionCeldas("comboBox"));

		// se recorre y asigna el resto de celdas que serian las que almacenen datos de
		// tipo texto
		for (int i = 0; i < titulos.length; i++) {
			if (i != Tabla.STOCK || i != Tabla.PRECIO_COMPRA || i != Tabla.PRECIO_VENTA
					|| i != Tabla.PERFIL || i != Tabla.EVENTO || i != Tabla.IMAGEN || i != Tabla.ESTADO)
				tabla.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
		}

		// // se recorre y asigna el resto de celdas que serian las que almacenen datos
		// de
		// // tipo texto
		// for (int i = 0; i < titulos.length - 3; i++) {
		// tabla.getColumnModel().getColumn(i).setCellRenderer(new
		// GestionCeldas("texto"));
		// }

		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.setRowHeight(35);// tama�o de las celdas
		tabla.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tamaño de largo para cada columna y su contenido
		tabla.getColumnModel().getColumn(Tabla.ID).setPreferredWidth(80);// ID
		tabla.getColumnModel().getColumn(Tabla.ID).setMaxWidth(150);
		tabla.getColumnModel().getColumn(Tabla.ID).setResizable(false);
		tabla.getColumnModel().getColumn(Tabla.CODIGO).setPreferredWidth(100);// CODIGO
		tabla.getColumnModel().getColumn(Tabla.CODIGO).setMaxWidth(100);

		// ------------------------------------------------------------------------------
		GestionCeldaComboBox comboRender = new GestionCeldaComboBox();
		JComboBox combo = new JComboBox<>();

		EstadoBL lsEstados = new EstadoBL();

		try {
			for (String item : lsEstados.getAllEstadoNombre()) {
				combo.addItem(item);
				// combo.setSelectedIndex(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		DefaultCellEditor comboCell = new DefaultCellEditor(combo);
		tabla.getColumnModel().getColumn(Tabla.ESTADO).setCellEditor(comboCell);
		tabla.getColumnModel().getColumn(Tabla.ESTADO).setCellRenderer(comboRender);
		// ---------------------------------------------------------------------------------

		tabla.getColumnModel().getColumn(Tabla.ESTADO).setPreferredWidth(110);// ESTADO
		tabla.getColumnModel().getColumn(Tabla.ESTADO).setMaxWidth(110);
		tabla.getColumnModel().getColumn(Tabla.CATEGORIA).setPreferredWidth(100);// CATEGORIA
		tabla.getColumnModel().getColumn(Tabla.IVA).setPreferredWidth(40);// IVA
		tabla.getColumnModel().getColumn(Tabla.PRODUCTO).setPreferredWidth(280);// PRODUCTO
		tabla.getColumnModel().getColumn(Tabla.STOCK).setPreferredWidth(55);// STOCK
		tabla.getColumnModel().getColumn(Tabla.STOCK).setMaxWidth(55);
		tabla.getColumnModel().getColumn(Tabla.PRECIO_COMPRA).setPreferredWidth(100);// PRECIO_COMPRA
		tabla.getColumnModel().getColumn(Tabla.PRECIO_VENTA).setPreferredWidth(100);// PRECIO_VENTA
		tabla.getColumnModel().getColumn(Tabla.DESCRIPCION).setPreferredWidth(100);// DESCRIPCION
		tabla.getColumnModel().getColumn(Tabla.FECHA_CREACION).setPreferredWidth(130);// FECHA_CREACION
		tabla.getColumnModel().getColumn(Tabla.FECHA_MODIFICACION).setPreferredWidth(130);// FECHA_MODIFICACION
		tabla.getColumnModel().getColumn(Tabla.IMAGEN).setPreferredWidth(100);// IMAGEN
		tabla.getColumnModel().getColumn(Tabla.PERFIL).setPreferredWidth(30);// accion perfil
		tabla.getColumnModel().getColumn(Tabla.EVENTO).setPreferredWidth(30);// accion evento

		// personaliza el encabezado
		JTableHeader jtableHeader = tabla.getTableHeader();
		jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
		tabla.setTableHeader(jtableHeader);
		// tabla.setDefaultRenderer(tabla.getColumnClass(Tabla.ESTADO, comboRender));

		// se asigna la tabla al scrollPane
		scrollPaneTabla.setViewportView(tabla);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// capturo fila o columna dependiendo de mi necesidad
		int fila = tabla.rowAtPoint(e.getPoint());
		int columna = tabla.columnAtPoint(e.getPoint());

		/*
		 * uso la columna para valiar si corresponde a la columna de perfil garantizando
		 * que solo se produzca algo si selecciono una fila de esa columna
		 */
		if (columna == Tabla.PERFIL) {
			// sabiendo que corresponde a la columna de perfil, envio la posicion de la fila
			// seleccionada
			// validarSeleccionMouse(fila);
		} else if (columna == Tabla.EVENTO) {// se valida que sea la columna del otro evento
			actualizarProductoFila(fila);
		}

	}

	/**
	 * Este metodo simularia el proceso o la acci�n que se quiere realizar si
	 * se presiona alguno de los botones o iconos de la tabla
	 *
	 * @param fila
	 */
	private void actualizarProductoFila(int fila) {
		Tabla.filaSeleccionada = fila;

		// teniendo la fila entonces se obtiene el objeto correspondiente para enviarse
		// como parammetro o imprimir la informaci�n
		System.out.println(tabla.getValueAt(fila, Tabla.CODIGO).toString() + " : "
				+ tabla.getValueAt(fila, Tabla.PRODUCTO).toString());

	}

	// estos metododos pueden ser usados dependiendo de nuestra necesidad, por
	// ejemplo para cambiar el tama�o del icono al ser presionado
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
