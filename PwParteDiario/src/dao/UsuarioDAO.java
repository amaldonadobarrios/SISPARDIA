package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Usuario;

public class UsuarioDAO {
	Connection con = null;

//declaramos los metodos para el mantenimiento de la tabla usuarios
//metodo para insertar
	public String InsertarUsuario(Usuario usu) throws Exception {
		String mensaje = null;
		String sqlResult = "";
		con = AccesoBD.getConnection();
		sqlResult = "INSERT INTO USUARIOPNP ( IDUSUARIO,APEPAT,APEMAT, NOMBRES,ESTADO,CIP, PASSWORD,USUREG, GRADO) VALUES(SEC_USUARIOPNP.nextval,?,?,?,?,?,?,?,?)";
		if (con != null) {
			try {
				PreparedStatement ps = con.prepareStatement(sqlResult);
				ps.setString(1, usu.getApepat().toUpperCase().trim());
				ps.setString(2, usu.getApemat().toUpperCase().trim());
				ps.setString(3, usu.getNombres().toUpperCase().trim());
				ps.setInt(4, usu.getEstado());
				ps.setString(5, usu.getCip().trim());
				ps.setString(6, usu.getPassword());
				ps.setString(7, usu.getUsureg());
				ps.setInt(8, usu.getGrado());
				int i = ps.executeUpdate();
				if (i > 0) {
					con.commit();
					mensaje = "OK";
				} else {
					con.rollback();
					mensaje = "NO OK";
				}
			} catch (SQLException e) {
				throw new Exception("Problemas del sistema..." + e.getMessage());
			} finally {
				try {
					con.close();
				} catch (SQLException ex) {
				}
			}
		}
		return mensaje;
	}

// metodo actualizar
	public String actualizarUsuario(Usuario usu) throws Exception {
		String mensaje = null;
		String sqlResult = "";
		con = AccesoBD.getConnection();
		sqlResult = "UPDATE USUARIOPNP  SET APEPAT=?,APEMAT=?, NOMBRES=?,ESTADO=?,CIP=?, PASSWORD=?,USUMOD=? , FECHAMOD=SYSDATE, GRADO=? WHERE idusuario=?";
		if (con != null) {
			try {
				PreparedStatement ps = con.prepareStatement(sqlResult);
				ps.setString(1, usu.getApepat().toUpperCase().trim());
				ps.setString(2, usu.getApemat().toUpperCase().trim());
				ps.setString(3, usu.getNombres().toUpperCase().trim());
				ps.setInt(4, usu.getEstado());
				ps.setString(5, usu.getCip().trim());
				ps.setString(6, usu.getPassword());
				ps.setString(7, usu.getUsumod());
				ps.setInt(8, usu.getGrado());
				ps.setInt(9, usu.getIdusuario());
				int i = ps.executeUpdate();
				if (i > 0) {
					con.commit();
					mensaje = "OK";
				} else {
					con.rollback();
					mensaje = "NO OK";
				}
			} catch (SQLException e) {
				throw new Exception("Problemas del sistema... " + e.getMessage());
			} finally {
				try {
					con.close();
				} catch (SQLException ex) {
				}
			}
		}

		return mensaje;
	}

	// metodo para listar usuarios
	public List<Usuario> getUsuarios() throws Exception {
		String sqlResult = "";
		List<Usuario> listTemp = null;

		try {
			con = AccesoBD.getConnection();
			sqlResult = "select * from USUARIOPNP USU INNER JOIN GRADO GRA ON GRA.TGRAD=USU.GRADO";
		} catch (Throwable ex) {
			throw new Exception("Problemas del sistema...");
		}
		if (con != null) {

			try {
				PreparedStatement ps = con.prepareStatement(sqlResult);
				ResultSet rs = ps.executeQuery();
				listTemp = new ArrayList<>();
				Usuario usu;
				while (rs.next()) {
					usu = new Usuario(rs.getInt("IDUSUARIO"), rs.getInt("estado"), rs.getString("APEPAT"),
							rs.getString("APEMAT"), rs.getString("nombres"), rs.getString("cip"),
							rs.getString("password"), rs.getString("usumod"), rs.getString("usureg"),rs.getInt("GRADO"));
					usu.setDesgrad(rs.getString("DESGRAD"));
					listTemp.add(usu);
				}
			} catch (SQLException e) {
				throw new Exception("Problemas del sistema..." + e.getMessage());
			} finally {
				try {
					con.close();
				} catch (SQLException ex) {
				}
			}
		}
		return listTemp;
	}

