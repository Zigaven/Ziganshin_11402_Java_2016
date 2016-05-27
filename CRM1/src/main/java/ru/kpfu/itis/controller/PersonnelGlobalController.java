package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.OrdersEntity;
import ru.kpfu.itis.service.ComicsService;
import ru.kpfu.itis.service.OrdersService;
import ru.kpfu.itis.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruslanzigansin on 03.05.16.
 */
@Controller
@RequestMapping("/staff")
public class PersonnelGlobalController {

    @Autowired
    UserService userService;

    @Autowired
    OrdersService ordersService;

    @Autowired
    ComicsService comicsService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfilePage(Model model) {
        GeneralEntity person = userService.getUserByLogin(
                ((UserDetails)SecurityContextHolder.getContext().
                        getAuthentication().getPrincipal()).getUsername());        GeneralEntity generalEntity = userService.getUserEntityById(person.getId());
        model.addAttribute("profile", generalEntity);
        return "staff_profile";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String getOrdersPage(Model model, HttpSession session) {
        List<String[]> orders = new ArrayList<>();
        session.setAttribute("orders",orders);
        for(OrdersEntity ordersEntity: ordersService.getAll()) {
            orders.add(new String[]{ordersEntity.getClientEntity().getFirstName(),ordersEntity.getComicsEntity().getName()});
            model.addAttribute("orders",session.getAttribute("orders"));
        }
        return "staff_orders";
    }
}
