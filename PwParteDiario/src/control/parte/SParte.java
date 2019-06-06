package control.parte;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dao.ParteDiarioDAO;
import entity.Partediario;
import util.GenerarPDF;

/**
 * Servlet implementation class SParte
 */
@WebServlet("/SParte")
public class SParte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SParte() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	private void procesar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(this.getClass().getName());
		HttpSession sesion = request.getSession();
		String ID = (String) sesion.getAttribute("ID");
		String usuario = null;
		if (sesion.getAttribute("ID") != null) {
			if (ID.equals(sesion.getId())) {
				if (sesion.getAttribute("CIP") != null) {
					usuario = (String) sesion.getAttribute("CIP");
					String action = request.getParameter("action") != null ? request.getParameter("action") : "";

					switch (action) {
					case "genParte":
						this.genParte(request, response, usuario);
						break;
					case "conParte":
						this.conParte(request, response, usuario);
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

	private void conParte(HttpServletRequest request, HttpServletResponse response, String usuario) throws IOException {
		String id=request.getParameter("id");
		ParteDiarioDAO partedao= new ParteDiarioDAO();
		byte[] blob=partedao.DownloadParte(Integer.parseInt(id));
		ByteArrayOutputStream baos = new ByteArrayOutputStream(blob.length);
		baos.write(blob);
		ServletOutputStream sos = null;
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=" + "ParteDiario.pdf");
		response.setContentLength(baos.size());
		sos = response.getOutputStream();
		baos.writeTo(sos);
		
	}

	private void genParte(HttpServletRequest request, HttpServletResponse response, String usuario) throws IOException, ServletException {
		GenerarPDF pdf = new GenerarPDF();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formato2 = new SimpleDateFormat("ddMMyyyy");
		SimpleDateFormat formato3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
		String sqlText = "{call GENERARPARTEDIARIO(?,?)}";
		Calendar fechaConsulta = Calendar.getInstance();
		String fechahoy=formato.format(fechaConsulta.getTime());
		String fechahoypdf=formato2.format(fechaConsulta.getTime());
		String fechaGenerarParte=formato3.format(fechaConsulta.getTime());

		//generar rol de servicio
		ParteDiarioDAO partedao= new ParteDiarioDAO();
		PdfPTable tabla = null;
		try {
			String rutaimagenescudo = getServletContext().getRealPath("dist/img/escudopnp.png");
			tabla = pdf.generarTabla(partedao.ejecutarProcedimiento_ListaParteDiario(sqlText, usuario));
			ByteArrayOutputStream baos = pdf.generarPDF("PARTE DIARIO  DEL "+fechahoy, "Generado: "+ fechaGenerarParte, "Usuario Registro :"+usuario, rutaimagenescudo,tabla);
			
			//recuperar el archivo
			byte[] reporte = baos.toByteArray();
			Partediario pd= new Partediario();
			pd.setIdpartediario(0);
			pd.setEstado(1);
			pd.setFechareg(fechaConsulta.getTime());
			pd.setFechaparte(new Date());
			pd.setUsureg(usuario);
			pd.setReporte(reporte);
			partedao.grabarParteDiario(pd);
			//registro de parte diarios
			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Pragma", "public");
			// write ByteArrayOutputStream to the ServletOutputStream
//			OutputStream os = response.getOutputStream();
//			baos.writeTo(os);
//			os.flush();
//			os.close();
			ServletOutputStream sos = null;
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "attachment; filename=" + "ParteDiario"+fechahoypdf+".pdf");
			response.setContentLength(baos.size());
			sos = response.getOutputStream();
			baos.writeTo(sos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
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

}
