package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EfectivoDAO;
import dao.UsuarioDAO;
import entity.Usuario;

/**
 * Servlet implementation class SPage
 */
@WebServlet("/SPage")
public class SPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(this.getClass().getName());
		HttpSession sesion = request.getSession();
		String ID = (String) sesion.getAttribute("ID");
		if (sesion.getAttribute("ID") != null) {
			if (ID.equals(sesion.getId())) {
				if (sesion.getAttribute("CIP") != null) {

					String action = request.getParameter("action") != null ? request.getParameter("action") : "";

					switch (action) {
					case "pagehome":
						this.pagehome(request, response);
						break;
					case "salir":
						this.salir(request, response);
						break;
					case "login":
						this.pagelogin(request, response);
						break;
					case "regusu":
						this.regusu(request, response);
						break;
					case "listusu":
						this.listusu(request, response);
						break;
					case "modusu":
						this.modusu(request, response);
						break;
					case "regefe":
						this.regefe(request, response);
						break;
					case "agresit":
						this.agresit(request, response);
						break;	
					default:
						this.pagelogin(request, response);
						break;
					}

				} else {
					request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
					sesion.invalidate();
					System.out.println("DESTINO:" + "index.jsp");
					forwar("index.jsp", request, response);

				}

			} else {
				request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
				sesion.invalidate();
				System.out.println("DESTINO:" + "index.jsp");
				forwar("index.jsp", request, response);
			}
		} else {
			request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
			sesion.invalidate();
			System.out.println("DESTINO:" + "index.jsp");
			forwar("index.jsp", request, response);
		}
	}

	private void agresit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("breadcrumb", "Agregar Situacion");
		request.setAttribute("body", "agresit");
		forwar("template.jsp", request, response);
		
	}

	private void regefe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EfectivoDAO dao = new EfectivoDAO();
		try {
			request.setAttribute("lista", dao.GetEfectivos());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("breadcrumb", "Registrar Efectivo");
		request.setAttribute("body", "regefectivo");
		forwar("template.jsp", request, response);
		
	}

	private void salir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		request.setAttribute("msg", "SESION FINALIZADA");
		forwar("index.jsp", request, response);
		
	}

	private void listusu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO dao=new UsuarioDAO();
		List<Usuario> lista= new ArrayList<Usuario>();
		try {
			lista= dao.getUsuarios();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("lista", lista);
		request.setAttribute("msg", 1);
		request.setAttribute("breadcrumb", "Listar Usuario");
		request.setAttribute("body", "listusu");
		forwar("template.jsp", request, response);
		
	}

	private void modusu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("breadcrumb", "Modificar Usuario");
		request.setAttribute("body", "modusu");
		forwar("template.jsp", request, response);
		
	}

	private void regusu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("breadcrumb", "Registrar Usuario");
		request.setAttribute("body", "regusuario");
		forwar("template.jsp", request, response);
		
	}

	public void forwar(String jsp, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher(jsp).forward(req, resp);
	}

	private void pagehome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("breadcrumb", "Principal");
		request.setAttribute("body", "principal");
		forwar("template.jsp", request, response);
	}

	private void pagelogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		forwar("index.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
