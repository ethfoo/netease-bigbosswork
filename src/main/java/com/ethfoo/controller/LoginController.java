package com.ethfoo.controller;

import com.ethfoo.Utils.Const;
import com.ethfoo.pojo.User;
import com.ethfoo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView loginPage(){
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView loginCheck(HttpSession session, HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam String username, @RequestParam String password) throws IOException {
        ModelAndView mv = new ModelAndView("login");
        User user = userService.checkUserAndPasswd(username, password);
        if( user.getUsertype() == null || user.getUsertype().equals("") ){
            //mv.addObject("error", "用户名密码错误");

        }else{
            session.setAttribute(Const.SESSION_USER, user);
            response.sendRedirect("/");
        }

        return mv;
    }

}
