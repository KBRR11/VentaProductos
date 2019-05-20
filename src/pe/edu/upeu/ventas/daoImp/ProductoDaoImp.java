package pe.edu.upeu.ventas.daoImp;

import java.util.List;
import java.util.Map;

import oracle.jrockit.jfr.tools.ConCatRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import pe.edu.upeu.ventas.dao.ProductoDao;
import pe.edu.upeu.ventas.entity.Categoria;
import pe.edu.upeu.ventas.entity.Producto;
import pe.edu.upeu.ventas.util.Conexion;

public class ProductoDaoImp implements ProductoDao {
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	@Override
	public int create(Producto u) {
		int x = 0;
		String sql ="INSERT INTO producto (idproducto, idcategoria, nom_producto, precio, cantidad) VALUES (NULL, ?, ?, ?, ?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, u.getIdcategoria());
			ps.setString(2, u.getNom_producto());
			ps.setDouble(3, u.getPrecio());
			ps.setInt(4, u.getCantidad());
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
	public int update(Producto u) {
		int x = 0;
		String sql = "UPDATE producto Set  idcategoria=?, nom_producto=?, precio=?, cantidad=? WHERE idproducto=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			//ps.setInt(1, u.getIdproducto());
			ps.setInt(1, u.getIdcategoria());
			//ps.setInt(2, u.getIdproducto());
			ps.setString(2, u.getNom_producto());
			ps.setDouble(3, u.getPrecio());
			ps.setInt(4, u.getCantidad());
			ps.setInt(5, u.getIdproducto());
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			Conexion.cerrar();
		}
		return x;
	}
	public int updateCantidad(Producto u) {
		int x = 0;
		String sql = "UPDATE producto Set  cantidad=? WHERE idproducto=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, u.getCantidad());
			ps.setInt(2, u.getIdproducto());
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
		String sql= "DELETE FROM producto WHERE idproducto=?";
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

	@Override
	public Producto read(int id) {
		 
		Producto p =new Producto();
		 String sql = "select * from producto where idproducto = ?";
		 try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				p.setIdproducto(rs.getInt("idproducto"));
				p.setIdcategoria(rs.getInt("idcategoria"));
				p.setNom_producto(rs.getString("nom_producto"));
				p.setPrecio(rs.getDouble("precio"));
				p.setCantidad(rs.getInt("cantidad"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		 finally {
				Conexion.cerrar();
			}
		 return p;
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<>();
		String sql = "select c.idcategoria, c.nom_categoria, p.idproducto, p.nom_producto, p.precio, p.cantidad "
				+ "from producto as p, categoria as c WHERE c.idcategoria = p.idcategoria";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				 Map<String,Object> map= new HashMap<String,Object>();
				map.put("idcategoria", rs.getInt("idcategoria"));
				map.put("nom_categoria", rs.getString("nom_categoria"));
				map.put("idproducto", rs.getInt("idproducto"));
				map.put("nom_producto", rs.getString("nom_producto"));
				map.put("precio", rs.getDouble("precio"));
				map.put("cantidad", rs.getInt("cantidad"));
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
