package com.zhou.restfultest.service.impl;

import com.zhou.restfultest.dao.VideoRepository;
import com.zhou.restfultest.model.Video;
import com.zhou.restfultest.service.VideoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class VideoServiceImpl extends ServiceImpl<Video,Integer> implements VideoService {
    @Resource
    VideoRepository videoRepository;
    @Override
    public Video findByTitle(String title) {
        return videoRepository.findByTitle(title);
    }
}
