package UserInterface.Ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class EliminarTrabajador extends JPanel {
	public EliminarTrabajador() {
		setBackground(new Color(255, 0, 255));

		JLabel lblNewLabel = new JLabel("TRABAJADOR ELIMINADO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		add(lblNewLabel);
	}

}
