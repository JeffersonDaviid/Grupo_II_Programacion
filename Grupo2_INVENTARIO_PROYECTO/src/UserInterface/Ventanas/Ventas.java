package UserInterface.Ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Ventas extends JPanel {
	public Ventas() {
		setBackground(new Color(255, 0, 255));

		JLabel lblNewLabel = new JLabel("REALIZANDO VENTAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		add(lblNewLabel);
	}

}
