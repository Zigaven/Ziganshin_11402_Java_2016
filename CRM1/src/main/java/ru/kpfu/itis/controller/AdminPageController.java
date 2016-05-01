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
import ru.kpfu.itis.entities.PersonnelEntity;
import ru.kpfu.itis.service.PersonnelProfileService;
import ru.kpfu.itis.service.PersonnelService;
import ru.kpfu.itis.service.ShopService;

import javax.validation.Valid;
import java.math.BigInteger;

/**
 * Created by ruslanzigansin on 27.04.16.
 */
@Controller
@RequestMapping("/admin")
public class AdminPageController {


    @RequestMapping(method = RequestMethod.GET)
    public String getAdminPage() {
        return "admin_page";
    }

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public String getShopPage() {
        return "admin_shops";
    }

    @RequestMapping(value = "/staff", method = RequestMethod.GET)
    public String getStaffPage() {
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
        return "admin_comics";
    }



}
