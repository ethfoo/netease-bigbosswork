package com.ethfoo.controller;

import com.ethfoo.Utils.Const;
import com.ethfoo.Utils.UserTypeConst;
import com.ethfoo.pojo.Buyrecord;
import com.ethfoo.pojo.Item;
import com.ethfoo.pojo.User;
import com.ethfoo.service.BuyrecordService;
import com.ethfoo.service.ItemService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.catalina.startup.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private BuyrecordService buyrecordService;

    /**
     * 单个商品展示页
     */
    @RequestMapping(value = "/item/{id}")
    public ModelAndView itemShow(HttpSession session, @PathVariable String id) {
        ModelAndView mv = new ModelAndView("item");

        User user = (User) session.getAttribute(Const.SESSION_USER);
        if (user == null) {
            user = new User();
            user.setUsertype(UserTypeConst.NOT_LOGGED_IN);
        }
        mv.addObject("user", user);

        //判断商品是否购买过以及购买当时的价格
        boolean isRecord = itemService.isRecord(Integer.parseInt(id));
        if (isRecord) {
            Buyrecord buyrecord = buyrecordService.getBuyRecordByItemid(Integer.parseInt(id));
            double buyprice = buyrecord.getBuyprice();
            mv.addObject("buyprice", buyprice);
        }
        mv.addObject("isrecord", isRecord);


        Item item = itemService.getItemById(id);
        mv.addObject("item", item);

        return mv;
    }


}
