package ru.kpfu.itis.view;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import ru.kpfu.itis.entities.ComicsForDownloadEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Map;


/**
 * Created by ruslanzigansin on 04.05.16.
 */
public class PDFView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map model, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ArrayList<ComicsForDownloadEntity> arrayList = new ArrayList<>(model.values());
        int k = 0;
        ComicsForDownloadEntity comic = arrayList.get(0);

        Paragraph header = new Paragraph(new Chunk("\t\t\t\t\t\tOne comics for you:\n" + comic.getName(), FontFactory.getFont(FontFactory.HELVETICA, 30)));
        document.add(header);

        try {
            for (ComicsForDownloadEntity anArrayList : arrayList) {
                k++;
                String path = "/Users/ruslanzigansin/CRM1/target/CRM1/resources";
                Image image = Image.getInstance(path + anArrayList.getPath());
                Paragraph img1 = new Paragraph();
                img1.add(image);
//        for(int i = 2; i < 25; i++) {
//            String im = "/images/its" + i + ".jpeg";
//            comics.setPath(im);
//            Paragraph img2 = new Paragraph();
                document.add(img1);
            }


//        }

        } catch (ClassCastException e) {
            e.printStackTrace();
        }


    }
}
