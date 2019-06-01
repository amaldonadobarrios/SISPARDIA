package control.efectivo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EfectivoDAO;
import dao.EfectivoSituacionDAO;
import entity.Efectivo;
import entity.EfectivoSituacion;

/**
 * Servlet implementation class Sefectivo
 */
@WebServlet("/Sefectivo")
public class Sefectivo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Sefectivo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesar(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		procesar(request, response);
	}

	private void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.getClass().getName());
		HttpSession sesion = request.getSession();
		String ID = (String) sesion.getAttribute("ID");
		String usuario=null;
		if (sesion.getAttribute("ID") != null) {
			if (ID.equals(sesion.getId())) {
				if (sesion.getAttribute("CIP") != null) {
						usuario=(String)sesion.getAttribute("CIP");
					String action = request.getParameter("action") != null ? request.getParameter("action") : "";

					switch (action) {
					case "regefectivo":
						this.regefectivo(request, response,usuario);
						break;	
					case "getefe":
						this.getefe(request, response,usuario);
						break;
					case "getefecip":
						this.getefecip(request, response,usuario);
						break;	
					case "regSituacion":
						this.regSituacion(request, response,usuario);
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

	private void regSituacion(HttpServletRequest request, HttpServletResponse response, String usuario) throws ServletException, IOException {
		String idefectivo = request.getParameter("idefectivo") != null ? request.getParameter("idefectivo") : "";
		String txtsituacion = request.getParameter("txtsituacion") != null ? request.getParameter("txtsituacion") : "";
		String indeterminado = request.getParameter("indeterminado") != null ? request.getParameter("indeterminado") : "";
		String txtfechaini = request.getParameter("txtfechaini") != null ? request.getParameter("txtfechaini") : "";
		String txtfecharange = request.getParameter("txtfecharange") != null ? request.getParameter("txtfecharange") : "";
		String txtobservaciones = request.getParameter("txtobservaciones") != null ? request.getParameter("txtobservaciones") : "";
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		EfectivoSituacion efesitu=null;
		Date fini=null;
		Date ffin=null;
		Calendar hoy = Calendar.getInstance(); // locale-specific
		hoy.setTime(new Date());
		hoy.set(Calendar.HOUR_OF_DAY, 0);
		hoy.set(Calendar.MINUTE, 0);
		hoy.set(Calendar.SECOND, 0);
		hoy.set(Calendar.MILLISECOND, 0);
		int msg=100;
		if (idefectivo.equals("")) {
			msg=3;
			request.setAttribute("msg", msg);
			request.setAttribute("breadcrumb", "Agregar Situacion");
			request.setAttribute("body", "agresit");
			forwar("template.jsp", request, response);
		}else {
			if (indeterminado.equals("on")) {
				try {fini=format.parse (txtfechaini);} catch (ParseException e) {
				msg=4; 
				request.setAttribute("msg", msg);
				request.setAttribute("breadcrumb", "Agregar Situacion");
				request.setAttribute("body", "agresit");
				forwar("template.jsp", request, response);}
				if (fini.after(new Date())|| fini.equals(hoy.getTime())) {
					// registra  situacion  con solo fecha ini
					efesitu= new  EfectivoSituacion(0, 1, ffin, fini, Integer.parseInt(idefectivo), Integer.parseInt(txtsituacion), 1, txtobservaciones.toUpperCase().trim(), usuario);
					EfectivoSituacionDAO dao= new EfectivoSituacionDAO();
					msg=dao.grabar(efesitu);
					request.setAttribute("msg", msg);
					request.setAttribute("breadcrumb", "Agregar Situacion");
					request.setAttribute("body", "agresit");
					forwar("template.jsp", request, response);	
				}else {
					//error 
					msg=7;
					request.setAttribute("msg", msg);
					request.setAttribute("breadcrumb", "Agregar Situacion");
					request.setAttribute("body", "agresit");
					forwar("template.jsp", request, response);
				}
				
				
			}else {
				
				String[] parts = txtfecharange.split("-");
				String fechainicial=parts[0].trim();
				String fechafinal=parts[1].trim();
				try {
					fini=format.parse (fechainicial);
					ffin=format.parse (fechafinal);
				} catch (ParseException e) {
				msg=4; 
				request.setAttribute("msg", msg);
				request.setAttribute("breadcrumb", "Agregar Situacion");
				request.setAttribute("body", "agresit");
				forwar("template.jsp", request, response);
				}
				if (fini.after(new Date())|| fini.equals(hoy.getTime())) {
					if (ffin.before(fini)|| fini.equals(fini)) {
						// registra  situacion  con rango de fechas
						efesitu= new  EfectivoSituacion(0, 1, ffin, fini, Integer.parseInt(idefectivo), Integer.parseInt(txtsituacion), 0, txtobservaciones.toUpperCase().trim(), usuario);
						EfectivoSituacionDAO dao= new EfectivoSituacionDAO();
						msg=dao.grabar(efesitu);
						request.setAttribute("msg", msg);
						request.setAttribute("breadcrumb", "Agregar Situacion");
						request.setAttribute("body", "agresit");
						forwar("template.jsp", request, response);	
	
					}else {
					//error 
					msg=7;
					request.setAttribute("msg", msg);
					request.setAttribute("breadcrumb", "Agregar Situacion");
					request.setAttribute("body", "agresit");
					forwar("template.jsp", request, response);
					}
				}else {
					//error 
					msg=7;
					request.setAttribute("msg", msg);
					request.setAttribute("breadcrumb", "Agregar Situacion");
					request.setAttribute("body", "agresit");
					forwar("template.jsp", request, response);	
				}	
			}
		}	
	}

	private void getefecip(HttpServletRequest request, HttpServletResponse response, String usuario) throws ServletException, IOException {
		String cipefectivo = request.getParameter("bcip") != null ? request.getParameter("bcip") : "";
		EfectivoDAO dao = new EfectivoDAO();
		EfectivoSituacionDAO  daosit= new  EfectivoSituacionDAO();
		Efectivo ef=null;
		try {
			ef=dao.GetEfectivosxcip(cipefectivo);
			request.setAttribute("objefe", ef);
			request.setAttribute("msg", 1);
		} catch (Exception e1) {
		}
		if (ef==null) {
			request.setAttribute("msg", 0);
		}else {
			request.setAttribute("msg", 1);
			try {
				request.setAttribute("lista", daosit.ListaEfectivoSituacion(cipefectivo));
			} catch (Exception e) {
			}
		}
		request.setAttribute("breadcrumb", "Agregar Situacion");
		request.setAttribute("body", "agresit");
		forwar("template.jsp", request, response);
		
	}

	private void getefe(HttpServletRequest request, HttpServletResponse response, String usuario) throws ServletException, IOException {
		String idefectivo = request.getParameter("id") != null ? request.getParameter("id") : "";
		EfectivoDAO dao = new EfectivoDAO();
		Efectivo ef= new Efectivo();
		ef.setIdefectivo(Integer.parseInt(idefectivo));
		try {
			ef=dao.GetEfectivo(ef);
			request.setAttribute("objefe", ef);
		} catch (Exception e1) {}
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

	private void regefectivo(HttpServletRequest request, HttpServletResponse response, String usuario) throws ServletException, IOException {
		String idefectivo = request.getParameter("idefectivo") != null ? request.getParameter("idefectivo") : "";
		String txtapepat = request.getParameter("txtapepat") != null ? request.getParameter("txtapepat") : "";
		String txtapemat = request.getParameter("txtapemat") != null ? request.getParameter("txtapemat") : "";
		String txtnombres = request.getParameter("txtnombres") != null ? request.getParameter("txtnombres") : "";
		String txtdni = request.getParameter("txtdni") != null ? request.getParameter("txtdni") : "";
		String txtemail = request.getParameter("txtemail") != null ? request.getParameter("txtemail") : "";
		String txttelefono = request.getParameter("txttelefono") != null ? request.getParameter("txttelefono") : "";
		String txtdomicilio = request.getParameter("txtdomicilio") != null ? request.getParameter("txtdomicilio") : "";
		String txtcip = request.getParameter("txtcip") != null ? request.getParameter("txtcip") : "";
		String txtgrado = request.getParameter("txtgrado") != null ? request.getParameter("txtgrado") : "";
		String txtjerarquia = request.getParameter("txtjerarquia") != null ? request.getParameter("txtjerarquia") : "";
		String txtarea = request.getParameter("txtarea") != null ? request.getParameter("txtarea") : "";
		String txtcargo = request.getParameter("txtcargo") != null ? request.getParameter("txtcargo") : "";
		String txtmodalidad = request.getParameter("txtmodalidad") != null ? request.getParameter("txtmodalidad") : "";
		String txtestado = request.getParameter("txestado") != null ? request.getParameter("txestado") : "";
		if (idefectivo.equals("")) {
			idefectivo="0";
		}
		EfectivoDAO dao = new EfectivoDAO();
		Efectivo e= new Efectivo(Integer.parseInt(idefectivo), txtapemat.toUpperCase().trim(), txtapepat.toUpperCase().trim(), txtcip.trim(), txtemail.toLowerCase().trim(), txtdni.trim(), txtdomicilio.toUpperCase().trim(), Integer.parseInt(txtestado), new Date(), new Date(), Integer.parseInt(txtgrado.trim()), Integer.parseInt(txtarea), Integer.parseInt(txtcargo), Integer.parseInt(txtjerarquia), Integer.parseInt(txtmodalidad), txtnombres.toUpperCase().trim(), txttelefono.trim(), usuario, usuario);
		boolean rpta=dao.grabar(e);
		int estado=0;
		if (rpta) {
			estado=1;
		}
		try {
			request.setAttribute("lista", dao.GetEfectivos());
		} catch (Exception ex) {}
		request.setAttribute("msg", estado);
		request.setAttribute("breadcrumb", "Registrar Efectivo");
		request.setAttribute("body", "regefectivo");
		forwar("template.jsp", request, response);
			
		
		
		
		
		
		
		
		
		
	}

	public void forwar(String jsp, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher(jsp).forward(req, resp);
	}
	private void pagelogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		forwar("index.jsp", request, response);
	}
}
