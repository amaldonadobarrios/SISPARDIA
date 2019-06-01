package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import entity.Efectivo;
import entity.EfectivoSituacion;
import entity.ListaSituacionEfectivo;

public class EfectivoSituacionDAO {
	public int grabar(EfectivoSituacion efesit) {
		int rpta = 6;
		if (efesit != null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwParteDiario");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			try {
				em.persist(efesit);
			} catch (Exception e) {
				rpta = 5;
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return rpta;
	}
	public List<ListaSituacionEfectivo> ListaEfectivoSituacion(String cip) throws Exception {
		String query = "SELECT \r\n" + 
				"  TO_CHAR(ES.FECHAREG, 'DD/MM/YYYY hh24:mi') AS FECHAREG,\r\n" + 
				"  SI.DESCRIPCION,\r\n" + 
				"  TO_CHAR(ES.FECHAINI, 'DD/MM/YYYY') AS FINI  ,\r\n" + 
				"  NVL(TO_CHAR(ES.FECHAFIN, 'DD/MM/YYYY'),'NO REGISTRO') AS FFIN ,\r\n" + 
				"  CASE WHEN (ES.INDETERMINADO=1) THEN 'INDETERMINADO'\r\n" + 
				"WHEN (ES.INDETERMINADO=0) THEN 'DETERMINADO'\r\n" + 
				" END AS RANGO,\r\n" + 
				"  ES.OBSERVACIONES,\r\n" + 
				"  CASE WHEN (ES.ESTADO=1) THEN 'ACTIVADO'\r\n" + 
				"WHEN (ES.ESTADO=0) THEN 'DESACTIVADO'\r\n" + 
				" END AS ESTADO,\r\n" + 
				"  ES.USUREG,\r\n" + 
				"   CASE WHEN (ES.ESTADO=1) THEN\r\n" + 
				"  CASE WHEN (trunc(ES.FECHAFIN)<trunc(sysdate)) THEN 'CADUCADO'\r\n" + 
				"WHEN (trunc(ES.FECHAFIN)>trunc(sysdate))THEN 'VIGENTE'\r\n" + 
				"WHEN (trunc(ES.FECHAFIN)=trunc(sysdate))THEN 'VIGENTE' ELSE 'VIGENTE' \r\n" + 
				"END\r\n" + 
				"ELSE 'NO VIGENTE'\r\n" + 
				" END AS VIGENCIA\r\n" + 
				"FROM EFECTIVO_SITUACION ES\r\n" + 
				"INNER JOIN EFECTIVO EF ON EF.IDEFECTIVO=ES.IDEFECTIVO\r\n" + 
				"INNER JOIN SITUACION SI ON SI.IDSITUACION=ES.IDSITUACION\r\n" + 
				"WHERE EF.CIP=? ORDER BY ES.FECHAREG DESC";
		List<ListaSituacionEfectivo> lista=null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwParteDiario");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setString(1, cip);
				ResultSet rs = ps.executeQuery();
				lista=new ArrayList<>();
				while (rs.next()) {
					ListaSituacionEfectivo object = new ListaSituacionEfectivo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
					lista.add(object);
				}
			} catch (SQLException e) {
				System.out.println("Excepcion en query ListaEfectivoSituacion: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
				cn.close();
			}
		}
		return lista;
	}
}
