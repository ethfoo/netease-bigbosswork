package com.ethfoo.mapper;

import com.ethfoo.pojo.Item;

import java.util.List;


public interface ItemMapper {
    int insertItem(Item item);
    Item selectItemById(int id);
    List<Item> selectItems();
    int updateItem(Item item);
}
