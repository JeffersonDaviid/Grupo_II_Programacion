package UserInterface.Ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Facturacion extends JPanel {
	public Facturacion() {
		setBackground(new Color(255, 60, 85));

		JLabel lblNewLabel = new JLabel("REALIZANDO FACTURACION");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		add(lblNewLabel);
	}

}
