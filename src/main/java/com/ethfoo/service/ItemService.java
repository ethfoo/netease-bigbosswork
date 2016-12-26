package com.ethfoo.service;

import com.ethfoo.pojo.Item;

/**
 * Created by ethfoo on 2016/12/23.
 */
public interface ItemService {

    int publicItem(Item item);//发布商品
    Item getItemById(String id);//通过商品id获取商品信息

}
