package test;

import java.util.List;

import dao.ParteDiarioDAO;
import entity.ListaParteDiario;
import entity.TempUsu;

public class TestParteDAO {

	public static void main(String[] args) {
		ParteDiarioDAO dao= new ParteDiarioDAO();
		TempUsu  usu= new TempUsu();
		usu.setUsuario("31424836");
		String sqlText = "{call GENERARPARTEDIARIO(?,?)}";
		List<ListaParteDiario> lista = null;
		try {
			lista = dao.ejecutarProcedimiento_ListaParteDiario(sqlText,"31424836");
			for (ListaParteDiario parteDiario : lista) {
				System.out.println(parteDiario.getApemat());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(lista.size());
		System.out.println(lista.toString());
		

	}

}
