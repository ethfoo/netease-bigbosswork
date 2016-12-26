package com.ethfoo.controller;

import com.ethfoo.Utils.Const;
import com.ethfoo.Utils.UserTypeConst;
import com.ethfoo.pojo.Item;
import com.ethfoo.pojo.User;
import com.ethfoo.service.ItemService;
import org.apache.catalina.startup.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 单个商品展示页
     */
    @RequestMapping(value = "/item/{id}")
    public ModelAndView itemShow(HttpSession session, @PathVariable String id){
        ModelAndView mv = new ModelAndView("item");

        User user = (User) session.getAttribute(Const.SESSION_USER);
        if( user == null ){
            user = new User();
            user.setUsertype(UserTypeConst.NOT_LOGGED_IN);
        }
        mv.addObject("user", user);

        //TODO 加入判断商品是否购买过以及购买当时的价格

        Item item = itemService.getItemById(id);
        mv.addObject("item", item);

        return mv;
    }
}
