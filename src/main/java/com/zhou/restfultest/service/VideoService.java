package com.zhou.restfultest.service;

import com.zhou.restfultest.model.Category;
import com.zhou.restfultest.model.Video;

import java.util.List;

public interface VideoService extends Service<Video,Integer> {
    public Video findByTitle(String name);
    public Integer findMaxId();
    public List<Video> findVideosByCategory(Category category);
}
