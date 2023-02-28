package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

import BL.VueloBL;
import BL.Entities.Vuelo;
import FWK.AppException;
import GUI.UI_Component.CustomText;
import GUI.UI_Component.CustomTextLabel;

public class Grupo2 extends JFrame {

    private TextAutoCompleter autoCompletar;
    ArrayList<Vuelo> lsVuelo;
    ArrayList<Vuelo> lsVuelos;
    
    public Grupo2() {
        
        VueloBL vuelosG = new VueloBL();

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
        try {
            lsVuelo = vuelosG.GetAllVuelos();
            autoCompletar = new TextAutoCompleter(txtOrigen);
            Set<String> lugaresPartidaUnicos = new HashSet<String>(); //almacena la posicion de los lugares y que no se repitan
            for (Vuelo v : lsVuelo) {
                String lugarPartida = v.getLugarPartida();
                if (!lugaresPartidaUnicos.contains(lugarPartida)) {
                    autoCompletar.addItem(lugarPartida);
                    lugaresPartidaUnicos.add(lugarPartida);
                }
            }
        } catch (AppException e) {
            e.printStackTrace();
        }
        // autoCompletar.addItem("Guayaquil");
        // autoCompletar.addItem("Guayas");
        // autoCompletar.addItem("Guarani");
        // autoCompletar.addItem("Machala");
        // autoCompletar.addItem("Manta");
        panelContenedorBusquedaIda.add(txtOrigen);
        
        CustomText txtDestino = new CustomText("Ingresa destino", "Ingresa destino");
        txtDestino.setColumns(20);
        panelContenedorBusquedaIda.add(txtDestino);
        try {
            lsVuelo = vuelosG.GetAllVuelos();
            autoCompletar = new TextAutoCompleter(txtDestino);
            Set<String> lugaresDestinoUnicos = new HashSet<String>(); //almacena la posicion de los lugares y que no se repitan
            for (Vuelo v : lsVuelo) {
                String lugarDestino = v.getLugarDestino();
                if (!lugaresDestinoUnicos.contains(lugarDestino)){
                    autoCompletar.addItem(lugarDestino);
                    lugaresDestinoUnicos.add(lugarDestino);
                }
            }
        } catch (AppException e) {
            e.printStackTrace();
        }
        
        CustomTextLabel txtFechaIda = new CustomTextLabel("Ida", 20);
        BorderLayout borderLayout = (BorderLayout) txtFechaIda.getLayout();
        borderLayout.setHgap(5);
        panelContenedorBusquedaIda.add(txtFechaIda);
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setBackground(Color.RED);
        btnBuscar.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 12));
        btnBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        btnBuscar.setBorder(new LineBorder(Color.RED));
        panelContenedorBusquedaIda.add(btnBuscar);
        btnBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                try {
                    lsVuelos = vuelosG.GetAllVuelos();
                    obtenerDatosVuelos();
                } catch (AppException e) {
                    e.printStackTrace();
                }
                //for (Vuelo vuelo : lsVuelos) {
                    //System.out.println(vuelosG.GetAllVuelos());
                //} 

                //A continuación validamos que los campos del formulario no esten vacíos para un correcto guardado del producto
                // if( !txtId.getText().isEmpty() &&
                //     !txtNombreProducto.getText().isEmpty() &&
                //     !txtCodigoProducto.getText().isEmpty() &&
                //     !"".equals(cbxCategoriaProducto.getSelectedItem()) &&
                //     !txtStockProducto.getText().isEmpty() &&
                //     !txtPrecioCompra.getText().isEmpty() &&
                //     !txtPrecioVenta.getText().isEmpty() &&
                //     !"".equals(cbxIvaProducto.getSelectedItem()))
                // {
                //     Producto nuevoProducto = new Producto();
                //     nuevoProducto.setIdProducto(txtId.getText());
                //     nuevoProducto.setProducto(txtNombreProducto.getText());
                //     nuevoProducto.setCodigoProducto(txtCodigoProducto.getText());
                //     CategoriaProducto categoria = new CategoriaProducto();
                //     int idCategoria = (cbxCategoriaProducto.getSelectedIndex()+1);
                //     categoria.setIdCategoriaProducto(idCategoria);
                //     nuevoProducto.setFkCategoriaProducto(categoria);
                //     nuevoProducto.setStock(Integer.parseInt(txtStockProducto.getText()));
                //     nuevoProducto.setPrecioCompra(Double.parseDouble(txtPrecioCompra.getText()));
                //     nuevoProducto.setPrecioVenta(Double.parseDouble(txtPrecioVenta.getText()));
                //     Iva iva = new Iva();
                //     int idIva = (cbxIvaProducto.getSelectedIndex()+1);
                //     iva.setId(idIva);
                //     nuevoProducto.setFkIva(iva);
                //     nuevoProducto.setFechaIngreso(fechaActual);
                //     lsProductosRegistrados.add(nuevoProducto);
                //     llenarTabla();
                //     productoRegistrado.getRegistrarProducto(nuevoProducto);
                //     JOptionPane.showMessageDialog(null, "Producto Registrado");
                // }else{
                //     JOptionPane.showMessageDialog(null, "Error al agregar producto, campos vacíos");
                // }
                
            }

            
        });//TODO here
        
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

        // JButton btnBuscarIdaVuelta = new JButton("Buscar");
        // btnBuscarIdaVuelta.setForeground(Color.WHITE);
        // btnBuscarIdaVuelta.setBackground(Color.RED);
        // btnBuscarIdaVuelta.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 12));
        // btnBuscarIdaVuelta.setHorizontalAlignment(SwingConstants.CENTER);
        // btnBuscarIdaVuelta.setBorder(new LineBorder(Color.RED));
        // panelContenedorBusquedaIdaVuelta.add(btnBuscarIdaVuelta);
        
        JLabel lblAyudante3 = new JLabel("     ");
        panelBusqueda.add(lblAyudante3, BorderLayout.WEST);
    
        JLabel lblAyudante4 = new JLabel("     ");
        panelBusqueda.add(lblAyudante4, BorderLayout.EAST);

        cbxConfirmarRetorno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cbxConfirmarRetorno = (JComboBox) e.getSource();
        
                // Obtener el elemento seleccionado del cbxConfirmarRetorno
                String seleccion = (String) cbxConfirmarRetorno.getSelectedItem();
        
                // Cambiar el panel contenedor de busqueda según el elemento seleccionado en el cbx
                if (seleccion.equals("Solo ida")) {
                    panelContenedorBusquedaIda.add(btnBuscar);
                    // Mostrar panelContenedorBusquedaIda con los JText correspondientes
                    panelContenedorBusquedaIda.setVisible(true);
                    panelContenedorBusquedaIdaVuelta.setVisible(false);
                } else if (seleccion.equals("Ida y Vuelta")) {
                    panelContenedorBusquedaIdaVuelta.add(btnBuscar);
                    // Mostrar panelContedorBusquedaIdaVuelta con los JText correspondientes
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
        Grupo2 m = new Grupo2();
        m.setVisible(true);
    }

    private void obtenerDatosVuelos() {
        for (Vuelo v : lsVuelos) {
            System.out.println("ID de vuelo: " + v.getId());
            System.out.println("Estado: " + v.getEstado());
            System.out.println("Tipo de vuelo: " + v.getTipoVuelo());
            System.out.println("Lugar de partida: " + v.getLugarPartida());
            System.out.println("Lugar de destino: " + v.getLugarDestino());
            System.out.println("Precio por persona: " + v.getPrecioPorPersona());
            System.out.println("Recomendación: " + v.getRecomendacion());
            System.out.println("Clase de vuelo: " + v.getClaseVuelo());
            System.out.println("LATAM Pass: " + v.getLatamPass());
            System.out.println("Clase de precio: " + v.getClasePrecio());
            System.out.println("Fecha de salida: " + v.getFechaSalida());
            System.out.println("Fecha de vuelta: " + v.getFechaVuelta());
            System.out.println("Tiempo de salida: " + v.getTiempoSalida());
            System.out.println("Tiempo de llegada: " + v.getTiempoLlegada());
            System.out.println(" ");
        }
    }
}
