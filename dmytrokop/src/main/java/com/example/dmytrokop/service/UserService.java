package com.example.dmytrokop.service;

import com.example.dmytrokop.entity.UserEntity;
import com.example.dmytrokop.exception.UserAlreadyExistException;
import com.example.dmytrokop.exception.UserNotFoundException;
import com.example.dmytrokop.model.User;
import com.example.dmytrokop.repositoty.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration (UserEntity user) throws UserAlreadyExistException {
        // Проверка на унекальность имени
        if (userRepo.findByUsername(user.getUsername()) != null ) {
            throw new UserAlreadyExistException("POST User with this name already exists !!! ");
        }
        return userRepo.save(user);
    }

    public User getOne (Long id) throws UserNotFoundException {
        // User by ID
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User Not Found !!! ");
        }
        return User.toModel(user);
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }

}
