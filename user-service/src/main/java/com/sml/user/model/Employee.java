package com.sml.user.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@Document(collection = "Employee")
@ToString
public class Employee {

    @Id
    private Integer id;
    private String employeeName;

}
