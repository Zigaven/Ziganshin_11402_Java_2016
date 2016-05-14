package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.entities.ComicsEntity;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.OrdersEntity;
import ru.kpfu.itis.service.ComicsService;
import ru.kpfu.itis.service.OrdersService;
import ru.kpfu.itis.service.UserService;

/**
 * Created by ruslanzigansin on 10.05.16.
 */
@Controller
@RequestMapping(value = "/orders/procces")
public class OrdersController {
    @Autowired
    ComicsService comicsService;

    @Autowired
    OrdersService ordersService;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public String getOrders(@RequestParam(value = "comicsId") Integer comicsId) {
        GeneralEntity person = userService.getUserByLogin(
                ((UserDetails)SecurityContextHolder.getContext().
                        getAuthentication().getPrincipal()).getUsername());        ordersService.saveNewOrder(person,comicsId);
        return "/client_orders_procces";
    }

}
