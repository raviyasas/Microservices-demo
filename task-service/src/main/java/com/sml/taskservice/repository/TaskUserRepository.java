package com.sml.taskservice.repository;

import com.sml.taskservice.model.TaskUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskUserRepository extends JpaRepository<TaskUser, Integer> {

}
