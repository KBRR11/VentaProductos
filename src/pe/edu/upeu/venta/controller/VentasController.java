package pe.edu.upeu.venta.controller;

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
import pe.edu.upeu.ventas.entity.Producto;
import pe.edu.upeu.ventas.entity.Ventas;

/**
 * Servlet implementation class VentasController
 */
@WebServlet("/vc")
public class VentasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VentasDao vd = new VentasDaoImp();
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
		switch (op) {
		case 1:	
			int a = Integer.parseInt(request.getParameter("id"));
		if(a==0) {
		x = vd.create(new Ventas(0, Integer.parseInt(request.getParameter("vendedor")), request.getParameter("nomcliente"), null, null));
		out.println("Registro guardado correctamente..!");
		}
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
