package com.zhou.restfultest.service;


import com.zhou.restfultest.model.User;

import java.util.List;

public interface UserService extends Service<User,Integer>{
    /*void save(User model);//持久化
    void save(List<User> models);//批量持久化
    void deleteById(Integer id);//通过主鍵刪除
    User findById(Integer id);//通过ID查找
    List<User> findAll();//获取所有*/
    User findByName(String name);
}
