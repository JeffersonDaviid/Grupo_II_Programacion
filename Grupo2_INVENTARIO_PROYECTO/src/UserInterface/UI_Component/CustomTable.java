package UserInterface.UI_Component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import BusinnessLogic.ProductoBL;
import BusinnessLogic.Entities.Producto;
import Framework.Utilities.GestionCeldas;
import Framework.Utilities.GestionEncabezadoTabla;
import Framework.Utilities.ModeloTabla;
import Framework.Utilities.Tabla;

public class CustomTable extends JPanel implements MouseListener {

	private JScrollPane scrollPaneTabla;
	private JTable tablaPersonas;
	public ArrayList<Producto> lsProductos; // Producto de la base de datos

	ModeloTabla modelo;// modelo definido en la clase ModeloTabla
	private int filasTabla;
	private int columnasTabla;

	/**
	 * Create the frame.
	 */
	public CustomTable() {
		iniciarComponentes();
		construirTabla();
	}

	private void iniciarComponentes() {
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setLayout(new BorderLayout(0, 0));

		JLabel lblTablaPersonas = new JLabel("Tabla Productos");
		lblTablaPersonas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTablaPersonas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTablaPersonas.setFont(new Font("Rockwell", Font.BOLD, 25));
		this.add(lblTablaPersonas, BorderLayout.NORTH);

		scrollPaneTabla = new JScrollPane();
		add(scrollPaneTabla);

		tablaPersonas = new JTable();
		tablaPersonas.setBackground(Color.WHITE);
		tablaPersonas.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		tablaPersonas.addMouseListener(this);
		// tablaSeguimiento.addKeyListener(this);
		tablaPersonas.setOpaque(false);
		scrollPaneTabla.setViewportView(tablaPersonas);

	}

