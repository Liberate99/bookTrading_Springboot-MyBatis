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

    // selectAllBooksByPromulgatorid
    @Select("select * from book where promulgatorid=#{promulgatorid}")
    public List<Book> selectAllBooksByPromulgatorid(int promulgatorid);

    // selectBookByBooknameOrAuthername  模糊查询
    @Select("select * from book where bookname like '%${_str}%' or authername like '%${_str}%'")
    public List<Book> selectBookByBooknameOrAuthername(@Param("_str") String _str);

    // selectAllBooksWithPromulgatorByBookId
    @Select("select * from book b,user u where (b.promulgatorid = u.userid) and (b.bookid = #{bookid})")
    public BookWithPromulgator selectAllBooksWithPromulgatorByBookId(int bookid);

    // selectBookByBookId
    @Select("select * from book where bookid = #{bookid}")
    public Book selectBookById(int bookid);

    // selectBookByUserId & price小于等于此书
    @Select("select * from book where promulgatorid = #{promulgatorid} and bookprice <= #{price}")//select * from book where promulgatorid = #{promulgatorid} and price <= #{bookprice}
    public List<bookWithPrice> selectBookByUserId(@Param("promulgatorid")int promulgatorid, @Param("price")float price);

    // TODO: 2018/5/13 book selectByName

    // TODO: 2018/5/13 book selectByAutherName

    // insertBook
    @Insert("insert into book(bookname,authername,promulgatorid,purchaserid,status,bookprice,bookcontent,publishtime,picurl) values (#{bookname},#{authername},#{promulgatorid},#{purchaserid},#{status},#{bookprice},#{bookcontent},#{publishtime},#{picurl})")
    public void addBook(Book book);

    // upDateBookStatus_PurchaserId
    @Update("update book set status=#{status}, purchaserid=#{purchaserid} where bookid=#{bookid}")
    public int upDateBookStatus_PurchaserId(@Param("bookid")int bookid, @Param("purchaserid")int purchaserid, @Param("status")int status);

    // TODO: 2018/5/13 book delete
}
