package Ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class RevisarInventario extends JPanel {

    public RevisarInventario() {
        setBackground(new Color(186, 100, 85));

        JLabel lblNewLabel = new JLabel("REVISANDO INVENTARIO");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        add(lblNewLabel);
    }

}
