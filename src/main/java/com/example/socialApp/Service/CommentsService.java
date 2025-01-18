package com.example.socialApp.Service;

import com.example.socialApp.DTO.CommentsDTO;
import com.example.socialApp.DTO.RequestComment;
import com.example.socialApp.Repository.CommentsRepo;
import com.example.socialApp.Repository.PostsRepo;
import com.example.socialApp.Repository.UserRepo;
import com.example.socialApp.model.Comments;
import com.example.socialApp.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepo commentsRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PostsRepo postsRepo;


    public Comments addComment(RequestComment reqComment){
        Comments newComment = new Comments();
        newComment.setText_comment(reqComment.getText());
        newComment.setUser(userRepo.findById(reqComment.getUser_id()).orElseThrow(() -> new RuntimeException("User not found")));
        newComment.setPost(postsRepo.findById(reqComment.getPost_id()).orElseThrow(() -> new RuntimeException("post not found")));

        /*
        * Increase numbers of comment by 1
        * */
        Posts updated_post = newComment.getPost();
        updated_post.setComments(updated_post.getComments()+1);
        postsRepo.save(updated_post);

        return  commentsRepo.save(newComment);
    }

    public List<CommentsDTO> getComments( int postId){
        return commentsRepo.getRelatedComm(postId);
    }

    public Comments saveComment(Comments comment){
        return commentsRepo.save(comment);
    }
}
