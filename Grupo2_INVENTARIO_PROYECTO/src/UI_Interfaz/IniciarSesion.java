package UI_Interfaz;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class IniciarSesion extends JFrame {

    private JPanel panel_principal;
    private JTextField i_usuario;
    private JPasswordField i_contrasena;
    private JComboBox combo_rol;

    public static void main(String[] args) {
        // IniciarSesion frame = new IniciarSesion();
        // frame.setVisible(true);
    }

    public IniciarSesion() {
        try {
            setIconImage(new ImageIcon(getClass().getResource("logoEmpresa.png")).getImage());
        } catch (Exception e) {
            System.out.println(e);
        }

        setTitle("INICIAR SESION");
        setBounds(0, 0, 752, 434);
        panel_principal = new JPanel();
        panel_principal.setAutoscrolls(true);
        panel_principal.setFont(new Font("FreeSerif", Font.PLAIN, 12));
        panel_principal.setBorder(new EmptyBorder(5, 5, 5, 5));
        setResizable(false);
        setLocationRelativeTo(null);
        setContentPane(panel_principal);
        panel_principal.setLayout(null);
        // setVisible(true); // NO PUEDE estar en el constructor
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lbNameBusiness = new JLabel("EASY SELL");
        lbNameBusiness.setFont(new Font("DejaVu Sans Mono", Font.BOLD | Font.ITALIC, 35));
        lbNameBusiness.setHorizontalAlignment(SwingConstants.CENTER);
        lbNameBusiness.setBounds(12, 0, 740, 42);
        panel_principal.add(lbNameBusiness);

        JLabel lbEslogan = new JLabel("Te ayudamos en todo");
        lbEslogan.setForeground(new Color(255, 255, 255));
        lbEslogan.setHorizontalAlignment(SwingConstants.CENTER);
        lbEslogan.setHorizontalTextPosition(SwingConstants.CENTER);
        lbEslogan.setFont(new Font("Croissant One", Font.PLAIN, 20));
        lbEslogan.setBounds(0, 25, 740, 51);
        panel_principal.add(lbEslogan);

        JLabel lbLeyenda = new JLabel("Registre sus Datos");
        lbLeyenda.setHorizontalAlignment(SwingConstants.CENTER);
        lbLeyenda.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 13));
        lbLeyenda.setBounds(462, 90, 255, 17);
        panel_principal.add(lbLeyenda);

        JLabel lblUsuario_icon = new JLabel();
        lblUsuario_icon.setBounds(415, 141, 30, 30);
        ImageIcon imgUsuario = new ImageIcon("images/iconos/user.png");
        Icon iconUsuario = new ImageIcon(
                imgUsuario.getImage().getScaledInstance(lblUsuario_icon.getWidth(), lblUsuario_icon.getHeight(),
                        Image.SCALE_SMOOTH));
        lblUsuario_icon.setIcon(iconUsuario);
        panel_principal.add(lblUsuario_icon);

        JLabel lbContrasena_icon = new JLabel();
        lbContrasena_icon.setBounds(415, 261, 30, 30);
        ImageIcon img_contrasena = new ImageIcon("images/iconos/password.png");
        Icon icon_contrasena = new ImageIcon(
                img_contrasena.getImage().getScaledInstance(lbContrasena_icon.getWidth(),
                        lbContrasena_icon.getHeight(),
                        Image.SCALE_DEFAULT));
        lbContrasena_icon.setIcon(icon_contrasena);
        panel_principal.add(lbContrasena_icon);

        i_usuario = new JTextField();
        i_usuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        i_usuario.setFont(new Font("Dialog", Font.PLAIN, 13));
        i_usuario.setHorizontalAlignment(SwingConstants.CENTER);
        i_usuario.setOpaque(false);
        i_usuario.setBounds(462, 141, 255, 30);
        panel_principal.add(i_usuario);
        i_usuario.setColumns(10);

        i_contrasena = new JPasswordField();
        i_contrasena.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        i_contrasena.setHorizontalAlignment(SwingConstants.CENTER);
        i_contrasena.setOpaque(false);
        i_contrasena.setBounds(463, 261, 253, 30);
        panel_principal.add(i_contrasena);

        combo_rol = new JComboBox(new String[] { "Administrador", "Trabajador", "Otro" });
        combo_rol.setForeground(Color.DARK_GRAY);
        combo_rol.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        combo_rol.setBackground(new Color(255, 140, 0));
        combo_rol.setBounds(478, 206, 223, 24);
        panel_principal.add(combo_rol);

        JButton btn_ingresar = new JButton("Ingresar");
        btn_ingresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });
        btn_ingresar.setBackground(new Color(255, 140, 0));
        btn_ingresar.setBorderPainted(false);
        btn_ingresar.setBorder(new LineBorder(new Color(73, 168, 53), 10, true));
        btn_ingresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setLocationRelativeTo(null);
        btn_ingresar.setBounds(531, 329, 117, 25);
        panel_principal.add(btn_ingresar);

        JLabel lb_imgLogo = new JLabel();
        lb_imgLogo.setBounds(0, 142, 385, 264);
        ImageIcon img_logo = new ImageIcon("images/img_fondoLogin.png");
        Icon icon_logo = new ImageIcon(
                img_logo.getImage().getScaledInstance(lb_imgLogo.getWidth(), lb_imgLogo.getHeight(),
                        Image.SCALE_SMOOTH));
        lb_imgLogo.setIcon(icon_logo);
        panel_principal.add(lb_imgLogo);

        JLabel lbBackground = new JLabel();
        lbBackground.setBounds(0, -25, 827, 431);
        ImageIcon img_fondoPantalla = new ImageIcon("images/img_fondoLoginLienzo.jpg");
        Icon icon_fondoPantalla = new ImageIcon(
                img_fondoPantalla.getImage().getScaledInstance(lbBackground.getWidth(), lbBackground.getHeight(),
                        Image.SCALE_SMOOTH));
        lbBackground.setIcon(icon_fondoPantalla);
        panel_principal.add(lbBackground);
    }

    public void iniciarSesion() {
        try {
            // Consultar la base de datos
            // ("RUTA Y NOMBRE DE LA BASE DE DATOS","USUARIO","CONTRASEÑA")
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_inventario", "root", "");
            PreparedStatement consulta = conexion
                    .prepareStatement("select * from usuarios where Usuario = ?");
            consulta.setString(1, i_usuario.getText().trim());// otra opcion
            // permite conocer si encontro los datos
            ResultSet resultado = consulta.executeQuery();

            if (resultado.next()) {
                if (resultado.getString("Usuario").toUpperCase().equals(i_usuario.getText().trim().toUpperCase())
                        && resultado.getString("Contrasena").equals(new String(i_contrasena.getPassword()))
                        && resultado.getString("Rol").equals(combo_rol.getSelectedItem())) {
                    if (combo_rol.getSelectedItem().equals("Administrador")) {
                        LienzoInterfaz iAdmin = new LienzoInterfaz();
                        iAdmin.setVisible(true);
                        this.setVisible(false);
                    } else if (combo_rol.getSelectedItem().equals("Trabajador")) {
                        // IAdministrador iAdmin = new IAdministrador();
                        // iAdmin.setVisible(true);
                        // this.setVisible(false);
                    }
                } else
                    JOptionPane.showMessageDialog(null, "Revise sus datos e intente nuevamente");

            } else {
                JOptionPane.showMessageDialog(null, "El usuario " +
                        i_usuario.getText().toUpperCase()
                        + " no se encuentra en la base de datos");
            }

            // // Query
            // PreparedStatement inputDataBase = conexion
            // .prepareStatement("insert into usuarios values(?,?,?,?,?,?,?,?,?,?)");
            // // Llenando la base de datos
            // inputDataBase.setString(1, "thomas.germain17");
            // inputDataBase.setString(2, "271001");
            // inputDataBase.setString(3, "Trabajador");
            // inputDataBase.setString(4, "ACTIVO");
            // inputDataBase.setString(5, "Thomas");
            // inputDataBase.setString(6, "Daniel");
            // inputDataBase.setString(7, "Germain");
            // inputDataBase.setString(8, "Lennox");
            // inputDataBase.setString(9, "17xxxxxxxx");
            // inputDataBase.setString(10, "0000000000");
            // inputDataBase.executeUpdate(); // ENVIAR A LA BASE
            conexion.close();
        } catch (SQLException errorSesion) {
            JOptionPane.showMessageDialog(null, "No se puede conectar con la base de datos " + errorSesion);
        }
    }
}
