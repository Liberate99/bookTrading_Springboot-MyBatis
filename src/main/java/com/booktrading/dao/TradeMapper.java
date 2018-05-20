package com.booktrading.dao;

import java.util.List;

import com.booktrading.module.Trade;
import org.apache.ibatis.annotations.*;


/**
 * Created by apple on 2018/5/20.
 */

@Mapper
public interface TradeMapper {

    // addTrade
    @Insert("insert into trade(tradeid,puchasername,salername,price,bookid,type) values (#{tradeid},#{puchasername},#{salername},#{price},#{bookid},#{type})")
    public int addTrade(Trade trade);
}
