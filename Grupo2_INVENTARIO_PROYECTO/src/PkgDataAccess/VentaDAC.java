package PkgDataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import PkgBusinnessLogic.Entities.Producto;
import PkgBusinnessLogic.Entities.Venta;

public class VentaDAC extends DataHelper {
	PreparedStatement ps;
	ResultSet rs;
	int r;

	public void registrarVenta(Venta v) {
		String sql = "INSERT INTO venta (CLIENTE, VENDEDOR, TOTAL) VALUES (?,?,?)";
		try {
			ps = DataHelper.getConexion().prepareStatement(sql);
			ps.setString(1, v.getCliente());
			// ps.setString(2, v.getVendedor());
			ps.setString(2, null);
			ps.setDouble(3, v.getTotal());
			ps.execute();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}

	}

	public Producto BuscarPro(String cod) {
		Producto producto = new Producto();
		String sql = "SELECT * FROM Producto WHERE CODIGO_PRODUCTO = ?";
		try {
			ps = DataHelper.getConexion().prepareStatement(sql);
			ps.setString(1, cod);
			rs = ps.executeQuery();
			if (rs.next()) {
				producto.setProducto(rs.getString("PRODUCTO"));
				producto.setPrecioVenta(rs.getFloat("PRECIO_VENTA"));
				producto.setStock(rs.getInt("STOCK"));
			}
			DataHelper.cerrarConexion();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return producto;
	}

}
