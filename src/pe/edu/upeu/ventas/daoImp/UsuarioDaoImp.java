package pe.edu.upeu.ventas.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pe.edu.upeu.ventas.dao.UsuarioDao;
import pe.edu.upeu.ventas.entity.Producto;
import pe.edu.upeu.ventas.entity.Usuario;
import pe.edu.upeu.ventas.util.Conexion;

public class UsuarioDaoImp implements UsuarioDao{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	@Override
	public int create(Usuario u) {
		int x = 0;
		String sql ="INSERT INTO usuario (idusuario, idrol, nom_user, clave) VALUES (NULL, ?, ?, ?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, u.getIdrol());
			ps.setString(2, u.getNom_user());
			ps.setString(3, u.getClave());
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
	public int update(Usuario u) {
		int x = 0;
		String sql = "UPDATE usuario Set  idrol=?, nom_user=?, clave=? WHERE idusuario=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, u.getIdrol());
			ps.setString(2, u.getNom_user());
			ps.setString(3, u.getClave());
			ps.setInt(5, u.getIdusuario());
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
		String sql= "DELETE FROM usuario WHERE idusuario=?";
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
	public Usuario read(int id) {
		 
		Usuario u =new Usuario();
		 String sql = "select * from usuario where idusuario = ?";
		 try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				u.setIdusuario(rs.getInt("idusuario"));
				u.setIdrol(rs.getInt("idrol"));
				u.setNom_user(rs.getString("nom_user"));
				u.setClave(rs.getString("clave"));
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		 finally {
				Conexion.cerrar();
			}
		 return u;
	}
	@Override
	public Usuario Validar(String user, String clave) {
		Usuario u =new Usuario();
		 String sql = "select * from usuario where nom_user = ? and clave=?";
		 try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, clave);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				u.setIdusuario(rs.getInt("idusuario"));
				u.setIdrol(rs.getInt("idrol"));
				u.setNom_user(rs.getString("nom_user"));
				u.setClave(rs.getString("clave"));
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		 finally {
				Conexion.cerrar();
			}
		 return u;
	}
	@Override
	
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
				List<Map<String, Object>> list = new ArrayList<>();
				String sql = "select r.idrol, r.nom_rol, u.idusuario, u.nom_user, u.clave "
						+ "from usuario as u, rol as r WHERE r.idrol = u.idusuario";
				try {
					cx = Conexion.getConexion();
					ps = cx.prepareStatement(sql);
					rs = ps.executeQuery();
					while(rs.next()) {
						 Map<String,Object> map= new HashMap<String,Object>();
						map.put("idrol", rs.getInt("idrol"));
						map.put("nom_rol", rs.getString("nom_rol"));
						map.put("idusuario", rs.getInt("idusuario"));
						map.put("nom_user", rs.getString("nom_user"));
						map.put("clave", rs.getString("clave"));
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
