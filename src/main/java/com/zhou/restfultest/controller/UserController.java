package com.zhou.restfultest.controller;


import com.zhou.restfultest.model.User;
import com.zhou.restfultest.model.Video;
import com.zhou.restfultest.service.UserService;
import com.zhou.restfultest.service.VideoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private VideoService videoService;

    @PostMapping("/save/user")
    public User save(User user) {
        userService.save(user);
        return user;
    }
    @PostMapping("/save/favorite")
    public User savefavorite(@RequestParam Integer uid,@RequestParam Integer vid) {
        User user = userService.findById(uid);
        Video video=videoService.findById(vid);
        user.getFavorites().add(video);
        userService.save(user);
        return user;
    }
    @PostMapping("/delete")
    public void delete(@RequestParam Integer id) {
        userService.deleteById(id);
    }
    @PostMapping("/detailbyid")
    public User detailById(@RequestParam Integer id) {
        User user = userService.findById(id);
        return user;
    }
    @PostMapping("/detailbyname")
    public User detailByName(@RequestParam String name) {
        User user = userService.findByName(name);
        return user;
    }
    @PostMapping("/findall")
    public List<User> findAll() {
        List<User> users = userService.findAll();
        return users;
    }
    /*

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }*/
}
