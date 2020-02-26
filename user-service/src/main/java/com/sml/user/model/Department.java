package com.sml.user.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Data
@Document(collection = "Department")
@ToString
public class Department {

    @Id
    private String id;

    @Indexed(name = "deptName")
    private String departmentName;
    private String description;
    private List employees;
}
