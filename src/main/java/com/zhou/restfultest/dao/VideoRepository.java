package com.zhou.restfultest.dao;

import com.zhou.restfultest.model.Category;
import com.zhou.restfultest.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("videorRepository")
public interface VideoRepository extends JpaRepository<Video,Integer> {
    Video findByTitle(String name);
    @Query(" select max(id) from Video ")
    Integer findMaxId();

    public List<Video> findVideosByCategory(Category category);
}
