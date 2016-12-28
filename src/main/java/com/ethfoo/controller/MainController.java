package com.ethfoo.controller;

import com.ethfoo.Utils.UserTypeEnum;
import com.ethfoo.pojo.Item;
import com.ethfoo.service.ItemService;
import com.ethfoo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;

    @RequestMapping("/")
    public ModelAndView welcome(HttpSession session){
        ModelAndView mv = new ModelAndView("welcome");
        UserTypeEnum typeEnum = userService.getUserLoginState(session);

        List<Item> itemList = itemService.getAllItemsWithRecord();
        for(Item item : itemList){
            System.out.println(item.toString());
        }
        mv.addObject("usertype", typeEnum.toString());
        mv.addObject("itemlist", itemList);
        return mv;
    }
}
