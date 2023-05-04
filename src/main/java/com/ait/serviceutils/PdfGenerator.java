package com.ait.serviceutils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.ait.entity.CitizenPlan;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PdfGenerator {

	public void generatePdf(HttpServletResponse response, List<CitizenPlan> records, File file) throws Exception {

		Document document = new Document(PageSize.A4);

		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(file));
		

		document.open();

		// Creating font
		// Setting font style and size
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);

		// Creating Paragraph
		Paragraph p = new Paragraph("CUSTOMER PLANS INFO", fontTitle);

		// Aligning the paragraph in document
		p.setAlignment(Paragraph.ALIGN_CENTER);

		// Adding the created document in paragraph
		document.add(p);

		PdfPTable table = new PdfPTable(7);
		table.setSpacingBefore(5);

		table.addCell("ID");
		table.addCell("CITIZEN NAME");
		table.addCell("PLAN NAME");
		table.addCell("PLAN STATUS");
		table.addCell("PLAN START DATE");
		table.addCell("PLAN END DATE");
		table.addCell("BENEFIT AMOUNT");

		

		for (CitizenPlan plan : records) {
			table.addCell(String.valueOf(plan.getCITIZEN_ID()));
			table.addCell(plan.getCITIZEN_NAME());
			table.addCell(plan.getPLAN_NAME());
			table.addCell(plan.getPLAN_STATUS());
			table.addCell(plan.getPLAN_START_DATE() + "");
			table.addCell(plan.getPLAN_END_DATE() + "");
			table.addCell(plan.getBENEFIT_AMOUNT() + "");

		}

		document.add(table);

		document.close();

	}
}
