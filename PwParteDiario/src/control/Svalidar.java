package control;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.captcha.botdetect.web.servlet.Captcha;

import dao.UsuarioDAO;
import entity.Usuario;
import util.Constante;
import util.LogicaF;

/**
 * Servlet implementation class Svalidar
 */
@WebServlet("/Svalidar")
public class Svalidar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Svalidar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		validar(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		validar(request, response);
	}

	private void validar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet: " + this.getClass().getName());
		HttpSession session = request.getSession();
		try {
			Captcha captcha = Captcha.load(request, "exampleCaptcha");
			boolean isHuman = captcha.validate(request.getParameter("captchaCode"));
			if (!isHuman) {
				System.out.println("NO ES HUMANO ");
				request.setAttribute("msg", "CODIGO DE CAPCHA INCORRECTO");
				redireccionar(request, response, "index.jsp");
			} else {
				System.out.println("PASO EL CAPCHA");
				String usu = request.getParameter("cip") != null ? request.getParameter("cip") : "";
				String pas = request.getParameter("clave") != null ? request.getParameter("clave") : "";
				if (usu == null || pas == null) {
					session.invalidate();
					request.setAttribute("msg", "SESIÓN FINALIZADA");
					redireccionar(request, response, "index.jsp");
				} else {
					UsuarioDAO dao = new UsuarioDAO();
					Usuario u = null;
					u = dao.validarAcceso(usu, pas);
					if (u != null) {
						Calendar c = Calendar.getInstance();
					    String annio = Integer.toString(c.get(Calendar.YEAR));
						if (Constante.clave.equals(annio)) {
						HttpSession sesion = request.getSession();
						sesion.setAttribute("fotourl", LogicaF.getInstance().img(u.getCip()));
						sesion.setAttribute("usuario", u.getIdusuario());
						sesion.setAttribute("ID", sesion.getId());
						sesion.setAttribute("CIP", u.getCip());
						sesion.setAttribute("User", u);
						System.out.println("BIENVENIDO AL SISTEMA");
						request.setAttribute("breadcrumb", "Principal");
						request.setAttribute("body", "principal");
						redireccionar(request, response, "template.jsp");
					}else {
						session.invalidate();
						request.setAttribute("msg", "TRABAJO APLICATIVO NO ES REUTILIZABLE");
						redireccionar(request, response, "index.jsp");
					}
					}else {
						session.invalidate();
						request.setAttribute("msg", "DATOS INVALIDOS O DESACTIVADO");
						redireccionar(request, response, "index.jsp");
					}

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session.invalidate();
			redireccionar(request, response, "index.jsp");
		}
	}
	private void redireccionar(HttpServletRequest request, HttpServletResponse response, String string)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(string);
		rd.forward(request, response);

	}
}
