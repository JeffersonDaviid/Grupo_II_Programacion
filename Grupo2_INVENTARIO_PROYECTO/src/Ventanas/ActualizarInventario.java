package Ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class ActualizarInventario extends JPanel {
    public ActualizarInventario() {
        setBackground(new Color(156, 84, 75));

        JLabel lblNewLabel = new JLabel("INVENTARIO ACTUALIZADO");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        add(lblNewLabel);
    }

}
