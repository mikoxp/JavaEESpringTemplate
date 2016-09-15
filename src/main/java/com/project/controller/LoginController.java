package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author moles
 */
@Controller
public class LoginController {
    /**
     * login page
     *
     * @param error  error massage
     * @param logout logout message
     * @return login page model
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Nieprawidłowy login lub hasło!!!!!!!");
        }
        if (logout != null) {
            model.addObject("ms", "Wylogowano");
        }
        model.setViewName("login");

        return model;
    }
}
