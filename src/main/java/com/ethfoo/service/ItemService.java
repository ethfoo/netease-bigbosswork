package com.ethfoo.service;

import com.ethfoo.pojo.Item;

import java.util.List;

public interface ItemService {

    int publicItem(Item item);//发布商品
    Item getItemById(String id);//通过商品id获取商品信息
    int editItem(Item item);
    List<Item> getAllItemsWithRecord();
    boolean isRecord(int itemid);

}
