package com.example.sample.repository;

import com.example.sample.model.Task;
import com.example.sample.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface TaskRepository extends CrudRepository<Task, Long>{

    Collection<Task> findByUserName(String name);

}
