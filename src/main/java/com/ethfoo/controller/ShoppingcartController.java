package com.ethfoo.controller;

import com.alibaba.fastjson.JSON;
import com.ethfoo.pojo.Buyrecord;
import com.ethfoo.pojo.Shoppingcart;
import com.ethfoo.pojo.vo.ShoppingcartItem;
import com.ethfoo.service.ShoppingcartService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@RestController
public class ShoppingcartController {
    @Autowired
    private ShoppingcartService shoppingcartService;

    /*
    购物车显示页面
     */
    @RequestMapping(value = "/shoppingcart")
    public ModelAndView shoppingcartPage(){
        ModelAndView mv = new ModelAndView("shoppingcart");
        List<ShoppingcartItem> itemList = shoppingcartService.getCartList();
        mv.addObject("itemList", itemList);
        return mv;
    }

    /*
    加入购物车
     */
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

    /*
    购买购物车中的所有商品
     */
    @RequestMapping(value = "/buyall", method = RequestMethod.POST)
    public Map<String, Object> buyall(@RequestBody ShoppingcartItem[] shoppingcartItems) throws IOException {
        Map<String, Object> map = new HashMap<>();

        List<ShoppingcartItem> list = new ArrayList<>();
        Collections.addAll(list, shoppingcartItems);
        shoppingcartService.buyCartItems(list);

        map.put("msg", "成功");
        return map;
    }


}
