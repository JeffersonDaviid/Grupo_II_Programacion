package BusinnessLogic;

import java.sql.ResultSet;

import BusinnessLogic.Entities.Estado;
import DataAccess.EstadoDAC;

public class EstadoBL {

    public Estado getBLEstadoById(int id) {
        try {
            EstadoDAC estadoDac = new EstadoDAC();
            ResultSet rsEstado = estadoDac.getEstadoById(id);
            while (rsEstado.next()) {
                Estado estado = new Estado(id, rsEstado.getString("ESTADO"));
                return estado;
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el estado en getBLEstadoById(int id): " + e.getMessage());
        }
        return null;
    }
}