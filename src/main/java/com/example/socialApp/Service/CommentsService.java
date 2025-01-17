package com.example.socialApp.Service;

import com.example.socialApp.Repository.CommentsRepo;
import com.example.socialApp.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepo commentsRepo;

    public Comments saveComment(Comments comment){
        return commentsRepo.save(comment);
    }
}
