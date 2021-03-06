package com.booktrading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booktrading.dao.UserMapper;
import com.booktrading.module.User;

/**
 * Created by apple on 2018/5/13.
 */

//@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
@RestController
@RequestMapping("/user")
public class UserController {

    //自动注入
    @Autowired
    UserMapper userMapper;

    @RequestMapping(value={"/selectUserById"}, method=RequestMethod.GET)
    public User selectUserById(@RequestParam(value = "userid") String id){
        User user = userMapper.selectUserById(Integer.parseInt(id));
        return user;
    }

    @RequestMapping(value={"/selectUserByName"}, method=RequestMethod.GET)
    public List<User> selectUserByName(@RequestParam(value = "username") String userName){
        return userMapper.selectUserByName(userName);
    }

    @RequestMapping(value = "/selectUserBalanceByName", method = RequestMethod.GET)
    public float selectUserBalanceByName(@RequestParam(value = "username") String userName){
        return userMapper.selectUserBalanceByName(userName);
    }

    // 获取用户收藏
    @RequestMapping(value = "/selectUserCollectionByName", method = RequestMethod.GET)
    public String selectUserCollectionByName(@RequestParam(value = "username") String username){
        return userMapper.selectUserCollectionByName(username);
    }

    @RequestMapping(value={"/addUser"}, method=RequestMethod.POST)
    public int addUser(User user){
        return userMapper.addUser(user);
    }

    @RequestMapping(value={"/updateUser"}, method=RequestMethod.POST)
    public void updateUser(User user){
        userMapper.updateUser(user);
    }

    // 添加收藏
    @RequestMapping(value={"/addCollection"}, method = RequestMethod.POST)
    public int addCollection(@RequestParam(value = "username") String username, @RequestParam(value = "collection") String collection) {
        return userMapper.addCollection(username,collection);
    }

    @RequestMapping(value={"/reduceUserBalance"}, method = RequestMethod.POST)
    public int reduceUserBalance(@RequestParam(value = "userid") int userid, @RequestParam(value = "price") float price) {
        return userMapper.reduceUserBalance(userid,price);
    }

    @RequestMapping(value = {"/updateUserBalance"}, method = RequestMethod.POST)
    public int updateUserBalance(@RequestParam(value = "username") String username, @RequestParam(value = "balance") float balance) {
        return userMapper.updateUserBalance(username,balance);
    }

    @RequestMapping(value={"/deleteUser"}, method=RequestMethod.POST)
    public void deleteUser(String id){
        userMapper.deleteUser(Integer.parseInt(id));
    }
}
