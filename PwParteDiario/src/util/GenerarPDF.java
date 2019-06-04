package util;

import java.io.ByteArrayOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

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

	public ByteArrayOutputStream generarPDF(String header, String info, String footer, String rutaImagen) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			Document document = new Document(PageSize.A4, 36, 36, 10, 10);
			PdfWriter pw = PdfWriter.getInstance(document, baos);
			document.open();
			document.add(getHeader(header));
			Image omagen = Image.getInstance(rutaImagen);
			omagen.scaleAbsolute(400, 400);
			omagen.setAlignment(Element.ALIGN_CENTER);
			document.add(omagen);
			document.add(getInfo(info));
			document.add(getInfo(""));
			document.add(getFooter(footer));
			document.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return baos;

	}

}
