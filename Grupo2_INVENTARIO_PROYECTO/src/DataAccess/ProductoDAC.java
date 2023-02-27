package DataAccess;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

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
    public void registrarProducto(Producto pro){
        String sql = "insert into " + APP.BASE_DATOS_MYSQL.TABLA_PRODUCTO + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //String sql = "insert into Producto values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            ps = DataHelper.getConexion().prepareStatement(sql);
            ps.setString(1, pro.getIdProducto()); //idproducto
            ps.setString(2, pro.getCodigoProducto()); //codigo
            ps.setInt(3, 1); //estado (ez)
            ps.setInt(4, pro.getFkCategoriaProducto().getIdCategoriaProducto()); //categoria
            ps.setInt(5, pro.getFkIva().getId()); //iva
            ps.setString(6, pro.getProducto()); //nombre
            ps.setInt(7, pro.getStock()); //stock
            ps.setDouble(8, pro.getPrecioCompra()); //preciocompra
            ps.setDouble(9, pro.getPrecioVenta()); //precioventa
            ps.setString(10, pro.getDescripcion()); //descripcion
            ps.setString(11, null); //imagen
            ps.setString(12, pro.getFechaIngreso()); //fecha creacion     
            ps.setString(13, "No modificado"); //fecha modificacion          
            ps.executeUpdate();
            DataHelper.cerrarConexion();
            //return true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
            //return false;
        }
    } //TODO aqui muere mi contenido xd

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
