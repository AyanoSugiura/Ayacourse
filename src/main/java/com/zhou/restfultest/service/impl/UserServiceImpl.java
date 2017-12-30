package com.zhou.restfultest.service.impl;



import com.zhou.restfultest.dao.UserRepository;
import com.zhou.restfultest.model.User;
import com.zhou.restfultest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<User,Integer> implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    /*@Override
    public void save(User model) {
        userRepository.save(model);
    }

    @Override
    public void save(List<User> models) {
        userRepository.save(models);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.delete(id);
    }


    @Override
    public User findById(Integer id) {
        return (User) userRepository.findOne(id);
    }



    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }*/
}
