package UI_Interfaz;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import CustomerControl.CustomButton;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Cursor;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBackground(new Color(255, 255, 255));
		setMinimumSize(new Dimension(960, 540));
		setLocationRelativeTo(null);
		JFrame frame = new JFrame("SERVICIO ADMINISTRADOR");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// ENCABEZADO
		JPanel header = new JPanel();
		header.setVisible(false);
		contentPane.add(header, BorderLayout.NORTH);
		header.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel logoEmpresa = new JLabel("IMG LOGO EMPRESA");
		header.add(logoEmpresa);

		JLabel logoEmpresa_1 = new JLabel();
		header.add(logoEmpresa_1);

		JLabel lbRol = new JLabel("ADMINISTRADOR");
		lbRol.setHorizontalAlignment(SwingConstants.CENTER);
		header.add(lbRol);

		// PANEL DE NAVEGACION PRINCIPAL
		JPanel panelNavegacion = new JPanel();
		panelNavegacion.setOpaque(false);
		panelNavegacion.setAutoscrolls(true);
		panelNavegacion.setBackground(new Color(255, 102, 51));
		panelNavegacion.setMaximumSize(new Dimension(100, 32767));
		panelNavegacion.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(panelNavegacion, BorderLayout.WEST);
		panelNavegacion.setLayout(new GridLayout(0, 1, 0, 25));
		ImageIcon img_userIcon = new ImageIcon("Grupo2_INVENTARIO_PROYECTO/images/img_UserIcon.png");

		// PANEL DE NAVEGACION INFORMACION DE USUARIO
		JPanel panelNavegacion_UsuarioDatos = new JPanel();
		panelNavegacion_UsuarioDatos.setOpaque(false);
		panelNavegacion_UsuarioDatos.setMinimumSize(new Dimension(100, 10));
		panelNavegacion_UsuarioDatos.setMaximumSize(new Dimension(100, 250));
		panelNavegacion.add(panelNavegacion_UsuarioDatos);
		panelNavegacion_UsuarioDatos.setLayout(null);

		JLabel img_User = new JLabel();
		img_User.setLocation(29, 12);
		panelNavegacion_UsuarioDatos.add(img_User);
		img_User.setHorizontalTextPosition(SwingConstants.CENTER);
		img_User.setHorizontalAlignment(SwingConstants.CENTER);
		img_User.setOpaque(true);
		img_User.setRequestFocusEnabled(false);
		img_User.setSize(new Dimension(127, 127));
		img_User.setAlignmentX(Component.CENTER_ALIGNMENT);
		Icon img_UserIconResize = new ImageIcon(
				img_userIcon.getImage().getScaledInstance(img_User.getWidth(), img_User.getHeight(),
						Image.SCALE_SMOOTH));
		img_User.setIcon(img_UserIconResize);

		JLabel lblAdminitrado = new JLabel("ADMINISTRADOR");
		lblAdminitrado.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAdminitrado.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminitrado.setBounds(12, 126, 158, 38);
		panelNavegacion_UsuarioDatos.add(lblAdminitrado);

		CustomButton btnCerrarSesion = new CustomButton("CERRAR SESION");
		btnCerrarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		btnCerrarSesion.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCerrarSesion.setBounds(12, 176, 158, 25);
		panelNavegacion_UsuarioDatos.add(btnCerrarSesion);
		btnCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JLabel lbBackground = new JLabel();
		lbBackground.setLocation(-12, -13);
		lbBackground.setSize(966, 504);
		ImageIcon img_fondoPantalla = new ImageIcon("Grupo2_INVENTARIO_PROYECTO/images/img_fondoLoginLienzo.jpg");
		Icon icon_fondoPantalla = new ImageIcon(
				img_fondoPantalla.getImage().getScaledInstance(700, 700,
						Image.SCALE_SMOOTH));
		lbBackground.setIcon(icon_fondoPantalla);
		panelNavegacion_UsuarioDatos.add(lbBackground);

		// PANEL DE NAVEGACION ACCIONES
		JPanel panelNavegacion_Acciones = new JPanel();
		panelNavegacion_Acciones.setOpaque(false);
		panelNavegacion.add(panelNavegacion_Acciones);
		panelNavegacion_Acciones.setLayout(new GridLayout(7, 0, 0, 17));

		CustomButton btnRegistrarProducto = new CustomButton("Registrar Producto",
				"Grupo2_INVENTARIO_PROYECTO/images/iconos/bird.png");
		panelNavegacion_Acciones.add(btnRegistrarProducto);
		btnRegistrarProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		CustomButton btnRegistrarTrabajador = new CustomButton("Registrar Trabajador");
		panelNavegacion_Acciones.add(btnRegistrarTrabajador);
		btnRegistrarTrabajador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		CustomButton btnEliminarTrabajador = new CustomButton("Eliminar Trabajador");
		panelNavegacion_Acciones.add(btnEliminarTrabajador);
		btnEliminarTrabajador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		CustomButton btnListaInventario = new CustomButton("Revisar Inventario");
		panelNavegacion_Acciones.add(btnListaInventario);
		btnListaInventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		CustomButton btnActualizarInventario = new CustomButton("Actualizar Inventario");
		panelNavegacion_Acciones.add(btnActualizarInventario);
		btnActualizarInventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// PIE DE APP
		JPanel footer = new JPanel();
		footer.setOpaque(false);
		contentPane.add(footer, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("© EASY SELL | Todos los derechos reservados 2023");
		footer.add(lblNewLabel);

		// CONTENIDO ACTULIZABLE
		JPanel xxxxxContenidoTEMPORAL = new JPanel();
		xxxxxContenidoTEMPORAL.setBorder(null);
		xxxxxContenidoTEMPORAL.setBackground(new Color(153, 102, 204));
		contentPane.add(xxxxxContenidoTEMPORAL, BorderLayout.CENTER);
		xxxxxContenidoTEMPORAL.setLayout(null);
	}

	public void insertarPanelNavegacion(JPanel footer) {
		contentPane.add(footer, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("© EASY SELL | Todos los derechos reservados 2023");
		footer.add(lblNewLabel);
	}
}
