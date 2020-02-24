package com.sml.taskservice.controller;

import com.sml.taskservice.model.Task;
import com.sml.taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @GetMapping("/getTasks")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping("/addTask")
    public ResponseEntity<Task> addTask(@Valid @RequestBody Task task){
        taskService.addTask(task);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
}
