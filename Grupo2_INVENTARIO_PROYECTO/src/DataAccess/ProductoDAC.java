package DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import BusinnessLogic.Entities.Producto;

//import com.mysql.jdbc.PreparedStatement;

import Framework.APP;
import Framework.AppException;
import java.sql.PreparedStatement;

public class ProductoDAC extends DataHelper {
    //TODO contenido agregado por ADCJ
    PreparedStatement ps;
    ResultSet rs;
    /**
     * 
     * @param pro : del tipo Producto la cual es la entidad donde se alojan las variables, getters y setter del producto
     * @return : true si la conexión es exitosa y agrega los valores solicitados, false si se presenta un error al enviar los datos
     */
    public boolean registrarProducto(Producto pro){
        String sql = "INSERT INTO" + APP.BASE_DATOS_MYSQL.TABLA_PRODUCTO + "(" + APP.BASE_DATOS_MYSQL.PK_ID_PRODUCTO
                                                                               + ", " + APP.BASE_DATOS_MYSQL.CODIGO_PRODUCTO
                                                                               + ", " + APP.BASE_DATOS_MYSQL.FK_ID_ESTADO
                                                                               + ", " + APP.BASE_DATOS_MYSQL.FK_ID_CATEGORIA_PRODUCTO
                                                                               + ", " + APP.BASE_DATOS_MYSQL.FK_ID_IVA
                                                                               + ", " + APP.BASE_DATOS_MYSQL.PRODUCTO
                                                                               + ", " + APP.BASE_DATOS_MYSQL.STOCK
                                                                               + ", " + APP.BASE_DATOS_MYSQL.PRECIO_COMPRA
                                                                               + ", " + APP.BASE_DATOS_MYSQL.PRECIO_VENTA
                                                                               + ", " + APP.BASE_DATOS_MYSQL.DESCRIPCION
                                                                               + ", " + APP.BASE_DATOS_MYSQL.IMAGEN
                                                                               + ", " + APP.BASE_DATOS_MYSQL.FECHA_CREACION
                                                                               + ", " + APP.BASE_DATOS_MYSQL.FECHA_MODIFICACION + ")"
                                                                               + " VALUES " + " (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        try{
            ps = DataHelper.getConexion().prepareStatement(sql);
            ps.setString(1, pro.getCodigoProducto());
            ps.setString(5, pro.getProducto());
            ps.setInt(6, pro.getStock());
            ps.setDouble(7, pro.getPrecioCompra());
            ps.setDouble(8, pro.getPrecioVenta());
            ps.setString(9, pro.getFechaIngreso());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    } 

    public void consultarIVA(JComboBox iva){
        String sql = "SELECT NOMBRE FROM iva";
        try {
            ps = DataHelper.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                iva.addItem(rs.getString("NOMBRE"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }//TODO aqui muere mi contenido xd

    public ResultSet getProducto() throws AppException {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.PK_ID_PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.CODIGO_PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_ESTADO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_CATEGORIA_PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_IVA
                    + ", " + APP.BASE_DATOS_MYSQL.PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.STOCK
                    + ", " + APP.BASE_DATOS_MYSQL.PRECIO_COMPRA
                    + ", " + APP.BASE_DATOS_MYSQL.PRECIO_VENTA
                    + ", " + APP.BASE_DATOS_MYSQL.DESCRIPCION
                    + ", " + APP.BASE_DATOS_MYSQL.IMAGEN
                    + ", " + APP.BASE_DATOS_MYSQL.FECHA_CREACION
                    + ", " + APP.BASE_DATOS_MYSQL.FECHA_MODIFICACION
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_PRODUCTO;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "getProducto() " + e.getMessage());
        }
    }

    public ResultSet getProductoByCategoria(int idCategoria) throws AppException {
        try {
            String sql = "SELECT "
                    + APP.BASE_DATOS_MYSQL.PK_ID_PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.CODIGO_PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_ESTADO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_CATEGORIA_PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.FK_ID_IVA
                    + ", " + APP.BASE_DATOS_MYSQL.PRODUCTO
                    + ", " + APP.BASE_DATOS_MYSQL.STOCK
                    + ", " + APP.BASE_DATOS_MYSQL.PRECIO_COMPRA
                    + ", " + APP.BASE_DATOS_MYSQL.PRECIO_VENTA
                    + ", " + APP.BASE_DATOS_MYSQL.DESCRIPCION
                    + ", " + APP.BASE_DATOS_MYSQL.IMAGEN
                    + ", " + APP.BASE_DATOS_MYSQL.FECHA_CREACION
                    + ", " + APP.BASE_DATOS_MYSQL.FECHA_MODIFICACION
                    + " FROM "
                    + APP.BASE_DATOS_MYSQL.TABLA_PRODUCTO
                    + " WHERE "
                    + APP.BASE_DATOS_MYSQL.FK_ID_CATEGORIA_PRODUCTO + " = " + idCategoria;
            return getResultSet(sql);
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en getProductoByCategoria(int idCategoria) " + e.getMessage());
        }
    }

}
