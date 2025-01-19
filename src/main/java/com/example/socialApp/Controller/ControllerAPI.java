package com.example.socialApp.Controller;

import com.example.socialApp.DTO.*;
import com.example.socialApp.Service.CommentsService;
import com.example.socialApp.Service.PostsService;
import com.example.socialApp.Service.UserService;
import com.example.socialApp.model.Comments;
import com.example.socialApp.model.Posts;
import com.example.socialApp.model.Users;
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
    @Autowired
    private UserService userService;

    /**
     * Register a new user.
     *
     * @param user the user details
     * @return the registered user or an error message
     */
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody Users user) {
        try {
            Users registeredUser = userService.registerUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Authenticate a user.
     *
     * @param user the login details (email and password)
     * @return a success message or an error message
     */
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Users user) {
        boolean isAuthenticated = userService.authenticateUser(user.getEmail(), user.getPass());
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
        }
    }
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
            @RequestParam(value = "text", required = false)MultipartFile file,
            @RequestParam(value= "text", required = false) String text,
            @RequestParam(value= "user_id", required = false) int user_id
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

    /*
    *
    *  Profiles API
    *
    * */

    @GetMapping("/getprofile/{id}")
    public ProfileInfoDTO getprofile(@PathVariable int id){
        return userService.getProfile(id);
    }

    @GetMapping("/getprofiledetail/{id}")
    public ProfileDetailsDTO getprofiledetail(@PathVariable int id){
        return userService.getProfileDetails(id);
    }

    @PutMapping("/updateBG")
    public  ResponseEntity<Users> updateBg(@RequestParam("file") MultipartFile file,
                                           @RequestParam("user_id") int user_id) throws IOException {
       Users user = userService.updateBG(user_id, file);
        return ResponseEntity.ok(user);
    }
    @PutMapping("/updateprofpic")
    public  ResponseEntity<Users> updatepp(@RequestParam("file") MultipartFile file,
                                           @RequestParam("user_id") int user_id) throws IOException {
       Users user = userService.updateProfPic(user_id, file);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/posts/{id}")
    public List<PostWithUserDTO> getmyposts(@PathVariable("id") int id){
        return postsService.getMyPost(id);
    }

}
