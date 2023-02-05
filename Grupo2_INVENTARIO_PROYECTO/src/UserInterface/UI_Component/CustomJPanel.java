package UserInterface.UI_Component;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CustomJPanel extends JPanel {
    private BufferedImage image;

    public CustomJPanel(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    // public static void main(String[] args) {
    // JFrame frame = new JFrame("Resizable Background Image");
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Container content = frame.getContentPane();
    // content.setLayout(new GridBagLayout());

    // GridBagConstraints constraints = new GridBagConstraints();
    // constraints.fill = GridBagConstraints.BOTH;
    // constraints.weightx = 1.0;
    // constraints.weighty = 1.0;

    // Lienzo panel = new Lienzo(
    // "images/img_bienvenidosApp.jpg");
    // content.add(panel, constraints);
    // frame.pack();
    // frame.setVisible(true);
    // frame.setMinimumSize(new Dimension(960, 540));
    // }
}
