package com.ethfoo.service;

import com.ethfoo.mapper.ItemMapper;
import com.ethfoo.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public int publicItem(Item item) {
        int ret = itemMapper.insertItem(item);
        return ret;
    }

    @Override
    public Item getItemById(String id) {

        return itemMapper.selectItemById( Integer.parseInt(id) );
    }
}
