package com.ethfoo.service;

import com.ethfoo.mapper.BuyrecordMapper;
import com.ethfoo.mapper.ShoppingcartMapper;
import com.ethfoo.pojo.Buyrecord;
import com.ethfoo.pojo.Shoppingcart;
import com.ethfoo.pojo.vo.ShoppingcartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShoppingcartServiceImpl implements ShoppingcartService {
    @Autowired
    private ShoppingcartMapper shoppingcartMapper;
    @Autowired
    private BuyrecordMapper buyrecordMapper;

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

    @Override
    public int buyCartItems(List<ShoppingcartItem> items) {
        List<Buyrecord> buyrecords = new ArrayList<>();
        for(ShoppingcartItem item : items){
            Buyrecord buyrecord = new Buyrecord();
            buyrecord.setItemid(item.getItemid());
            buyrecord.setBuyprice(item.getPrice());
            buyrecord.setNum(item.getNum());
            buyrecord.setDate(new Date());
            buyrecords.add(buyrecord);
        }

        //TODO 事务
        buyrecordMapper.insertBuyrecordList(buyrecords);
        shoppingcartMapper.truncateCart();
        return 0;
    }
}
