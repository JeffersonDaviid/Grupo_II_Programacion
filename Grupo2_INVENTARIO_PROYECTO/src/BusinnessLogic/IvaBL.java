package BusinnessLogic;

import java.sql.ResultSet;

import BusinnessLogic.Entities.Iva;
import DataAccess.IvaDAC;
import Framework.APP;
import Framework.AppException;

public class IvaBL {
    public Iva getBLIvaById(int id) throws Exception {
        try {
            IvaDAC ivaDac = new IvaDAC();
            ResultSet rsIva = ivaDac.getIvaById(id);
            while (rsIva.next()) {
                Iva iva = new Iva(id, rsIva.getString(APP.BASE_DATOS_MYSQL.NOMBRE));
                return iva;
            }
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getBLIvaById(int id): " + e.getMessage());
        }
        return null;
    }
}
