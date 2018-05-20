package com.booktrading.controller;


import com.booktrading.dao.TradeMapper;
import com.booktrading.module.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by apple on 2018/5/20.
 */

@RestController
@RequestMapping("/trade")
public class TradeController {


    @Autowired
    TradeMapper tradeMapper;

    @RequestMapping(value={"/addTrade"}, method = RequestMethod.POST)
    public int addTrade(Trade trade) {
        return tradeMapper.addTrade(trade);
    }
}
