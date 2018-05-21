package com.booktrading.module;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by apple on 2018/5/13.
 */

@Setter
@Getter
public class Book {
    private int bookid;
    private String bookname;
    private String authername;
    private int promulgatorid;
    private int purchaserid;
    private int status;
    private float bookprice;
    private String bookcontent;
    private String publishtime;
    private String picurl;
}
