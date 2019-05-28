package test;

import java.util.List;

import dao.UsuarioDAO;
import entity.Usuario;

public class TestDAO {

	public static void main(String[] args) throws Exception {
		 InsertarUsuario();
		// ActualizarUsuario();
		// ListarUsuario();
		// ListarUsuarioxid(11);
		//validarusuario("31424836", "123456");

	}

	public static void InsertarUsuario() throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usu = new Usuario(0, 1, "maldonado2", "barrios", "alexander", "31424836", "123456", "444", "31424836","160");
		String respuesta = dao.InsertarUsuario(usu);
		System.out.println("TEST.TestDAO.main() InsertarUsuario : Respuesta: " + respuesta);
	}

	public static void ActualizarUsuario() throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usu = new Usuario(12, 1, "maldonado111111", "barrios66", "alexander66", "31424836", "123456", "666",
				"31424836","s1");
		String respuesta = dao.actualizarUsuario(usu);
		System.out.println("TEST.TestDAO.main() ActualizarUsuario : Respuesta: " + respuesta);
	}

	private static void ListarUsuario() throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> respuesta = dao.getUsuarios();
		System.out.println("TEST.TestDAO.main() ListarUsuario : Respuesta: " + respuesta.toString());
	}

	private static void ListarUsuarioxid(int id) throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario respuesta = dao.getUsuarioXid(id);
		System.out.println("TEST.TestDAO.main() ListarUsuarioxid : Respuesta: " + respuesta.toString());
	}

	private static void validarusuario(String cip, String pass) throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario respuesta = dao.validarAcceso(cip, pass);
		System.out.println("TEST.TestDAO.main() validarusuario : Respuesta: " + respuesta.toString());

	}

}
