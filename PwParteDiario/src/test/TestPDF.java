package test;

import util.GenerarPDF;

public class TestPDF {

	public static void main(String[] args) {
		
		GenerarPDF g =  new GenerarPDF();
		g.generarPDF("TITULO", "INFO", "FOOTER", "C:\\demo\\escudopnp.png");

	}

}
