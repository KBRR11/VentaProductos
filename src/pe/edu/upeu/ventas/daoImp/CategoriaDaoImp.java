package pe.edu.upeu.ventas.daoImp;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import pe.edu.upeu.ventas.dao.CategoriaDao;
import pe.edu.upeu.ventas.entity.Categoria;
import pe.edu.upeu.ventas.util.Conexion;



public class CategoriaDaoImp implements CategoriaDao {
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	@Override
	public int create(Categoria u) {
		// TODO Auto-generated method stub
				int x = 0;
				String sql ="INSERT INTO categoria (idcategoria, nom_categoria) VALUES (NULL, ?, ?, ?)";
				try {
					cx = Conexion.getConexion();
					ps = cx.prepareStatement(sql);
					ps.setString(1, u.getNom_categoria());
					x = ps.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
				return x;
	}

	@Override
	public int update(Categoria u) {
		// TODO Auto-generated method stub
				int x = 0;
				String sql = "UPDATE categoria SET  nom_categoria = ?  WHERE idcategoria = ?";
				try {
					cx = Conexion.getConexion();
					ps = cx.prepareStatement(sql);
					ps.setString(1, u.getNom_categoria());
					ps.setInt(2, u.getIdcategoria());
					x = ps.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
				return x;
	}

	@Override
	public int delete(int id) {
		int x = 0;
		// TODO Auto-generated method stub
		String sql= "DELETE FROM categoria WHERE idcategoria = ?";
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
	public Categoria read(int id) {
		// TODO Auto-generated method stub
		String sql= "select * from categoria where idcategoria=?";
		Categoria a = new Categoria();
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {				
				a.setIdcategoria(rs.getInt("idcategoria"));
				a.setNom_categoria(rs.getString("nom_categoria"));
				
						    
			}
			
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return a;
	}

	@Override
	public List<Categoria> readAll() {
		// TODO Auto-generated method stub
				List<Categoria> list = new ArrayList<>();
				String sql = "select *from categoria";
				try {
					cx = Conexion.getConexion();
					ps = cx.prepareStatement(sql);
					rs = ps.executeQuery();
					while(rs.next()) {
						Categoria a = new Categoria();
						a.setIdcategoria(rs.getInt("idcategoria"));
						a.setNom_categoria(rs.getString("nom_categoria"));
						list.add(a);
					    
					}
					
				} catch (Exception e) {
					System.out.println(e);
				}
				return list;
			}
}


