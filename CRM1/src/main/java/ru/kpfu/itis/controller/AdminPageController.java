package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.entities.ComicsEntity;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.PersonnelProfileEntity;
import ru.kpfu.itis.entities.ShopEntity;
import ru.kpfu.itis.entities.roles.Role;
import ru.kpfu.itis.form.ProfileForm;
import ru.kpfu.itis.form.RegisterForm;
import ru.kpfu.itis.form.ShopForm;
import ru.kpfu.itis.response.ComicsResponse;
import ru.kpfu.itis.service.ComicsService;
import ru.kpfu.itis.service.PersonnelProfileService;
import ru.kpfu.itis.service.ShopService;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.PersonnelProfileFormValid;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruslanzigansin on 27.04.16.
 */
@Controller
@RequestMapping("/admin")
public class AdminPageController {
    @Autowired
    UserService userService;

    @Autowired
    ComicsService comicsService;

    @Autowired
    ShopService shopService;

    @Autowired
    PersonnelProfileService personnelProfileService;

    PersonnelProfileFormValid valid = new PersonnelProfileFormValid();

    @RequestMapping(method = RequestMethod.GET)
    public String getAdminPage() {
        return "admin_page";
    }

    @RequestMapping(value = {"/shop", "/shop/{page}"}, method = RequestMethod.GET)
    public String getShopPage(@PathVariable java.util.Map<String, String> pathVariables, Model model) {
        int page = 0;
        if (pathVariables.containsKey("page")) page = Integer.parseInt(pathVariables.get("page"));

        Page<ShopEntity> shopEntities = shopService.getAllShops(new PageRequest(page, 5));

        model.addAttribute("shop", shopEntities);
        model.addAttribute("page", page);
        model.addAttribute("maxpage", shopEntities.getTotalPages());

        return "admin_shops";
    }

    @RequestMapping(value = {"/staff", "/staff/{page}"}, method = RequestMethod.GET)
    public String getStaffPage(@PathVariable java.util.Map<String, String> pathVariables, Model model) {

//        int page = 0;
//        if (pathVariables.containsKey("page")) page = Integer.parseInt(pathVariables.get("page"));

        List<GeneralEntity> personnelEntities = userService.findAllByRole(Role.ROLE_STAFF);

        model.addAttribute("personnel", personnelEntities);
//        model.addAttribute("page", page);

        return "admin_staff";
    }


    @RequestMapping(value = "/profit", method = RequestMethod.GET)
    public String getProfitPage() {
        return "admin_profit";
    }

    @RequestMapping(value = "/expense", method = RequestMethod.GET)
    public String getExpensePage() {
        return "admin_expense";
    }

    @RequestMapping(value = "/comics", method = RequestMethod.GET)
    public String getComicsPage() {
//        List<ComicsEntity> comicsEntity = comicsService.getAllComics();
//        model.addAttribute("comics", comicsEntity);

        return "admin_comics";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public
    @ResponseBody
    List<ComicsResponse> getComics(@PathVariable java.util.Map<String, String> pathVariables, Model model, @RequestParam("pub") String publisher) {
        List<ComicsEntity> comicsEntity = comicsService.getAllComics();
        List<ComicsEntity> comicses = comicsService.getComicsByPublisher(publisher);
        List<ComicsResponse> comicsResp = new ArrayList<ComicsResponse>();
        model.addAttribute("comics", comicsEntity);
        for (ComicsEntity comics : comicses) {
            ComicsResponse comicsResponse = new ComicsResponse();
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

    @RequestMapping(value = "/add_comics", method = RequestMethod.GET)
    public String addComics(Model model) {
        List<ComicsEntity> comics = comicsService.getAllComics();
        model.addAttribute("comics", comics);
        return "admin_add_comics";
    }

    @RequestMapping(value = "/add_comics", method = RequestMethod.POST)
    public String addComics(@RequestParam("file") MultipartFile file,
                            RedirectAttributes redirectAttributes, @RequestParam("name") String name,
                            @RequestParam("price") Integer price, @RequestParam("description") String description,
                            @RequestParam("publisher") String publisher) {
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File("/Users/ruslanzigansin/CRM1/target/CRM1/resources/images/"
                                + file.getOriginalFilename())));
                FileCopyUtils.copy(file.getInputStream(), stream);
                stream.close();
                redirectAttributes.addFlashAttribute("message",
                        "You successfully uploaded " + file.getName() + "!");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("message",
                        "You failed to upload " + file.getName() + " => " + e.getMessage());
            }
        } else {
            redirectAttributes.addFlashAttribute("message",
                    "You failed to upload " + file.getName() + " because the file was empty");
        }
        String path = "/images/" + file.getOriginalFilename();

