package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.mxrck.autocompleter.TextAutoCompleter;

import GUI.UI_Component.CustomText;
import GUI.UI_Component.CustomTextLabel;

public class Vuelo extends JFrame {
    private TextAutoCompleter autoCompletar;
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

        /*
         * Creación del panel principal superior (Grupo 2), panel de filtros y panel de busqueda
         */
        
        JPanel panelGrupo2 = new JPanel();
        panelGrupo2.setBackground(Color.LIGHT_GRAY);
        panelGrupo2.setBorder(new EmptyBorder(5, 0, 10, 0));
        getContentPane().add(panelGrupo2, BorderLayout.NORTH);
        panelGrupo2.setLayout(new GridLayout(2, 0, 0, 8));

        JPanel panelFiltros = new JPanel();
        panelFiltros.setBorder(null);
        panelFiltros.setOpaque(false);
        panelGrupo2.add(panelFiltros);
        panelFiltros.setLayout(new BorderLayout(0, 0));
        
        JPanel panelBusqueda = new JPanel();
        panelBusqueda.setBorder(null);
        panelBusqueda.setOpaque(false);
        panelGrupo2.add(panelBusqueda);
        panelBusqueda.setLayout(new BorderLayout(0, 0));
        
        JPanel panelContenedorFiltro = new JPanel();
        panelContenedorFiltro.setOpaque(false);
        panelFiltros.add(panelContenedorFiltro, BorderLayout.CENTER);
        panelContenedorFiltro.setLayout(new GridLayout(0, 4, 10, 0));
        
        JPanel panelContenedorBusquedaIda = new JPanel();
        panelContenedorBusquedaIda.setOpaque(false);
        panelContenedorBusquedaIda.setLayout(new GridLayout(1, 4, 10, 0));
        panelBusqueda.add(panelContenedorBusquedaIda, BorderLayout.CENTER);
        
        JPanel panelContenedorBusquedaIdaVuelta = new JPanel();
        panelContenedorBusquedaIdaVuelta.setOpaque(false);
        panelContenedorBusquedaIdaVuelta.setLayout(new GridLayout(1, 4, 10, 0));
        //panelBusqueda.add(panelContenedorBusquedaIdaVuelta, BorderLayout.CENTER);

        /*
         * Para el panel filtro
         */
        
        JComboBox cbxConfirmarRetorno = new JComboBox();
        cbxConfirmarRetorno.setFont(new Font("TI-Nspire", Font.PLAIN, 12));
        cbxConfirmarRetorno.setOpaque(false);
        cbxConfirmarRetorno.addItem("Solo ida");
        cbxConfirmarRetorno.addItem("Ida y Vuelta");
        panelContenedorFiltro.add(cbxConfirmarRetorno);
        
        JComboBox elegirPlan = new JComboBox();
        elegirPlan.setFont(new Font("TI-Nspire", Font.PLAIN, 12));
        elegirPlan.setOpaque(false);
        elegirPlan.addItem("Economy");
        elegirPlan.addItem("Premium Economy");
        elegirPlan.addItem("Premium Business");
        panelContenedorFiltro.add(elegirPlan);
        
        JComboBox cantidadPasajeros = new JComboBox();
        cantidadPasajeros.setFont(new Font("TI-Nspire", Font.PLAIN, 12));
        cantidadPasajeros.setOpaque(false);
        cantidadPasajeros.addItem("1");
        panelContenedorFiltro.add(cantidadPasajeros);
        
        JCheckBox ckbxUsarMillas = new JCheckBox("Usar Millas LATAM Pass");
        ckbxUsarMillas.setFont(new Font("TI-Nspire", Font.BOLD, 12));
        ckbxUsarMillas.setOpaque(false);
        panelContenedorFiltro.add(ckbxUsarMillas);

        JLabel lblAyudante1 = new JLabel("     ");
        panelFiltros.add(lblAyudante1, BorderLayout.WEST);
        
        JLabel lblAyudante2 = new JLabel("     ");
        panelFiltros.add(lblAyudante2, BorderLayout.EAST);

        /*
         * Para el panel busqueda de solo Ida o Ida y Vuelta
         */
        
