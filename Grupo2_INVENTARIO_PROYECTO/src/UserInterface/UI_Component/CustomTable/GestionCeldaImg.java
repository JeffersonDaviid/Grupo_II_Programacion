package UserInterface.UI_Component.CustomTable;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class GestionCeldaImg implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        JLabel label = new JLabel();
        // ImageIcon iconoBuscar = new ImageIcon("images/iconos/ico_buscar.png");
        ImageIcon iconoGuardar = new ImageIcon("images/iconos/ico_guardar.png");

        // Icon icon_buscar = new ImageIcon(iconoBuscar.getImage());
        Icon icon_guardar = new ImageIcon(iconoGuardar.getImage());

        // if (String.valueOf(value).equals("PERFIL")) {
        // label.setIcon(icon_buscar);
        // } else if (String.valueOf(value).equals("EVENTO")) {
        // label.setIcon(icon_guardar);
        // }
        label.setIcon(icon_guardar);
        // label.setHorizontalAlignment(JLabel.LEFT);
        // return boton;
        return label;
    }

}
