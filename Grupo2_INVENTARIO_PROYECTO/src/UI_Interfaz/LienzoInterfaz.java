package UI_Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CustomerControl.CustomButton;

public class LienzoInterfaz extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		LienzoInterfaz frame = new LienzoInterfaz();
		frame.setVisible(true);

	}

	public LienzoInterfaz() {
		setMinimumSize(new Dimension(960, 540));
		setLocationRelativeTo(null);
		JFrame frame = new JFrame("SERVICIO ADMINISTRADOR");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// ENCABEZADO
		JPanel header = new JPanel();
		contentPane.add(header, BorderLayout.NORTH);
		header.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel logoEmpresa = new JLabel("IMG LOGO EMPRESA");
		header.add(logoEmpresa);

		JLabel lbRol = new JLabel("ADMINISTRADOR");
		header.add(lbRol);

		// PANEL DE NAVEGACION
		JPanel panelNavegacion = new JPanel();
		panelNavegacion.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(panelNavegacion, BorderLayout.WEST);
		panelNavegacion.setLayout(new GridLayout(10, 1, 10, 10));

		CustomButton btnRegistrarProducto = new CustomButton("Registrar Producto");
		panelNavegacion.add(btnRegistrarProducto);

		JButton btnNewButton = new JButton("New button");
		panelNavegacion.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		panelNavegacion.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		panelNavegacion.add(btnNewButton_2);

		JButton btnNewButton_1_1 = new JButton("New button");
		panelNavegacion.add(btnNewButton_1_1);

		// PIE DE APP
		JPanel footer = new JPanel();
		contentPane.add(footer, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("© EASY SELL | Todos los derechos reservados 2023");
		footer.add(lblNewLabel);

		// CONTENIDO ACTULIZABLE
		JPanel xxxxxContenidoTEMPORAL = new JPanel();
		contentPane.add(xxxxxContenidoTEMPORAL, BorderLayout.CENTER);
		xxxxxContenidoTEMPORAL.setLayout(null);
	}

	public void insertarPanelNavegacion(JPanel footer) {
		contentPane.add(footer, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("© EASY SELL | Todos los derechos reservados 2023");
		footer.add(lblNewLabel);
	}

}
