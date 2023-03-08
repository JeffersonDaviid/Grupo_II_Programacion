package UserInterface.Ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import com.itextpdf.layout.element.List;
//import com.mysql.fabric.xmlrpc.base.Array;

import javax.swing.JTextPane;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import BusinnessLogic.Entities.Producto;
import BusinnessLogic.Entities.Venta;
import DataAccess.VentaDAC;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ScrollPaneConstants;

public class Ventas extends JPanel {

	JTable tblProductos;
	DefaultTableModel modelo;

	Venta v = new Venta();
	VentaDAC vDAC = new VentaDAC();
	Producto pro = new Producto();
	double total = 0;
	Object[] fila = new Object[4];

	/*
	 * Creacion de los TextField que se utilizaran para el apartado de ventas
	 */

	private JTextField txtCodigoProducto;
	private JTextField txtCantidad;
	private JTextField txtNombre;
	private JTextField txtMonto;
	private JTextField txtTelefono;
	private JTextField txtCedula;
	private JTextField txtDireccion;

	public Ventas() {
		setBackground(new Color(255, 0, 255));
		setLayout(new BorderLayout(0, 0));

		JPanel panelSuperior = new JPanel();
		add(panelSuperior, BorderLayout.NORTH);

		JLabel lbTituloPanelSuperior = new JLabel("VENTAS");
		panelSuperior.add(lbTituloPanelSuperior);

		JTextPane txtTotal = new JTextPane();
		txtTotal.setEditable(false);
		txtTotal.setForeground(Color.GREEN);
		txtTotal.setBackground(Color.BLACK);

		JPanel panelLateralIzquierdo = new JPanel();
		add(panelLateralIzquierdo, BorderLayout.WEST);
		txtCodigoProducto = new JTextField();
		txtCodigoProducto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String cod = txtCodigoProducto.getText();
					if (!"".equals(txtCodigoProducto.getText())) {
						pro = vDAC.BuscarPro(cod);
						if (pro.getProducto() != null) {

							fila[0] = (txtCodigoProducto.getText());
							fila[1] = (pro.getProducto());
							fila[2] = (pro.getPrecioVenta());
							txtCantidad.requestFocus();

						}
					}
				}
			}
		});
		txtCodigoProducto.setColumns(10);

		txtCantidad = new JTextField();
		txtCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!"".equals(txtCantidad.getText())) {

						if (pro.getStock() >= Integer.parseInt(txtCantidad.getText())) {
							fila[0] = (txtCodigoProducto.getText());
							fila[1] = (pro.getProducto());
							fila[2] = (pro.getPrecioVenta());
							fila[3] = (txtCantidad.getText());
							modelo.addRow(fila);

							total = total
									+ ((Integer.parseInt(fila[3].toString()) * Double.parseDouble(fila[2].toString())));

							txtCantidad.setText("");
							txtCodigoProducto.setText("");
							txtTotal.setText(String.format("%.2f", total));
							txtCodigoProducto.requestFocus();
						} else {
							JOptionPane.showMessageDialog(null,
									"La cantidad ingresada supera el stock, stock disponible: " + pro.getStock());
						}
					}
				}
			}
		});

		/*
		 * 
		 * btnAgregarVenta: se encarga de agregar la venta al modelo que se muestra en
		 * pantalla
		 * 
		 */

		JButton btnAgregarVenta = new JButton("AGREGAR");
		btnAgregarVenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!"".equals(txtCantidad.getText()) && !"".equals(txtCodigoProducto.getText())) {
					if (e.getButton() == 1) {
						String cod = txtCodigoProducto.getText();
						pro = vDAC.BuscarPro(cod);

						if (pro.getStock() >= Integer.parseInt(txtCantidad.getText())) {
							fila[0] = (txtCodigoProducto.getText());
							fila[1] = (pro.getProducto());
							fila[2] = (pro.getPrecioVenta());
							fila[3] = (txtCantidad.getText());
							modelo.addRow(fila);

							total = total
									+ ((Integer.parseInt(fila[3].toString()) * Double.parseDouble(fila[2].toString())));

							txtCodigoProducto.setText("");
							txtCantidad.setText("");
							txtTotal.setText(String.format("%.2f", total));
						} else {
							JOptionPane.showMessageDialog(null,
									"La cantidad ingresada supera el stock, stock disponible: " + pro.getStock());
						}

					}
				}
			}
		});

		txtCantidad.setColumns(10);

		JTextPane txtCambio = new JTextPane();
		txtCambio.setEditable(false);
		txtCambio.setBackground(Color.BLACK);
		txtCambio.setForeground(Color.GREEN);

		txtMonto = new JTextField();
		txtMonto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txtCambio.setText(String.format("%.2f", (Double.parseDouble(txtMonto.getText()) - total)));
				}
			}
		});
		txtMonto.setForeground(Color.GREEN);
		txtMonto.setBackground(Color.BLACK);
		txtMonto.setColumns(10);

		JLabel lbTotal = new JLabel("TOTAL:");

		JLabel lbMonto = new JLabel("MONTO:");

		JLabel lbCambio = new JLabel("CAMBIO:");

		JLabel lbCantidad = new JLabel("CANTIDAD:");

		JLabel lbCodigoProducto = new JLabel("COD_PRODUCTO:");

		JLabel lbTituloPanelIzquierdo = new JLabel("INGREO DE PRODUCTOS");
		GroupLayout gl_panelLateralIzquierdo = new GroupLayout(panelLateralIzquierdo);
		gl_panelLateralIzquierdo.setHorizontalGroup(
				gl_panelLateralIzquierdo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLateralIzquierdo.createSequentialGroup()
								.addGroup(gl_panelLateralIzquierdo.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelLateralIzquierdo.createSequentialGroup()
												.addContainerGap()
												.addGroup(gl_panelLateralIzquierdo
														.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panelLateralIzquierdo.createSequentialGroup()
																.addGroup(gl_panelLateralIzquierdo
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(txtTotal,
																				GroupLayout.PREFERRED_SIZE, 85,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(lbTotal,
																				GroupLayout.PREFERRED_SIZE, 73,
																				GroupLayout.PREFERRED_SIZE))
																.addGap(18)
																.addGroup(gl_panelLateralIzquierdo
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(txtMonto,
																				GroupLayout.PREFERRED_SIZE, 88,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(lbMonto,
																				GroupLayout.PREFERRED_SIZE, 63,
																				GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addGroup(gl_panelLateralIzquierdo
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lbCambio,
																				GroupLayout.PREFERRED_SIZE, 63,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(txtCambio,
																				GroupLayout.PREFERRED_SIZE, 96,
																				GroupLayout.PREFERRED_SIZE)))
														.addGroup(gl_panelLateralIzquierdo.createSequentialGroup()
																.addGroup(gl_panelLateralIzquierdo
																		.createParallelGroup(Alignment.TRAILING)
																		.addComponent(lbCodigoProducto,
																				Alignment.LEADING,
																				GroupLayout.PREFERRED_SIZE, 98,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(lbCantidad,
																				GroupLayout.DEFAULT_SIZE, 98,
																				Short.MAX_VALUE))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_panelLateralIzquierdo
																		.createParallelGroup(Alignment.TRAILING, false)
																		.addComponent(txtCantidad)
																		.addComponent(txtCodigoProducto))
																.addPreferredGap(ComponentPlacement.RELATED, 82,
																		Short.MAX_VALUE))))
										.addGroup(gl_panelLateralIzquierdo.createSequentialGroup()
												.addGap(57)
												.addComponent(lbTituloPanelIzquierdo, GroupLayout.PREFERRED_SIZE, 209,
														GroupLayout.PREFERRED_SIZE)))
								.addContainerGap())
						.addGroup(gl_panelLateralIzquierdo.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnAgregarVenta, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
								.addGap(176)));
		gl_panelLateralIzquierdo.setVerticalGroup(
				gl_panelLateralIzquierdo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLateralIzquierdo.createSequentialGroup()
								.addGap(15)
								.addComponent(lbTituloPanelIzquierdo, GroupLayout.PREFERRED_SIZE, 13,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panelLateralIzquierdo.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtCodigoProducto, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbCodigoProducto))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panelLateralIzquierdo.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lbCantidad))
								.addGap(18)
								.addComponent(btnAgregarVenta)
								.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
								.addGroup(gl_panelLateralIzquierdo.createParallelGroup(Alignment.BASELINE)
										.addComponent(lbTotal)
										.addComponent(lbMonto)
										.addComponent(lbCambio))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panelLateralIzquierdo.createParallelGroup(Alignment.LEADING)
										.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtMonto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCambio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
		panelLateralIzquierdo.setLayout(gl_panelLateralIzquierdo);

		/*
		 * Panel Inferior
		 * 
		 * btnCompletarVenta: manda la informacion del usuario a la tabla ventas en la
		 * base de datos
		 * 
		 */
		JPanel panelInferior = new JPanel();
		add(panelInferior, BorderLayout.SOUTH);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);

		JLabel lbTituloPanelInferior = new JLabel("INFORMACION USUARIO");

		JLabel lbNombre = new JLabel("NOMBRE:");

		JLabel lbTelefono = new JLabel("TELEFONO:");

		JLabel lbCedula = new JLabel("CEDULA:");

		JLabel lbDireccion = new JLabel("DIRECCION:");

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);

		txtCedula = new JTextField();
		txtCedula.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);

		JButton btnCompletarVenta = new JButton("COMPLETAR VENTA");

		btnCompletarVenta.addMouseListener(new MouseAdapter() {

			@Override
			//
			public void mouseClicked(MouseEvent e) {
				if (!"".equals(txtNombre.getText()) && !"".equals(txtCedula.getText())
						&& !"".equals(txtTelefono.getText()) && !"".equals(txtDireccion.getText())) {
					if (e.getButton() == 1) {
						v.setCliente(txtNombre.getText());
						v.setCedula(txtCedula.getText());
						v.setTelefono(txtTelefono.getText());
						v.setDireccion(txtDireccion.getText());
						v.setTotal(total);
						vDAC.registrarVenta(v);
						String[] codProductos = new String[modelo.getRowCount() - 1];
						int[] canProductos = new int[modelo.getRowCount() - 1];

						for (int i = 0; i < canProductos.length; i++) {
							codProductos[i] = (String) modelo.getValueAt((i + 1), 1);
							canProductos[i] = (Integer) modelo.getValueAt((i + 1), 4);
						}

						do {
							for (int i = 0; i <= modelo.getRowCount(); i++) {
								modelo.removeRow(i);
							}
						} while (modelo.getRowCount() != 0);
						txtTotal.setText("");
						txtNombre.setText("");
						txtCedula.setText("");
						txtTelefono.setText("");
						txtDireccion.setText("");
					}
				}
			}
		});
		GroupLayout gl_panelInferior = new GroupLayout(panelInferior);
		gl_panelInferior.setHorizontalGroup(
				gl_panelInferior.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInferior.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panelInferior.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelInferior.createSequentialGroup()
												.addComponent(lbTituloPanelInferior, GroupLayout.DEFAULT_SIZE, 525,
														Short.MAX_VALUE)
												.addContainerGap())
										.addGroup(gl_panelInferior.createSequentialGroup()
												.addGroup(gl_panelInferior.createParallelGroup(Alignment.LEADING, false)
														.addComponent(lbTelefono, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(lbNombre, GroupLayout.DEFAULT_SIZE, 72,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panelInferior.createParallelGroup(Alignment.LEADING)
														.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, 96,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(24)
												.addGroup(gl_panelInferior.createParallelGroup(Alignment.LEADING, false)
														.addComponent(lbCedula, Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(lbDireccion, Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panelInferior.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panelInferior.createSequentialGroup()
																.addComponent(txtCedula, GroupLayout.PREFERRED_SIZE, 96,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnCompletarVenta)
																.addGap(36))
														.addGroup(gl_panelInferior.createSequentialGroup()
																.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE,
																		167, GroupLayout.PREFERRED_SIZE)
																.addContainerGap()))))));
		gl_panelInferior.setVerticalGroup(
				gl_panelInferior.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelInferior.createSequentialGroup()
								.addGap(21)
								.addComponent(lbTituloPanelInferior)
								.addGap(22)
								.addGroup(gl_panelInferior.createParallelGroup(Alignment.BASELINE)
										.addComponent(lbNombre)
										.addComponent(btnCompletarVenta)
										.addComponent(lbCedula)
										.addComponent(txtCedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelInferior.createParallelGroup(Alignment.BASELINE)
										.addComponent(lbTelefono)
										.addComponent(lbDireccion)
										.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelInferior.setLayout(gl_panelInferior);
		//
		// panel 3
		//
		JScrollPane panelCentral = new JScrollPane();
		panelCentral.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(panelCentral, BorderLayout.CENTER);
		tblProductos = new JTable();
		modelo = new DefaultTableModel();
		tblProductos.setModel(modelo);
		getColumnasTabla();
		panelCentral.setViewportView(tblProductos);

	}

	private void getColumnasTabla() {

		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("PRECIO VENTA");
		modelo.addColumn("CANTIDAD");

	}
}
