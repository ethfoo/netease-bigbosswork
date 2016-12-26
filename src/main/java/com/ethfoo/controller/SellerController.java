package com.ethfoo.controller;

import com.ethfoo.pojo.Item;
import com.ethfoo.service.ItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SellerController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/public")
    public ModelAndView publicPage(){
        ModelAndView mv = new ModelAndView("public");
        return mv;
    }

    @RequestMapping(value = "/publicItem", method = RequestMethod.POST)
    public ModelAndView publicItem(Item item){
        ModelAndView mv = new ModelAndView();
        int ret = itemService.publicItem(item);
        if( ret == 1){
            mv.setViewName("publicSuccess");
        }else{
            mv.setViewName("error");
        }

        return mv;
    }
}
