package com.example.dmytrokop.controller;

import com.example.dmytrokop.entity.UserEntity;
import com.example.dmytrokop.exception.UserAlreadyExistException;
import com.example.dmytrokop.exception.UserNotFoundException;
import com.example.dmytrokop.repositoty.UserRepo;
import com.example.dmytrokop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // POST
    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return  ResponseEntity.ok("POST User are correct and save. ");
        } catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("POST IS NOT WORKING");
        }
    }

    //GET
    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return  ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(" Error!, ўось не так (( ");
        }
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return  ResponseEntity.ok(userService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(" Error!, ўось не так (( ");
        }
    }
}
