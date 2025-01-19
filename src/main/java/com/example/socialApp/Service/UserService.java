package com.example.socialApp.Service;

import com.example.socialApp.DTO.ProfileDetailsDTO;
import com.example.socialApp.DTO.ProfileInfoDTO;
import com.example.socialApp.Repository.UserRepo;
import com.example.socialApp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    /**
     * Register a new user.
     *
     * @param user the user to register
     * @return the registered user
     * @throws Exception if the email already exists
     */
    public Users registerUser(Users user) throws Exception {
        // Check if the email already exists
        Optional<Users> existingUser = userRepo.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new Exception("Email already exists.");
        }

        // Save the new user
        return userRepo.save(user);
    }

    /**
     * Authenticate a user by email and password.
     *
     * @param email    the email of the user
     * @param password the password of the user
     * @return true if authentication is successful, otherwise false
     */
    public boolean authenticateUser(String email, String password) {
        Optional<Users> user = userRepo.findByEmail(email);
        return user.isPresent() && user.get().getPass().equals(password);
    }

    public Users saveUser(Users user){
        /*
        * Create new users
        * write here your conditions
        */
        return userRepo.save(user);
    }

    public ProfileInfoDTO getProfile(int id){
        Users user = userRepo.findById(id).get();
        ProfileInfoDTO data = new ProfileInfoDTO(
                user.getUser_name(),
                user.getUser_photo(),
                user.getUser_BG(),
                user.getPosts(),
                user.getFollowers_num(),
                user.getFollowing_num()
                );
        return data;
    }

    public ProfileDetailsDTO getProfileDetails(int id){
        Users user = userRepo.findById(id).get();
        ProfileDetailsDTO data = new ProfileDetailsDTO(
                user.getUser_name(),
                user.getEmail(),
                user.getPhone()
        );
        return data;
    }

    public Users updateBG (int id, MultipartFile file) throws IOException {
        Users user = userRepo.findById(id).get();

        String imgURL ="";
        if (!(file == null || file.isEmpty())){
            String fileName = file.getOriginalFilename();
            Path path = Paths.get("D:\\courses\\code\\web site\\Spring\\socialApp\\src\\assets\\" + fileName);
            Files.write(path, file.getBytes());
            imgURL = path.toString();
        }

        user.setUser_BG(imgURL);
        return userRepo.save(user);
    }


  public Users updateProfPic(int id, MultipartFile file) throws IOException {
        Users user = userRepo.findById(id).get();

        String imgURL ="";
        if (!(file == null || file.isEmpty())){
            String fileName = file.getOriginalFilename();
            Path path = Paths.get("D:\\courses\\code\\web site\\Spring\\socialApp\\src\\assets\\" + fileName);
            Files.write(path, file.getBytes());
            imgURL = path.toString();
        }

        user.setUser_photo(imgURL);
        return userRepo.save(user);
    }
}
