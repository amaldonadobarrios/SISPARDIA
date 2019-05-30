package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import entity.Efectivo;

public class EfectivoDAO {
	public boolean grabar(Efectivo efe) {
		boolean rpta = true;
		if (efe != null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwParteDiario");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			if (efe.getIdefectivo() > 0) {
				// update
				Efectivo comtemp = new Efectivo();
				comtemp = em.getReference(Efectivo.class, efe.getIdefectivo());
				comtemp.setApemat(efe.getApemat());
				comtemp.setApepat(efe.getApepat());
				comtemp.setCip((efe.getCip()));
				comtemp.setCorreo(efe.getCorreo());
				comtemp.setDni((efe.getDni()));
				comtemp.setDomicilio(efe.getDomicilio());
				comtemp.setEstado(efe.getEstado());
				comtemp.setFechamod(new Date());
				comtemp.setGrado(efe.getGrado());
				comtemp.setIdarea(efe.getIdarea());
				comtemp.setIdcargo(efe.getIdcargo());
				comtemp.setIdjerarquia(efe.getIdjerarquia());
				comtemp.setIdmodalidad(efe.getIdmodalidad());
				comtemp.setNombres(efe.getNombres());
				comtemp.setTelefono(efe.getTelefono());
				comtemp.setUsumod(efe.getUsumod());
				try {
					em.merge(comtemp);
				} catch (Exception e) {
					rpta = false;
				}
			} else {
				try {
					em.persist(efe);
				} catch (Exception e) {
					rpta = false;
				}
			}
			try {
				em.getTransaction().commit();
				em.close();
				emf.close();
			} catch (Exception e) {
				em.close();
				emf.close();
				rpta=false;
			}
			
		}
		return rpta;
	}

	public Efectivo GetEfectivo(Efectivo efe) throws Exception {
		Efectivo ef = null;
		if (efe != null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwParteDiario");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			if (efe.getIdefectivo() > 0) {
				try {
					ef = em.getReference(Efectivo.class, efe.getIdefectivo());
				} catch (Exception e) {
				}
			} else {

			}
			em.getTransaction().commit();
			em.close();
			emf.close();
		}
		return ef;
	}

	public JsonArray getEFECTIVOSJSON() throws Exception {
		String resumen = null;
		String query = "SELECT IDEFECTIVO,\r\n" + 
				"  APEPAT,\r\n" + 
				"  APEMAT,\r\n" + 
				"  NOMBRES,\r\n" + 
				"  GRA.DESGRAD,\r\n" + 
				"  CIP,\r\n" + 
				"  DNI,\r\n" + 
				"  CORREO,\r\n" + 
				"  TELEFONO,\r\n" + 
				"  DOMICILIO,\r\n" + 
				"  MODA.DESCRIPCION AS MODALIDAD,\r\n" + 
				"  AR.DESCRIPCION AS AREA,\r\n" + 
				"  CAR.DESCRIPCION AS CARGO,\r\n" + 
				"  ESTADO,\r\n" + 
				"  JER.DESCRIPCION AS JERARQUIA\r\n" + 
				"FROM EFECTIVO E \r\n" + 
				"inner JOIN  GRADO GRA ON GRA.TGRAD=E.GRADO\r\n" + 
				"INNER JOIN MODALIDAD MODA ON MODA.IDMODALIDAD=E.IDMODALIDAD\r\n" + 
				"INNER JOIN AREA AR ON AR.IDAREA=E.IDAREA\r\n" + 
				"INNER JOIN CARGO CAR ON CAR.IDCARGO=E.IDCARGO\r\n" + 
				"INNER JOIN JERARQUIA JER ON JER.IDJERARQUIA=E.IDJERARQUIA ";
		JsonArray array = new JsonArray();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwParteDiario");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					JsonObject object = new JsonObject();
					object.addProperty("IDEFECTIVO", rs.getInt(1));
					object.addProperty("APEPAT", rs.getString(2));
					object.addProperty("APEMAT", rs.getString(3));
					object.addProperty("NOMBRES", rs.getString(4));
					object.addProperty("DESGRAD", rs.getString(5));
					object.addProperty("CIP", rs.getString(6));
					object.addProperty("DNI", rs.getString(7));
					object.addProperty("CORREO", rs.getString(8));
					object.addProperty("TELEFONO", rs.getString(9));
					object.addProperty("DOMICILIO", rs.getString(10));
					object.addProperty("MODALIDAD", rs.getString(11));
					object.addProperty("AREA", rs.getString(12));
					object.addProperty("CARGO", rs.getString(13));
					object.addProperty("ESTADO", rs.getInt(14));
					object.addProperty("JERARQUIA", rs.getString(15));				
					array.add(object);

				}
			} catch (SQLException e) {
				System.out.println("Excepcion en query GetTurnoxsede: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
				cn.close();
			}
		}
		resumen = array.toString();
		return array;
	}
	public List<Efectivo> GetEfectivos() throws Exception {
		List<Efectivo> c = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwParteDiario");
		EntityManager em = emf.createEntityManager();
		try{
			 TypedQuery<Efectivo> query = em.createQuery("SELECT e FROM Efectivo e", Efectivo.class);
				 c = (List<Efectivo>)query.getResultList(); 
	    } catch(NoResultException e) {
	        c= null;
	    }catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return c;
	}
	public Efectivo  GetEfectivosxcip(String cip) throws Exception {
		Efectivo c = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwParteDiario");
		EntityManager em = emf.createEntityManager();
		try{
			TypedQuery<Efectivo> query = em.createQuery("SELECT e FROM Efectivo e where e.estado = :est AND e.cip= :bcip", Efectivo.class);
			query.setParameter("est", 1);
			query.setParameter("bcip", cip.trim());
				 c = (Efectivo)query.getSingleResult();
	    } catch(NoResultException e) {
	        c= null;
	    }catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return c;
	}
}
