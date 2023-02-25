package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Vuelo extends JFrame {
    public Vuelo() {
        getContentPane().setBackground(new Color(255, 255, 255));
        setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("VUELOS");
        setVisible(true);
        setAlwaysOnTop(true);
        // setResizable(false);
        // setMaximizedBounds(new Rectangle(0, 0, 280, 400));
        setMinimumSize(new Dimension(800, 600));
        // setSize(275, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panelGRUPO2 = new JPanel();
        panelGRUPO2.setOpaque(false);
        panelGRUPO2.setBorder(new EmptyBorder(5, 0, 10, 0));
        getContentPane().add(panelGRUPO2, BorderLayout.NORTH);
        panelGRUPO2.setLayout(new GridLayout(2, 0, 0, 8));

        JPanel panelFiltros = new JPanel();
        panelFiltros.setBorder(null);
        panelFiltros.setOpaque(false);
        panelGRUPO2.add(panelFiltros);

        JLabel lblNewLabel_1 = new JLabel("AQUI VA LA BARRA DE FILTROS");
        panelFiltros.add(lblNewLabel_1);

        JPanel panelBusqueda = new JPanel();
        panelBusqueda.setBorder(null);
        panelBusqueda.setOpaque(false);
        panelGRUPO2.add(panelBusqueda);

        JLabel lblNewLabel_2 = new JLabel("AQUI VA LA BUSQUEDA");
        panelBusqueda.add(lblNewLabel_2);

        JPanel panelGRUPO4 = new JPanel();
        panelGRUPO4.setOpaque(false);
        getContentPane().add(panelGRUPO4, BorderLayout.CENTER);

        JLabel lblNewLabel = new JLabel("PARTE DEL GRUPO 4");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelGRUPO4.add(lblNewLabel);

    }

    public static void main(String[] args) throws Exception {
        Vuelo m = new Vuelo();
        m.setVisible(true);
    }
}
