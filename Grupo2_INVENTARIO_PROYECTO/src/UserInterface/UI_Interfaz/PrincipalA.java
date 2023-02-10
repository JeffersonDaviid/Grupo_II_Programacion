package UserInterface.UI_Interfaz;

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

import Framework.AppException;
import UserInterface.UI_Component.CustomButton;
import UserInterface.UI_Component.CustomJPanel;
import UserInterface.Ventanas.ActualizarInventario;
import UserInterface.Ventanas.Bienvenida;
import UserInterface.Ventanas.EliminarTrabajador;
import UserInterface.Ventanas.RegistrarProducto;
import UserInterface.Ventanas.RegistrarTrabajador;
import UserInterface.Ventanas.RevisarInventario;

public class PrincipalA extends JFrame {

	CustomJPanel contentPane = new CustomJPanel("images/img_fondoLoginLienzo.jpg");
	// FondoPanel contentPane = new FondoPanel();
	JPanel CONTENIDO_ACTUALIZABLE = new JPanel();

	public static void main(String[] args) {
		PrincipalA frame = new PrincipalA();
		frame.setVisible(true);
	}

	public PrincipalA() {
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

		JLabel lbRol = new JLabel("ADMINISTRADOR");
		lbRol.setHorizontalAlignment(SwingConstants.CENTER);
		header.add(lbRol);

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
		// Bienvenida bienvenida = new Bienvenida("images/img_bienvenidosApp.jpg");
		// cambiarPagina(bienvenida);
		ActualizarInventario inventario;
		try {
			inventario = new ActualizarInventario();
			cambiarPagina(inventario);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// PANEL DE NAVEGACION PRINCIPAL
		// -------------------------------------------------------------------------------------------------------------
		JPanel panelNavegacion = new JPanel();
		panelNavegacion.setOpaque(false);
		panelNavegacion.setAutoscrolls(true);
		panelNavegacion.setBackground(new Color(255, 204, 51));
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

		JLabel lblAdminitrado = new JLabel("ADMINISTRADOR");
		lblAdminitrado.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAdminitrado.setHorizontalAlignment(SwingConstants.CENTER);
		panelCerrarSession.add(lblAdminitrado);

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

		CustomButton btnRegistrarProducto = new CustomButton("Registrar Producto", "images/iconos/paquete.png");
		btnRegistrarProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrarProducto registro = new RegistrarProducto();
				cambiarPagina(registro);
				setTitle("AGREGAR NUEVO PRODUCTO");
			}
		});
		btnRegistrarProducto.setHorizontalTextPosition(SwingConstants.LEFT);
		panelNavegacion_Acciones.add(btnRegistrarProducto);
		btnRegistrarProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		CustomButton btnRegistrarTrabajador = new CustomButton("Registrar Trabajador");
		btnRegistrarTrabajador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrarTrabajador registro = new RegistrarTrabajador();
				cambiarPagina(registro);
				setTitle("NUEVO TRABAJADOR");
			}
		});
		btnRegistrarTrabajador.setHorizontalTextPosition(SwingConstants.LEFT);
		panelNavegacion_Acciones.add(btnRegistrarTrabajador);
		btnRegistrarTrabajador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		CustomButton btnEliminarTrabajador = new CustomButton("Eliminar Trabajador");
		btnEliminarTrabajador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EliminarTrabajador et = new EliminarTrabajador();
				cambiarPagina(et);
				setTitle("ELIMINAR TRABAJADOR");
			}
		});
		btnEliminarTrabajador.setHorizontalTextPosition(SwingConstants.LEFT);
		panelNavegacion_Acciones.add(btnEliminarTrabajador);
		btnEliminarTrabajador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		CustomButton btnListaInventario = new CustomButton("Revisar Inventario");
		btnListaInventario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RevisarInventario inventario = new RevisarInventario();
				cambiarPagina(inventario);
				setTitle("INVENTARIO");
			}
		});
		btnListaInventario.setHorizontalTextPosition(SwingConstants.LEFT);
		panelNavegacion_Acciones.add(btnListaInventario);
		btnListaInventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		CustomButton btnActualizarInventario = new CustomButton("Actualizar Inventario");
		btnActualizarInventario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ActualizarInventario inventario = new ActualizarInventario();
					cambiarPagina(inventario);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				setTitle("ACTUALIZAR INVENTARIO");
				// panelNavegacion.setVisible(false); // Ocultar el panel
			}
		});
		btnActualizarInventario.setHorizontalTextPosition(SwingConstants.LEFT);
		panelNavegacion_Acciones.add(btnActualizarInventario);
		btnActualizarInventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	}

	private void cambiarPagina(JPanel panel) {
		CONTENIDO_ACTUALIZABLE.removeAll();
		CONTENIDO_ACTUALIZABLE.add(panel, BorderLayout.CENTER);
		CONTENIDO_ACTUALIZABLE.revalidate();
		CONTENIDO_ACTUALIZABLE.repaint();
	}
}
