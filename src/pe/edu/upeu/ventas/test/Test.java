package pe.edu.upeu.ventas.test;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import pe.edu.upeu.ventas.dao.ProductoDao;
import pe.edu.upeu.ventas.daoImp.ProductoDaoImp;
import pe.edu.upeu.ventas.entity.Producto;
import pe.edu.upeu.venta.controller.HomeController;


public class Test {
    private static ProductoDao dao = new ProductoDaoImp();
    private static List<Producto> al = new ArrayList<>();
    private static Gson g = new Gson();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//modificar();
		//listar();
		//guardar();
		//read();
		//delete();
	}
    
	static void guardar() {
		int x = dao.create(new Producto(0,1,"mipve",12,1));
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
