package com.zhou.restfultest.service;

import com.zhou.restfultest.model.Video;

public interface VideoService extends Service<Video,Integer> {
    public Video findByTitle(String name);
}
