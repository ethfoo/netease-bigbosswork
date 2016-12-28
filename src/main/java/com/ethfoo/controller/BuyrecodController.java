package com.ethfoo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BuyrecodController {

    @RequestMapping(value = "/buyrecord")
    public ModelAndView buyrecordPage(){
        ModelAndView mv = new ModelAndView("buyrecord");

        return mv;
    }
}
