package com.ethfoo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by ethfoo on 2016/12/23.
 */
@RestController
public class MainController {

    @RequestMapping("/")
    public ModelAndView welcome(HttpSession session){
        ModelAndView mv = new ModelAndView("welcome");

        return mv;
    }
}
