package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.entities.ClientEntity;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.service.ClientService;

/**
 * Created by ruslanzigansin on 25.04.16.
 */
@Controller
public class ClientProfilePageController {
    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/profile")
    public String getProfilePage(Model model){
        GeneralEntity user = (GeneralEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClientEntity clientEntity = clientService.getClientEntityById(user.getId());
        model.addAttribute("profile", clientService.getClientEntityById(user.getId()));
        return "profile";
    }
}
