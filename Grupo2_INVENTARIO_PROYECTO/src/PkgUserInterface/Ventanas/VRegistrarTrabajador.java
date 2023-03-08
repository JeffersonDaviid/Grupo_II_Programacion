package PkgUserInterface.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import PkgBusinnessLogic.Entities.Usuario;
import PkgDataAccess.UsuarioDAC;
import PkgFramework.Validadores;
import PkgUserInterface.UI_Component.CustomButton;
import PkgUserInterface.UI_Component.CustomJPanel;
import PkgUserInterface.UI_Component.CustomLabel;
import PkgUserInterface.UI_Component.CustomText;

public class VRegistrarTrabajador extends CustomJPanel {
    private JPasswordField passwordField;

    public VRegistrarTrabajador() {
        super("images/img_fondoRegistro.jpeg");
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.setOpaque(false);
        add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel = new JLabel("Cree un nuevo Trabajador");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setOpaque(false);
        add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(9, 5, 0, 20));

        JLabel lblNewLabel1 = new JLabel("CREDENCIALES");
        panel_1.add(lblNewLabel1);

        JLabel lblNewLabel2 = new JLabel("");
        panel_1.add(lblNewLabel2);

        JLabel lblNewLabel3 = new JLabel("");
        panel_1.add(lblNewLabel3);

        JLabel lblNewLabel4 = new JLabel("");
        panel_1.add(lblNewLabel4);

        JLabel lblNewLabel5 = new JLabel("");
        panel_1.add(lblNewLabel5);

        JLabel lblNewLabel_usuario = new JLabel("Usuario");
        panel_1.add(lblNewLabel_usuario);

        CustomText Usuario_1 = new CustomText("", "Campo vacío");
        Usuario_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        Usuario_1.setHorizontalAlignment(SwingConstants.CENTER);
        Usuario_1.setColumns(10);
        Usuario_1.setOpaque(false);
        panel_1.add(Usuario_1);

