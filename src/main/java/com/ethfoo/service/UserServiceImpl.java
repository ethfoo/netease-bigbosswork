package com.ethfoo.service;

import com.ethfoo.Utils.Const;
import com.ethfoo.Utils.UserTypeConst;
import com.ethfoo.Utils.UserTypeEnum;
import com.ethfoo.pojo.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User checkUserAndPasswd(String username, String password) {
        User user = new User();
        if( username.equalsIgnoreCase("buyer") && password.equals("reyub")){
            user.setUsertype(UserTypeConst.BUYER);
        }else if( username.equalsIgnoreCase("seller") && password.equals("relles")){
            user.setUsertype(UserTypeConst.SELLER);
        }
        return user;
    }

    @Override
    public UserTypeEnum getUserLoginState(HttpSession session) {
        User user = (User) session.getAttribute(Const.SESSION_USER);
        if( user == null || user.getUsertype().equals(UserTypeConst.NOT_LOGGED_IN)){
            return UserTypeEnum.NOT_LOGGED_IN;
        }else if( user.getUsertype().equals(UserTypeConst.BUYER)){
            return UserTypeEnum.BUYER;
        }else if( user.getUsertype().equals(UserTypeConst.SELLER)){
            return UserTypeEnum.SELLER;
        }
        return null;
    }
}
