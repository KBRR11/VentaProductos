package pe.edu.upeu.ventas.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pe.edu.upeu.ventas.dao.DetalleVentaDao;
import pe.edu.upeu.ventas.entity.DetalleVenta;
import pe.edu.upeu.ventas.entity.Ventas;
import pe.edu.upeu.ventas.util.Conexion;

public class DetalleVentaDaoImp implements DetalleVentaDao{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	
	@Override
	public int create(DetalleVenta u) {
		int x = 0;
		String sql ="INSERT INTO detalle_venta (iddetalle_venta, idventas, idproducto, precio_venta, cantidad_venta) VALUES (NULL, ?, ?, ?, ?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, u.getIdventas());
			ps.setInt(2, u.getIdproducto());
			ps.setDouble(3, u.getPrecio_venta());
			ps.setInt(4, u.getCantidad_venta());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		finally {
			Conexion.cerrar();
		}
		return x;
	}

	@Override
	public int update(DetalleVenta u) {
		int x = 0;
		String sql = "UPDATE detalle_venta Set  idventas=?, idproducto=?, precio_venta=?, cantidad_venta=? WHERE iddetalle_venta=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, u.getIdventas());
			ps.setInt(2, u.getIdproducto());
			ps.setDouble(3, u.getPrecio_venta());
			ps.setInt(4, u.getCantidad_venta());
			ps.setInt(5, u.getIddetalle_venta());
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			Conexion.cerrar();
		}
		return x;
	}

	@Override
	public int delete(int id) {
		int x=0;
		String sql= "DELETE FROM detalle_venta WHERE iddetalle_venta=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			Conexion.cerrar();
		}
		return x;
	}
	public List<DetalleVenta> readByVenta(int id) {
		// TODO Auto-generated method stub
		List<DetalleVenta> dventas=new ArrayList<DetalleVenta>();
		 String sql = "select * from detalle_venta where idventas = ?";
		 try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				DetalleVenta dv =new DetalleVenta();
				dv.setIdventas(rs.getInt("idventas"));
				dv.setIdproducto(rs.getInt("idproducto"));
				dv.setPrecio_venta(rs.getDouble("precio_venta"));
				dv.setCantidad_venta(rs.getInt("cantidad_venta"));
				
				dventas.add(dv);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		 finally {
				Conexion.cerrar();
			}
		 return dventas;
	}



	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
				List<Map<String, Object>> list = new ArrayList<>();
				String sql = "select v.idventas, v.idusuario, v.idcliente, v.doc, v.fecha"
						+ "p.idproducto, p.idcategoria, p.nom_producto, p.precio, p.cantidad,"
						+ " dv.iddetalle_venta, dv.precio_venta, dv.cantidad_venta"
						+ " from detalle_venta dv, producto p, ventas v WHERE v.idventas = dv.idventas and p.idproducto = dv.idproducto";
				try {
					cx = Conexion.getConexion();
					ps = cx.prepareStatement(sql);
					rs = ps.executeQuery();
					while(rs.next()) {
						 Map<String,Object> map= new HashMap<String,Object>();
						map.put("idventas", rs.getInt("idventas"));
						map.put("idusuario", rs.getInt("idusuario"));
						map.put("idcliente", rs.getInt("idcliente"));
						map.put("doc", rs.getString("doc"));
						map.put("fecha", rs.getString("fecha"));
						map.put("idproducto", rs.getInt("idproducto"));
						map.put("idcategoria", rs.getInt("idcategoria"));
						map.put("nom_producto", rs.getString("nom_producto"));
						map.put("precio", rs.getDouble("precio"));
						map.put("cantidad", rs.getInt("cantidad"));
						map.put("iddetalle_venta", rs.getInt("iddetalle_venta"));
						map.put("precio_venta", rs.getDouble("precio_venta"));
						map.put("cantidad_venta", rs.getString("cantidad_venta"));
						list.add(map);
					    
					}
					
				} catch (Exception e) {
					System.out.println(e);
				}
				finally {
					Conexion.cerrar();
	}
				return list;
	}

	}
