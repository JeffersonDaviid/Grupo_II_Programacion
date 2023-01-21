package UserInterface.Ventanas;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Bienvenida extends JPanel {

    public Bienvenida() {
        setBackground(new Color(255, 0, 255));

        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        ImageIcon img = new ImageIcon("images/img_bienvenidosApp.jpeg");
        lblNewLabel.setIcon(img);
        add(lblNewLabel);
    }

}
