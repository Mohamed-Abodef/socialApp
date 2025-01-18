package com.example.socialApp.Controller;

import com.example.socialApp.DTO.CommentsDTO;
import com.example.socialApp.DTO.PostWithUserDTO;
import com.example.socialApp.DTO.RequestComment;
import com.example.socialApp.Service.CommentsService;
import com.example.socialApp.Service.PostsService;
import com.example.socialApp.model.Comments;
import com.example.socialApp.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerAPI {

    @Autowired
    private PostsService postsService;
    @Autowired
    private CommentsService commentsService;

    @GetMapping("/posts")
    public List<PostWithUserDTO> getAllPosts(){
        return postsService.getAllPosts();
    }

    @GetMapping("/comments/{postId}")
    public List<CommentsDTO> getComments(@PathVariable("postId") int postId){
        return commentsService.getComments(postId);
    }

    @PostMapping("/addComment")
    public ResponseEntity<Comments> addComment(@RequestBody RequestComment requestComment){
        Comments comment = commentsService.addComment(requestComment);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }
}
