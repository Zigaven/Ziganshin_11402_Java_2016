package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.entities.ComicsEntity;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.MarkEntity;
import ru.kpfu.itis.response.ComicsResponse;
import ru.kpfu.itis.service.ComicsService;
import ru.kpfu.itis.service.MarkService;
import ru.kpfu.itis.service.OrdersService;
import ru.kpfu.itis.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruslanzigansin on 29.04.16.
 */
@Controller
@RequestMapping("/client")
public class ClientGlobalController {

    @Autowired
    MarkService markService;

    @Autowired
    UserService userService;

    @Autowired
    OrdersService ordersService;

    @Autowired
    ComicsService comicsService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfilePage(Model model) {
        GeneralEntity person = userService.getUserByLogin(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        String role = String.valueOf(person.getRole());
        GeneralEntity generalEntity = userService.getUserEntityById(person.getId());
        model.addAttribute("profile", generalEntity);

        if (role.equals("ROLE_ADMIN")) {
            return "redirect:/admin";
        }

        if (role.equals("ROLE_STAFF")) {
            return "redirect:/staff";
        }

//        UserService client = userService.getPersonnelEntityById(person.getId()); ???
//        model.addAttribute("client", client);
        return "/client_profile";
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<ComicsResponse> getComicsPage(@PathVariable java.util.Map<String, String> pathVariables, Model model, @RequestParam("pub") String publisher) {
        List<ComicsEntity> comicsEntity = comicsService.getAllComics();
        List<ComicsEntity> comicses = comicsService.getComicsByPublisher(publisher);
        List<ComicsResponse> comicsResp = new ArrayList<ComicsResponse>();
        model.addAttribute("comics", comicsEntity);
        for (ComicsEntity comics : comicses) {
            ComicsResponse comicsResponse = new ComicsResponse();
            comicsResponse.setId(comics.getId());
            comicsResponse.setName(comics.getName());
            comicsResponse.setDescription(comics.getDescription());
            comicsResponse.setPrice(comics.getPrice());
            comicsResponse.setPath(comics.getPath());
            comicsResponse.setPublisher(comics.getPublisher());
            comicsResp.add(comicsResponse);
        }
        System.out.println(comicsResp.size());
        return comicsResp;
    }

    @RequestMapping(value = "/comics", method = RequestMethod.GET)
    public String getComics(Model model, HttpSession session) {

        return "/client_comics";
    }

    @RequestMapping(value = "/marvel")
    public String getMarvelPage() {
        return "/client_marvel";
    }

    @RequestMapping(value = "/dc")
    public String getDCPage() {
        return "/client_dc";
    }

    @RequestMapping(value = "/mark/{comics}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Integer addMark(@PathVariable(value = "comics") String comics) {
        GeneralEntity generalEntity = userService.getUserByLogin(
                ((UserDetails) SecurityContextHolder.getContext().
                        getAuthentication().getPrincipal()).getUsername());
        MarkEntity markId = markService.getMarkEntityByGeneralEntity(generalEntity);

        if (markId == null) {
            markService.saveNewMark(generalEntity, comics);
        }

        List marks = markService.getAllByComics(comics);

        return marks.size();
    }

    @RequestMapping(value = "/check/mark/{comics}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List checkMark(@PathVariable(value = "comics") String comics) {
        GeneralEntity generalEntity = userService.getUserByLogin(
                ((UserDetails) SecurityContextHolder.getContext().
                        getAuthentication().getPrincipal()).getUsername());
        MarkEntity markId = markService.getMarkEntityByGeneralEntity(generalEntity);

        List list = new ArrayList();

        if (markId == null) {
            list.add(0, false);
        } else {
            list.add(0, true);
        }

        List marks = markService.getAllByComics(comics);

        list.add(1, marks.size());

        return list;
    }

    @RequestMapping(value = "/contact")
    public String getContactPage() {
        return "/client_contact";
    }

    @RequestMapping(value = "/contact/done")
    public String getContactDone() {
        return "/client_contact_done";
    }

    @RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET)
    public String getIndexPage() {
        return "/client_home";
    }
}
