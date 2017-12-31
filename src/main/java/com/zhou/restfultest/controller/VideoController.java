package com.zhou.restfultest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhou.restfultest.model.Video;
import com.zhou.restfultest.service.CategoryService;
import com.zhou.restfultest.service.UserService;
import com.zhou.restfultest.service.VideoService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/video")
public class VideoController {
    @Resource
    private VideoService videoService;
    @Resource
    private UserService userService;
    @Resource
    private CategoryService categoryService;
    private ObjectMapper mapper=new ObjectMapper();

    @PostMapping("/save")
    public Video save(@RequestParam String data, @RequestParam("filename") MultipartFile file) {
        data=URLDecoder.decode(data);
        System.out.println(data);
        Map<String,Object> map= null;
        try {
            map = mapper.readValue(data,Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Video video=new Video();
        try {
            file.transferTo(new File("D://zhou1//project2//restfultest//src//main//resources//videoresources//"+file.getOriginalFilename()));
            System.out.println(file.getOriginalFilename());
            video.setTitle("");
            video.setTitle((String) map.get("title"));
            if((Integer) map.get("id")!=null)
                video.setId((Integer) map.get("id"));
            video.setAuthor(userService.findById((Integer) map.get("uid")));
            video.setCategory(categoryService.findById((Integer) map.get("cid")));
            video.setLink("http://localhost:8080/video/getfile/"+file.getOriginalFilename());
            videoService.save(video);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return video;
    }
    @GetMapping("/getfile/{filename:.+}")
    public ResponseEntity getFile(@PathVariable String filename) {
        System.out.println("文件名为"+filename);
        File file=new File("D://zhou1//project2//restfultest//src//main//resources//videoresources//"+filename);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", "attachment; filename=" + filename);
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new FileSystemResource(file));
    }
    @PostMapping("/detailbyid")
    public Video detailById(@RequestParam Integer id) {
        Video video = videoService.findById(id);
        return video;
    }
    @PostMapping("/detailbyname")
    public Video detailByTitle(@RequestParam String name) {
        Video video = videoService.findByTitle(name);
        return video;
    }
    @PostMapping("/findall")
    public List<Video> findAll() {
        List<Video> videos = videoService.findAll();
        return videos;
    }
}