package UserInterface.Ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class ReporteVenta extends JPanel {
	public ReporteVenta() {
		setBackground(new Color(25, 80, 85));

		JLabel lblNewLabel = new JLabel("REPORTE DE VENTAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		add(lblNewLabel);
	}

}
