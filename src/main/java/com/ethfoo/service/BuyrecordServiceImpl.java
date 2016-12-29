package com.ethfoo.service;

import com.ethfoo.mapper.BuyrecordMapper;
import com.ethfoo.pojo.Buyrecord;
import com.ethfoo.pojo.vo.RecordItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyrecordServiceImpl implements BuyrecordService {
    @Autowired
    private BuyrecordMapper buyrecordMapper;

    @Override
    public List<RecordItem> getAllRecordItems() {
        List<RecordItem> recordItems = buyrecordMapper.selectAllRecord();
        return recordItems;
    }

    @Override
    public double recordTotalPrice(List<RecordItem> recordItemList) {
        double sum = 0;
        for (RecordItem item : recordItemList){
            double price = item.getBuyprice() * item.getNum();
            sum += price;
        }
        return sum;
    }

    @Override
    public Buyrecord getBuyRecordByItemid(int itemid) {
        return buyrecordMapper.selectByItemid(itemid);
    }
}
