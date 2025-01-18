package com.example.socialApp.Repository;

import com.example.socialApp.DTO.PostWithUserDTO;
import com.example.socialApp.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepo extends JpaRepository<Posts, Integer> {

    @Query("select new com.example.socialApp.DTO.PostWithUserDTO(u.user_id ,u.user_name, u.user_photo, p.post_id, p.text_post, p.img_url, p.comments, p.likes) FROM Posts p JOIN p.user u")
    List<PostWithUserDTO> returAllPosts();
}
