package com.zhou.restfultest.controller;

import com.zhou.restfultest.model.Category;
import com.zhou.restfultest.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;
    @PostMapping("/save")
    public Category save(Category category) {
        categoryService.save(category);
        System.out.println(category.getName());
        return category;
    }
    @PostMapping("/detailbyid")
    public Category detailById(@RequestParam Integer id) {
        Category category = categoryService.findById(id);
        return category;
    }
    @PostMapping("/detailbyname")
    public Category detailByName(@RequestParam String name) {
        Category category = categoryService.findByName(name);
        return category;
    }
    @GetMapping("/findall")
    public List<Category> findAll() {
        List<Category> categorys = categoryService.findAll();
        return categorys;
    }
}
