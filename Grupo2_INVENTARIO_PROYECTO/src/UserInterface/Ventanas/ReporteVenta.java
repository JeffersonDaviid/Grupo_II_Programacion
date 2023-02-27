package UserInterface.Ventanas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ReporteVenta extends JPanel {
	DefaultTableModel modelo;
	private JTable tblVentas;
	public ReporteVenta() {
		setLayout(new BorderLayout(0, 0));
    	
    	JPanel panelPrincipal = new JPanel();
    	add(panelPrincipal);
    	panelPrincipal.setLayout(new BorderLayout(0, 0));
    	
    	JPanel panelSuperior = new JPanel();
    	panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
    	
    	JPanel panelCentral = new JPanel();
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);
        panelCentral.setLayout(new BorderLayout(0, 0));
        
        JLabel lbCentralSuperior = new JLabel("      ");
        panelCentral.add(lbCentralSuperior, BorderLayout.NORTH);
        
        JLabel lbCentralInferior = new JLabel("      ");
        panelCentral.add(lbCentralInferior, BorderLayout.SOUTH);
        
        JLabel lbCentralIzquierdo = new JLabel("      ");
        panelCentral.add(lbCentralIzquierdo, BorderLayout.WEST);
        
        JLabel lbCentralDerecho = new JLabel("      ");
        panelCentral.add(lbCentralDerecho, BorderLayout.EAST);
        
        JPanel panelContenedor = new JPanel();
        panelCentral.add(panelContenedor, BorderLayout.CENTER);
        panelContenedor.setLayout(new BorderLayout(0, 0));
        
        JPanel panelFiltro = new JPanel();
        panelContenedor.add(panelFiltro, BorderLayout.NORTH);
        panelFiltro.setLayout(new GridLayout(2, 4, 5, 0));
        
        JLabel lblFiltrar = new JLabel("Filtrar por:");
        panelFiltro.add(lblFiltrar);
        
        JLabel lblAyudante1 = new JLabel(" ");
        panelFiltro.add(lblAyudante1);
        
        JLabel lblAyudante2 = new JLabel(" ");
        panelFiltro.add(lblAyudante2);
        
        JLabel lblTotalVenta = new JLabel("Total Venta");
        panelFiltro.add(lblTotalVenta);
        
        JComboBox cbxFiltroFecha = new JComboBox();
        panelFiltro.add(cbxFiltroFecha);
        
        JComboBox cbxFiltroId = new JComboBox();
        panelFiltro.add(cbxFiltroId);
        
        JButton btnBuscar = new JButton("Buscar");
        panelFiltro.add(btnBuscar);
        
        JTextField txtTotalVenta = new JTextField();
        txtTotalVenta.setEditable(false);
        panelFiltro.add(txtTotalVenta);
        txtTotalVenta.setColumns(10);
        
        JPanel panelResultados = new JPanel();
        panelContenedor.add(panelResultados, BorderLayout.SOUTH);
        panelResultados.setLayout(new GridLayout(0, 4, 0, 0));
        
        JLabel lblCantidadVentas = new JLabel("Cantidad De Ventas:");
        lblCantidadVentas.setHorizontalAlignment(SwingConstants.CENTER);
        panelResultados.add(lblCantidadVentas);
        
        JTextField txtCantidadVentas = new JTextField();
        txtCantidadVentas.setEditable(false);
        panelResultados.add(txtCantidadVentas);
        txtCantidadVentas.setColumns(10);
        
        JLabel lblTotalIngresos = new JLabel("Total Ingresos : $");
        lblTotalIngresos.setHorizontalAlignment(SwingConstants.CENTER);
        panelResultados.add(lblTotalIngresos);
        
        JTextField txtTotalIngresos = new JTextField();
        txtTotalIngresos.setEditable(false);
        panelResultados.add(txtTotalIngresos);
        txtTotalIngresos.setColumns(10);
        
        JScrollPane scroll = new JScrollPane();
        panelContenedor.add(scroll);
		
        tblVentas = new JTable();
        modelo = new DefaultTableModel();
        tblVentas.setModel(modelo);
        getColumnasTabla();
        scroll.setViewportView(tblVentas);
        
        JLabel lbTittle = new JLabel("REPORTE DE VENTAS");
        lbTittle.setFont(new Font("Berlin Sans FB", Font.BOLD, 13));
        panelSuperior.add(lbTittle);
	}

    /*
     * Este método permite asignarle el nombre a las columnas de la tabla venta
     */
	private void getColumnasTabla() {
        modelo.addColumn("FECHA DE VENTA");
        modelo.addColumn("N° VENTA");
        modelo.addColumn("ID PRODUCTO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("NOMBRE PRODUCTO");
        modelo.addColumn("VENDEDOR");
        modelo.addColumn("IVA");
        modelo.addColumn("PRECIO DE VENTA");
        modelo.addColumn("SUBTOTAL");
    }

}
