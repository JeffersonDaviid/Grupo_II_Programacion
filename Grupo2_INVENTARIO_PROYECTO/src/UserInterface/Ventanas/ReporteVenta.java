package UserInterface.Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.itextpdf.io.IOException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import BusinnessLogic.ProductoBL;
import BusinnessLogic.Entities.Compra;
import BusinnessLogic.Entities.Producto;

public class ReporteVenta extends JPanel {

	private ArrayList<Compra> lsCompra = new ArrayList<Compra>();

	public ReporteVenta() {
		setBackground(new Color(25, 80, 85));
		setVisible(true);
		JLabel lblNewLabel = new JLabel("REPORTE DE VENTAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		add(lblNewLabel);

		try {
			ProductoBL p = new ProductoBL();
			for (Producto item : p.getAllProducto()) {
				Compra c = new Compra(1, item);
				lsCompra.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		generarFactura(lsCompra);

	}

	public static void generarFactura(ArrayList<Compra> lsCompra) {

		// File file = new File("/home/jefferson/Escritorio/hello_world.pdf");
		File file = new File("Facturas/hello_world3.pdf");
		// Datos de la factura
		String numeroFactura = "F0001";
		String nombreCliente = "Juanito Pérez";
		Date fechaFactura = new Date();
		double totalFactura = 5000.00;

		// Formateo de fechas y números
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,###.00");

		try {
			PdfWriter pdfWriter = new PdfWriter(file);
			PdfDocument pdfDocument = new PdfDocument(pdfWriter);
			Document document = new Document(pdfDocument);

			// Agregar contenido a la factura
			Paragraph paragraph = new Paragraph();
			paragraph.add("Número de factura: " + numeroFactura + "\n");
			paragraph.add("Fecha de factura: " + sdf.format(fechaFactura) + "\n");
			paragraph.add("Cliente: " + nombreCliente + "\n\n");
			paragraph.add("Detalle de la factura:\n\n");
			for (Compra compras : lsCompra) {
				paragraph.add("\t- " + compras.getIntCantidad() + " : " + compras.getProducto().getProducto() + " \n");
			}
			paragraph.add("Total a pagar: $" + df.format(totalFactura));

			document.add(paragraph);

			document.close();
			pdfDocument.close();

			System.out.println("PDF creado");

			Compra c = new Compra(1, lsCompra.get(2).getProducto());

			System.out.println("tamaño" + lsCompra.size());
			if (!actualizarCantidadRepetido(c, lsCompra)) {
				lsCompra.add(c);
				System.out.println("hola ");
				System.out.println(c.getIntCantidad());
			}
			System.out.println("tamaño" + lsCompra.size());

			for (Compra compra : lsCompra) {
				System.out.println(compra.getIntCantidad());
			}

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

	/**
	 * Método que se encarga de incrementar la cantidad de un determinado item
	 * dentro de una lista, si es que este se encuentra en la lista, caso contrario
	 * no hará nada.
	 * 
	 * @param compra   item que se buscará en la lista.
	 * @param lsCompra lista que contiene el item.
	 * @return TRUE: Si es que encontro el item, FALSE: si es que no lo encontró.
	 */
	public static boolean actualizarCantidadRepetido(Compra compra, ArrayList<Compra> lsCompra) {
		for (Compra item : lsCompra) {
			if (item.getProducto().getProducto().equals(compra.getProducto().getProducto())) {
				item.setIntCantidad(item.getIntCantidad() + 1);
				return true;
			}
		}
		return false;
	}

}
