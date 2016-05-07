package ru.kpfu.itis.view;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.sun.corba.se.spi.activation.Server;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.pdf.PdfWriter;
import ru.kpfu.itis.entities.ComicsForDownloadEntity;


/**
 * Created by ruslanzigansin on 04.05.16.
 */
public class PDFView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map model, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ComicsForDownloadEntity comics = (ComicsForDownloadEntity) model.get("command");
        Image image = Image.getInstance("/Users/ruslanzigansin/CRM1/target/CRM1/resources"+ comics.getPath());
        Paragraph header = new Paragraph(new Chunk("One comics for you" + comics.getName(), FontFactory.getFont(FontFactory.HELVETICA, 30)));
        Paragraph by = new Paragraph();
        by.add(image);
        document.add(header);
        document.add(by);
    }
}
