package ru.kpfu.itis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ruslanzigansin on 14.04.16.
 */
@Controller
public class HomePageController {
    @RequestMapping(value = "/home")
    public String getIndexPage(){
        return "home";
    }
}
