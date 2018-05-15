package com.booktrading.controller;

import com.booktrading.dao.BookMapper;
import com.booktrading.module.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * Created by apple on 2018/5/13.
 */

@RestController
@RequestMapping("/book")
public class BookController {

    //自动注入
    @Autowired
    BookMapper bookMapper;

    //select all books
    @RequestMapping(value = {"/selectAllBooks"}, method = RequestMethod.GET)
    public List<Book> selectAllBooks(){
        return bookMapper.selectAllBooks();
    }

    //select book by bookid
    @RequestMapping(value = {"/selectBookById"}, method = RequestMethod.GET)
    public Book selectBookById(@RequestParam(value = "bookid") String id){
        Book book = bookMapper.selectBookById(Integer.parseInt(id));
        return book;
    }

    // TODO: 2018/5/13 selectBookByName

    // TODO: 2018/5/13 selectBookByAutherName

    // ....
}
