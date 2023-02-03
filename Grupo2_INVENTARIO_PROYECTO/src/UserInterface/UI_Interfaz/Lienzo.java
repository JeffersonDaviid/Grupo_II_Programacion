package UserInterface.UI_Interfaz;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lienzo extends JPanel {

    Lienzo() {
        setSize(1200, 100);
        setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon imagenBackground = new ImageIcon(getClass().getResource("images/img_fondoLoginLienzo.jpg"));

        g.drawImage(imagenBackground.getImage(), 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }

    // public static void main(String[] args) {
    // JFrame ventana = new JFrame("HOLA");
    // Lienzo fondo = new Lienzo();
    // ventana.setContentPane(fondo);
    // ventana.setVisible(true);
    // ventana.setLocationRelativeTo(null);
    // ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // ventana.setSize(600, 600);
    // }

}