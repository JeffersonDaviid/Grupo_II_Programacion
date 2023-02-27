package BL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BL.Entities.Vuelo;
import DAC.VueloDAC;
import FWK.AppException;

public class VueloBL {

    public List<Vuelo> GetAllVuelos( ) throws AppException{
        try {
            VueloDAC vueloDAC = new VueloDAC();
            List<Vuelo> lsVuelos = new ArrayList<Vuelo>();
            ResultSet rs = vueloDAC.getAllVuelos();
            while(rs.next())    {
                Vuelo v = new Vuelo(rs.getInt("ID_VUELO"), rs.getString("ESTADO"), rs.getInt("TIPO_VUELO"), rs.getString("LUGAR_PARTIDA"), rs.getString("LUGAR_DESTINO"), rs.getInt("PRECIO_POR_PERSONA"), rs.getString("RECOMENDACION"), rs.getString("CLASE_VUELO"), rs.getString("LATAM_PASS"), rs.getInt("CLASE_PRECIO"), rs.getString("FECHA_SALIDA"), rs.getString("FECHA_VUELTA"), rs.getString("TIEMPO_SALIDA"), rs.getString("TIEMPO_LLEGADA")); ;
                lsVuelos.add(v);
            }
            return lsVuelos;
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass());
        }
    } 
    
    //Arraylist <Vuelo> lsVuelos = new ArrayList<>();
}
