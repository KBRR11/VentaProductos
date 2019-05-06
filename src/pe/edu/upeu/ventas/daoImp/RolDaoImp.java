package pe.edu.upeu.ventas.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pe.edu.upeu.ventas.dao.RolDao;
import pe.edu.upeu.ventas.entity.Rol;
import pe.edu.upeu.ventas.util.Conexion;

public class RolDaoImp implements RolDao {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	@Override
	public int create(Rol u) {
		int x = 0;
		String sql ="INSERT INTO rol (idrol, nom_rol) VALUES (NULL, ?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, u.getIdrol());
			ps.setString(2, u.getNom_rol());
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
	public int update(Rol u) {
		int x = 0;
		String sql = "UPDATE rol Set   nom_rol=? WHERE idrol=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setString(1, u.getNom_rol());
			ps.setInt(2, u.getIdrol());
		
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
		int x = 0;
		// TODO Auto-generated method stub
		String sql= "DELETE FROM rol WHERE idrol = ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return x;
	}
	@Override
	public Rol read(int id) {
		// TODO Auto-generated method stub
				String sql= "select * from rol where idrol=?";
				Rol r = new Rol();
				try {
					cx = Conexion.getConexion();
					ps = cx.prepareStatement(sql);
					ps.setInt(1, id);
					rs = ps.executeQuery();
					while(rs.next()) {				
						r.setIdrol(rs.getInt("idrol"));
						r.setNom_rol(rs.getString("nom_rol"));
						
								    
					}
					
				} catch (Exception e) {
					System.out.println("Error: "+e);
				}
				return r;
			
	}
	@Override
	public List<Rol> readAll() {
		// TODO Auto-generated method stub
		List<Rol> list = new ArrayList<>();
		String sql = "select *from rol";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Rol r = new Rol();
				r.setIdrol(rs.getInt("idrol"));
				r.setNom_rol(rs.getString("nom_rol"));
				list.add(r);
			    
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
}
