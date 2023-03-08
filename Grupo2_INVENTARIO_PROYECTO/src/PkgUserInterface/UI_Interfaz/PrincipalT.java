package PkgUserInterface.UI_Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import PkgUserInterface.UI_Component.CustomButton;
import PkgUserInterface.UI_Component.CustomJPanel;
import PkgUserInterface.Ventanas.VBienvenida;
import PkgUserInterface.Ventanas.VVentas;

public class PrincipalT extends JFrame {

	CustomJPanel contentPane = new CustomJPanel("images/img_fondoLoginLienzo.jpg");
	// FondoPanel contentPane = new FondoPanel();
	JPanel CONTENIDO_ACTUALIZABLE = new JPanel();

	public static void main(String[] args) {
		PrincipalT frame = new PrincipalT();
		frame.setVisible(true);
	}

	public PrincipalT() {
		try {
			setIconImage(new ImageIcon(getClass().getResource("logoEmpresa.png")).getImage());
		} catch (Exception e) {
			System.out.println(e);
		}
		setTitle("BIENVENID@");
		setBackground(new Color(255, 120, 78));
		setMinimumSize(new Dimension(960, 540));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		this.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// ENCABEZADO
		// -------------------------------------------------------------------------------------------------------------
		JPanel header = new JPanel();
		header.setVisible(false);
		contentPane.add(header, BorderLayout.NORTH);
		header.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel logoEmpresa = new JLabel("IMG LOGO EMPRESA");
		header.add(logoEmpresa);

		JLabel logoEmpresa_1 = new JLabel();
		header.add(logoEmpresa_1);

		// PIE DE APP
		// -------------------------------------------------------------------------------------------------------------
		JPanel footer = new JPanel();
		footer.setOpaque(false);
		contentPane.add(footer, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("© EASY SELL | Todos los derechos reservados 2023");
		footer.add(lblNewLabel);

		// CONTENIDO ACTUALIZABLE
		// -------------------------------------------------------------------------------------------------------------
		contentPane.add(CONTENIDO_ACTUALIZABLE, BorderLayout.CENTER);
		CONTENIDO_ACTUALIZABLE.setLayout(new GridLayout(0, 1, 0, 0));
		VBienvenida bienvenida = new VBienvenida("images/img_bienvenidosApp.jpg");
		cambiarPagina(bienvenida);

		// PANEL DE NAVEGACION PRINCIPAL
		// -------------------------------------------------------------------------------------------------------------
		JPanel panelNavegacion = new JPanel();
		panelNavegacion.setOpaque(false);
		panelNavegacion.setAutoscrolls(true);
		panelNavegacion.setBackground(new Color(255, 102, 51));
		panelNavegacion.setMaximumSize(new Dimension(100, 32767));
		panelNavegacion.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(panelNavegacion, BorderLayout.WEST);
		panelNavegacion.setLayout(new GridLayout(0, 1, 0, 25));

		// PANEL DE NAVEGACION INFORMACION DE USUARIO
		JPanel panelNavegacion_UsuarioDatos = new JPanel();
		panelNavegacion_UsuarioDatos.setOpaque(false);
		panelNavegacion_UsuarioDatos.setMinimumSize(new Dimension(100, 10));
		panelNavegacion_UsuarioDatos.setMaximumSize(new Dimension(100, 250));
		panelNavegacion_UsuarioDatos.setLayout(new GridLayout(2, 1, 0, 0));
		panelNavegacion.add(panelNavegacion_UsuarioDatos);

		JPanel panelImgUsuario = new JPanel();
		panelImgUsuario.setOpaque(false);
		panelNavegacion_UsuarioDatos.add(panelImgUsuario);

		JLabel img_User = new JLabel();
		ImageIcon img_userIcon = new ImageIcon("images/img_UserIcon.png");
		// img_User.setLocation(13, 11);
		// img_User.setSize(127, 127);
		img_User.setIcon(img_userIcon);
		panelImgUsuario.add(img_User);

		JPanel panelCerrarSession = new JPanel();
		panelCerrarSession.setOpaque(false);
		panelCerrarSession.setBorder(new EmptyBorder(25, 0, 25, 0));
		panelNavegacion_UsuarioDatos.add(panelCerrarSession);
		panelCerrarSession.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lbRol = new JLabel("TRABAJADOR");
		lbRol.setHorizontalTextPosition(SwingConstants.CENTER);
		lbRol.setHorizontalAlignment(SwingConstants.CENTER);
		panelCerrarSession.add(lbRol);

		CustomButton btnCerrarSesion = new CustomButton("CERRAR SESION");
		btnCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IniciarSesion Inicio;
				try {
					Inicio = new IniciarSesion();
					Inicio.setVisible(true);
					setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCerrarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		btnCerrarSesion.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		panelCerrarSession.add(btnCerrarSesion);

		// PANEL DE NAVEGACION ACCIONES
		JPanel panelNavegacion_Acciones = new JPanel();
		panelNavegacion_Acciones.setOpaque(false);
		panelNavegacion.add(panelNavegacion_Acciones);
		panelNavegacion_Acciones.setLayout(new GridLayout(7, 0, 0, 15));

		CustomButton btnVenta = new CustomButton("VENTAS", "images/iconos/paquete.png");
		btnVenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VVentas iVenta = new VVentas();
				cambiarPagina(iVenta);
				setTitle("VENTAS");
			}
		});
		btnVenta.setHorizontalTextPosition(SwingConstants.LEFT);
		panelNavegacion_Acciones.add(btnVenta);
		btnVenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		CustomButton btnFacturacion = new CustomButton("FACTURACION");
		btnFacturacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		btnFacturacion.setHorizontalTextPosition(SwingConstants.LEFT);
		panelNavegacion_Acciones.add(btnFacturacion);
		btnFacturacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		CustomButton btnReporteVenta = new CustomButton("REPORTE VENTAS");
		btnReporteVenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		btnReporteVenta.setHorizontalTextPosition(SwingConstants.LEFT);
		panelNavegacion_Acciones.add(btnReporteVenta);
		btnReporteVenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	}

	/**
	 * Permite gestionar que ventana o interfaz se mostrara al dar clic en los
	 * botones disponibles
	 * para esta interfaz, por ejemplo, venta, facturación, etc
	 * 
	 * @param panel : recibe el panel que se mostrara
	 */
	private void cambiarPagina(JPanel panel) {
		CONTENIDO_ACTUALIZABLE.removeAll();
		CONTENIDO_ACTUALIZABLE.add(panel, BorderLayout.CENTER);
		CONTENIDO_ACTUALIZABLE.revalidate();
		CONTENIDO_ACTUALIZABLE.repaint();
	}
}
