package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.form.RegisterForm;
import ru.kpfu.itis.service.UserService;

import javax.validation.Valid;

/**
 * Created by ruslanzigansin on 23.04.16.
 */
@Controller
@RequestMapping("/register")
public class RegisterPageController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public String getClientRegistrationPage(Model model){
        model.addAttribute("clientform", new RegisterForm());
        return "register";
    }

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public String getClientRegistration(@ModelAttribute("clientform") @Valid RegisterForm registerForm, BindingResult result){

        if (result.hasErrors()) {
            return "register";
        }

        userService.createUser(registerForm);
        return "redirect:/login";
    }
}
