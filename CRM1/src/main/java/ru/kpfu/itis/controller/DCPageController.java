package ru.kpfu.itis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ruslanzigansin on 23.04.16.
 */
@Controller
public class DCPageController {
    @RequestMapping(value = "/dc")
    public String getDCPage(){
        return "dc";
    }
}
