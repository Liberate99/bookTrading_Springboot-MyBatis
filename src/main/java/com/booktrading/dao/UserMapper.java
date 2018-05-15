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
    public List<User> selectUserByName(String userName);

    @Insert("insert into user(username,password,userpic) values (#{username},#{password},#{userpic})")
    public void addUser(User user);

    @Update("update user set username=#{userName},password=#{passWord},userpic=#{userpic} where userid=#{userid}")
    public void updateUser(User user);

    @Delete("delete from user where userid=#{userid}")
    public void deleteUser(int id);
}
