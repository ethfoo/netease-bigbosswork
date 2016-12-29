package com.ethfoo.service;

import com.ethfoo.mapper.BuyrecordMapper;
import com.ethfoo.mapper.ItemMapper;
import com.ethfoo.pojo.Buyrecord;
import com.ethfoo.pojo.Item;
import com.ethfoo.pojo.vo.RecordItem;
import com.sun.prism.impl.Disposer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private BuyrecordMapper buyrecordMapper;

    @Override
    public int publicItem(Item item) {
        int ret = itemMapper.insertItem(item);
        return ret;
    }

    @Override
    public Item getItemById(String id) {

        return itemMapper.selectItemById( Integer.parseInt(id) );
    }

    @Override
    public int editItem(Item item) {
        itemMapper.updateItem(item);
        return 0;
    }

    @Override
    public List<Item> getAllItemsWithRecord() {
        List<Item> items = itemMapper.selectItems();
        List<RecordItem> buyrecords = buyrecordMapper.selectAllRecord();
        for( Item item : items ){
            if(  checkExist(buyrecords, item.getId()) ){
                item.setRecord(true);
            }else {
                item.setRecord(false);
            }
        }
        return items;
    }

    @Override
    public boolean isRecord(int itemid) {
        List<RecordItem> buyrecords = buyrecordMapper.selectAllRecord();
        return checkExist(buyrecords,itemid);
    }

    private boolean checkExist(List<RecordItem> buyrecords, int id){
        boolean flag = false;
        for(RecordItem item : buyrecords){
            if( item.getItemid() == id ){
                flag = true;
            }
        }
        return flag;
    }
}
