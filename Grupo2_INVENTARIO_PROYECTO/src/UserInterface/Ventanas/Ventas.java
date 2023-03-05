package UserInterface.Ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import BusinnessLogic.Entities.Producto;
import BusinnessLogic.Entities.Venta;
import DataAccess.VentaDAC;
import UserInterface.UI_Component.CustomJPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ScrollPaneConstants;

public class Ventas extends CustomJPanel {
	JTable tblProductos;
	DefaultTableModel modelo;
	Venta v = new Venta();
	int a = 0;
	VentaDAC vDAC = new VentaDAC();
	Producto pro = new Producto();
	double total = 0;
	Object[] fila = new Object[4];
	ArrayList<Producto> lsVentasRegistradas;
	private JTextField txtCodigoProducto;
	private JTextField txtCantidad;
	private JTextField txtNombre;
	private JTextField txtMonto;

	public Ventas() {
		super("images/img_fondoRegistro.jpeg");
		setBackground(new Color(255, 0, 255));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("VENTAS");
		panel.add(lblNewLabel);

		JTextPane txtTotal = new JTextPane();
		txtTotal.setEditable(false);
		txtTotal.setForeground(Color.GREEN);
		txtTotal.setBackground(Color.BLACK);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		add(panel_1, BorderLayout.WEST);
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
						if (pro.getProducto() != null) {
							fila[3] = (txtCantidad.getText());
							modelo.addRow(fila);

							total = total
									+ ((Integer.parseInt(fila[3].toString()) * Double.parseDouble(fila[2].toString())));

							txtCantidad.setText("");
							txtCodigoProducto.setText("");
							txtTotal.setText("" + total);
						}
					}
				}
			}
		});

		JButton btnAgregarVenta = new JButton("AGREGAR");
		btnAgregarVenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!"".equals(txtCantidad.getText()) && !"".equals(txtCodigoProducto.getText())) {
					if (e.getButton() == 1) {
						String cod = txtCodigoProducto.getText();
						pro = vDAC.BuscarPro(cod);
						if (pro.getProducto() != null) {
							fila[0] = (txtCodigoProducto.getText());
							fila[1] = (pro.getProducto());
							fila[2] = (pro.getPrecioVenta());
							fila[3] = (txtCantidad.getText());
							modelo.addRow(fila);

							total = total
									+ ((Integer.parseInt(fila[3].toString()) * Double.parseDouble(fila[2].toString())));
						}

						txtCodigoProducto.setText("");
						txtCantidad.setText("");
						txtTotal.setText("" + total);

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
					txtCambio.setText("" + (Double.parseDouble(txtMonto.getText()) - total));
				}
			}
		});
		txtMonto.setForeground(Color.GREEN);
		txtMonto.setBackground(Color.BLACK);
		txtMonto.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("TOTAL:");

		JLabel lblNewLabel_3 = new JLabel("MONTO:");

		JLabel lblNewLabel_4 = new JLabel("CAMBIO:");

		JLabel lblNewLabel_5 = new JLabel("CANTIDAD:");

		JLabel lblNewLabel_5_1 = new JLabel("COD_PRODUCTO:");

		JLabel lblNewLabel_6 = new JLabel("INGREO DE PRODUCTOS");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
												.addContainerGap()
												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel_1.createSequentialGroup()
																.addGroup(gl_panel_1
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(txtTotal,
																				GroupLayout.PREFERRED_SIZE, 85,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(lblNewLabel_2,
																				GroupLayout.PREFERRED_SIZE, 73,
																				GroupLayout.PREFERRED_SIZE))
																.addGap(18)
																.addGroup(gl_panel_1
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(txtMonto,
																				GroupLayout.PREFERRED_SIZE, 88,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(lblNewLabel_3,
																				GroupLayout.PREFERRED_SIZE, 63,
																				GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addGroup(gl_panel_1
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblNewLabel_4,
																				GroupLayout.PREFERRED_SIZE, 63,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(txtCambio,
																				GroupLayout.PREFERRED_SIZE, 96,
																				GroupLayout.PREFERRED_SIZE)))
														.addGroup(gl_panel_1.createSequentialGroup()
																.addGroup(gl_panel_1
																		.createParallelGroup(Alignment.TRAILING)
																		.addComponent(lblNewLabel_5_1,
																				Alignment.LEADING,
																				GroupLayout.PREFERRED_SIZE, 98,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(lblNewLabel_5,
																				GroupLayout.DEFAULT_SIZE, 98,
																				Short.MAX_VALUE))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_panel_1
																		.createParallelGroup(Alignment.TRAILING, false)
																		.addComponent(txtCantidad)
																		.addComponent(txtCodigoProducto))
																.addPreferredGap(ComponentPlacement.RELATED, 82,
																		Short.MAX_VALUE))))
										.addGroup(gl_panel_1.createSequentialGroup()
												.addGap(57)
												.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 209,
														GroupLayout.PREFERRED_SIZE)))
								.addContainerGap())
						.addGroup(gl_panel_1.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnAgregarVenta, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
								.addGap(176)));
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(15)
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtCodigoProducto, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_5_1))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_5))
								.addGap(18)
								.addComponent(btnAgregarVenta)
								.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_3)
										.addComponent(lblNewLabel_4))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtMonto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCambio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
		panel_1.setLayout(gl_panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		add(panel_2, BorderLayout.SOUTH);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);

		JButton btnCompletarVenta = new JButton("COMPLETAR VENTA");
		btnCompletarVenta.addMouseListener(new MouseAdapter() {

			@Override
			//
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					v.setCliente(txtNombre.getText());
					v.setVendedor("hola");
					v.setTotal(total);
					vDAC.registrarVenta(v);
					do {
						for (int i = 0; i <= modelo.getRowCount(); i++) {
							modelo.removeRow(a);
						}
					} while (modelo.getRowCount() != 0);
					txtTotal.setText("");
					txtNombre.setText("");
				}
			}
		});

		JLabel lblNewLabel_1 = new JLabel("INFORMACION USUARIO");

		JLabel lblNewLabel_8 = new JLabel("NOMBRE:");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_2.createSequentialGroup()
												.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 310,
														Short.MAX_VALUE)
												.addGap(138)
												.addContainerGap())
										.addGroup(gl_panel_2.createSequentialGroup()
												.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 59,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
												.addComponent(btnCompletarVenta)
												.addGap(36)))));
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
								.addGap(21)
								.addComponent(lblNewLabel_1)
								.addGap(22)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_8)
										.addComponent(btnCompletarVenta))
								.addContainerGap(23, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		// panel 3
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane, BorderLayout.CENTER);
		tblProductos = new JTable();
		modelo = new DefaultTableModel();
		tblProductos.setModel(modelo);
		getColumnasTabla();
		scrollPane.setViewportView(tblProductos);

	}

	private void getColumnasTabla() {

		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("PRECIO VENTA");
		modelo.addColumn("CANTIDAD");

	}

}
