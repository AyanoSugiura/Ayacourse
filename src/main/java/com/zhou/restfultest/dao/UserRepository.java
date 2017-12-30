package com.zhou.restfultest.dao;


import com.zhou.restfultest.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByName(String name);
}