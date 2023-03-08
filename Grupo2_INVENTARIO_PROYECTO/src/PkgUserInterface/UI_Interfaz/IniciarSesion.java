package PkgUserInterface.UI_Interfaz;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import PkgBusinnessLogic.UsuarioBL;
import PkgBusinnessLogic.Entities.Usuario;
import PkgFramework.APP;
import PkgUserInterface.UI_Component.CustomJPanel;

public class IniciarSesion extends JFrame {

    private CustomJPanel panelPrincipal = new CustomJPanel("images/img_fondoLoginLienzo.jpg");
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    JComboBox<String> cbxRol;

    public static void main(String[] args) throws Exception {
        IniciarSesion frame = new IniciarSesion();
        frame.setVisible(true);
    }

    public IniciarSesion() throws Exception {
        try {
            setIconImage(new ImageIcon(getClass().getResource("logoEmpresa.png")).getImage());
        } catch (Exception e) {
            System.out.println(e);
        }
        setTitle("INICIAR SESION");
        setBounds(0, 0, 752, 434);
        panelPrincipal.setFont(new Font("Lato", Font.PLAIN, 12));
        panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
        setResizable(false);
        setLocationRelativeTo(null);
        setContentPane(panelPrincipal);
        panelPrincipal.setLayout(null);
        // setVisible(true); // NO PUEDE estar en el constructor
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lbNameBusiness = new JLabel("EASY SELL");
        lbNameBusiness.setFont(new Font("DejaVu Sans Mono", Font.BOLD | Font.ITALIC, 40));
        lbNameBusiness.setHorizontalAlignment(SwingConstants.CENTER);
        lbNameBusiness.setBounds(12, 0, 740, 42);
        panelPrincipal.add(lbNameBusiness);

        JLabel lbEslogan = new JLabel("Te ayudamos en todo");
        lbEslogan.setForeground(new Color(255, 255, 255));
        lbEslogan.setHorizontalAlignment(SwingConstants.CENTER);
        lbEslogan.setHorizontalTextPosition(SwingConstants.CENTER);
        lbEslogan.setFont(new Font("Amaranth", Font.PLAIN, 25));
        lbEslogan.setBounds(0, 25, 740, 51);
        panelPrincipal.add(lbEslogan);

        JLabel lbLeyenda = new JLabel("Registre sus datos");
        lbLeyenda.setHorizontalAlignment(SwingConstants.CENTER);
        lbLeyenda.setFont(new Font("Lato", Font.BOLD, 18));
        lbLeyenda.setBounds(462, 90, 255, 17);
        panelPrincipal.add(lbLeyenda);

        JLabel lbUsuarioIcon = new JLabel();
        lbUsuarioIcon.setBounds(415, 141, 30, 30);
        ImageIcon imgUsuario = new ImageIcon("images/iconos/user.png");
        Icon iconUsuario = new ImageIcon(
                imgUsuario.getImage().getScaledInstance(lbUsuarioIcon.getWidth(), lbUsuarioIcon.getHeight(),
                        Image.SCALE_SMOOTH));
        lbUsuarioIcon.setIcon(iconUsuario);
        panelPrincipal.add(lbUsuarioIcon);

        JLabel lbContrasenaIcon = new JLabel();
        lbContrasenaIcon.setBounds(415, 261, 30, 30);
        ImageIcon imgContrasena = new ImageIcon("images/iconos/password.png");
        Icon iconContrasena = new ImageIcon(
                imgContrasena.getImage().getScaledInstance(lbContrasenaIcon.getWidth(),
                        lbContrasenaIcon.getHeight(),
                        Image.SCALE_SMOOTH));
        lbContrasenaIcon.setIcon(iconContrasena);
        panelPrincipal.add(lbContrasenaIcon);

        txtUsuario = new JTextField();
        txtUsuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        txtUsuario.setFont(new Font("Dialog", Font.PLAIN, 13));
        txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        txtUsuario.setOpaque(false);
        txtUsuario.setBounds(462, 141, 255, 30);
        panelPrincipal.add(txtUsuario);
        txtUsuario.setColumns(10);

        txtContrasena = new JPasswordField();
        txtContrasena.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        txtContrasena.setHorizontalAlignment(SwingConstants.CENTER);
        txtContrasena.setOpaque(false);
        txtContrasena.setBounds(463, 261, 253, 30);
        panelPrincipal.add(txtContrasena);

        String[] roles = { "Administrador", "Trabajador" };
        cbxRol = new JComboBox<>(roles);

        cbxRol.setForeground(Color.DARK_GRAY);
        cbxRol.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cbxRol.setBackground(new Color(255, 140, 0));
        cbxRol.setBounds(478, 206, 223, 24);
        panelPrincipal.add(cbxRol);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    iniciarSesion();
                } catch (Exception e1) {
                }
            }
        });
        btnIngresar.setBackground(new Color(255, 140, 0));
        btnIngresar.setBorderPainted(false);
        btnIngresar.setBorder(new LineBorder(new Color(73, 168, 53), 10, true));
        btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setLocationRelativeTo(null);
        btnIngresar.setBounds(531, 329, 117, 25);
        panelPrincipal.add(btnIngresar);

        JLabel lbImgLogo = new JLabel();
        lbImgLogo.setBounds(0, 142, 385, 264);
        ImageIcon imgLogo = new ImageIcon("images/img_fondoLogin.png");
        Icon iconLogo = new ImageIcon(
                imgLogo.getImage().getScaledInstance(lbImgLogo.getWidth(), lbImgLogo.getHeight(),
                        Image.SCALE_SMOOTH));
        lbImgLogo.setIcon(iconLogo);
        panelPrincipal.add(lbImgLogo);

    }

    /**
     * Permite gestionar si las credenciales de usuario son correctas para decidir
     * el inicio de sesión
     * 
     * @throws Exception : indica las excepciones que se pueden lanzar durante la
     *                   ejecución
     */
    public void iniciarSesion() throws Exception {

        // try {
        // UsuarioBL user = new UsuarioBL();
        // for (Usuario u : user.getAllUser()) {
        // System.out.println("Usuario: " + u.getUsuario());
        // System.out.println("Contraseña: " + u.getContrasena());
        // System.out.println("Contraseña: " + u.getFkIdRol());
        // }
        // } catch (Exception e) {
        // }

        UsuarioBL user = new UsuarioBL();
        Usuario u = user.getUserLogin(txtUsuario.getText().trim(),
                txtContrasena.getPassword(), cbxRol.getSelectedIndex() + 1);

        if (u != null) {
            if (u.getFkIdRol() == APP.LOGIN.ADMINISTRADOR) {

                PrincipalA iAdmin = new PrincipalA();
                iAdmin.setVisible(true);
                this.setVisible(false);
            } else if (u.getFkIdRol() == APP.LOGIN.TRABAJADOR) {
                PrincipalT iWorker = new PrincipalT();
                iWorker.setVisible(true);
                this.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario " +
                    txtUsuario.getText().toUpperCase()
                    + " no se encuentra en la base de datos.\nRevise sus datos e intente nuevamente");

        }
    }
}
