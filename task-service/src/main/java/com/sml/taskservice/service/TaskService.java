package com.sml.taskservice.service;

import com.sml.taskservice.logs.LogMessage;
import com.sml.taskservice.model.Task;
import com.sml.taskservice.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Qualifier("info")
    private LogMessage infoMessage;

    @Qualifier("warning")
    private LogMessage warningMessage;

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    public TaskService(TaskRepository taskRepository, LogMessage infoMessage, LogMessage warningMessage) {
        this.taskRepository = taskRepository;
        this.infoMessage = infoMessage;
        this.warningMessage = warningMessage;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public void addTask(Task task) {
        if (task.getId() != null) {
            taskRepository.save(task);
            LOGGER.info(infoMessage.getMessage());
        } else {
            LOGGER.error(warningMessage.getMessage());
        }
    }
}
