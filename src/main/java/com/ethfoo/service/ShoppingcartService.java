package com.ethfoo.service;

import com.ethfoo.pojo.Buyrecord;
import com.ethfoo.pojo.Shoppingcart;
import com.ethfoo.pojo.vo.ShoppingcartItem;

import java.util.List;

public interface ShoppingcartService {
    int addtocart(Shoppingcart shoppingcart);
    List<ShoppingcartItem> getCartList();
    int buyCartItems(List<ShoppingcartItem> items);
}
