package com.ethfoo.mapper;


import com.ethfoo.pojo.Buyrecord;
import com.ethfoo.pojo.vo.RecordItem;

import java.util.List;

public interface BuyrecordMapper {
    int insertBuyrecord(Buyrecord buyrecord);
    int insertBuyrecordList(List<Buyrecord> buyrecords);
    List<RecordItem> selectAllRecord();
}
