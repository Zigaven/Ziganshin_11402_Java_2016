package ru.kpfu.itis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ruslanzigansin on 24.04.16.
 */
@Controller
public class IndexPageController {

    @RequestMapping("/")
    public String getIndexPage(){
        return "home";
    }

}
