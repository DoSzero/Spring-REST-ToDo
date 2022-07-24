package com.example.dmytrokop.repositoty;

import com.example.dmytrokop.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity,Long> {
    // находим пользователь по Username также можно по паролю
    UserEntity findByUsername(String username);
    //UserEntity findById(Long id);
}
