package ru.kpfu.itis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ruslanzigansin on 30.04.16.
 */
@Controller
public class ComicsPageController {
    @RequestMapping("/comics")
    public String getComics(){
        return "/client_comics";
    }
}
