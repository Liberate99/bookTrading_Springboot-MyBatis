package com.booktrading.controller;

import com.booktrading.dao.BookMapper;
import com.booktrading.module.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by apple on 2018/5/13.
 */

@RestController
@RequestMapping("/book")
public class BookController {

    //自动注入
    BookMapper bookMapper;

    @RequestMapping(value = {"/selectBookById"}, method = RequestMethod.GET)
    public Book selectBookById(@RequestParam(value = "bookid") String id){
        Book book = bookMapper.selectBookById(Integer.parseInt(id));
        return book;
    }

    // TODO: 2018/5/13 selectBookByName

    // TODO: 2018/5/13 selectBookByAutherName

    // ....
}
