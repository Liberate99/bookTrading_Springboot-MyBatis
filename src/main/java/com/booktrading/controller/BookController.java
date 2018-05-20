package com.booktrading.controller;

import com.booktrading.dao.BookMapper;
import com.booktrading.module.Book;
import com.booktrading.module.BookWithPromulgator;
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

    // 自动注入
    @Autowired
    BookMapper bookMapper;

    // select all books
    @RequestMapping(value = {"/selectAllBooks"}, method = RequestMethod.GET)
    public List<Book> selectAllBooks(){
        return bookMapper.selectAllBooks();
    }

    // select all books with promulgator info
    @RequestMapping(value = {"/selectAllBooksWithPromulgator"}, method = RequestMethod.GET)
    public List<BookWithPromulgator> selectAllBooksWithPromulgator(){
        return bookMapper.selectAllBooksWithPromulgator();
    }

    // select All Books With Promulgator By BookId
    @RequestMapping(value = {"/selectAllBooksWithPromulgatorByBookId"}, method = RequestMethod.GET)
    public BookWithPromulgator selectAllBooksWithPromulgatorByBookId(@RequestParam(value = "bookid") int id){
        BookWithPromulgator bookWithPromulgator = bookMapper.selectAllBooksWithPromulgatorByBookId(id);
        return bookWithPromulgator;
    }
//    @Select("select * from book b,user u where (b.promulgatorid = u.userid) and (b.bookid = #{bookid})")
//    public List<BookWithPromulgator> selectAllBooksWithPromulgator(int bookid);

    // select book by bookid
    @RequestMapping(value = {"/selectBookById"}, method = RequestMethod.GET)
    public Book selectBookById(@RequestParam(value = "bookid") String id){
        Book book = bookMapper.selectBookById(Integer.parseInt(id));
        return book;
    }

    // TODO: 2018/5/13 selectBookByName

    // TODO: 2018/5/13 selectBookByAutherName

    // upDate Book Status
    @RequestMapping(value = {"/upDateBookStatusANDPurchaserId"}, method = RequestMethod.POST)
    public int upDateBookStatus_PurchaserId(@RequestParam(value = "bookid") int bookid, @RequestParam(value = "purchaserid") int purchaserid, @RequestParam(value = "status") int status){
        return bookMapper.upDateBookStatus_PurchaserId(bookid, purchaserid, status);
    }
}
