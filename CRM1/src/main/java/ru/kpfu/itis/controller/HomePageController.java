package ru.kpfu.itis.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.entities.GeneralEntity;

/**
 * Created by ruslanzigansin on 24.04.16.
 */
@Controller
public class HomePageController {


    @RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET)
    public String getIndexPage() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            GeneralEntity person = (GeneralEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String role = String.valueOf(person.getRole());

            if (role.equals("ROLE_ADMIN")) {
                return "redirect:/admin";
            }

            if (role.equals("ROLE_STAFF")) {
                return "redirect:/staff/profile";
            }
            if (role.equals("ROLE_CLIENT")) {
                return "redirect:/client/profile";
            }
        }
        return "/home";
    }

    @RequestMapping(value = "/about")
    public String getAboutPage() {
        return "about";
    }

}
