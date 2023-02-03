package BusinnessLogic;

import java.sql.ResultSet;

import BusinnessLogic.Entities.CategoriaProducto;
import DataAccess.CategoriaProductoDAC;

public class CategoriaProductoBL {

    public CategoriaProducto getBLCategoriaProductoById(int id) {
        EstadoBL estado = new EstadoBL();
        try {
            CategoriaProductoDAC estadoDac = new CategoriaProductoDAC();
            ResultSet rsCategoria = estadoDac.getCategoriaById(id);
            while (rsCategoria.next()) {
                CategoriaProducto categoria = new CategoriaProducto(
                        id,
                        estado.getBLEstadoById(rsCategoria.getInt("FK_ID_ESTADO")),
                        rsCategoria.getString("NOMBRE"));
                return categoria;
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el estado en getBLCategoriaProductoById(int id): " + e.getMessage());
        }
        return null;
    }
}
