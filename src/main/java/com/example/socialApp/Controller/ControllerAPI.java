package com.example.socialApp.Controller;

import com.example.socialApp.Service.PostsService;
import com.example.socialApp.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerAPI {

    @Autowired
    private PostsService postsService;

    @GetMapping("/posts")
    public List<Posts> getAllPosts(){
        return postsService.getAllPosts();
    }
}
