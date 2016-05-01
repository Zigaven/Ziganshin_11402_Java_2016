package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.entities.ClientEntity;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.ShopEntity;
import ru.kpfu.itis.service.ClientService;
import ru.kpfu.itis.service.PersonnelService;
import ru.kpfu.itis.service.ShopService;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by ruslanzigansin on 29.04.16.
 */
@Controller
@RequestMapping("/client")
public class ClientGlobalController {

//    @Autowired
//    ShopService shopService;

    @Autowired
    ClientService clientService;

    @Autowired
    PersonnelService personnelService;

    @RequestMapping(method = RequestMethod.GET)
    public String getProfilePage(Model model){
        GeneralEntity person = (GeneralEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String role = String.valueOf(person.getRole());

        if (role.equals("ROLE_ADMIN")){
            return "redirect:/admin";
        }

        if (role.equals("ROLE_STAFF")) {
            return "redirect:/staff";
        }

        ClientEntity client = clientService.getClientEntityById(person.getId());
        model.addAttribute("client", client);
        return "profile";
    }


}
