package UI_Interfaz;

import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.util.concurrent.Flow;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.FlowView;
import javax.swing.text.FlowView.FlowStrategy;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class Lienzo extends JFrame {

    public static void main(String[] args) {
        Lienzo frame = new Lienzo();
        frame.setVisible(true);
        // frame.setIconImage(new
        // ImageIcon(getClass().getResource("images/logoEmpresa.png")).getImage());

    }

    public Lienzo() {
        // setIconImage(new
        // ImageIcon(getClass().getResource("images/logoEmpresa.png")).getImage());

        setTitle("PROBANDO");
        setBounds(0, 0, 700, 720);
        setFont(new Font("FreeSerif", Font.PLAIN, 12));
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        // setLayout(new LayoutManager());
        setResizable(true);
        // setVisible(true); // NO PUEDE estar en el constructor
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lbBackground = new JLabel();
        lbBackground.setBounds(0, -25, this.getWidth(), this.getHeight());
        ImageIcon imageBackground = new ImageIcon("Grupo2_INVENTARIO_PROYECTO/images/img_fondoLoginLienzo.jpg");
        Icon iconBackgound = new ImageIcon(
                imageBackground.getImage().getScaledInstance(this.getWidth(), this.getHeight(),
                        Image.SCALE_DEFAULT));
        lbBackground.setIcon(iconBackgound);
        add(lbBackground);
    }
}
