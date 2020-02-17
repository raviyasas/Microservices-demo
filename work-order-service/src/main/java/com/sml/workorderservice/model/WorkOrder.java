package com.sml.workorderservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class WorkOrder implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String workOrderName;

    public WorkOrder(String name) {
        this.workOrderName = name;
    }
}
