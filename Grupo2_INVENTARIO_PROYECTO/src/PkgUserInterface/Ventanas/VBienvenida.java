package PkgUserInterface.Ventanas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class VBienvenida extends JPanel {
    private BufferedImage image;

    public VBienvenida(String imagePath) {
        setLayout(new BorderLayout(0, 0));

        JLabel lblBienvenido = new JLabel("BIENVENID@");
        lblBienvenido.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 37), null));
        lblBienvenido.setFont(new Font("Dialog", Font.BOLD, 23));
        add(lblBienvenido, BorderLayout.EAST);
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public VBienvenida() {
        setLayout(new BorderLayout(0, 0));

        JLabel lblBienvenido = new JLabel("BIENVENID@");
        lblBienvenido.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 37), null));
        lblBienvenido.setFont(new Font("Dialog", Font.BOLD, 23));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

}
