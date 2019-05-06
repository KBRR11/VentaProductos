package pe.edu.upeu.ventas.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.ventas.dao.ClienteDao;
import pe.edu.upeu.ventas.entity.Cliente;
import pe.edu.upeu.ventas.util.Conexion;

public class ClienteDaoImp implements ClienteDao {
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	@Override
	public int create(Cliente u) {
		int x = 0;
		String sql ="INSERT INTO cliente (idcliente, nombres, dni) VALUES (NULL, ?, ?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setString(1, u.getNombres());
			ps.setString(2, u.getDni());
			
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
	public int update(Cliente u) {
		int x = 0;
		String sql = "UPDATE cliente Set  nombres=?, dni=?  WHERE idcliente=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setString(1, u.getNombres());
			ps.setString(2, u.getDni());
			ps.setInt(3, u.getIdcliente());
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
		String sql= "DELETE FROM cliente WHERE idcliente=?";
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
	public Cliente read(int id) {
		Cliente c =new Cliente();
		 String sql = "select * from cliente where idcliente = ?";
		 try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				c.setIdcliente(rs.getInt("idcliente"));
				c.setNombres(rs.getString("nombres"));
				c.setDni(rs.getString("dni"));
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		 finally {
				Conexion.cerrar();
			}
		 return c;
	}

	@Override
	public List<Cliente> readAll() {
		List<Cliente> list = new ArrayList<>();
		String sql = "select *from cliente";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setIdcliente(rs.getInt("idcliente"));
				c.setNombres(rs.getString("nombres"));
				c.setDni(rs.getString("dni"));
				list.add(c);
			    
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	}


