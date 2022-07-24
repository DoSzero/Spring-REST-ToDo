package com.example.dmytrokop.repositoty;

import com.example.dmytrokop.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity,Long> {
}
