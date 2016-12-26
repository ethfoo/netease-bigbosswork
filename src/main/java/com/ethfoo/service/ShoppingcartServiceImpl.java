package com.ethfoo.service;

import com.ethfoo.mapper.ShoppingcartMapper;
import com.ethfoo.pojo.Shoppingcart;
import com.ethfoo.pojo.vo.ShoppingcartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingcartServiceImpl implements ShoppingcartService {
    @Autowired
    private ShoppingcartMapper shoppingcartMapper;

    @Override
    public int addtocart(Shoppingcart shoppingcart) {

        Shoppingcart sc = shoppingcartMapper.selectByItemid(shoppingcart.getItemid());
        if (sc == null){ //购物车中没有该商品，加入该商品
            shoppingcartMapper.insertItem(shoppingcart);
        }else { //购物车中有该商品，修改该商品的个数
            int oldNum = sc.getNum();
            int newNum = oldNum + shoppingcart.getNum();
            shoppingcart.setNum(newNum);
            shoppingcartMapper.updateItemNum(shoppingcart);
        }

        return 0;
    }

    @Override
    public List<ShoppingcartItem> getCartList() {
        return shoppingcartMapper.selectAllItem();
    }
}
