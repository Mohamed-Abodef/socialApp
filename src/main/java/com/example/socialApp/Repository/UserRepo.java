package com.example.socialApp.Repository;

import com.example.socialApp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<Users, Integer> {

//    @Query("select new com.example.socialApp.DTO.ProfileInfoDTO()")
}
