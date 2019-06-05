package util;

import java.io.ByteArrayOutputStream;
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

import entity.ParteDiario;

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
		p.setAlignment(Element.ALIGN_JUSTIFIED_ALL);
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
		public PdfPTable generarTabla(List<ParteDiario> datos) {
	// Este codigo genera una tabla de 3 columnas
PdfPTable table = new PdfPTable(4);
float[] medidaCeldas = {0.55f, 2.25f, 0.55f, 0.55f};
//ASIGNAS LAS MEDIDAS A LA TABLA (ANCHO)
try {
	table.setWidths(medidaCeldas);
} catch (DocumentException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}



for (ParteDiario parteDiario : datos) {
	//table.addCell(parteDiario.getArea());
	table.addCell(getcolumna(parteDiario.getGrado()));
	table.addCell(getcolumna(parteDiario.getApepat()+" "+parteDiario.getApemat()+ " "+parteDiario.getNombres()) );
	table.addCell(getcolumna(parteDiario.getCargo()));
	table.addCell(getcolumna(parteDiario.getHorario()));
	//table.addCell(parteDiario.getModalidad());
	//table.addCell(parteDiario.getJerarquia());
	//table.addCell(parteDiario.getSituacion());
	//table.addCell(parteDiario.getRango());
	//table.addCell(parteDiario.getObservaciones());
	//table.addCell(parteDiario.getServicio());
	
	
	
}
				// addCell() agrega una celda a la tabla, el cambio de fila
				// ocurre automaticamente al llenar la fila

				// Si desea crear una celda de mas de una columna
				// Cree un objecto Cell y cambie su propiedad span

				PdfPCell celdaFinal = new PdfPCell(new Paragraph(" TOTAL : "+datos.size()));

				// Indicamos cuantas columnas ocupa la celda
				celdaFinal.setColspan(5);
				table.addCell(celdaFinal);
	return table;
	
}
	public ByteArrayOutputStream generarPDF(String header, String info, String footer, String rutaImagen,PdfPTable tabla ) {
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
