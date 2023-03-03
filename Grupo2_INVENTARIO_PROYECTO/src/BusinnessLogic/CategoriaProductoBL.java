package BusinnessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;

import BusinnessLogic.Entities.CategoriaProducto;
import DataAccess.CategoriaProductoDAC;
import Framework.APP;
import Framework.AppException;

public class CategoriaProductoBL {
    /**
     * Método que permite obtener la categoria de un pruducto
     * 
     * @param id : tipo Int, identificador de la categoría
     * @return : retorna una clase CategoriaProducto
     * @throws Exception : indica las excepciones que se pueden lanzar durante la ejecución
     */
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

    /**
     * Método que obtiene todos los nombres de todas las categorías de los producto
     * 
     * @return : retorna ArrayList<String> una cadena iterable
     * @throws Exception : indica las excepciones que se pueden lanzar durante la ejecución
     */
    public ArrayList<String> getAllCategoriaNombre() throws Exception {
        try {
            ArrayList<String> lsEstado = new ArrayList<String>();
            CategoriaProductoDAC categoriaDac = new CategoriaProductoDAC();
            ResultSet rsEstado = categoriaDac.getAllCaterogia();
            while (rsEstado.next()) {
                lsEstado.add(rsEstado.getString(APP.BASE_DATOS_MYSQL.NOMBRE));
            }
            return lsEstado;
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getAllCategoriaNombre(): " + e.getMessage());
        }
    }

}
