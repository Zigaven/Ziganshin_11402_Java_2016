package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.service.UserService;

/**
 * Created by ruslanzigansin on 03.05.16.
 */
@Controller
@RequestMapping("/staff")
public class PersonnelGlobalController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public String getProfilePage(Model model) {
        GeneralEntity person = (GeneralEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        GeneralEntity generalEntity = userService.getUserEntityById(person.getId());
        model.addAttribute("profile", generalEntity);
        return "staff_profile";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String getOrdersPage() {
        return "staff_orders";
    }
}
