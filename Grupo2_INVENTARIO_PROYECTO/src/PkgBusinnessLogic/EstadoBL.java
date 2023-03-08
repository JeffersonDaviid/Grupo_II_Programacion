package PkgBusinnessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;

import PkgBusinnessLogic.Entities.Estado;
import PkgDataAccess.EstadoDAC;
import PkgFramework.APP;
import PkgFramework.AppException;

public class EstadoBL {

    /**
     * Retorna una lista tipo Estado con todos sus atributos, es decir id y nombre
     * 
     * @return : ArrayList<Estado> con todos los atributos de los estados
     * @throws Exception : indica las excepciones que se pueden lanzar durante la
     *                   ejecución
     */
    public ArrayList<Estado> getAllBLEstado() throws Exception {
        try {
            ArrayList<Estado> lsEstado = new ArrayList<Estado>();
            EstadoDAC estadoDac = new EstadoDAC();
            ResultSet rsEstado = estadoDac.getAllEstado();
            while (rsEstado.next()) {
                Estado estado = new Estado(rsEstado.getInt(APP.BASE_DATOS_MYSQL.PK_ID_ESTADO),
                        rsEstado.getString(APP.BASE_DATOS_MYSQL.ESTADO));
                lsEstado.add(estado);
            }
            return lsEstado;
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getAllBLEstado(): " + e.getMessage());
        }
    }

    /**
     * Método que retorna una lista de los nombres de los estados disponibles acorde
     * a la tabla Estado
     * 
     * @return : ArrayList<String> con todos los nombres de los estados
     * @throws Exception : indica las excepciones que se pueden lanzar durante la
     *                   ejecución
     */
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

    /**
     * Método que retorna una clase Estado, para lo cual necesita el id del estado
     * que deseamos buscar
     * 
     * @param id : es de tipo INT, y es el identificador unico del estado
     * @return : clase Estado
     * @throws Exception : indica las excepciones que se pueden lanzar durante la
     *                   ejecución
     */
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