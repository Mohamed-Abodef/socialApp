package com.example.socialApp.Controller;

import com.example.socialApp.DTO.CommentsDTO;
import com.example.socialApp.DTO.PostWithUserDTO;
import com.example.socialApp.DTO.PostingPostDTO;
import com.example.socialApp.DTO.RequestComment;
import com.example.socialApp.Service.CommentsService;
import com.example.socialApp.Service.PostsService;
import com.example.socialApp.model.Comments;
import com.example.socialApp.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerAPI {

    @Autowired
    private PostsService postsService;
    @Autowired
    private CommentsService commentsService;

    /*
    *
    * Post Sections
    *
    * */


    @GetMapping("/posts")
    public List<PostWithUserDTO> getAllPosts(){
        return postsService.getAllPosts();
    }

    @PostMapping("/posting")
    public ResponseEntity<Posts> addPost(
            @RequestParam("file")MultipartFile file,
            @RequestParam("text") String text,
            @RequestParam("user_id") int user_id
            ) throws IOException {
        Posts newpost = postsService.savePost(new PostingPostDTO(text,file,user_id));
        return ResponseEntity.status(HttpStatus.CREATED).body(newpost);
    }

    @PostMapping("/addlike/{post_id}")
    public Posts addlike(@PathVariable("post_id")int post_id){
        return postsService.addLike(post_id);
    }

    @PostMapping("/sublike/{post_id}")
    public Posts sublike(@PathVariable("post_id")int post_id){
        return postsService.subLike(post_id);
    }

    /*
    *
    *  Comment Sections
    *
    * */


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