        JLabel lblNewLabel_7_3_3 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_3);

        JLabel lblNewLabel_contraseña = new JLabel("Contraseña");
        panel_1.add(lblNewLabel_contraseña);

        passwordField = new JPasswordField();
        passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setOpaque(false);
        // passwordField.setBounds(463, 261, 253, 30);
        panel_1.add(passwordField);

        JLabel lblNewLabel6 = new JLabel("DATOS DEL USUARIO:");
        panel_1.add(lblNewLabel6);

        JLabel lblNewLabel7 = new JLabel("");
        panel_1.add(lblNewLabel7);

        JLabel lblNewLabel8 = new JLabel("");
        panel_1.add(lblNewLabel8);

        JLabel lblNewLabel9 = new JLabel("");
        panel_1.add(lblNewLabel9);

        JLabel lblNewLabel10 = new JLabel("");
        panel_1.add(lblNewLabel10);

        JLabel lblNewLabel1Nombre = new JLabel("1°er Nombre:");
        panel_1.add(lblNewLabel1Nombre);

        CustomText Nombre_1 = new CustomText("", "Campo vacío");
        Nombre_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        Nombre_1.setHorizontalAlignment(SwingConstants.CENTER);
        Nombre_1.setColumns(10);
        Nombre_1.setOpaque(false);
        panel_1.add(Nombre_1);

        JLabel lblNewLabel11 = new JLabel("");
        panel_1.add(lblNewLabel11);

        JLabel lblNewLabel2Nombre = new JLabel("2°do Nombre:");
        panel_1.add(lblNewLabel2Nombre);

        CustomText Nombre_2 = new CustomText("", "Campo vacío");
        Nombre_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        Nombre_2.setHorizontalAlignment(SwingConstants.CENTER);
        Nombre_2.setColumns(10);
        Nombre_2.setOpaque(false);
        panel_1.add(Nombre_2);

        JLabel lblNewLabel1Apellido = new JLabel("1°er Apellido:");
        panel_1.add(lblNewLabel1Apellido);

        CustomText Apellido_1 = new CustomText("", "Campo vacío");
        Apellido_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        Apellido_1.setHorizontalAlignment(SwingConstants.CENTER);
        Apellido_1.setColumns(10);
        Apellido_1.setOpaque(false);
        panel_1.add(Apellido_1);

        JLabel lblNewLabel12 = new JLabel("");
        panel_1.add(lblNewLabel12);

        JLabel lblNewLabel2Apellido = new JLabel("2°do Apellido:");
        panel_1.add(lblNewLabel2Apellido);

        CustomText Apellido_2 = new CustomText("", "Campo vacío");
        Apellido_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        Apellido_2.setHorizontalAlignment(SwingConstants.CENTER);
        Apellido_2.setColumns(10);
        Apellido_2.setOpaque(false);
        panel_1.add(Apellido_2);

        JLabel lblNewLabelcedula = new JLabel("Cedula:");
        panel_1.add(lblNewLabelcedula);

        CustomText Cedula = new CustomText("", "Campo vacío");
        Cedula.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        Cedula.setHorizontalAlignment(SwingConstants.CENTER);
        Cedula.setColumns(10);
        Cedula.setOpaque(false);
        panel_1.add(Cedula);

        JLabel lblNewLabel13 = new JLabel("");
        panel_1.add(lblNewLabel13);

        JLabel lblNewLabel14 = new JLabel("");
        panel_1.add(lblNewLabel14);

        JLabel lblNewLabel15 = new JLabel("");
        panel_1.add(lblNewLabel15);

        JLabel lblNewLabeltelefono = new JLabel("Telefono:");
        panel_1.add(lblNewLabeltelefono);

        CustomText Telefono = new CustomText("", "Campo vacío");
        Telefono.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        Telefono.setHorizontalAlignment(SwingConstants.CENTER);
        Telefono.setColumns(10);
        Telefono.setOpaque(false);
        panel_1.add(Telefono);

        JLabel lblNewLabel16 = new JLabel("");
        panel_1.add(lblNewLabel16);

        JLabel lblNewLabel17 = new JLabel("");
        panel_1.add(lblNewLabel17);

        JLabel lblNewLabel18 = new JLabel("");
        panel_1.add(lblNewLabel18);

        JLabel lblNewLabelemail = new JLabel("Email:");
        panel_1.add(lblNewLabelemail);

        CustomText Email = new CustomText("", "Campo vacío");
        Email.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        Email.setHorizontalAlignment(SwingConstants.CENTER);
        Email.setColumns(10);
        Email.setOpaque(false);
        panel_1.add(Email);

        JLabel lblNewLabel19 = new JLabel("");
        panel_1.add(lblNewLabel19);

        CustomButton btnAgregar = new CustomButton("Agregar", "images/iconos/ico_guardar.png");
        btnAgregar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Usuario user = new Usuario(
                        Usuario_1.getText().trim(),
                        new String(passwordField.getPassword()),
                        Email.getText().trim(),
                        Nombre_1.getText().trim(),
                        Nombre_2.getText().trim(),
                        Apellido_1.getText().trim(),
                        Apellido_2.getText().trim(),
                        Cedula.getText().trim(),
                        Telefono.getText().trim());
                try {
                    UsuarioDAC u = new UsuarioDAC();
                    if (u.setUser(
                            user.getUsuario(),
                            user.getContrasena(),
                            user.getEmail(),
                            user.getPrimerNombre(),
                            user.getSegundoNombre(),
                            user.getApellidoPaterno(),
                            user.getApellidoMaterno(),
                            user.getCedula(),
                            user.getTelefono())) {

                    }
                    JOptionPane.showMessageDialog(null, "Usuario Registrado");

                } catch (Exception ex) {
                }
            }
        });
        panel_1.add(btnAgregar);

        CustomButton btnLimpiar = new CustomButton("Limpiar", "images/iconos/limpiar.png");
        btnLimpiar.setHorizontalAlignment(SwingConstants.CENTER);
        btnLimpiar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Usuario_1.setText("");
                passwordField.setText("");
                Nombre_1.setText("");
                Nombre_2.setText("");
                Apellido_1.setText("");
                Apellido_2.setText("");
                Cedula.setText("");
                Telefono.setText("");
                Email.setText("");
            }
        });
        panel_1.add(btnLimpiar);

        JLabel lblNewLabel21 = new JLabel("");
        panel_1.add(lblNewLabel21);

        JLabel lblNewLabel22 = new JLabel("");
        panel_1.add(lblNewLabel22);

        JLabel lblNewLabel23 = new JLabel("");
        panel_1.add(lblNewLabel23);

        JLabel lblNewLabel24 = new JLabel("");
        panel_1.add(lblNewLabel24);

        JLabel lblNewLabel25 = new JLabel("");
        panel_1.add(lblNewLabel25);

        JPanel panel_2 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
        flowLayout.setHgap(30);
        panel_2.setOpaque(false);

        add(panel_2, BorderLayout.EAST);

        CustomLabel lblNewLabel26 = new CustomLabel("", "images/img_agregar_usuario.png");
        panel_2.add(lblNewLabel26);

        JPanel panel_3 = new JPanel();
        panel_3.setOpaque(false);
        add(panel_3, BorderLayout.WEST);
        panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

        CustomLabel lblNewLabel27 = new CustomLabel("", "images/img_Logo_con_bordes.png");
        panel_3.add(lblNewLabel27);

        Validadores.deshabilitarCVX(Usuario_1);
        Validadores.deshabilitarCVX(passwordField);
        Validadores.deshabilitarCVX(Nombre_1);
        Validadores.deshabilitarCVX(Nombre_2);
        Validadores.deshabilitarCVX(Apellido_1);
        Validadores.deshabilitarCVX(Apellido_2);
        Validadores.deshabilitarCVX(Cedula);
        Validadores.deshabilitarCVX(Telefono);
        Validadores.deshabilitarCVX(Email);
    }
}