	// metodo para consultar un usuario por su id
	public Usuario getUsuarioXid(int id) throws Exception {
		String sqlResult = "";
		Usuario usu = null;

		try {
			con = AccesoBD.getConnection();
			sqlResult = "select * from USUARIOPNP USU \r\n" + 
					"INNER JOIN GRADO GRA ON GRA.TGRAD=USU.GRADO\r\n" + 
					"where USU.idusuario=?";
		} catch (Throwable ex) {
			throw new Exception("Problemas del sistema...");
		}

		if (con != null) {

			try {
				PreparedStatement ps = con.prepareStatement(sqlResult);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					usu = new Usuario(rs.getInt("IDUSUARIO"), rs.getInt("estado"), rs.getString("APEPAT"),
							rs.getString("APEMAT"), rs.getString("nombres"), rs.getString("cip"),
							rs.getString("password"), rs.getString("usumod"), rs.getString("usureg"),rs.getInt("GRADO"));
					usu.setDesgrad(rs.getString("DESGRAD"));
				}

			} catch (SQLException e) {
				throw new Exception("Problemas del sistema...");
			} finally {
				try {
					con.close();
				} catch (SQLException ex) {
				}
			}
		}

		return usu;
	}

	// metodo para validar un usuario
	public Usuario validarAcceso(String usuario, String clave) throws Exception {
		String sqlResult = "";
		Usuario usu = null;
		try {
			con = AccesoBD.getConnection();
			sqlResult = "select USU.IDUSUARIO,USU.ESTADO,USU.APEMAT,USU.APEPAT,USU.NOMBRES,USU.CIP,USU.PASSWORD,USU.USUMOD,USU.USUREG,USU.GRADO, GRA.DESGRAD from USUARIOPNP USU  INNER JOIN GRADO GRA ON GRA.TGRAD=USU.GRADO where USU.cip=? and USU.password=? and USU.estado=1";
		} catch (Throwable ex) {
			System.out.println(ex.getMessage());
			throw new Exception("Problemas del sistema...");
		}

		if (con != null) {

			try {
				PreparedStatement ps = con.prepareStatement(sqlResult);
				ps.setString(1, usuario);
				ps.setString(2, clave);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					usu = new Usuario(rs.getInt("IDUSUARIO"), rs.getInt("estado"), rs.getString("APEPAT"),
							rs.getString("APEMAT"), rs.getString("nombres"), rs.getString("cip"),
							rs.getString("password"), rs.getString("usumod"), rs.getString("usureg"),rs.getInt("GRADO"));
					usu.setDesgrad(rs.getString("DESGRAD"));
				}

			} catch (SQLException e) {
				throw new Exception("Problemas del sistema...");
			} finally {
				try {
					con.close();
				} catch (SQLException ex) {
				}
			}
		}
		System.out.println(usu.toString());
		return usu;

	}
	public Usuario getUsuarioXcip(String id) throws Exception {
		String sqlResult = "";
		Usuario usu = null;

		try {
			con = AccesoBD.getConnection();
			sqlResult = "select * from USUARIOPNP USU \r\n" + 
					"LEFT JOIN GRADO GRA ON GRA.TGRAD=USU.GRADO\r\n" + 
					"where USU.cip=?";
		} catch (Throwable ex) {
			throw new Exception("Problemas del sistema...");
		}

		if (con != null) {

			try {
				PreparedStatement ps = con.prepareStatement(sqlResult);
				ps.setString(1, id);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					usu = new Usuario(rs.getInt("IDUSUARIO"), rs.getInt("estado"), rs.getString("APEPAT"),
							rs.getString("APEMAT"), rs.getString("nombres"), rs.getString("cip"),
							rs.getString("password"), rs.getString("usumod"), rs.getString("usureg"),rs.getInt("GRADO"));
				}
			} catch (SQLException e) {
				throw new Exception("Problemas del sistema...");
			} finally {
				try {
					con.close();
				} catch (SQLException ex) {
				}
			}
		}

		return usu;
	}

}
