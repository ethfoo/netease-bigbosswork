package com.ethfoo.service;


import com.ethfoo.pojo.vo.RecordItem;

import java.util.List;

public interface BuyrecordService {
    List<RecordItem> getAllRecordItems();
    double recordTotalPrice(List<RecordItem> recordItemList);

}
