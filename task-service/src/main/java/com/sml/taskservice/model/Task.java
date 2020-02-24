package com.sml.taskservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
//@Table(name = "tasks")
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

    @ManyToMany
    @JoinTable(
            name = "task_users",
            joinColumns = {@JoinColumn(name = "ïd")},
            inverseJoinColumns = {@JoinColumn(name = "id")}
    )
    @JsonBackReference
    private List<TaskUser> taskUsers;

}
