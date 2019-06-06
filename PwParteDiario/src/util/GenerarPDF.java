package util;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import entity.ListaParteDiario;

public class GenerarPDF {

	private Font fuenteBold = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);
	private Font fuenteNormal = new Font(Font.FontFamily.COURIER, 8, Font.NORMAL);
	private Font fuenteItalic = new Font(Font.FontFamily.COURIER, 8, Font.ITALIC);

	private Paragraph getHeader(String texto) {
		Paragraph p = new Paragraph();
		Chunk c = new Chunk();
		p.setAlignment(Element.ALIGN_CENTER);
		c.append(texto);
		c.setFont(fuenteBold);
		p.add(c);
		return p;
	}

	private Paragraph getInfo(String texto) {
		Paragraph p = new Paragraph();
		Chunk c = new Chunk();
		p.setAlignment(Element.ALIGN_RIGHT);
		c.append(texto);
		c.setFont(fuenteNormal);
		p.add(c);
		return p;
	}

	private Paragraph getFooter(String texto) {
		Paragraph p = new Paragraph();
		Chunk c = new Chunk();
		p.setAlignment(Element.ALIGN_RIGHT);
		c.append(texto);
		c.setFont(fuenteItalic);
		p.add(c);
		return p;
	}

	private Paragraph getcolumna(String texto) {
		Paragraph columna1 = new Paragraph(texto);
		columna1.getFont().setStyle(Font.BOLD);
		columna1.getFont().setSize(6);
		return columna1;
	}
	private Paragraph getcabecera(String texto) {
		Paragraph columna1 = new Paragraph(texto);
		columna1.setAlignment(Element.ALIGN_CENTER);
		columna1.getFont().setStyle(Font.BOLD);
		columna1.getFont().setSize(6);
		return columna1;
	}

	public PdfPTable generarTabla(List<ListaParteDiario> datos) {
		//procesamiento de datos
		List<ListaParteDiario> listadisponibleservicio= new ArrayList<>();
		List<ListaParteDiario> listadisponiblefranco= new ArrayList<>();
		List<ListaParteDiario> listadescuentos= new ArrayList<>();
		List<String> Areas=new ArrayList<String>();
		String area="";
		int contador=1;
		//obtener areas
		for (int i = 0; i < datos.size(); i++) {
			if (area.equals(datos.get(i).getArea())) {	
			}else {
				area=datos.get(i).getArea();
				Areas.add(area);
			}
				if (datos.get(i).getSituacion().equals("DISPONIBLE") && datos.get(i).getServicio().equals("SERVICIO")) {
					listadisponibleservicio.add(datos.get(i));	
				}else {
					listadescuentos.add(datos.get(i));		
				}
				
		}
		//procesamiento de datos	
		// Este codigo genera una tabla de 3 columnas
		PdfPTable table = new PdfPTable(7);
		float[] medidaCeldas = { 0.15f,0.55f, 2.25f, 0.55f, 0.55f, 0.55f, 0.55f };
		//ASIGNAS LAS MEDIDAS A LA TABLA (ANCHO)
		try {table.setWidths(medidaCeldas);	} catch (DocumentException e) {e.printStackTrace();}
		
		for (String ar : Areas) {
			PdfPCell celdacabecera = new PdfPCell(getcabecera(ar));
			celdacabecera.setColspan(7);
			celdacabecera.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			table.addCell(celdacabecera);
			for (ListaParteDiario parteDiario : listadisponibleservicio) {
				if (parteDiario.getArea().equals(ar)) {
					table.addCell(getcolumna(String.valueOf(contador++)));
					table.addCell(getcolumna(parteDiario.getGrado()));
					table.addCell(getcolumna(parteDiario.getApepat() + " " + parteDiario.getApemat() + " " + parteDiario.getNombres()));
					table.addCell(getcolumna(parteDiario.getCargo()));
					table.addCell(getcolumna(parteDiario.getHorario()));
					table.addCell(getcolumna(""));
					table.addCell(getcolumna(""));
				}	
			}
		}
		PdfPCell celdacabecera = new PdfPCell(getcabecera("DESCUENTOS"));
		celdacabecera.setColspan(7);
		celdacabecera.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		table.addCell(celdacabecera);
		if (listadescuentos.size()>0) {
			for (ListaParteDiario parteDiario : listadescuentos) {
					table.addCell(getcolumna(String.valueOf(contador++)));
					table.addCell(getcolumna(parteDiario.getGrado()));
					table.addCell(getcolumna(parteDiario.getApepat() + " " + parteDiario.getApemat() + " " + parteDiario.getNombres()));
					table.addCell(getcolumna(parteDiario.getCargo()));
					if (parteDiario.getSituacion().equals("DISPONIBLE")) {
						table.addCell(getcolumna(parteDiario.getServicio()));
						table.addCell(getcolumna(""));	
						table.addCell(getcolumna(""));	
					}else {
						table.addCell(getcolumna(parteDiario.getSituacion()));
						table.addCell(getcolumna(parteDiario.getRango()));	
						table.addCell(getcolumna(parteDiario.getObservaciones()));	
					}		
			}
		}else {
			PdfPCell celdaFRANCO = new PdfPCell(getcabecera("NO REGISTRA"));
			celdaFRANCO.setColspan(7);
			celdaFRANCO.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			table.addCell(celdaFRANCO);	
		}
		PdfPCell celdaFinal = new PdfPCell(new Paragraph(" TOTAL : " + datos.size()+" EFECTIVOS"));
		celdaFinal.setColspan(7);
		celdaFinal.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		table.addCell(celdaFinal);
		PdfPCell celdaFinal1 = new PdfPCell(new Paragraph(" DISPONIBLES : " + listadisponibleservicio.size()+" EFECTIVOS"));
		celdaFinal1.setColspan(7);
		celdaFinal1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		table.addCell(celdaFinal1);
		PdfPCell celdaFinal2 = new PdfPCell(new Paragraph(" DESCUENTOS : " + listadescuentos.size()+" EFECTIVOS"));
		celdaFinal2.setColspan(7);
		celdaFinal2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		table.addCell(celdaFinal2);
		return table;
	}

	public ByteArrayOutputStream generarPDF(String header, String info, String footer, String rutaImagen,PdfPTable tabla) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			Document document = new Document(PageSize.A4, 36, 36, 10, 10);
			PdfWriter pw = PdfWriter.getInstance(document, baos);
			document.open();
			document.add(getHeader(header));
			Image omagen = Image.getInstance(rutaImagen);
			omagen.scaleAbsolute(50, 50);
			omagen.setAlignment(Element.ALIGN_CENTER);
			document.add(omagen);
			document.add(getInfo(info));
			document.add(getInfo(" "));
			document.add(tabla);
			document.add(getInfo(""));
			document.add(getFooter(footer));
			document.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return baos;

	}

}
