package com.booktrading.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.booktrading.module.User;

/**
 * Created by apple on 2018/5/12.
 */

@Mapper
public interface UserMapper {
    @Select("select * from user where userid = #{userid}")
    public User selectUserById(int userid);

    @Select("select * from user where username = #{username}")
    public List<User> selectUserByName(String username);

    // 获取用户余额
    @Select("select balance from user where username = #{username}")
    public float selectUserBalanceByName(String userName);

    // 获取用户收藏
    @Select("select collection from user where username = #{usernmae}")
    public String selectUserCollectionByName(String userName);

    @Insert("insert into user(username,password,userpic) values (#{username},#{password},#{userpic})")
    public int addUser(User user);

    @Update("update user set username=#{username},password=#{password},userpic=#{userpic},balance=#{balance} where userid=#{userid}")
    public void updateUser(User user);

    // 添加收藏
    @Update("update user set collection=concat(collection,',',#{collection}) where username=#{username}")
    public int addCollection(@Param("username") String username, @Param("collection") String collection);

    // reduceUserBalance
    @Update("update user set balance=balance - #{price} where userid=#{userid}")
    public int reduceUserBalance(@Param("userid") int userid, @Param("price") float price);

    @Update("update user set balance=#{balance} where username=#{username}")
    public int updateUserBalance(@Param("username") String username, @Param("balance") float balance);

    @Delete("delete from user where userid=#{userid}")
    public void deleteUser(int id);
}
