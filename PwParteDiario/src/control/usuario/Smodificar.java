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
 * Servlet implementation class Smodificar
 */
@WebServlet("/Smodificar")
public class Smodificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Smodificar() {
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
		String evento=request.getParameter("evento");
		String cip=null;
		String apepat=request.getParameter("txtapepat");
		String apemat=request.getParameter("txtapemat");
		String nombres=request.getParameter("txtnom");
		String estado=request.getParameter("txtest");
		String pass=request.getParameter("txtpass");
		String pass2=request.getParameter("txtpass2");
		String idusuario=request.getParameter("txtid");
		String grado=request.getParameter("txtgrado");
		String rpt=null;
		Usuario usu=null;
		if (evento!=null) {
			switch (evento) {
			case "buscar":
				cip=request.getParameter("bcip");
				try {
					UsuarioDAO dao= new UsuarioDAO();
					usu=dao.getUsuarioXcip(cip);
					
					if (usu!=null) {
						request.setAttribute("objusu", usu);
						request.setAttribute("msg", 1);
						request.setAttribute("breadcrumb", "Registrar Usuario");
						request.setAttribute("body", "modusu");
						request.getRequestDispatcher("template.jsp").forward(request, response);
					}else {
						request.setAttribute("msg", 0);
						request.setAttribute("breadcrumb", "Registrar Usuario");
						request.setAttribute("body", "modusu");
						request.getRequestDispatcher("template.jsp").forward(request, response);
					}
					
				} catch (Exception e) {
					request.setAttribute("msg", 0);
					request.setAttribute("breadcrumb", "Registrar Usuario");
					request.setAttribute("body", "modusu");
					request.getRequestDispatcher("template.jsp").forward(request, response);
				}
				
				break;
			case "modificar":
				cip=request.getParameter("txtcip");
					if (pass.equals(pass2)) {
						
						usu=new Usuario(Integer.parseInt(idusuario), Integer.parseInt(estado), apepat, apemat, nombres, cip, pass, "1", "1",grado);
						UsuarioDAO dao= new UsuarioDAO();
						try {
							rpt=dao.actualizarUsuario(usu);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (rpt!=null) {
							if (rpt.equals("OK")) {
								request.setAttribute("msg1", 1);
								request.setAttribute("breadcrumb", "Registrar Usuario");
								request.setAttribute("body", "modusu");
								request.getRequestDispatcher("template.jsp").forward(request, response);
							}else{
								request.setAttribute("msg1", 0);
								request.setAttribute("breadcrumb", "Registrar Usuario");
								request.setAttribute("body", "modusu");
								request.getRequestDispatcher("template.jsp").forward(request, response);
							}	
						}else {
							request.setAttribute("msg1", 0);
							request.setAttribute("breadcrumb", "Registrar Usuario");
							request.setAttribute("body", "modusu");
							request.getRequestDispatcher("template.jsp").forward(request, response);
						}
					}else {
						request.setAttribute("msg1", 0);
						request.setAttribute("breadcrumb", "Registrar Usuario");
						request.setAttribute("body", "modusu");
						request.getRequestDispatcher("template.jsp").forward(request, response);
					}		
				break;

			default:
				break;
			}
		}else {
			//error evento null
			request.setAttribute("msg", "Evento null");
			request.getRequestDispatcher("modusu.jsp").forward(request, response);
		}
		
	}

}
