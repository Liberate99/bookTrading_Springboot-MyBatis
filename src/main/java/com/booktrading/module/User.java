package com.booktrading.module;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by apple on 2018/5/12.
 */

@Setter
@Getter
public class User {
    private int userid;
    private String username;
    private String password;
    private String userpic;
    private float balance;
}
