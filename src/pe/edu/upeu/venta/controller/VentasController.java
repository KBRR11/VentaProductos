package pe.edu.upeu.venta.controller;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.ventas.dao.ClienteDao;
import pe.edu.upeu.ventas.dao.DetalleVentaDao;
import pe.edu.upeu.ventas.dao.UsuarioDao;
import pe.edu.upeu.ventas.dao.VentasDao;
import pe.edu.upeu.ventas.daoImp.ClienteDaoImp;
import pe.edu.upeu.ventas.daoImp.DetalleVentaDaoImp;
import pe.edu.upeu.ventas.daoImp.UsuarioDaoImp;
import pe.edu.upeu.ventas.daoImp.VentasDaoImp;
import pe.edu.upeu.ventas.entity.Cliente;
import pe.edu.upeu.ventas.entity.DetalleVenta;
import pe.edu.upeu.ventas.entity.Producto;
import pe.edu.upeu.ventas.entity.Ventas;

/**
 * Servlet implementation class VentasController
 */
@WebServlet("/vc")
public class VentasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VentasDao vtd = new VentasDaoImp();
	private UsuarioDao ud = new UsuarioDaoImp();
	private ClienteDao cld = new ClienteDaoImp();
	private DetalleVentaDao dvd = new DetalleVentaDaoImp();
	private Gson g = new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//System.out.println(request.getParameter("opc"));
		int op = Integer.parseInt(request.getParameter("opc"));
		int x = 0;
		int y =0;
		int d=0;
		switch (op) {
		case 1:	
			x = cld.create(new Cliente(0,request.getParameter("nomcliente"), request.getParameter("dnicliente")));
			out.println("Registro guardado correctamente..!");//no me dice esto
			
			break;
		case 2:
			out.println(g.toJson(cld.readAll()));
			
			break;
	    case 3:
	    	
	    	y= vtd.create(new Ventas(0, Integer.parseInt(request.getParameter("vendedor")),Integer.parseInt(request.getParameter("id")) , request.getParameter("doc"), request.getParameter("fecha")));
	    	out.println(" guardado correctamente..!");
			
	    	break;
	    case 4: 
	    	int w = Integer.parseInt(request.getParameter("id"));
			
	    	out.println(g.toJson(vtd.readByCliente(w)));//estoy trabajando en esto
	    	break;
	    	
	    case 5: 
	    	d= dvd.create(new DetalleVenta(0,Integer.parseInt(request.getParameter("idvent")),Integer.parseInt(request.getParameter("id")),Double.parseDouble(request.getParameter("precioto")),Integer.parseInt(request.getParameter("cantvent"))));
	    	out.println("Venta Exitosa..!");
	    	//out.println(g.toJson(dvd.));
	    	break;
	    case 6:
            int s = Integer.parseInt(request.getParameter("id"));
			
	    	out.println(g.toJson(dvd.readByVenta(s)));
	    	break;
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
