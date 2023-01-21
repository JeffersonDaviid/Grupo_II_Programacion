package UserInterface.Ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class RegistrarTrabajador extends JPanel {
    public RegistrarTrabajador() {
        setBackground(new Color(153, 200, 215));

        JLabel lblNewLabel = new JLabel("TRABAJADOR REGISTRADO");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        add(lblNewLabel);
    }
}
