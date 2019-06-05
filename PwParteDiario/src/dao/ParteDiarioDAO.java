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
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

import entity.ParteDiario;
import oracle.jdbc.OracleTypes;

public class ParteDiarioDAO {

	
	public List<ParteDiario> generarParteDiario(String usuario) {
		List<ParteDiario> lista=null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwParteDiario");
		EntityManager em = emf.createEntityManager();
		//StoredProcedureQuery storedProcedure = em.createNamedStoredProcedureQuery("GENERARPARTEDIARIO");
		StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GENERARPARTEDIARIO");
		storedProcedure.registerStoredProcedureParameter("P_USUARIO", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("P_LISTA", ResultSet.class, ParameterMode.REF_CURSOR);
		storedProcedure.setParameter("P_USUARIO", usuario);
		storedProcedure.execute();
		ResultSet rs = (ResultSet) storedProcedure.getOutputParameterValue("P_LISTA");
//		try {
//			lista= new ArrayList<>();
//			while (rs.next()) {
//				ParteDiario object = new ParteDiario();	
//				object.setArea(rs.getString("AREA"));
//				object.setGrado(rs.getString("GRADO"));
//				object.setApepat(rs.getString("APEPAT"));
//				object.setApemat(rs.getString("APEMAT"));
//				object.setNombres(rs.getString("NOMBRES"));
//				object.setCargo(rs.getString("CARGO"));
//				object.setHorario(rs.getString("HORARIO"));
//				object.setModalidad(rs.getString("MODALIDAD"));
//				object.setJerarquia(rs.getString("JERARQUIA"));
//				object.setSituacion(rs.getString("SITUACION"));
//				object.setRango(rs.getString("RANGO"));
//				object.setObservaciones(rs.getString("OBSERVACIONES"));
//				object.setServicio(rs.getString("SERVICIO"));
//				lista.add(object);
//
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		return lista;
	}
	public List<ParteDiario> ejecutarProcedimiento_ListaParteDiario(String sp_sql, Object... variablea) throws Exception 
	{
		List<ParteDiario> lista=null;
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
          		ParteDiario object = new ParteDiario();	
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


public  List<ParteDiario> getProducto(String usuario) throws Exception {
        
		List<ParteDiario> lista = null;
        CallableStatement cs = null;
        String sqlText = "{call GENERARPARTEDIARIO(?,?)}";
        Connection conexion = AccesoBD.getConnection();
        ResultSet rs = null;
        boolean found = false; 
        try {
        	System.out.println("xxx");
            cs = conexion.prepareCall(sqlText);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setString(2, usuario);
            cs.execute();
            System.out.println("yyy");
         
               rs = (ResultSet) cs.getObject(1); 
               lista= new ArrayList<>();
               while (rs.next()) {
            		ParteDiario object = new ParteDiario();	
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
  
        } catch (SQLException ex) {
           System.out.println( ex.getMessage());
            try {
            	conexion.close();
            } catch (SQLException ex1) {
               
            }
            lista =null;
        }finally{
            try {
                cs.close();
                conexion.close();
            } catch (SQLException ex) {
                
            }
        }
        return lista;
    }
	
}
