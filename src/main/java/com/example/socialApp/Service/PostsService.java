package com.example.socialApp.Service;

import com.example.socialApp.DTO.PostWithUserDTO;
import com.example.socialApp.DTO.PostingPostDTO;
import com.example.socialApp.Repository.PostsRepo;
import com.example.socialApp.Repository.UserRepo;
import com.example.socialApp.model.Posts;
import com.example.socialApp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class PostsService {

    @Autowired
    private PostsRepo postsRepo;
    @Autowired
    private UserRepo userRepo;


    public Posts savePost(PostingPostDTO post) throws IOException {
        Posts newPost = new Posts();

        String imgURL ="";
        if (!(post.getFile() == null || post.getFile().isEmpty())){
            String fileName = post.getFile().getOriginalFilename();
            Path path = Paths.get("D:\\courses\\code\\web site\\Spring\\socialApp\\src\\assets\\" + fileName);
            Files.write(path, post.getFile().getBytes());
            imgURL = path.toString();
        }

        newPost.setComments(0);
        newPost.setText_post(post.getText());
        newPost.setUser(userRepo.findById(post.getUser_id()).get());
        newPost.setImg_url(imgURL);
        newPost.setLikes(0);

        Users user = newPost.getUser();
        user.setPosts(user.getPosts()+1);
        userRepo.save(user);

        return postsRepo.save(newPost);
    }

    public List<PostWithUserDTO> getAllPosts(){
        List<PostWithUserDTO> posts = postsRepo.returAllPosts();
        if (posts.isEmpty()) {
            throw new RuntimeException("No posts available.");
        }
        return posts;
    }

    public Posts addLike(int post_id){
        Posts post = postsRepo.findById(post_id).get();
        post.setLikes(post.getLikes()+1);
        return postsRepo.save(post);
    }

    public Posts subLike(int post_id){
        Posts post = postsRepo.findById(post_id).get();
        post.setLikes(post.getLikes()-1);
        return postsRepo.save(post);
    }

    public List<PostWithUserDTO> getMyPost(int id){
        return postsRepo.returMyPosts(id);
    }
}

