package com.ethfoo.mapper;

import com.ethfoo.pojo.Item;


public interface ItemMapper {
    int insertItem(Item item);
    Item selectItemById(int id);
}
