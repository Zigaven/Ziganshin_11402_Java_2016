package ru.kpfu.itis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.entities.ComicsForDownloadEntity;
import ru.kpfu.itis.service.ComicsForDownloadService;

import java.util.List;

/**
 * Created by ruslanzigansin on 04.05.16.
 */
@Controller
public class PDFController {

    @Autowired
    ComicsForDownloadService comicsForDownloadService;
    @RequestMapping( value = "/generate/pdf.htm", method = RequestMethod.GET)
    ModelAndView generatePdf(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        System.out.println("Calling generatePdf()...");
        String name = "Avengers";
        ComicsForDownloadEntity comics = comicsForDownloadService.getComicsByName(name);

        ModelAndView modelAndView = new ModelAndView("pdfView", "command",comics);

        return modelAndView;
    }
}