        CustomText txtOrigen = new CustomText("Ingresa origen", "Ingresa origen");
        txtOrigen.setColumns(20);
        autoCompletar = new TextAutoCompleter(txtOrigen);
        autoCompletar.addItem("Guayaquil");
        autoCompletar.addItem("Guayas");
        autoCompletar.addItem("Guarani");
        autoCompletar.addItem("Machala");
        autoCompletar.addItem("Manta");
        panelContenedorBusquedaIda.add(txtOrigen);
        
        CustomText txtDestino = new CustomText("Ingresa destino", "Ingresa destino");
        txtDestino.setColumns(20);
        panelContenedorBusquedaIda.add(txtDestino);
        
        CustomTextLabel txtFechaIda = new CustomTextLabel("Ida", 20);
        BorderLayout borderLayout = (BorderLayout) txtFechaIda.getLayout();
        borderLayout.setHgap(5);
        panelContenedorBusquedaIda.add(txtFechaIda);
        
        JButton btnBuscarIda = new JButton("Buscar");
        btnBuscarIda.setForeground(Color.WHITE);
        btnBuscarIda.setBackground(Color.RED);
        btnBuscarIda.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 12));
        btnBuscarIda.setHorizontalAlignment(SwingConstants.CENTER);
        btnBuscarIda.setBorder(new LineBorder(Color.RED));
        panelContenedorBusquedaIda.add(btnBuscarIda);
        
        CustomText txtOrigenIdaVuelta = new CustomText("Ingresa origen", "Ingresa origen");
        txtOrigenIdaVuelta.setColumns(20);
        panelContenedorBusquedaIdaVuelta.add(txtOrigenIdaVuelta);
        
        CustomText txtDestinoIdaVuelta = new CustomText("Ingresa destino", "Ingresa destino");
        txtDestinoIdaVuelta.setColumns(20);
        panelContenedorBusquedaIdaVuelta.add(txtDestinoIdaVuelta);
        
        CustomTextLabel txtFechaIdaV = new CustomTextLabel("Ida", 20);
        BorderLayout borderLayout2 = (BorderLayout) txtFechaIdaV.getLayout();
        borderLayout2.setHgap(5);
        panelContenedorBusquedaIdaVuelta.add(txtFechaIdaV);
        
        CustomTextLabel txtFechaVuelta = new CustomTextLabel("Vuelta", 20);
        BorderLayout borderLayout3 = (BorderLayout) txtFechaVuelta.getLayout();
        borderLayout3.setHgap(5);
        panelContenedorBusquedaIdaVuelta.add(txtFechaVuelta);

        JButton btnBuscarIdaVuelta = new JButton("Buscar");
        btnBuscarIdaVuelta.setForeground(Color.WHITE);
        btnBuscarIdaVuelta.setBackground(Color.RED);
        btnBuscarIdaVuelta.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 12));
        btnBuscarIdaVuelta.setHorizontalAlignment(SwingConstants.CENTER);
        btnBuscarIdaVuelta.setBorder(new LineBorder(Color.RED));
        panelContenedorBusquedaIdaVuelta.add(btnBuscarIdaVuelta);
        
        JLabel lblAyudante3 = new JLabel("     ");
        panelBusqueda.add(lblAyudante3, BorderLayout.WEST);
    
        JLabel lblAyudante4 = new JLabel("     ");
        panelBusqueda.add(lblAyudante4, BorderLayout.EAST);

        cbxConfirmarRetorno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cbxConfirmarRetorno = (JComboBox) e.getSource();
        
                // Obtener el elemento seleccionado del JComboBox
                String seleccion = (String) cbxConfirmarRetorno.getSelectedItem();
        
                // Cambiar el panel de abajo según el elemento seleccionado
                if (seleccion.equals("Solo ida")) {
                    // Mostrar panel1 con los JText correspondientes
                    panelContenedorBusquedaIda.setVisible(true);
                    panelContenedorBusquedaIdaVuelta.setVisible(false);
                } else if (seleccion.equals("Ida y Vuelta")) {
                    // Mostrar panel2 con los JText correspondientes
                    panelBusqueda.add(panelContenedorBusquedaIdaVuelta, BorderLayout.CENTER);
                    panelContenedorBusquedaIda.setVisible(false);
                    panelContenedorBusquedaIdaVuelta.setVisible(true);
                }
            }
        });

        /*
         * Panel del grupo 4
         */
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
