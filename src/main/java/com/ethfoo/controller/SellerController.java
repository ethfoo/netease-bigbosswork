package com.ethfoo.controller;

import com.ethfoo.pojo.Item;
import com.ethfoo.service.ItemService;
import org.apache.log4j.Logger;
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
import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
public class SellerController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/public")
    public ModelAndView publicPage() {
        ModelAndView mv = new ModelAndView("public");
        return mv;
    }

    @RequestMapping(value = "/publicItem", method = RequestMethod.POST)
    public ModelAndView publicItem(Item item, MultipartFile file, HttpServletRequest request,
                                   HttpServletResponse response, HttpSession session) throws IOException {
        ModelAndView mv = new ModelAndView();

        if(file != null || !file.isEmpty()){
            String realPath = request.getServletContext().getRealPath("/");
            String name = item.getTitle() ;//+ new Date().getTime()
            //TODO check type and size
            String url = realPath + name;
            file.transferTo(new File(url));
            item.setImage(url);
        }

        System.out.println("******item-->" + item);
        System.out.println("*************" + file.toString() + "***name:" +
                file.getName() + "***type:" + file.getContentType() + "****size:" + file.getSize());
        int ret = itemService.publicItem(item);
        if( ret == 1){
            mv.setViewName("publicSuccess");
        }else{
            mv.setViewName("error");
        }
        return mv;
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editItemPage(@PathVariable String id) {
        ModelAndView mv = new ModelAndView("edit");
        Item item = itemService.getItemById(id);
        mv.addObject("item", item);
        return mv;
    }

    @RequestMapping(value = "/editItem")
    public ModelAndView editItem(Item item) {
        System.out.println("*************item-->" + item.toString());
        ModelAndView mv = new ModelAndView();
        itemService.editItem(item);
        mv.addObject("message", "编辑");
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteItem(@PathVariable String id){
        ModelAndView mv = new ModelAndView();
        itemService.deleteItem(Integer.parseInt(id));
        mv.setViewName("success");
        mv.addObject("message", "删除");
        return mv;
    }

}
