package com.project.controllerRest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moles
 */
@RestController
@RequestMapping("test")
public class TestController {
    /**
     * @return string
     */
    @RequestMapping
    public String test() {
        return "test";
    }
}
