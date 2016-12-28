package com.ethfoo.service;

import com.ethfoo.Utils.UserTypeEnum;
import com.ethfoo.pojo.User;

import javax.servlet.http.HttpSession;

public interface UserService {

    User checkUserAndPasswd(String username, String password);
    UserTypeEnum getUserLoginState(HttpSession session);

}
