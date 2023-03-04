package UserInterface.UI_Component.CustomTable;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class GestionCeldaComboBox implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {

        JComboBox combo = new JComboBox();
        return combo;

    }

}
