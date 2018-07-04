package com.example.sample.controller;

import com.example.sample.model.Task;
import com.example.sample.model.TaskNotFoundException;
import com.example.sample.repository.TaskRepository;
import com.example.sample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskRepository taskRepository;
    private UserRepository userRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

//    @GetMapping("/{usedId}")
//    public Collection<Task> getTasksFromUserId(@PathVariable String userId) {
//        this.validateUser(userId);
//        return this.taskRepository.findByUserName(userId);
//    }

    @GetMapping("/{taskId}")
    public Task readTask(@PathVariable Long taskId) {
        return this.taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
    }

    @PostMapping
    public ResponseEntity<?> add(Authentication authentication, @RequestBody Task input) {
        String username = authentication.getName();
        this.validateUser(username);
        return this.userRepository
                .findByName(username)
                .map(account -> {
                    Task result = taskRepository.save(new Task(account, input.getDescription()));
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                            .buildAndExpand(result.getId()).toUri();
                    return ResponseEntity.created(location).build();

                })
                .orElse(ResponseEntity.noContent().build());
    }

//    @PutMapping("/{id}")
//    public void editTask(@PathVariable long id, @RequestBody Task task) {
//        Task existingTask = taskRepository.findById(id).orElse(null);
//        Assert.notNull(existingTask, "Task not found");
//        existingTask.setDescription(task.getDescription());
//        taskRepository.save(existingTask);
//    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id) {
        taskRepository.deleteById(id);
    }


    private void validateUser(String userId) {
        this.userRepository.findByName(userId).orElseThrow(()-> new UsernameNotFoundException(userId));
    }
}
