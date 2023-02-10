package BusinnessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;

import BusinnessLogic.Entities.CategoriaProducto;
import DataAccess.CategoriaProductoDAC;
import Framework.APP;
import Framework.AppException;

public class CategoriaProductoBL {

    public CategoriaProducto getBLCategoriaProductoById(int id) throws Exception {
        EstadoBL estado = new EstadoBL();
        try {
            CategoriaProductoDAC estadoDac = new CategoriaProductoDAC();
            ResultSet rsCategoria = estadoDac.getCategoriaById(id);
            while (rsCategoria.next()) {
                CategoriaProducto categoria = new CategoriaProducto(
                        id,
                        estado.getBLEstadoById(rsCategoria.getInt(APP.BASE_DATOS_MYSQL.FK_ID_ESTADO)),
                        rsCategoria.getString(APP.BASE_DATOS_MYSQL.NOMBRE));
                return categoria;
            }
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getBLCategoriaProductoById(int id): " + e.getMessage());
        }
        return null;
    }

    public ArrayList<String> getAllCategoriaProducto() throws Exception {
        ArrayList<String> lsCategoria = new ArrayList<String>();
        try {
            CategoriaProductoDAC categoriaDAC = new CategoriaProductoDAC();
            ResultSet rsCategoria = categoriaDAC.getAllCaterogia();
            while (rsCategoria.next()) {
                lsCategoria.add(rsCategoria.getString(APP.BASE_DATOS_MYSQL.NOMBRE));
            }
            return lsCategoria;
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getAllCategoriaProducto(): " + e.getMessage());
        }
    }

}
