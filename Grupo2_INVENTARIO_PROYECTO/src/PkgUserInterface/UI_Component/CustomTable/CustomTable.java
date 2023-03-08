package PkgUserInterface.UI_Component.CustomTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

import PkgBusinnessLogic.CategoriaProductoBL;
import PkgBusinnessLogic.EstadoBL;
import PkgBusinnessLogic.IvaBL;
import PkgBusinnessLogic.Entities.Producto;
import PkgDataAccess.ProductoDAC;
import PkgFramework.AppException;
import PkgFramework.Utilities.Tabla;

public class CustomTable extends JPanel implements MouseListener {

	private static JScrollPane scrollPaneTabla;
	private static JTable tblTabla;
	private static ArrayList<String> lsEstadoNombre;
	private static ArrayList<String> lsCategoriaProductoNombre;
	private static ArrayList<String> lsIvaNombre;

	ModeloTabla modelo;// modelo definido en la clase ModeloTabla

	public CustomTable(ArrayList<String> lsTitutloTabla, ArrayList<Producto> lsProductos) throws Exception {
		setOpaque(false);
		iniciarComponentes();
		construirTabla(lsTitutloTabla, lsProductos);
	}

	private void iniciarComponentes() {
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setLayout(new BorderLayout(0, 0));

		JLabel lbTituloTabla = new JLabel("Tabla Productos");
		lbTituloTabla.setHorizontalAlignment(SwingConstants.CENTER);
		lbTituloTabla.setHorizontalTextPosition(SwingConstants.CENTER);
		lbTituloTabla.setFont(new Font("Rockwell", Font.BOLD, 25));
		this.add(lbTituloTabla, BorderLayout.NORTH);

		scrollPaneTabla = new JScrollPane();
		add(scrollPaneTabla);

		tblTabla = new JTable();
		tblTabla.setBackground(Color.WHITE);
		tblTabla.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		tblTabla.addMouseListener(this);
		// tblTablaSeguimiento.addKeyListener(this);
		tblTabla.setOpaque(false);
		scrollPaneTabla.setViewportView(tblTabla);

	}

	/**
	 * Metodo que permite construir la tblTabla de personas
	 * se crean primero las columnas y luego se asigna la informaci�n
	 * 
	 * @throws Exception
	 */
	public void construirTabla(ArrayList<String> lsTitutloTabla, ArrayList<Producto> lsProductos) throws Exception {
		// se asignan las columnas al arreglo para enviarse al momento de construir la
		// tblTabla
		String titulos[] = new String[lsTitutloTabla.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = lsTitutloTabla.get(i);
		}
		/*
		 * obtenemos los datos de la lista y los guardamos en la matriz
		 * que luego se manda a construir la tblTabla
		 */
		Object[][] data = obtenerMatrizDatos(lsTitutloTabla, lsProductos);
		construirTabla(titulos, data);
	}

	public static String cambiarComasPorPuntos(Float cadena) {
		return String.format("%.2f", cadena).replace(",", ".");
	}

	/**
	 * Llena la informaci�n de la tblTabla usando la lista de personas trabajada
	 * anteriormente, guardandola en una matriz que se retorna con toda
	 * la informaci�n para luego ser asignada al modelo
	 * 
	 * @param lsTitutloTabla
	 * @return
	 */
	private Object[][] obtenerMatrizDatos(ArrayList<String> lsTitutloTabla, ArrayList<Producto> lsProductos) {

		/*
		 * se crea la matriz donde las filas son dinamicas pues corresponde
		 * a todos los usuarios, mientras que las columnas son estaticas
		 * correspondiendo a las columnas definidas por defecto
		 */
		String informacion[][] = new String[lsProductos.size()][lsTitutloTabla.size()];

		for (int x = 0; x < informacion.length; x++) {
			informacion[x][Tabla.ID] = lsProductos.get(x).getIdProducto() + "";
			informacion[x][Tabla.CODIGO] = lsProductos.get(x).getCodigoProducto() + "";
			informacion[x][Tabla.ESTADO] = lsProductos.get(x).getFkEstado().getEstado() + "";
			informacion[x][Tabla.CATEGORIA] = lsProductos.get(x).getFkCategoriaProducto().getNombre() + "";
			informacion[x][Tabla.IVA] = lsProductos.get(x).getFkIva().getNombre() + "";
			informacion[x][Tabla.PRODUCTO] = lsProductos.get(x).getProducto() + "";
			informacion[x][Tabla.STOCK] = lsProductos.get(x).getStock() + "";
			informacion[x][Tabla.PRECIO_COMPRA] = cambiarComasPorPuntos(lsProductos.get(x).getPrecioCompra()) + "";
			informacion[x][Tabla.PRECIO_VENTA] = cambiarComasPorPuntos(lsProductos.get(x).getPrecioVenta()) + "";
			informacion[x][Tabla.DESCRIPCION] = lsProductos.get(x).getDescripcion() + "";
			informacion[x][Tabla.FECHA_CREACION] = lsProductos.get(x).getFechaIngreso() + "";
			informacion[x][Tabla.FECHA_MODIFICACION] = lsProductos.get(x).getFechaModificacion() + "";
			// se asignan las plabras clave para que en la clase GestionCeldas se use para
			// asignar el icono correspondiente
			informacion[x][Tabla.EVENTO] = "EVENTO";
		}
		return informacion;
	}

