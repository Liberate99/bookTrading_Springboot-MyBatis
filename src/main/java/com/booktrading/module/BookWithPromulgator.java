package com.booktrading.module;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by apple on 2018/5/16.
 */

@Setter
@Getter
public class BookWithPromulgator{
    private int bookid;
    private String bookname;
    private String authername;
    private String picurl;
    private int promulgatorid;
    private int purchaserid;
    private int status;
    private float bookprice;
    private String bookcontent;
    private String publishTime;

//    private int userid;
    private String username;
    private String password;
    private String userpic;
}
