package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.entities.GeneralEntity;
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
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;

    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public String getClientRegistrationPage(Model model) {
        model.addAttribute("clientform", new RegisterForm());
        return "register";
    }

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public String getClientRegistration(@ModelAttribute("clientform") @Valid RegisterForm registerForm, BindingResult result) {

        if (result.hasErrors()) {
            return "register";
        }



        try {
            GeneralEntity generalEntity = userService.getUserEntityById(userService.createUser(registerForm));
            try {
                UserDetails userDetails = userDetailsService.loadUserByUsername(registerForm.getLogin());

                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        userDetails, registerForm.getPassword(), userDetails.getAuthorities());
                authenticationManager.authenticate(auth);

                // redirect into secured main page if authentication successful
                if (auth.isAuthenticated()) {
                    SecurityContextHolder.getContext().setAuthentication(auth);
                    return "redirect:/";
                }
            } catch (Exception e) {
                //logger.debug("Problem authenticating user" + username, e);
            }
        } catch (DataIntegrityViolationException e) {

        }


        userService.createUser(registerForm);
        return "redirect:/login";
    }

    }
