package BusinnessLogic;

import java.sql.ResultSet;

import BusinnessLogic.Entities.Iva;
import DataAccess.IvaDAC;

public class IvaBL {
    public Iva getBLIvaById(int id) {
        try {
            IvaDAC ivaDac = new IvaDAC();
            ResultSet rsIva = ivaDac.getIvaById(id);
            while (rsIva.next()) {
                Iva iva = new Iva(id, rsIva.getString("NOMBRE"));
                return iva;
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el estado en getBLIvaById(int id): " + e.getMessage());
        }
        return null;
    }
}
