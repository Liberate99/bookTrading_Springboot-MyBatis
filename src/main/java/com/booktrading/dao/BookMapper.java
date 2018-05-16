package com.booktrading.dao;

import java.util.List;

import com.booktrading.module.BookWithPromulgator;
import org.apache.ibatis.annotations.*;

import com.booktrading.module.Book;

/**
 * Created by apple on 2018/5/13.
 */



@Mapper
public interface BookMapper {

    // selectAllBooks
    @Select("select * from book")
    public List<Book> selectAllBooks();
    
    // selectAllBooksWithPromulgator
    @Select("select * from book b,user u where b.promulgatorid = u.userid")
    public List<BookWithPromulgator> selectAllBooksWithPromulgator();

    // selectAllBooksWithPromulgatorByBookId
    @Select("select * from book b,user u where (b.promulgatorid = u.userid) and (b.bookid = #{bookid})")
    public BookWithPromulgator selectAllBooksWithPromulgatorByBookId(int bookid);

    // selectById
    @Select("select * from book where bookid = #{bookid}")
    public Book selectBookById(int bookid);

    // TODO: 2018/5/13 book selectByName

    // TODO: 2018/5/13 book selectByAutherName

    // TODO: 2018/5/13 book insert

    // TODO: 2018/5/13 book update

    // TODO: 2018/5/13 book delete
}
