package com.example.socialApp.Repository;

import com.example.socialApp.DTO.CommentsDTO;
import com.example.socialApp.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentsRepo extends JpaRepository<Comments, Integer> {

    @Query("select new com.example.socialApp.DTO.CommentsDTO(c.text_comment,c.comment_id,u.user_name,u.user_photo,u.user_id,c.post.post_id) from Comments c join c.user u where c.post.post_id = :postId")
    List<CommentsDTO> getRelatedComm(@Param("postId") int postId);

}
