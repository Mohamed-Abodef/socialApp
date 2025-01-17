package com.example.socialApp.Service;

import com.example.socialApp.Repository.PostsRepo;
import com.example.socialApp.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {

    @Autowired
    private PostsRepo postsRepo;

    public Posts savePost(Posts post){
        return postsRepo.save(post);
    }

    public List<Posts> getAllPosts(){
        return postsRepo.findAll();
    }
}
