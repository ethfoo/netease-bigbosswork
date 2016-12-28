package com.ethfoo.mapper;


import com.ethfoo.pojo.Buyrecord;

import java.util.List;

public interface BuyrecordMapper {
    int insertBuyrecord(Buyrecord buyrecord);
    int insertBuyrecordList(List<Buyrecord> buyrecords);
    List<Buyrecord> selectAllRecord();
}
