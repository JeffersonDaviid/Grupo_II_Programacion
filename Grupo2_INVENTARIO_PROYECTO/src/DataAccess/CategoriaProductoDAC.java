package DataAccess;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JComboBox;

import Framework.APP;
import Framework.AppException;

public class CategoriaProductoDAC extends DataHelper {
    PreparedStatement ps;
    ResultSet rs;

    /**
     * Permite consultar en la BD la tabla categoriaproducto y asì obtener los tipos
     * de producto disponible para mostrarlos en el ComboBox
     * 
     * @param iva : recibe como paràmetro el JComboBox de CategoriaProducto
     */
    public void consultarCategorias(JComboBox categoria) {
        String sql = "SELECT NOMBRE FROM CategoriaProducto";
        try {
            ps = DataHelper.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                categoria.addItem(rs.getString("NOMBRE"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public ResultSet getCategoriaById(int id) throws AppException {

        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.FK_ID_ESTADO + ", "
                    + APP.BASE_DATOS_MYSQL.NOMBRE
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_CATEGORIA_PRODUCTO
                    + " WHERE "
                    + APP.BASE_DATOS_MYSQL.PK_ID_CATEGORIA_PRODUCTO + " = " + id;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "getCategoriaById() " + e.getMessage());
        }
    }

    public ResultSet getAllCaterogia() throws AppException {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.FK_ID_ESTADO + ", "
                    + APP.BASE_DATOS_MYSQL.NOMBRE
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_CATEGORIA_PRODUCTO;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getAllCaterogia() " + e.getMessage());
        }
    }

}
