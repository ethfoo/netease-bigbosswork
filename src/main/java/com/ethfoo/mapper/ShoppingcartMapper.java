package com.ethfoo.mapper;


import com.ethfoo.pojo.Shoppingcart;
import com.ethfoo.pojo.vo.ShoppingcartItem;

import java.util.List;

public interface ShoppingcartMapper {
    int insertItem(Shoppingcart shoppingcart);
    Shoppingcart selectByItemid(int itemid);
    int updateItemNum(Shoppingcart shoppingcart);
    int deleteItem(int itemid);
    List<ShoppingcartItem> selectAllItem();
    int truncateCart();
}
