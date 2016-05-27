package ru.kpfu.itis.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.entities.ComicsEntity;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.roles.Role;
import ru.kpfu.itis.service.ComicsService;
import ru.kpfu.itis.service.OrdersService;
import ru.kpfu.itis.service.UserService;

import java.io.IOException;
import java.util.List;

/**
 * Created by ruslanzigansin on 26.05.16.
 */
@RestController
@RequestMapping("/rest/api")
public class ApiController {
    @Autowired
    UserService userService;

    @Autowired
    OrdersService ordersService;

    @Autowired
    ComicsService comicsService;






    @RequestMapping("/role")
    public Role getRole() {
        GeneralEntity user = userService.getUserByLogin(
                ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        return user.getRole();
    }

    @RequestMapping("/comics")
    public List<ComicsEntity> getComics() {
        return comicsService.getAllComics();
    }

    @RequestMapping(value = "/comics/new" , method = RequestMethod.POST)
    public void postNewCar(@RequestBody String appIdJson){
        ComicsEntity comicsEntity= new ComicsEntity();
        try {
            comicsEntity = new ObjectMapper().readValue(appIdJson,ComicsEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        comicsService.addNewComics(comicsEntity);
    }


    @RequestMapping(value = "/users/new" , method = RequestMethod.POST)
    public void postNewUser(@RequestBody String appIdJson){
        GeneralEntity usersEntity= new GeneralEntity();
        try {
            usersEntity = new ObjectMapper().readValue(appIdJson,GeneralEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        userService.addNewUser(usersEntity);
    }

}
