package util;

import java.io.IOException;

public class LogicaF {
	// PATRON SINGLETON INI
	private static LogicaF instance = null;

	public static synchronized LogicaF getInstance() {
		if (instance == null) {
			instance = new LogicaF();
		}
		return instance;
	}

	private LogicaF() {
	}

	// PATRON SINGLETON FIN

	public String img(String cip) throws IOException {
		int tamaño_cip = cip.length();
		String sSubCadena = cip.substring(tamaño_cip - 1, tamaño_cip);
		String rutaimagen = "https://aguila6.pnp.gob.pe/FotosTit/" + sSubCadena + "/" + cip + ".jpg";
		return rutaimagen;
	}

}
