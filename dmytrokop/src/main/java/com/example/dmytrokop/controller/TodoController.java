package com.example.dmytrokop.controller;

import com.example.dmytrokop.entity.TodoEntity;
import com.example.dmytrokop.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity creatTodo(@RequestBody TodoEntity todo,
                                    @RequestParam Long userId ){
        try {
            return ResponseEntity.ok(todoService.createTodo(todo,userId));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(" Error!, ўось не так (( ");
        }
    }

    // PUT
    @PutMapping
    public ResponseEntity completeTodo (@RequestParam Long id ) {
        try {
            return ResponseEntity.ok(todoService.complete(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(" Error!, ўось не так (( ");
        }
    }
}
