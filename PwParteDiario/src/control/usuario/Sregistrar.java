package control.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import entity.Usuario;

/**
 * Servlet implementation class Sregistrar
 */
@WebServlet("/Sregistrar")
public class Sregistrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sregistrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cip=request.getParameter("txtcip");
		String apepat=request.getParameter("txtapepat");
		String apemat=request.getParameter("txtapemat");
		String nombres=request.getParameter("txtnom");
		String estado=request.getParameter("txtest");
		String pass=request.getParameter("txtpass");
		String pass2=request.getParameter("txtpass2");
		String grado=request.getParameter("txtgrado");
		String rpt=null;
		Usuario usu=null;
		
		
		
		try {
			if (pass.equals(pass2)) {
				usu= new Usuario(0, Integer.parseInt(estado), apepat.toUpperCase().trim(), apemat.toUpperCase().trim(), nombres.trim().toUpperCase(), cip.trim(), pass.toUpperCase(), "1", "1",grado);
				UsuarioDAO dao= new  UsuarioDAO();
				rpt=dao.InsertarUsuario(usu);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if (rpt!=null) {
			if (rpt.equals("OK")) {
				request.setAttribute("msg", 1);
				request.setAttribute("breadcrumb", "Registrar Usuario");
				request.setAttribute("body", "regusuario");
				request.getRequestDispatcher("template.jsp").forward(request, response);
				
			}else {
				request.setAttribute("msg", 0);
				request.setAttribute("breadcrumb", "Registrar Usuario");
				request.setAttribute("body", "regusuario");
				request.getRequestDispatcher("template.jsp").forward(request, response);
			}	
		} else {
			request.setAttribute("msg", 0);
			request.setAttribute("breadcrumb", "Registrar Usuario ");
			request.setAttribute("body", "regusuario");
			request.getRequestDispatcher("template.jsp").forward(request, response);
		}
		
		
		
		
		
		
		
	}

}
