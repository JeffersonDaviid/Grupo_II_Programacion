package UserInterface.Ventanas;

import javax.swing.JPanel;

import UserInterface.UI_Component.CustomJPanel;
import UserInterface.UI_Component.CustomLabel;
import UserInterface.UI_Component.CustomText;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

import BusinnessLogic.Entities.Usuario;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class RegistrarTrabajador extends CustomJPanel {
    private JTextField textField;
    private JPasswordField passwordField;

    public RegistrarTrabajador() {
        super("images/fondoRegistro.jpeg");
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(0, 3, 25, 25));

        JLabel lblNewLabel_1 = new JLabel("imagen uuario");
        lblNewLabel_1.setOpaque(false);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("Cree un nuevo us");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("logo empresa");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel_2);

        JPanel panel_1 = new JPanel();
        panel_1.setOpaque(false);
        add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(0, 11, 15, 0));

        CustomLabel lblNewLabel_7_3_6 = new CustomLabel("", "images/fondoRegistro.jpeg");
        panel_1.add(lblNewLabel_7_3_6);

        JLabel lblNewLabel_7_3 = new JLabel("");
        panel_1.add(lblNewLabel_7_3);

        JLabel lblNewLabel_7_3_1_13 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_13);

        JLabel lblNewLabel_6 = new JLabel("CREDENCIAL}");
        panel_1.add(lblNewLabel_6);

        JLabel lblNewLabel_7_3_1_5 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_5);

        JLabel lblNewLabel_7_3_1 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1);

        JLabel lblNewLabel_7_3_3 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_3);

        JLabel lblNewLabel_7_3_1_3 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_3);

        JLabel lblNewLabel_7_3_5 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_5);

        JLabel lblNewLabel_7_3_4 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_4);

        JLabel lblNewLabel_7_3_1_12 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_12);

        JLabel lblNewLabel_3 = new JLabel("DATO DE USUARIO");
        panel_1.add(lblNewLabel_3);

        JLabel lblNewLabel_4_1 = new JLabel("APELLIDO");
        panel_1.add(lblNewLabel_4_1);

        JLabel lblNewLabel_4 = new JLabel("NOMBRE");
        panel_1.add(lblNewLabel_4);

        CustomText textField_1 = new CustomText();
        panel_1.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_7_3_2 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_2);

        JLabel lblNewLabel_4_1_1 = new JLabel("TELEFONO");
        panel_1.add(lblNewLabel_4_1_1);

        passwordField = new JPasswordField();
        panel_1.add(passwordField);

        CustomText textField_1_1 = new CustomText();
        textField_1_1.setColumns(10);
        panel_1.add(textField_1_1);

        JButton btnNewButton = new JButton("New button");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Usuario user = new Usuario(textField_1_1.getText(), new String(passwordField.getPassword()),
                        TOOL_TIP_TEXT_KEY,
                        TOOL_TIP_TEXT_KEY,
                        TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY);

            }
        });
        panel_1.add(btnNewButton);

        JLabel lblNewLabel_7_3_1_8 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_8);

        JLabel lblNewLabel_7_3_1_11 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11);

        JLabel lblNewLabel_7_3_1_10 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_10);

        JLabel lblNewLabel_7_3_1_11_21 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_21);

        JLabel lblNewLabel_7_3_1_11_20 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_20);

        JLabel lblNewLabel_5 = new JLabel("CEDULA");
        panel_1.add(lblNewLabel_5);

        JLabel lblNewLabel_7_3_1_11_19 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_19);

        JLabel lblNewLabel_7_3_1_11_18 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_18);

        JLabel lblNewLabel_7_3_1_11_17 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_17);

        JLabel lblNewLabel_7_3_1_11_16 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_16);

        JLabel lblNewLabel_7_3_1_11_15 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_15);

        JLabel lblNewLabel_7_3_1_11_14 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_14);

        JLabel lblNewLabel_7_3_1_11_13 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_13);

        JLabel lblNewLabel_7_3_1_11_12 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_12);

        JLabel lblNewLabel_7_3_1_11_11 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_11);

        JLabel lblNewLabel_7_3_1_11_10 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_10);

        JLabel lblNewLabel_7_3_1_11_9 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_9);

        JLabel lblNewLabel_7_3_1_11_8 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_8);

        JLabel lblNewLabel_7_3_1_11_7 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_7);

        JLabel lblNewLabel_7_3_1_11_6 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_6);

        JLabel lblNewLabel_7_3_1_11_5 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_5);

        JLabel lblNewLabel_7_3_1_11_4 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_4);

        JLabel lblNewLabel_7_3_1_11_3 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_3);

        JLabel lblNewLabel_7_3_1_11_2 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_2);

        JLabel lblNewLabel_7_3_1_11_1 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_11_1);

        JLabel lblNewLabel_7_3_1_9 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_9);

        JLabel lblNewLabel_7_3_1_7 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_7);

        JLabel lblNewLabel_7_3_1_6 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_6);

        JLabel lblNewLabel_7_3_1_4 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_4);

        JLabel lblNewLabel_7_3_1_2 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_2);

        JLabel lblNewLabel_7_3_1_1 = new JLabel("");
        panel_1.add(lblNewLabel_7_3_1_1);

        JPanel panel_2 = new JPanel();
        panel_2.setOpaque(false);
        add(panel_2, BorderLayout.EAST);

        JLabel lblNewLabel_7_3_1_1_1 = new JLabel("sdasdas");
        panel_2.add(lblNewLabel_7_3_1_1_1);

        JPanel panel_3 = new JPanel();
        panel_3.setOpaque(false);
        add(panel_3, BorderLayout.WEST);

        JLabel lblNewLabel_7_3_1_1_1_1 = new JLabel("sdasdas");
        panel_3.add(lblNewLabel_7_3_1_1_1_1);

    }
}
