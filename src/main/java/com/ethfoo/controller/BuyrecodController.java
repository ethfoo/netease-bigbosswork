package com.ethfoo.controller;

import com.ethfoo.pojo.vo.RecordItem;
import com.ethfoo.service.BuyrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class BuyrecodController {
    @Autowired
    BuyrecordService buyrecordService;

    @RequestMapping(value = "/buyrecord")
    public ModelAndView buyrecordPage(){
        ModelAndView mv = new ModelAndView("buyrecord");
        List<RecordItem> recordItemList = buyrecordService.getAllRecordItems();
        double totalPrice = buyrecordService.recordTotalPrice(recordItemList);

        mv.addObject("recordlist", recordItemList);
        mv.addObject("totalprice", totalPrice);
        return mv;
    }
}
