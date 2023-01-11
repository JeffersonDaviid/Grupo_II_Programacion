package UI_Interfaz;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.Icon;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet.ColorAttribute;

public class IAdministrador extends JFrame {
    private JPanel contenido;
    // JButton btnRegistrarProducto;
    // JButton btnRegistrarTrabajador;
    // JButton btnEliminarTrabajador;
    // JButton btnInventario;
    // JButton btnActualizarInventario;
    public static void main(String[] args) {
        IAdministrador frame = new IAdministrador();
        frame.setVisible(true);
    }

    public IAdministrador(){
        setTitle("Servicio Administrador");
        setBounds(0, 0, 752, 434);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contenido = new JPanel();
        contenido.setAutoscrolls(true);
        contenido.setFont(new Font("FreeSerif", Font.PLAIN, 12));
        contenido.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contenido);
        contenido.setLayout(null);

        JButton btnRegistrarProducto = new JButton("Nuevo registro de producto");
        JButton btnRegistrarTrabajador = new JButton("Nuevo registro de trabajador");
        JButton btnEliminarTrabajador = new JButton("Eliminar registro de trabajador");
        JButton btnInventario = new JButton("Inventario de productos");
        JButton btnActualizarInventario = new JButton("Actualizar inventario");

        btnRegistrarProducto.setBackground(Color.orange);
        btnRegistrarProducto.setBorderPainted(false);
        btnRegistrarProducto.setBorder(new LineBorder(new Color(73, 168, 53), 10, true));
        btnRegistrarProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setLocationRelativeTo(null);
        btnRegistrarProducto.setBounds(30, 130, 200, 25);
        contenido.add(btnRegistrarProducto);

        btnRegistrarTrabajador.setBackground(Color.orange);
        btnRegistrarTrabajador.setBorderPainted(false);
        btnRegistrarTrabajador.setBorder(new LineBorder(new Color(73, 168, 53), 10, true));
        btnRegistrarTrabajador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setLocationRelativeTo(null);
        btnRegistrarTrabajador.setBounds(30, 180, 200, 25);
        contenido.add(btnRegistrarTrabajador);

        btnEliminarTrabajador.setBackground(Color.orange);
        btnEliminarTrabajador.setBorderPainted(false);
        btnEliminarTrabajador.setBorder(new LineBorder(new Color(73, 168, 53), 10, true));
        btnEliminarTrabajador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setLocationRelativeTo(null);
        btnEliminarTrabajador.setBounds(30, 230, 200, 25);
        contenido.add(btnEliminarTrabajador);

        btnInventario.setBackground(Color.orange);
        btnInventario.setBorderPainted(false);
        btnInventario.setBorder(new LineBorder(new Color(73, 168, 53), 10, true));
        btnInventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setLocationRelativeTo(null);
        btnInventario.setBounds(30, 280, 200, 25);
        contenido.add(btnInventario);

        btnActualizarInventario.setBackground(Color.orange);
        btnActualizarInventario.setBorderPainted(false);
        btnActualizarInventario.setBorder(new LineBorder(new Color(73, 168, 53), 10, true));
        btnActualizarInventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setLocationRelativeTo(null);
        btnActualizarInventario.setBounds(30, 330, 200, 25);
        contenido.add(btnActualizarInventario);

        JLabel lbtitleBanner = new JLabel("SERVICIO ADMINISTRATIVO");
        lbtitleBanner.setHorizontalAlignment(SwingConstants.CENTER);
        lbtitleBanner.setForeground(Color.WHITE);
        lbtitleBanner.setFont(new Font("Dialog", Font.BOLD, 13));
        lbtitleBanner.setBounds(490, 35, 255, 17);
        contenido.add(lbtitleBanner);


        JLabel lbLogo = new JLabel();
        lbLogo.setBounds(105, 30, 60, 60);
        ImageIcon imgLogo = new ImageIcon("Grupo2_INVENTARIO_PROYECTO/images/iconos/admin.png");
        Icon imgLogoIco = new ImageIcon(
                imgLogo.getImage().getScaledInstance(lbLogo.getWidth(), lbLogo.getHeight(),
                        Image.SCALE_SMOOTH));
        lbLogo.setIcon(imgLogoIco);
        contenido.add(lbLogo);

        JLabel lbBackground = new JLabel();
        lbBackground.setBounds(0, -25, 752, 100);
        ImageIcon imageBackground = new ImageIcon("Grupo2_INVENTARIO_PROYECTO/images/img_bannerAdmin.jpg");
        Icon iconBackground = new ImageIcon(
                imageBackground.getImage().getScaledInstance(lbBackground.getWidth(), lbBackground.getHeight(),
                        Image.SCALE_SMOOTH));
        lbBackground.setIcon(iconBackground);
        contenido.add(lbBackground);

        JLabel lbBannerLateral = new JLabel();
        lbBannerLateral.setBounds(0,-25, 260, 434);
        ImageIcon imageLateral = new ImageIcon("Grupo2_INVENTARIO_PROYECTO/images/img_fondoLateral.jpg");
        Icon iconLateral = new ImageIcon(
                imageLateral.getImage().getScaledInstance(lbBannerLateral.getWidth(), lbBannerLateral.getHeight(),
                        Image.SCALE_SMOOTH));
        lbBannerLateral.setIcon(iconLateral);
        contenido.add(lbBannerLateral);
    
    }
}
