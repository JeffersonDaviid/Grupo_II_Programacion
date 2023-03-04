package UserInterface.UI_Component.CustomTable;

import javax.swing.table.DefaultTableModel;

import Framework.Utilities.Tabla;

public class ModeloTabla extends DefaultTableModel {

	String[] titulos;
	Object[][] datos;

	/**
	 * Determina el modelo con el que se va a construir la tabla
	 * 
	 * @param datos
	 * @param titulos
	 */
	public ModeloTabla(Object[][] datos, String[] titulos) {
		super();
		this.titulos = titulos;
		this.datos = datos;
		setDataVector(datos, titulos);
	}

	public ModeloTabla() {

	}

	public boolean isCellEditable(int row, int column) {
		// Definimos si una celda puede ser o no editable
		if (column == Tabla.CODIGO || column == Tabla.FECHA_CREACION || column == Tabla.FECHA_MODIFICACION) {
			return false;
		} else {
			return true;
		}

	}

}
