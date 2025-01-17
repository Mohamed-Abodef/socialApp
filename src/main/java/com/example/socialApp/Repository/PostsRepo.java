package com.example.socialApp.Repository;

import com.example.socialApp.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepo extends JpaRepository<Posts, Integer> {
}
