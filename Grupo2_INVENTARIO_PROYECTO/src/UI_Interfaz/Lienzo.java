// package UI_Interfaz;

// import java.awt.*;
// import javax.swing.*;

// public class Lienzo {
// private String[] keys = { "One", "Twoooooo", "Three", "Four",
// "Five", "Six", "Seven", "Eight",
// "Nine", "Ten", "Eleven", "Twelve" };
// private String[] values = { "Apple", "Boy", "Cat", "Denmark",
// "Elephant", "Foo", "Hello", "Igloo",
// "Jug", "Kangaroo", "Lip", "Now" };

// public static void main(String[] args) {
// Lienzo n = new Lienzo();

// }

// public Lienzo() {
// GridBagConstraints gbc;
// JTextField textField = null;
// int maxWidth = 0;
// JLabel[] labels = new JLabel[keys.length];

// for (int i = 0; i < keys.length; i++) {
// labels[i] = new JLabel(keys[i]);
// maxWidth = Math.max(labels[i].getPreferredSize().width, maxWidth);
// }

// JPanel[] panels = new JPanel[keys.length];
// for (int i = 0; i < keys.length; i++) {
// panels[i] = new JPanel(new FlowLayout());

// gbc = new GridBagConstraints();
// gbc.gridx = 0;
// gbc.gridy = 0;
// gbc.anchor = GridBagConstraints.EAST;
// gbc.insets = new Insets(1, 1, 1, 1);
// panels[i].add(Box.createHorizontalStrut(maxWidth), gbc);

// gbc.gridy = 1;
// panels[i].add(labels[i], gbc);

// textField = new JTextField(10);
// textField.setText(values[i]);
// gbc.gridx = 1;
// panels[i].add(textField, gbc);

// panel.add(panels[i]);
// }
// JFrame frame = new JFrame("Test");
// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// JPanel panel = new JPanel(new FlowLayout());
// panel.setOpaque(false);
// frame.getContentPane().add(panel);
// frame.setSize(640, 480);
// frame.setLocationRelativeTo(null);
// frame.setVisible(true);
// frame.setBackground(Color.MAGENTA);
// }

// }