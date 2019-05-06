package pe.edu.upeu.ventas.dao;
import java.util.List;


import pe.edu.upeu.ventas.entity.Cliente;

public interface ClienteDao {
	public int create(Cliente u);
	public int update(Cliente u);
	public int delete(int id);
	public Cliente read(int id);
	public List<Cliente> readAll();
}
