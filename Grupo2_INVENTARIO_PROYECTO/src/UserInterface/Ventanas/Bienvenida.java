package UserInterface.Ventanas;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class Bienvenida extends JPanel {
    private BufferedImage image;

    public Bienvenida(String imagePath) {
        setLayout(new BorderLayout(0, 0));

        JLabel lblBienvenido = new JLabel("BIENVENIDO");
        lblBienvenido.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 37), null));
        lblBienvenido.setFont(new Font("Dialog", Font.BOLD, 23));
        add(lblBienvenido, BorderLayout.EAST);
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public Bienvenida() {
        setLayout(new BorderLayout(0, 0));

        JLabel lblBienvenido = new JLabel("BIENVENIDO");
        lblBienvenido.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 37), null));
        lblBienvenido.setFont(new Font("Dialog", Font.BOLD, 23));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

}
