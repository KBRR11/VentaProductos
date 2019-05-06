package pe.edu.upeu.venta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.ventas.dao.RolDao;
import pe.edu.upeu.ventas.dao.UsuarioDao;
import pe.edu.upeu.ventas.daoImp.RolDaoImp;
import pe.edu.upeu.ventas.daoImp.UsuarioDaoImp;
import pe.edu.upeu.ventas.entity.Producto;
import pe.edu.upeu.ventas.entity.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/lc")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsuarioDao ud = new UsuarioDaoImp();
    private RolDao rd = new RolDaoImp();
    private Gson g = new Gson();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		//System.out.println(request.getParameter("opc"));
		int op = Integer.parseInt(request.getParameter("opc"));
		String x = "";
		String y = "";
		switch (op) {
		case 1:	
		 x = request.getParameter("user");
		 y = request.getParameter("pass");
		 Usuario u = new Usuario();
		 u.setIdusuario(0);
		 u = ud.Validar(x, y);
		 
			out.println(g.toJson(u));
			
		break;	
		case 2:	
			out.println(g.toJson(rd.readAll()));		 
			break;
		/*case 3:	
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
			}*/
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
