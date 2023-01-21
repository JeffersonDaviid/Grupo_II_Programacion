package UserInterface.Ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class RegistrarProducto extends JPanel {

    public RegistrarProducto() {
        setBackground(new Color(80, 100, 155));

        JLabel lblNewLabel = new JLabel("PRODUCTO REGISTRADO");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        add(lblNewLabel);
    }
}
