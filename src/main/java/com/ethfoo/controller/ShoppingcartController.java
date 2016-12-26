package com.ethfoo.controller;

import com.ethfoo.pojo.Shoppingcart;
import com.ethfoo.pojo.vo.ShoppingcartItem;
import com.ethfoo.service.ShoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShoppingcartController {
    @Autowired
    private ShoppingcartService shoppingcartService;

    @RequestMapping(value = "/addtocart")
    public Map<String, Object> addtocart(Shoppingcart shoppingcart){
        Map<String, Object> map = new HashMap<>();

        if (shoppingcartService.addtocart(shoppingcart) == 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "失败");
        }

        return map;
    }

    @RequestMapping(value = "/shoppingcart")
    public ModelAndView shoppingcartPage(){
        ModelAndView mv = new ModelAndView("shoppingcart");
        List<ShoppingcartItem> itemList = shoppingcartService.getCartList();
        mv.addObject("itemList", itemList);
        return mv;
    }

    @RequestMapping(value = "buyall")
    public String buyall(HttpServletRequest request){


        return "buyall";
    }
}
