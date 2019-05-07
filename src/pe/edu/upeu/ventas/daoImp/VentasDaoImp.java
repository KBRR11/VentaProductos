package pe.edu.upeu.ventas.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pe.edu.upeu.ventas.dao.VentasDao;
import pe.edu.upeu.ventas.entity.Producto;
import pe.edu.upeu.ventas.entity.Ventas;
import pe.edu.upeu.ventas.util.Conexion;

public class VentasDaoImp implements VentasDao {
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	
	@Override
	public int create(Ventas u) {
		int x = 0;
		String sql ="INSERT INTO ventas (idventas, idusuario, idcliente, doc, fecha) VALUES (NULL, ?, ?, ?, ?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, u.getIdusuario());
			ps.setInt(2, u.getIdcliente());
			ps.setString(3, u.getDoc());
			ps.setString(4, u.getFecha());
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
	public int update(Ventas u) {
		int x = 0;
		String sql = "UPDATE ventas Set  idusuario=?, idcliente=?, doc=?, fecha=? WHERE idventas=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			
			ps.setInt(1, u.getIdusuario());
			
			ps.setInt(2, u.getIdcliente());
			ps.setString(3, u.getDoc());
			ps.setString(4, u.getFecha());
			ps.setInt(5, u.getIdventas());
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
		String sql= "DELETE FROM ventas WHERE idventas=?";
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
	public Ventas read(int id) {
		// TODO Auto-generated method stub
		Ventas v =new Ventas();
		 String sql = "select * from ventas where idventas = ?";
		 try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				v.setIdventas(rs.getInt("idventas"));
				v.setIdusuario(rs.getInt("idusuario"));
				v.setIdcliente(rs.getInt("idcliente"));
				v.setDoc(rs.getString("doc"));
				v.setFecha(rs.getString("fecha"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		 finally {
				Conexion.cerrar();
			}
		 return v;
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<>();
		String sql = "select u.idusuario, u.idrol, u.nom_user, u.clave"
				+ "c.idcliente, c.nombres, c.dni, v.idventas, v.doc, v.fecha"
				+ "from ventas v, cliente c, usuario u WHERE u.idusuario = v.idusuario and c.idcliente = v.idcliente ";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				 Map<String,Object> map= new HashMap<String,Object>();
				map.put("idusuario", rs.getInt("idusuario"));
				map.put("idrol", rs.getInt("idrol"));
				map.put("nom_user", rs.getString("nom_user"));
				map.put("clave", rs.getString("clave"));
				map.put("idcliente", rs.getInt("idcliente"));
				map.put("nombres", rs.getString("nombres"));
				map.put("dni", rs.getString("dni"));
				map.put("idventas", rs.getInt("idventas"));
				map.put("doc", rs.getString("doc"));
				map.put("fecha", rs.getString("fecha"));
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


