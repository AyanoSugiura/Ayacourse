package com.zhou.restfultest.service.impl;

import com.zhou.restfultest.dao.VideoRepository;
import com.zhou.restfultest.model.Category;
import com.zhou.restfultest.model.Video;
import com.zhou.restfultest.service.VideoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class VideoServiceImpl extends ServiceImpl<Video,Integer> implements VideoService {
    @Resource
    VideoRepository videoRepository;
    @Override
    public Video findByTitle(String title) {
        return videoRepository.findByTitle(title);
    }
    @Override
    public Integer  findMaxId() {
        return videoRepository.findMaxId();
    }

    @Override
    public List<Video> findVideosByCategory(Category category) {
        return videoRepository.findVideosByCategory(category);
    }
}
