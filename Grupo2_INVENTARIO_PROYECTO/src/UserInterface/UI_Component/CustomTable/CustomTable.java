package UserInterface.UI_Component.CustomTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import BusinnessLogic.CategoriaProductoBL;
import BusinnessLogic.EstadoBL;
import BusinnessLogic.IvaBL;
import BusinnessLogic.Entities.Producto;
import DataAccess.ProductoDAC;
import Framework.AppException;
import Framework.Utilities.Tabla;

public class CustomTable extends JPanel implements MouseListener {

	private static JScrollPane scrollPaneTabla;
	private static JTable tabla;
	private static ArrayList<Producto> lsProductos; // Producto de la base de datos
	private static ArrayList<String> lsEstadoNombre;
	private static ArrayList<String> lsCategoriaProductoNombre;
	private static ArrayList<String> lsIvaNombre;

	ModeloTabla modelo;// modelo definido en la clase ModeloTabla
	private int filasTabla;
	private int columnasTabla;

	public CustomTable(ArrayList<String> titulosList, ArrayList<Producto> lsProductos) throws Exception {
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
	 * 
	 * @throws Exception
	 */
	public void construirTabla(ArrayList<String> titulosList, ArrayList<Producto> lsProductos) throws Exception {
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
			informacion[x][Tabla.PRECIO_COMPRA] = Double.parseDouble(df.format(lsProductos.get(x).getPrecioCompra()))
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
	 * @throws AppException
	 */
	private void construirTabla(String[] titulos, Object[][] data) throws Exception {
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
		// GestionCeldas("combo"));

		// se recorre y asigna el resto de celdas que serian las que almacenen datos de
		// tipo texto
		for (int i = 0; i < titulos.length; i++) {
			if (i != Tabla.STOCK || i != Tabla.PRECIO_COMPRA || i != Tabla.PRECIO_VENTA
					|| i != Tabla.PERFIL || i != Tabla.EVENTO || i != Tabla.IMAGEN || i != Tabla.ESTADO
					|| i != Tabla.CATEGORIA || i != Tabla.IVA)
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
		// GestionCeldaComboBox comboRender = new GestionCeldaComboBox();
		// tabla.getColumnModel().getColumn(Tabla.ESTADO).setCellRenderer(comboRender);
		try {
			EstadoBL lsEstados = new EstadoBL();
			lsEstadoNombre = lsEstados.getAllEstadoNombre();
			tabla.getColumnModel().getColumn(Tabla.ESTADO).setCellEditor(cargarComboItems(lsEstadoNombre));
		} catch (Exception e) {
			throw new AppException(e, getClass(), "Error al crear comboBox Estado " + e.getMessage());
		}

		tabla.getColumnModel().getColumn(Tabla.ESTADO).setPreferredWidth(110);
		tabla.getColumnModel().getColumn(Tabla.ESTADO).setMaxWidth(110);

		try {
			CategoriaProductoBL lsCategoriaProducto = new CategoriaProductoBL();
			lsCategoriaProductoNombre = lsCategoriaProducto.getAllCategoriaNombre();
			tabla.getColumnModel().getColumn(Tabla.CATEGORIA)
					.setCellEditor(cargarComboItems(lsCategoriaProductoNombre));
		} catch (Exception e) {
			throw new AppException(e, getClass(), "Error al crear comboBox Estado " + e.getMessage());
		}
		// ---------------------------------------------------------------------------------

		tabla.getColumnModel().getColumn(Tabla.CATEGORIA).setPreferredWidth(100);

		try {
			IvaBL lsIva = new IvaBL();
			lsIvaNombre = lsIva.getAllIvaNombre();
			tabla.getColumnModel().getColumn(Tabla.IVA).setCellEditor(cargarComboItems(lsIvaNombre));
		} catch (Exception e) {
			throw new AppException(e, getClass(), "Error al crear comboBox Estado " +
					e.getMessage());
		}
		tabla.getColumnModel().getColumn(Tabla.IVA).setPreferredWidth(40);
		tabla.getColumnModel().getColumn(Tabla.PRODUCTO).setPreferredWidth(280);
		tabla.getColumnModel().getColumn(Tabla.STOCK).setPreferredWidth(55);
		tabla.getColumnModel().getColumn(Tabla.STOCK).setMaxWidth(55);
		tabla.getColumnModel().getColumn(Tabla.PRECIO_COMPRA).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(Tabla.PRECIO_VENTA).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(Tabla.DESCRIPCION).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(Tabla.FECHA_CREACION).setPreferredWidth(130);
		tabla.getColumnModel().getColumn(Tabla.FECHA_MODIFICACION).setPreferredWidth(130);
		tabla.getColumnModel().getColumn(Tabla.IMAGEN).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(Tabla.PERFIL).setPreferredWidth(30);
		tabla.getColumnModel().getColumn(Tabla.EVENTO).setPreferredWidth(30);

		// personaliza el encabezado
		JTableHeader jtableHeader = tabla.getTableHeader();
		jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
		tabla.setTableHeader(jtableHeader);

		// se asigna la tabla al scrollPane
		scrollPaneTabla.setViewportView(tabla);

	}

	public DefaultCellEditor cargarComboItems(ArrayList<String> lsItem) {

		// GestionCeldaComboBox comboRender = new GestionCeldaComboBox();
		// tabla.getColumnModel().getColumn(Tabla.ESTADO).setCellRenderer(comboRender);
		JComboBox combo = new JComboBox<>();
		try {
			for (String item : lsItem) {
				combo.addItem(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		DefaultCellEditor comboCell = new DefaultCellEditor(combo);
		return comboCell;

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
		// Tabla.filaSeleccionada = fila;

		// teniendo la fila entonces se obtiene el objeto correspondiente para enviarse
		// como parammetro o imprimir la información
		System.out.println(
				"PK_ID_PRODUCTO :\t\t" + tabla.getValueAt(fila, Tabla.ID).toString()
						+ "\nCODIGO_PRODUCTO :\t\t" + tabla.getValueAt(fila, Tabla.CODIGO).toString()
						+ "\nFK_ID_ESTADO :\t\t\t" + tabla.getValueAt(fila, Tabla.ESTADO).toString()
						+ "\nFK_ID_ESTADO :\t\t\t"
						+ getIndexComboItemByName(lsEstadoNombre, tabla.getValueAt(fila, Tabla.ESTADO).toString())
						+ "\nFK_ID_CATEGORIA_PRODUCTO :\t" + tabla.getValueAt(fila, Tabla.CATEGORIA).toString()
						+ "\nFK_ID_CATEGORIA_PRODUCTO :\t"
						+ getIndexComboItemByName(lsCategoriaProductoNombre,
								tabla.getValueAt(fila, Tabla.CATEGORIA).toString())
						+ "\nFK_ID_IVA :\t\t\t" + tabla.getValueAt(fila, Tabla.IVA).toString()
						+ "\nFK_ID_IVA :\t\t\t"
						+ getIndexComboItemByName(lsIvaNombre, tabla.getValueAt(fila, Tabla.IVA).toString())
						+ "\nPRODUCTO :\t\t\t" + tabla.getValueAt(fila, Tabla.PRODUCTO).toString()
						+ "\nSTOCK :\t\t\t\t" + tabla.getValueAt(fila, Tabla.STOCK).toString()
						+ "\nPRECIO_COMPRA :\t\t\t" + tabla.getValueAt(fila, Tabla.PRECIO_COMPRA).toString()
						+ "\nPRECIO_VENTA :\t\t\t" + tabla.getValueAt(fila, Tabla.PRECIO_VENTA).toString()
						+ "\nDESCRIPCION :\t\t" + tabla.getValueAt(fila, Tabla.DESCRIPCION).toString()
						+ "\nIMAGEN :\t" + tabla.getValueAt(fila, Tabla.IMAGEN).toString()
						+ "\nFECHA_CREACION :\t\t" + tabla.getValueAt(fila, Tabla.FECHA_CREACION).toString()
						+ "\nFECHA_MODIFICACION :\t\t" + tabla.getValueAt(fila, Tabla.FECHA_MODIFICACION).toString());

		ProductoDAC productoDAC = new ProductoDAC();
		boolean rs = false;
		try {
			rs = productoDAC.setProducto(
					tabla.getValueAt(fila, Tabla.ID).toString(),
					tabla.getValueAt(fila, Tabla.CODIGO).toString(),
					getIndexComboItemByName(lsEstadoNombre, tabla.getValueAt(fila, Tabla.ESTADO).toString()),
					getIndexComboItemByName(lsCategoriaProductoNombre,
							tabla.getValueAt(fila, Tabla.CATEGORIA).toString()),
					getIndexComboItemByName(lsIvaNombre, tabla.getValueAt(fila, Tabla.IVA).toString()),
					tabla.getValueAt(fila, Tabla.PRODUCTO).toString(),
					Integer.parseInt(tabla.getValueAt(fila, Tabla.STOCK).toString()),
					Float.parseFloat(tabla.getValueAt(fila, Tabla.PRECIO_COMPRA).toString()),
					Float.parseFloat(tabla.getValueAt(fila, Tabla.PRECIO_VENTA).toString()),
					tabla.getValueAt(fila, Tabla.DESCRIPCION).toString(),
					null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!rs) {
			System.out.println("ERROR...!");
		}

	}

	private int getIndexComboItemByName(ArrayList<String> lsItem, String item) {
		int posicion = 0;

		for (String comboItem : lsItem) {
			posicion++;
			if (comboItem.equalsIgnoreCase(item))
				return posicion;
		}
		return -1;
	}

	// estos metododos pueden ser usados dependiendo de nuestra necesidad, por
	// ejemplo para cambiar el tama�o del icono al ser presionado
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
