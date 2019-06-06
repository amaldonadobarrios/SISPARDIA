package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import entity.Efectivo;
import entity.EfectivoSituacion;
import entity.ListaParteDiario;
import entity.Partediario;
import oracle.jdbc.OracleTypes;

public class ParteDiarioDAO {

	
public List<ListaParteDiario> ejecutarProcedimiento_ListaParteDiario(String sp_sql, Object... variablea) throws Exception 
	{
		List<ListaParteDiario> lista=null;
		Connection cn = AccesoBD.getConnection();
		List<Object> tabla = new ArrayList<Object>();
		System.out.println("antes de conexion");
		if (cn != null) {
			System.out.println("entre hay conexion");
		int filas = variablea.length;
		ResultSet rs = null;
		CallableStatement stmt =null;
		try {
			System.out.println(" Entre al try catch");
			stmt = cn.prepareCall(sp_sql);
			stmt.registerOutParameter(1, OracleTypes.CURSOR); // REF CURSOR
			int indice = 2;

			if (filas > 0) {
				for (int i = 0; i < filas; i++) {
					String cariable = (String) variablea[i];
					System.out.println("cariable "+cariable);
					stmt.setString(indice, cariable);
					indice++;
				}
			}

			stmt.execute();
			rs = (ResultSet) stmt.getObject(1);
	         lista= new ArrayList<>();
             while (rs.next()) {
          		ListaParteDiario object = new ListaParteDiario();	
  				object.setArea(rs.getString("AREA"));
  				object.setGrado(rs.getString("GRADO"));
  				object.setApepat(rs.getString("APEPAT"));
  				object.setApemat(rs.getString("APEMAT"));
  				object.setNombres(rs.getString("NOMBRES"));
  				object.setCargo(rs.getString("CARGO"));
  				object.setHorario(rs.getString("HORARIO"));
  				object.setModalidad(rs.getString("MODALIDAD"));
  				object.setJerarquia(rs.getString("JERARQUIA"));
  				object.setSituacion(rs.getString("SITUACION"));
  				object.setRango(rs.getString("RANGO"));
  				object.setObservaciones(rs.getString("OBSERVACIONES"));
  				object.setServicio(rs.getString("SERVICIO"));
  				lista.add(object);
                      
              }

		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
			tabla = null;
		}
		finally
		{
			try {	if(rs!=null ) {rs.close();} 		} catch (SQLException e1) {		}
			try {	if(stmt!=null ) {stmt.close();}	} catch (SQLException e1){	}
			try {	if(cn!=null ) {cn.close();}	} catch (SQLException e) {	}
			stmt  = null;
			rs  = null;
			cn = null;
		}}
		return lista;
}
	public List<Object> ejecutarProcedimiento_SP_CONSULTA(String sp_sql, Object... variablea) throws Exception 
	{
		Connection cn = AccesoBD.getConnection();
		List<Object> tabla = new ArrayList<Object>();
		System.out.println("antes de conexion");
		if (cn != null) {
			System.out.println("entre hay conexion");
		int filas = variablea.length;
		ResultSet rs = null;
		CallableStatement stmt =null;
		try {
			System.out.println(" Entre al try catch");
			stmt = cn.prepareCall(sp_sql);
			stmt.registerOutParameter(1, OracleTypes.CURSOR); // REF CURSOR
			int indice = 2;

			if (filas > 0) {
				for (int i = 0; i < filas; i++) {
					String cariable = (String) variablea[i];
					System.out.println("cariable "+cariable);
					stmt.setString(indice, cariable);
					indice++;
				}
			}

			stmt.execute();
			rs = (ResultSet) stmt.getObject(1);
			ResultSetMetaData mtdt = rs.getMetaData();
			int counColumnas = mtdt.getColumnCount();
			List<String> fila = new ArrayList<String>();

			while (rs.next()) {
				fila = new ArrayList<String>();
				for (int i = 1; i <= counColumnas; i++) {
					String dato = rs.getString(i);
					fila.add(dato);
				}
				tabla.add(fila);
			}

		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
			tabla = null;
		}
		finally
		{
			try {	if(rs!=null ) {rs.close();} 		} catch (SQLException e1) {		}
			try {	if(stmt!=null ) {stmt.close();}	} catch (SQLException e1){	}
			try {	if(cn!=null ) {cn.close();}	} catch (SQLException e) {	}
			stmt  = null;
			rs  = null;
			cn = null;
		}}
		return tabla;
}
	public int grabarParteDiario(Partediario pd) {
		int rpta = 1;
		if (pd != null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwParteDiario");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			try {
				em.persist(pd);
			} catch (Exception e) {
				rpta = 0;
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return rpta;
	}
	public List<Partediario> GetPartediario() throws Exception {
		List<Partediario> c = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwParteDiario");
		EntityManager em = emf.createEntityManager();
		try{
			 TypedQuery<Partediario> query = em.createQuery("SELECT e FROM Partediario e ORDER BY e.idpartediario DESC", Partediario.class);
				 c = (List<Partediario>)query.getResultList(); 
	    } catch(NoResultException e) {
	        c= null;
	    }catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return c;
	}
	public byte[] DownloadParte(int id_fichero) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwParteDiario");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Partediario u = null;
		u = em.getReference(Partediario.class, id_fichero);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return u.getReporte();
	}

	
}