	/**
	 * Con los titulos y la información a mostrar se crea el modelo para
	 * poder personalizar la tblTabla, asignando tamaño de celdas tanto en ancho
	 * como en alto así como los tipos de datos que va a poder soportar.
	 * 
	 * @param titulos
	 * @param data
	 * @throws AppException
	 */
	private void construirTabla(String[] titulos, Object[][] data) throws Exception {
		modelo = new ModeloTabla(data, titulos);
		// se asigna el modelo a la tblTabla
		tblTabla.setModel(modelo);

		// se recorre y asigna el resto de celdas que serian las que almacenen datos de
		// tipo texto
		for (int i = 0; i < titulos.length; i++) {
			if (i == Tabla.STOCK || i == Tabla.PRECIO_COMPRA || i == Tabla.PRECIO_VENTA)
				tblTabla.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("numerico"));

			if (i == Tabla.ID || i == Tabla.CODIGO || i == Tabla.PRODUCTO || i == Tabla.DESCRIPCION
					|| i == Tabla.CATEGORIA || i == Tabla.ESTADO || i == Tabla.IVA || i == Tabla.FECHA_CREACION
					|| i == Tabla.FECHA_MODIFICACION)
				tblTabla.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));

			if (i == Tabla.EVENTO)
				tblTabla.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("icono"));
		}

		tblTabla.getTableHeader().setReorderingAllowed(false);
		tblTabla.setRowHeight(35);// tama�o de las celdas
		tblTabla.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tamaño de largo para cada columna y su contenido
		tblTabla.getColumnModel().getColumn(Tabla.ID).setPreferredWidth(80);// ID
		tblTabla.getColumnModel().getColumn(Tabla.ID).setMaxWidth(150);
		tblTabla.getColumnModel().getColumn(Tabla.ID).setResizable(false);
		tblTabla.getColumnModel().getColumn(Tabla.CODIGO).setPreferredWidth(100);// CODIGO
		tblTabla.getColumnModel().getColumn(Tabla.CODIGO).setMaxWidth(100);

		// ------------------------------------------------------------------------------
		// GestionCeldaComboBox comboRender = new GestionCeldaComboBox();
		// tblTabla.getColumnModel().getColumn(Tabla.ESTADO).setCellRenderer(comboRender);
		try {
			EstadoBL lsEstados = new EstadoBL();
			lsEstadoNombre = lsEstados.getAllEstadoNombre();
			tblTabla.getColumnModel().getColumn(Tabla.ESTADO).setCellEditor(cargarComboItems(lsEstadoNombre));

			CategoriaProductoBL lsCategoriaProducto = new CategoriaProductoBL();
			lsCategoriaProductoNombre = lsCategoriaProducto.getAllCategoriaNombre();
			tblTabla.getColumnModel().getColumn(Tabla.CATEGORIA)
					.setCellEditor(cargarComboItems(lsCategoriaProductoNombre));

			IvaBL lsIva = new IvaBL();
			lsIvaNombre = lsIva.getAllIvaNombre();
			tblTabla.getColumnModel().getColumn(Tabla.IVA).setCellEditor(cargarComboItems(lsIvaNombre));

		} catch (Exception e) {
			throw new AppException(e, getClass(), "Error al crear comboBox Estado " + e.getMessage());
		}

		tblTabla.getColumnModel().getColumn(Tabla.ESTADO).setPreferredWidth(110);
		tblTabla.getColumnModel().getColumn(Tabla.ESTADO).setMaxWidth(110);

		tblTabla.getColumnModel().getColumn(Tabla.CATEGORIA).setPreferredWidth(100);

		tblTabla.getColumnModel().getColumn(Tabla.IVA).setPreferredWidth(40);
		tblTabla.getColumnModel().getColumn(Tabla.PRODUCTO).setPreferredWidth(280);
		tblTabla.getColumnModel().getColumn(Tabla.STOCK).setPreferredWidth(55);
		tblTabla.getColumnModel().getColumn(Tabla.STOCK).setMaxWidth(55);
		tblTabla.getColumnModel().getColumn(Tabla.PRECIO_COMPRA).setPreferredWidth(100);
		tblTabla.getColumnModel().getColumn(Tabla.PRECIO_VENTA).setPreferredWidth(100);
		tblTabla.getColumnModel().getColumn(Tabla.DESCRIPCION).setPreferredWidth(100);
		tblTabla.getColumnModel().getColumn(Tabla.FECHA_CREACION).setPreferredWidth(130);
		tblTabla.getColumnModel().getColumn(Tabla.FECHA_MODIFICACION).setPreferredWidth(130);
		tblTabla.getColumnModel().getColumn(Tabla.EVENTO).setMaxWidth(30);
		tblTabla.getColumnModel().getColumn(Tabla.EVENTO).setPreferredWidth(30);

		// personaliza el encabezado
		JTableHeader jtableHeader = tblTabla.getTableHeader();
		jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
		tblTabla.setTableHeader(jtableHeader);

		// se asigna la tblTabla al scrollPane
		scrollPaneTabla.setViewportView(tblTabla);

	}

	public DefaultCellEditor cargarComboItems(ArrayList<String> lsItem) {

		JComboBox<String> combo = new JComboBox<>();
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
		int fila = tblTabla.rowAtPoint(e.getPoint());
		int columna = tblTabla.columnAtPoint(e.getPoint());

		if (columna == Tabla.EVENTO) {
			actualizarProductoFila(fila);
		}

	}

	/**
	 * Este metodo simularia el proceso o la acci�n que se quiere realizar si
	 * se presiona alguno de los botones o iconos de la tblTabla
	 *
	 * @param fila
	 */
	private void actualizarProductoFila(int fila) {

		// teniendo la fila entonces se obtiene el objeto correspondiente para enviarse
		// como parammetro o imprimir la información
		Date fechaHoraActual = new Date();
		SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		ProductoDAC productoDAC = new ProductoDAC();

		try {
			productoDAC.setProducto(
					tblTabla.getValueAt(fila, Tabla.ID).toString(),
					tblTabla.getValueAt(fila, Tabla.CODIGO).toString(),
					getIndiceComboItemPorNombre(lsEstadoNombre, tblTabla.getValueAt(fila, Tabla.ESTADO).toString()),
					getIndiceComboItemPorNombre(lsCategoriaProductoNombre,
							tblTabla.getValueAt(fila, Tabla.CATEGORIA).toString()),
					getIndiceComboItemPorNombre(lsIvaNombre, tblTabla.getValueAt(fila, Tabla.IVA).toString()),
					tblTabla.getValueAt(fila, Tabla.PRODUCTO).toString(),
					Integer.parseInt(tblTabla.getValueAt(fila, Tabla.STOCK).toString()),
					Float.parseFloat(tblTabla.getValueAt(fila, Tabla.PRECIO_COMPRA).toString()),
					Float.parseFloat(tblTabla.getValueAt(fila, Tabla.PRECIO_VENTA).toString()),
					tblTabla.getValueAt(fila, Tabla.DESCRIPCION).toString(),
					null, formatoFechaHora.format(fechaHoraActual));

			JOptionPane.showMessageDialog(null,
					"El producto " + tblTabla.getValueAt(fila, Tabla.CODIGO).toString() + " ha sido actualizado");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"El producto " + tblTabla.getValueAt(fila, Tabla.CODIGO).toString() + " NO ha podido actualizarse");
			e.printStackTrace();
		}
	}

	private int getIndiceComboItemPorNombre(ArrayList<String> lsItem, String item) {
		int posicion = 0;

		for (String comboItem : lsItem) {
			posicion++;
			if (comboItem.equalsIgnoreCase(item))
				return posicion;
		}
		return -1;
	}

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
