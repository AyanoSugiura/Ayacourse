package com.zhou.restfultest.dao;

import com.zhou.restfultest.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findByName(String name);
}
