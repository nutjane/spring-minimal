package com.example.sample.model;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long taskId) {
        super("cound not find task " + taskId);
    }
}
