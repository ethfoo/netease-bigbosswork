package com.ethfoo.service;

import com.ethfoo.pojo.User;

/**
 * Created by ethfoo on 2016/12/23.
 */
public interface UserService {

    User checkUserAndPasswd(String username, String password);

}
