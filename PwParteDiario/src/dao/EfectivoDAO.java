package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Efectivo;

public class EfectivoDAO {
	boolean grabar(Efectivo efe) {
		boolean rpta = true;
		if (efe != null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwParteDiario");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			if (efe.getIdefectivo() > 0) {
				// update
				Efectivo comtemp = new Efectivo();
				comtemp = em.getReference(Efectivo.class, efe.getIdefectivo());
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
			em.getTransaction().commit();
			em.close();
			emf.close();
		}
		return rpta;
	}

	public Efectivo GetEfectivo(Efectivo efe) throws Exception {
		Efectivo ef=null;
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
}
