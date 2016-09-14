package com.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author moles
 */
@Controller
public class MainController {

    /**
     * @return index model
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView start() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

}