	/**
	 * Metodo que permite construir la tabla de personas
	 * se crean primero las columnas y luego se asigna la informaci�n
	 */
	private void construirTabla() {
		ProductoBL producto = new ProductoBL();
		lsProductos = producto.getAllProducto();

		ArrayList<String> titulosList = new ArrayList<>();

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
		Object[][] data = obtenerMatrizDatos(titulosList);
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
	private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

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
	 * Con los titulos y la informaci�n a mostrar se crea el modelo para
	 * poder personalizar la tabla, asignando tama�o de celdas tanto en ancho como
	 * en alto
	 * as� como los tipos de datos que va a poder soportar.
	 * 
	 * @param titulos
	 * @param data
	 */
	private void construirTabla(String[] titulos, Object[][] data) {
		modelo = new ModeloTabla(data, titulos);
		// se asigna el modelo a la tabla
		tablaPersonas.setModel(modelo);

		filasTabla = tablaPersonas.getRowCount();
		columnasTabla = tablaPersonas.getColumnCount();

		// se asigna el tipo de dato que tendr�n las celdas de cada columna definida
		// respectivamente para validar su personalizaci�n
		tablaPersonas.getColumnModel().getColumn(Tabla.STOCK).setCellRenderer(new GestionCeldas("numerico"));
		tablaPersonas.getColumnModel().getColumn(Tabla.PRECIO_COMPRA)
				.setCellRenderer(new GestionCeldas("numerico"));
		tablaPersonas.getColumnModel().getColumn(Tabla.PRECIO_VENTA)
				.setCellRenderer(new GestionCeldas("numerico"));
		tablaPersonas.getColumnModel().getColumn(Tabla.IMAGEN).setCellRenderer(new GestionCeldas("icono"));
		tablaPersonas.getColumnModel().getColumn(Tabla.PERFIL).setCellRenderer(new GestionCeldas("icono"));
		tablaPersonas.getColumnModel().getColumn(Tabla.EVENTO).setCellRenderer(new GestionCeldas("icono"));

		// se recorre y asigna el resto de celdas que serian las que almacenen datos de
		// tipo texto
		for (int i = 0; i < titulos.length; i++) {
			if (i != Tabla.STOCK && i != Tabla.PRECIO_COMPRA && i != Tabla.PRECIO_VENTA
					&& i != Tabla.PERFIL && i != Tabla.EVENTO && i != Tabla.IMAGEN)
				System.out.println(i);
			tablaPersonas.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
		}

		tablaPersonas.getTableHeader().setReorderingAllowed(false);
		tablaPersonas.setRowHeight(25);// tama�o de las celdas
		tablaPersonas.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tamaño de largo para cada columna y su contenido
		tablaPersonas.getColumnModel().getColumn(Tabla.ID).setPreferredWidth(80);// ID
		tablaPersonas.getColumnModel().getColumn(Tabla.ID).setMaxWidth(150);
		tablaPersonas.getColumnModel().getColumn(Tabla.ID).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(Tabla.CODIGO).setPreferredWidth(100);// CODIGO
		tablaPersonas.getColumnModel().getColumn(Tabla.CODIGO).setMaxWidth(100);
		tablaPersonas.getColumnModel().getColumn(Tabla.ESTADO).setPreferredWidth(110);// ESTADO
		tablaPersonas.getColumnModel().getColumn(Tabla.ESTADO).setMaxWidth(110);
		tablaPersonas.getColumnModel().getColumn(Tabla.CATEGORIA).setPreferredWidth(100);// CATEGORIA
		tablaPersonas.getColumnModel().getColumn(Tabla.IVA).setPreferredWidth(40);// IVA
		tablaPersonas.getColumnModel().getColumn(Tabla.PRODUCTO).setPreferredWidth(280);// PRODUCTO
		tablaPersonas.getColumnModel().getColumn(Tabla.STOCK).setPreferredWidth(55);// STOCK
		tablaPersonas.getColumnModel().getColumn(Tabla.STOCK).setMaxWidth(55);
		tablaPersonas.getColumnModel().getColumn(Tabla.PRECIO_COMPRA).setPreferredWidth(100);// PRECIO_COMPRA
		tablaPersonas.getColumnModel().getColumn(Tabla.PRECIO_VENTA).setPreferredWidth(100);// PRECIO_VENTA
		tablaPersonas.getColumnModel().getColumn(Tabla.DESCRIPCION).setPreferredWidth(100);// DESCRIPCION
		tablaPersonas.getColumnModel().getColumn(Tabla.FECHA_CREACION).setPreferredWidth(130);// FECHA_CREACION
		tablaPersonas.getColumnModel().getColumn(Tabla.FECHA_MODIFICACION).setPreferredWidth(130);// FECHA_MODIFICACION
		tablaPersonas.getColumnModel().getColumn(Tabla.IMAGEN).setPreferredWidth(100);// IMAGEN
		tablaPersonas.getColumnModel().getColumn(Tabla.PERFIL).setPreferredWidth(30);// accion perfil
		tablaPersonas.getColumnModel().getColumn(Tabla.EVENTO).setPreferredWidth(30);// accion evento

		// personaliza el encabezado
		JTableHeader jtableHeader = tablaPersonas.getTableHeader();
		jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
		tablaPersonas.setTableHeader(jtableHeader);

		// se asigna la tabla al scrollPane
		scrollPaneTabla.setViewportView(tablaPersonas);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// capturo fila o columna dependiendo de mi necesidad
		int fila = tablaPersonas.rowAtPoint(e.getPoint());
		int columna = tablaPersonas.columnAtPoint(e.getPoint());

		/*
		 * uso la columna para valiar si corresponde a la columna de perfil garantizando
		 * que solo se produzca algo si selecciono una fila de esa columna
		 */
		if (columna == Tabla.PERFIL) {
			// sabiendo que corresponde a la columna de perfil, envio la posicion de la fila
			// seleccionada
			// validarSeleccionMouse(fila);
		} else if (columna == Tabla.EVENTO) {// se valida que sea la columna del otro evento
			JOptionPane.showMessageDialog(null, "Evento del otro icono");
		}

	}

	/**
	 * Este metodo simularia el proceso o la acci�n que se quiere realizar si
	 * se presiona alguno de los botones o iconos de la tabla
	 *
	 * @param fila
	 */
	// private void validarSeleccionMouse(int fila) {
	// Tabla.filaSeleccionada = fila;

	// // teniendo la fila entonces se obtiene el objeto correspondiente para
	// enviarse
	// // como parammetro o imprimir la informaci�n
	// PersonaVo miPersona = new PersonaVo();
	// miPersona.setDocumento(tablaPersonas.getValueAt(fila,
	// Tabla.CODIGO).toString());
	// miPersona.setNombre(tablaPersonas.getValueAt(fila,
	// Tabla.PRODUCTO).toString());

	// String info = "INFO PERSONA\n";
	// info += "Documento: " + miPersona.getDocumento() + "\n";
	// info += "Nombre: " + miPersona.getNombre() + "\n";

	// JOptionPane.showMessageDialog(null, info);
	// }

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
