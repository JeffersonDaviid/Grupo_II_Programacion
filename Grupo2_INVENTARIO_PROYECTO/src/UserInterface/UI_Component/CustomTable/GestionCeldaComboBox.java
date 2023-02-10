package UserInterface.UI_Component.CustomTable;

import java.awt.Component;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import BusinnessLogic.EstadoBL;
import DataAccess.EstadoDAC;

public class GestionCeldaComboBox implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {

        // DefaultTableModel model = (DefaultTableModel) table.getModel();
        JComboBox combo = new JComboBox();

        // combo.setSelectedItem((model.getValueAt(row, column).toString()));
        // combo.addItem("Pan");
        // combo.addItem("leche");
        // combo.addItem("huevos");
        // combo.addItem("manzanas");

        EstadoBL lsEstados = new EstadoBL();

        try {
            return cargarComboItems(combo, lsEstados.getAllEstadoNombre());
        } catch (Exception e) {
        }
        return combo;

    }

    public JComboBox cargarComboItems(JComboBox combo, ArrayList<String> lsItems) {

        for (String item : lsItems) {
            combo.addItem(item);
        }
        combo.setSelectedIndex(2);
        return combo;
    }

}
