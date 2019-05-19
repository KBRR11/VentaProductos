package pe.edu.upeu.ventas.test;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import pe.edu.upeu.ventas.dao.ClienteDao;
import pe.edu.upeu.ventas.dao.DetalleVentaDao;
import pe.edu.upeu.ventas.dao.ProductoDao;
import pe.edu.upeu.ventas.dao.VentasDao;
import pe.edu.upeu.ventas.daoImp.ClienteDaoImp;
import pe.edu.upeu.ventas.daoImp.DetalleVentaDaoImp;
import pe.edu.upeu.ventas.daoImp.ProductoDaoImp;
import pe.edu.upeu.ventas.daoImp.VentasDaoImp;
import pe.edu.upeu.ventas.entity.Producto;
import pe.edu.upeu.ventas.entity.Ventas;
import pe.edu.upeu.ventas.entity.Cliente;
import pe.edu.upeu.ventas.entity.DetalleVenta;
import pe.edu.upeu.venta.controller.HomeController;


public class Test {
    private static ProductoDao dao = new ProductoDaoImp();
    private static ClienteDao cldao = new ClienteDaoImp();
    private static DetalleVentaDao dvd = new DetalleVentaDaoImp();
    private static VentasDao vedao = new VentasDaoImp();
    private static List<Cliente> cl = new ArrayList<>();
    private static List<Producto> al = new ArrayList<>();
    private static List<Ventas> ve = new ArrayList<>();
    private static Gson g = new Gson();
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//modificar();
		//listar();
		guardarDVenta();
		//read();
		//delete();
	}
    
	static void guardarDVenta() {
		int x = dvd.create(new DetalleVenta(0,53,1,21.7,10));
		System.out.println(x);
	}
	
	static void guardar() {
		int x = cldao.create(new Cliente(0,"Pedro","123456"));
		System.out.println(x);
	}
	static void guardarVenta() {
		int x = vedao.create(new Ventas(0,1,4,"Factura","2019/05/08"));
		System.out.println(x);
	}
	static void modificar() {
		
		int x = dao.update(new Producto(12,2,"leche de mipalo",14,1));
		System.out.println(x);
	}
	
	static void delete() {
		int x = dao.delete(7);
		System.out.println(x);
	}
	
	
}
