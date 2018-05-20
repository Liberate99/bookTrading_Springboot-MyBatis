package com.booktrading.module;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by apple on 2018/5/20.
 */

@Getter
@Setter
public class Trade {
    private int tradeid;
    private String purchasername;
    private String salername;
    private float price;
    private int bookid;
    private int type;
}
