package com.zhou.restfultest.dao;

import com.zhou.restfultest.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("videorRepository")
public interface VideoRepository extends JpaRepository<Video,Integer> {
    Video findByTitle(String name);
}