        ComicsEntity comicsEntity = new ComicsEntity();
        comicsEntity.setName(name);
        comicsEntity.setPath(path);
        comicsEntity.setDescription(description);
        comicsEntity.setPrice(price);
        comicsEntity.setPublisher(publisher);
        comicsService.addNewComics(comicsEntity);

        return "redirect:/admin/comics";
    }


    @RequestMapping(value = "/add_staff", method = RequestMethod.GET)
    public String getStaffRegistrationPage(Model model) {
        model.addAttribute("clientform", new RegisterForm());
        return "admin_add_staff";
    }

    @RequestMapping(value = "/add_staff", method = RequestMethod.POST)
    public String getStaffRegistrationPage(@ModelAttribute("clientform") @Valid RegisterForm registerForm, BindingResult result) {

        if (result.hasErrors()) {
            return "admin_add_staff";
        }

        userService.createUser(registerForm);
        return "redirect:/admin/staff";
    }

    @RequestMapping(value = "/add_shop", method = RequestMethod.GET)
    public String getOfficeRegistrationPage(Model model) {
        model.addAttribute("shopform", new ShopForm());
        return "admin_add_shop";
    }

    @RequestMapping(value = "/staff/profile/{id}", method = RequestMethod.GET)
    public String getStaffProfile(@PathVariable("id") Integer id, Model model, HttpSession session) {
        GeneralEntity staffEntity = userService.getUserEntityById(id);
        PersonnelProfileEntity profile = personnelProfileService.getStaffProfileEntityByStaffEntity(staffEntity);
        session.setAttribute("staff",staffEntity);
        session.setAttribute("profile",profile);
        session.setAttribute("id",id);


        model.addAttribute("staff", session.getAttribute("staff"));
        model.addAttribute("profile", session.getAttribute("profile"));
        model.addAttribute("id", session.getAttribute("id"));

        return "admin_staff_profile";
    }

    @RequestMapping(value = "/staff/profile/edit/{id}", method = RequestMethod.GET)
    public String updateStaffProfile(@PathVariable Integer id, Model model) {

//        GeneralEntity staffEntity = userService.getUserEntityById(id);
//        PersonnelProfileEntity profile = personnelProfileService.getStaffProfileEntityByStaffEntity(staffEntity);
//
//        if (profile == null) profile = new PersonnelProfileEntity();
//
//        model.addAttribute("staff", staffEntity);
//        model.addAttribute("profile", profile);
//        model.addAttribute("id", id);
//        model.addAttribute("salary", profile.getSalary() + "");
//
//        model.addAttribute("userform", new ProfileForm());

        return "admin_staff_profile_edit";
    }

    @RequestMapping(value = "/staff/profile/edit/{id}", method = RequestMethod.POST)
    public String updateStaffProfile(@PathVariable Integer id, @ModelAttribute("profileForm") @Valid ProfileForm form, BindingResult result) {

        valid.validate(form, result);


        if (!result.hasErrors()) {
            return "redirect:/admin/staff/profile/" + id;
        } else {

            GeneralEntity staffEntity = userService.getUserEntityById(id);
            PersonnelProfileEntity profile = personnelProfileService.getStaffProfileEntityByStaffEntity(staffEntity);

            personnelProfileService.saveNewProfile(form, profile, staffEntity);

            String str = "/admin/staff/profile/" + id;

            return "redirect:" + str;
        }
    }

    @RequestMapping(value = "/add_shop", method = RequestMethod.POST)
    public String getOfficeRegistrationPage(@ModelAttribute("shopform") @Valid ShopForm shopForm, BindingResult result) {

        if (result.hasErrors()) {
            return "admin_add_office";
        }
        shopService.createNewShop(shopForm);
        return "redirect:/admin/shop";
    }

    @RequestMapping(value = "/shop/profile/{id}", method = RequestMethod.GET)
    public String getShopProfile(@PathVariable("id") Long id, Model model, HttpSession session) {
        ShopEntity shopEntity = shopService.getOneById(id);

        if (shopEntity == null) {
            return "redirect:/admin/shop";
        }
        session.setAttribute("shop",shopEntity);

        model.addAttribute("shop", session.getAttribute("shop"));

        return "admin_shop_profile";
    }

}
