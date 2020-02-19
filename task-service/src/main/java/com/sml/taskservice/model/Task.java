package com.sml.taskservice.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "Tasks", schema = "")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "task_id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "task_name", nullable = false)
    @NotEmpty(message = "Task name should not be empty")
    private String taskName;

    @Temporal(TemporalType.DATE)
    private Date taskStartedDate;

}
