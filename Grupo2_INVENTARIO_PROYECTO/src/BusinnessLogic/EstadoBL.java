package BusinnessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;

import BusinnessLogic.Entities.Estado;
import DataAccess.EstadoDAC;
import Framework.APP;
import Framework.AppException;

public class EstadoBL {

    public ArrayList<Estado> getAllBLEstado() throws Exception {
        try {
            ArrayList<Estado> lsEstado = new ArrayList<Estado>();
            EstadoDAC estadoDac = new EstadoDAC();
            ResultSet rsEstado = estadoDac.getAllEstado();
            while (rsEstado.next()) {
                Estado estado = new Estado(rsEstado.getInt(APP.BASE_DATOS_MYSQL.ID_ESTADO),
                        rsEstado.getString(APP.BASE_DATOS_MYSQL.ESTADO));
                lsEstado.add(estado);
            }
            return lsEstado;
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getAllBLEstado(): " + e.getMessage());
        }
    }

    public ArrayList<String> getAllEstadoNombre() throws Exception {
        try {
            ArrayList<String> lsEstado = new ArrayList<String>();
            EstadoDAC estadoDac = new EstadoDAC();
            ResultSet rsEstado = estadoDac.getAllEstado();
            while (rsEstado.next()) {
                lsEstado.add(rsEstado.getString(APP.BASE_DATOS_MYSQL.ESTADO));
            }
            return lsEstado;
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getAllBLEstado(): " + e.getMessage());
        }
    }

    public Estado getBLEstadoById(int id) throws Exception {
        try {
            EstadoDAC estadoDac = new EstadoDAC();
            ResultSet rsEstado = estadoDac.getEstadoById(id);
            while (rsEstado.next()) {
                Estado estado = new Estado(id, rsEstado.getString(APP.BASE_DATOS_MYSQL.ESTADO));
                return estado;
            }
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getBLEstadoById(int id): " + e.getMessage());
        }
        return null;
    }
}