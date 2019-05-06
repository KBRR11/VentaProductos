package pe.edu.upeu.venta.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;

import pe.edu.upeu.ventas.dao.CategoriaDao;
import pe.edu.upeu.ventas.dao.ProductoDao;
import pe.edu.upeu.ventas.daoImp.CategoriaDaoImp;
import pe.edu.upeu.ventas.daoImp.ProductoDaoImp;
import pe.edu.upeu.ventas.entity.Producto;




@WebServlet("/hc")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductoDao pd = new ProductoDaoImp();   
    private CategoriaDao cd = new CategoriaDaoImp();
    private Gson g = new Gson();
	
    
    public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		//System.out.println(request.getParameter("opc"));
		int op = Integer.parseInt(request.getParameter("opc"));
		int x = 0;
		switch (op) {
		case 1:	
			out.println(g.toJson(cd.readAll()));
			
		break;	
		case 2:	
			out.println(g.toJson(pd.readAll()));		 
			break;
		case 3:	
			int w = Integer.parseInt(request.getParameter("id"));
			if(w==0) {
			x = pd.create(new Producto(0,Integer.parseInt(request.getParameter("cat")),request.getParameter("prod"),
					Double.parseDouble(request.getParameter("precio")),Integer.parseInt(request.getParameter("cant"))));
			out.println("Registro guardado correctamente..!");
			}else {
				out.println(g.toJson(pd.read(w)));
			}
			break;
		case 4:	
			out.println(g.toJson(pd.delete(Integer.parseInt(request.getParameter("id")))));		 
			break;
		case 5:
			int a = Integer.parseInt(request.getParameter("id"));
			if(a==0) {
			x = pd.create(new Producto(0,Integer.parseInt(request.getParameter("cat")),request.getParameter("prod"),
					Double.parseDouble(request.getParameter("precio")),Integer.parseInt(request.getParameter("cant"))));
			out.println("Registro guardado correctamente..!");
			}else {
			x = pd.update(new Producto(a,Integer.parseInt(request.getParameter("cat")),request.getParameter("prod"),
					Double.parseDouble(request.getParameter("precio")),Integer.parseInt(request.getParameter("cant"))));
			out.println("Modificado correctamente..!");
			}
			}
			
    }
		
    
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		} 
	
}
