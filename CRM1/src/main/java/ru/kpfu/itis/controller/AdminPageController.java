package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.entities.ComicsEntity;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.PersonnelProfileEntity;
import ru.kpfu.itis.entities.ShopEntity;
import ru.kpfu.itis.form.ProfileForm;
import ru.kpfu.itis.form.RegisterForm;
import ru.kpfu.itis.form.ShopForm;
import ru.kpfu.itis.service.ComicsService;
import ru.kpfu.itis.service.PersonnelProfileService;
import ru.kpfu.itis.service.ShopService;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.PersonnelProfileFormValid;

import javax.validation.Valid;
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
        return "admin_shops";
    }

    @RequestMapping(value = {"/staff", "/staff/{page}"}, method = RequestMethod.GET)
    public String getStaffPage(@PathVariable java.util.Map<String, String> pathVariables, Model model) {

        int page = 0;
        if (pathVariables.containsKey("page")) page = Integer.parseInt(pathVariables.get("page"));

        Page<GeneralEntity> personnelEntities = userService.getAllUsers(new PageRequest(page, 5));

        model.addAttribute("personnel", personnelEntities);
        model.addAttribute("page", page);

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
    public String getComicsPage(@PathVariable java.util.Map<String, String> pathVariables, Model model) {
        List<ComicsEntity> comicsEntity = comicsService.getAllComics();
        model.addAttribute("comics", comicsEntity);

        return "admin_comics";
    }

    @RequestMapping(value = "/add_comics")
    public String addComics() {
        return "admin_add_comics";
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
    public String getStaffProfile(@PathVariable("id") Integer id, Model model) {

        GeneralEntity generalEntity = userService.getUserEntityById(id);
        model.addAttribute("personnel", generalEntity);

        return "admin_staff_profile";
    }

    @RequestMapping(value = "/staff/edit/profile/{id}", method = RequestMethod.GET)
    public String updateStaffProfile(@PathVariable Integer id, Model model) {

        GeneralEntity staffEntity = userService.getUserEntityById(id);
        PersonnelProfileEntity profile = personnelProfileService.getStaffProfileEntityByStaffEntity(staffEntity);

        if (profile == null) profile = new PersonnelProfileEntity();

        model.addAttribute("staff", staffEntity);
        model.addAttribute("profile", profile);
        model.addAttribute("id", id);
        model.addAttribute("salary", profile.getSalary() + "");

        model.addAttribute("userform", new ProfileForm());

        return "admin_staff_profile_edit";
    }

    @RequestMapping(value = "/staff/edit/profile/{id}", method = RequestMethod.POST)
    public String updateStaffProfile(Model model, @PathVariable Integer id, @ModelAttribute("profileForm") @Valid ProfileForm form, BindingResult result) {

        valid.validate(form, result);

        if (result.hasErrors()) {
            GeneralEntity staffEntity = userService.getUserEntityById(id);
            PersonnelProfileEntity profile = personnelProfileService.getStaffProfileEntityByStaffEntity(staffEntity);

            model.addAttribute("staff", staffEntity);
            model.addAttribute("profile", profile);
            model.addAttribute("id", id);
            model.addAttribute("salary", profile.getSalary() + "");

            model.addAttribute("userform", new ProfileForm());

            return "admin_staff_profile_edit_page";
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
    public String getShopProfile(@PathVariable("id") Long id, Model model) {
        ShopEntity shopEntity = shopService.getOneById(id);

        if (shopEntity == null) {
            return "redirect:/admin/shop";
        }

        model.addAttribute("shop", shopEntity);

        return "admin_shop_profile";
    }

}
