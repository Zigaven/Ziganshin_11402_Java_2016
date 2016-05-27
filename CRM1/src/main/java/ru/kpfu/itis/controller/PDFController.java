package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.entities.ComicsForDownloadEntity;
import ru.kpfu.itis.service.ComicsForDownloadService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by ruslanzigansin on 04.05.16.
 */
@Controller
public class PDFController {

    @Autowired
    ComicsForDownloadService comicsForDownloadService;

    @RequestMapping(value = {"/generate/pdf.pdf", "client/generate/pdf.pdf"}, method = RequestMethod.GET)
    ModelAndView generatePdf(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        System.out.println("Calling generatePdf()...");
        List<ComicsForDownloadEntity> list = comicsForDownloadService.getComics();
        ModelAndView modelAndView = new ModelAndView("pdfView");

        for (ComicsForDownloadEntity n : list) {
            String name = (String) n.getName();
            ComicsForDownloadEntity comics = comicsForDownloadService.getComicsByName(name);
            modelAndView.addObject(name, comics);
        }


        return modelAndView;

    }
}
