package com.ethfoo.service;

import com.ethfoo.Utils.UserTypeConst;
import com.ethfoo.pojo.User;
import org.springframework.stereotype.Service;

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
}
