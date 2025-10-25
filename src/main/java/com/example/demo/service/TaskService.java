package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository)
    {
        this.taskRepository=taskRepository;
    }

    public Task addTask(Task task)
    {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks()
    {
        return taskRepository.findAll();
    }

    public Optional<Task> getTask(Integer id)
    {
        return taskRepository.findById(id);
    }

    public void deleteTask(Integer id)
    {
        taskRepository.deleteById(id);
    }

    public void deleteAllTasks()
    {
        taskRepository.deleteAll();
    }

    public Task updateTask(Integer id,Task newTask)
    {
        for(Task t:taskRepository.findAll())
        {
            if(t.getId()== id)
            {
                t.setTitle(newTask.getTitle());
                t.setDescription(newTask.getDescription());
                t.setStatus(newTask.getStatus());
                return taskRepository.save(t);
            }
        }

        throw new RuntimeException("Task Not Found");

    }

}
