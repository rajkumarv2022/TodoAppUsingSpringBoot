package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService)
    {
        this.taskService=taskService;
    }

    @GetMapping("/api/getAlltask")
    public List<Task> getAlltasks()
    {
        return taskService.getAllTasks();
    }

    @GetMapping("/api/gettask/{id}")
    public Optional<Task> getTaskByid(@PathVariable Integer id)
    {
        return taskService.getTask(id);
    }

    @PostMapping("/api/createTask")
    public Task createTask(@RequestBody Task task)
    {
        return taskService.addTask(task);
    }

    @PutMapping("/api/updatetask/{id}")
    public Task updateTask(@PathVariable Integer id,@RequestBody Task task)
    {
        return taskService.updateTask(id,task);
    }

    @DeleteMapping("/api/deletetask/{id}")
    public void deleteById(@PathVariable Integer id)
    {
        taskService.deleteTask(id);
    }

    @DeleteMapping("/api/deleteAlltaks")
    public void deleteAllTasks()
    {
        taskService.deleteAllTasks();
    }

    @GetMapping("/get")
    public String hello()
    {
        return "hello world";
    }

}
