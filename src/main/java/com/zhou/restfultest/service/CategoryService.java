package com.zhou.restfultest.service;


import com.zhou.restfultest.model.Category;

public interface CategoryService extends Service<Category,Integer> {
    Category findByName(String name);
}
