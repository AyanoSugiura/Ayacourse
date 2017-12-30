package com.zhou.restfultest.service.impl;

import com.zhou.restfultest.dao.CategoryRepository;
import com.zhou.restfultest.model.Category;
import com.zhou.restfultest.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class CategoryServiceImpl extends ServiceImpl<Category,Integer> implements CategoryService {
    @Resource
    CategoryRepository categoryRepository;

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }
}
