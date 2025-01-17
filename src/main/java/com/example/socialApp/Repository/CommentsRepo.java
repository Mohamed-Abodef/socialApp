package com.example.socialApp.Repository;

import com.example.socialApp.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepo extends JpaRepository<Comments, Integer> {
}
