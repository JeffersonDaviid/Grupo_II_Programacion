package PkgUserInterface.Ventanas;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

import com.itextpdf.io.IOException;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

import PkgBusinnessLogic.Entities.Venta;
import PkgDataAccess.ProductoDAC;

public class VReporteVenta extends JPanel {

        private static double doubleTotal = 0;

        public static void generarFactura(String cliente, String cedula, String direccion, String telefono,
                        ArrayList<Venta> lsCompra, double total) {

                Date fechaFactura = new Date();
                SimpleDateFormat sdfFormatoFactura = new SimpleDateFormat("ddMMyyHHmm");
                SimpleDateFormat sdfFormatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                String stringPdfPath = "Facturas/" + quitarEspaciosEnCadena(cliente)
                                + sdfFormatoFactura.format(fechaFactura)
                                + ".pdf";
                File file = new File(stringPdfPath);

                // Datos de la factura
                String stringNumeroFactura = "E" + sdfFormatoFactura.format(fechaFactura) + "S";
                String stringFechaFactura = sdfFormatoFecha.format(fechaFactura);

                // Formateo de fechas y números
                DecimalFormat df = new DecimalFormat("#,###.00");

                try {
                        PdfWriter pdfWriter = new PdfWriter(file);
                        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
                        Document document = new Document(pdfDocument);

                        for (Paragraph itemParagraphEncabezado : llenarPdfEncabezado(cliente, direccion, telefono,
                                        cedula,
                                        stringFechaFactura,
                                        stringNumeroFactura)) {
                                document.add(itemParagraphEncabezado);
                        }

                        document.add(llenarPdfTabla(lsCompra, total));

                        Cell cell1 = new Cell().add(new Paragraph("TOTAL:\t\t\t\t\t " + df.format(doubleTotal)))
                                        .setTextAlignment(TextAlignment.RIGHT)
                                        .setBackgroundColor(ColorConstants.ORANGE);

                        document.add(cell1);

                        document.close();
                        pdfDocument.close();

                        System.out.println("PDF creado");

                } catch (FileNotFoundException ex) {
                        System.out.println(ex.getMessage());
                } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                }

        }

        public static Table llenarPdfTabla(ArrayList<Venta> lsCompra, double total) {
                DecimalFormat df = new DecimalFormat("#,###.00");

                Table pdfTabla = new Table(4);
                pdfTabla.setWidth(UnitValue.createPercentValue(100));

                Cell cell1 = new Cell().add(new Paragraph("Cantidad"))
                                .setTextAlignment(TextAlignment.CENTER)
                                .setBackgroundColor(ColorConstants.ORANGE);

                Cell cell2 = new Cell().add(new Paragraph("Descripción"))
                                .setBackgroundColor(ColorConstants.ORANGE);

                Cell cell3 = new Cell().add(new Paragraph("Precio Unitario"))
                                .setTextAlignment(TextAlignment.CENTER)

                                .setBackgroundColor(ColorConstants.ORANGE);

                Cell cell4 = new Cell().add(new Paragraph("Subtotal"))
                                .setTextAlignment(TextAlignment.CENTER)
                                .setBackgroundColor(ColorConstants.ORANGE);

                pdfTabla.addCell(cell1);
                pdfTabla.addCell(cell2);
                pdfTabla.addCell(cell3);
                pdfTabla.addCell(cell4);

                for (Venta itemCompra : lsCompra) {

                        Cell cellCantidad = new Cell().add(
                                        new Paragraph(itemCompra.getIntCantidad() + ""))
                                        .setFontSize(10);

                        Cell cellDescripcion = new Cell().add(
                                        new Paragraph(itemCompra.getProducto().getProducto()))
                                        .setFontSize(10)
                                        .setWidth(UnitValue.createPercentValue(60));

                        Cell cellPrecioUnitario = new Cell().add(
                                        new Paragraph(df.format(itemCompra.getProducto().getPrecioVenta()) + ""))
                                        .setTextAlignment(TextAlignment.RIGHT)
                                        .setFontSize(10)
                                        .setWidth(UnitValue.createPercentValue(20));

                        Cell cellSubtotalUnitario = new Cell().add(
                                        new Paragraph(df.format(
                                                        itemCompra.getProducto().getStock()
                                                                        * itemCompra.getProducto().getPrecioVenta())
                                                        + ""))
                                        .setTextAlignment(TextAlignment.RIGHT)
                                        .setFontSize(10)
                                        .setWidth(UnitValue.createPercentValue(20));

                        doubleTotal += itemCompra.getIntCantidad()
                                        * itemCompra.getProducto().getPrecioVenta();

                        ProductoDAC productoDACActualizar = new ProductoDAC();

                        try {
                                if (itemCompra.getProducto().getStock() - itemCompra.getIntCantidad() == 0) {
                                        productoDACActualizar.setProductoVendido(
                                                        itemCompra.getProducto().getCodigoProducto(),
                                                        2,
                                                        itemCompra.getProducto().getStock()
                                                                        - itemCompra.getIntCantidad());
                                } else {
                                        productoDACActualizar.setProductoVendido(
                                                        itemCompra.getProducto().getCodigoProducto(),
                                                        itemCompra.getProducto().getFkEstado().getIdEstado(),
                                                        itemCompra.getProducto().getStock()
                                                                        - itemCompra.getIntCantidad());
                                }
                        } catch (Exception e) {
                                e.printStackTrace();
                        }

                        pdfTabla.addCell(cellCantidad);
                        pdfTabla.addCell(cellDescripcion);
                        pdfTabla.addCell(cellPrecioUnitario);
                        pdfTabla.addCell(cellSubtotalUnitario);

                }

                return pdfTabla;
        }

        public static ArrayList<Paragraph> llenarPdfEncabezado(String cliente, String direccion, String correo,
                        String cedula,
                        String fechaFactura,
                        String numeroFactura) {
                ArrayList<Paragraph> lsItemsPdfEncabezado = new ArrayList<>();

                Paragraph paragraphEncabezadoPdf1 = new Paragraph();
                Paragraph paragraphEncabezadoPdf2 = new Paragraph();
                Paragraph paragraphEncabezadoPdf3 = new Paragraph();
                Paragraph paragraphEncabezadoPdf4 = new Paragraph();
                Paragraph paragraphEncabezadoPdf5 = new Paragraph();
                Paragraph paragraphEncabezadoPdf6 = new Paragraph();
                Paragraph paragraphEncabezadoPdf7 = new Paragraph();
                Paragraph paragraphEncabezadoPdf8 = new Paragraph();

                paragraphEncabezadoPdf1.add(
                                "______________________________________________________________________________");

                paragraphEncabezadoPdf2.add("EASY SELL")
                                .setTextAlignment(TextAlignment.CENTER)
                                .setBold()
                                .setMargin(-5)
                                .setFontSize(18);

                paragraphEncabezadoPdf3.add("'Te ayudamos en todo'")
                                .setTextAlignment(TextAlignment.CENTER)
                                .setItalic()
                                .setFontSize(11);

                paragraphEncabezadoPdf4
                                .add("CLIENTE: " + cliente + "\t\t\t\t\t\t\t\t\t\t\t\t\t N° FACTURA: " + numeroFactura)
                                .setTextAlignment(TextAlignment.JUSTIFIED);

                paragraphEncabezadoPdf5
                                .add("DIRECCIÓN: " + direccion + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tFECHA: " + fechaFactura)
                                .setTextAlignment(TextAlignment.JUSTIFIED);

                paragraphEncabezadoPdf6.add("TELEFONO: " + correo)
                                .setTextAlignment(TextAlignment.JUSTIFIED);

                paragraphEncabezadoPdf7.add("CEDULA: " + cedula)
                                .setTextAlignment(TextAlignment.JUSTIFIED);

                paragraphEncabezadoPdf8.add(
                                "______________________________________________________________________________\n\n")
                                .setMargin(-10);

                lsItemsPdfEncabezado.add(paragraphEncabezadoPdf1);
                lsItemsPdfEncabezado.add(paragraphEncabezadoPdf2);
                lsItemsPdfEncabezado.add(paragraphEncabezadoPdf3);
                lsItemsPdfEncabezado.add(paragraphEncabezadoPdf4);
                lsItemsPdfEncabezado.add(paragraphEncabezadoPdf5);
                lsItemsPdfEncabezado.add(paragraphEncabezadoPdf6);
                lsItemsPdfEncabezado.add(paragraphEncabezadoPdf7);
                lsItemsPdfEncabezado.add(paragraphEncabezadoPdf8);

                return lsItemsPdfEncabezado;
        }

        /**
         * Quita los especios de una cadena, el método se utiliza para el nombre de la
         * factura
         * 
         * @param cadena
         * @return
         */
        public static String quitarEspaciosEnCadena(String cadena) {
                return cadena.replaceAll("\\s+", "");
        }
}
